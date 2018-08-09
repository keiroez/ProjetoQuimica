package br.com.model.DAO.SQLite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.model.DAO.fabricaDAO.SufixoDAO;
import br.com.model.VO.Sufixo;

public class SufixoDAOSQLite extends SufixoDAO {
    private SQLiteDatabase sqLiteDatabase;

    public SufixoDAOSQLite(SQLiteDatabase sqLiteDatabase) {
        this.sqLiteDatabase = sqLiteDatabase;
    }



    @Override
    public void insertDadosSufixo(List<Sufixo> sufixos) throws Exception {
        try {
            ContentValues values = new ContentValues();
            for (Sufixo sufixo: sufixos
                    ) {
                values.put("nome", sufixo.getSufixo());
                values.put("grupo", sufixo.getGrupo());

                if (this.sqLiteDatabase.insert("sufixo", null, values) > 0) {
                    //return;
                } else {
                    throw new Exception("Erro ao inserir dados IUPAC");
                }
            }
            return;
        }catch (Exception e){
            System.out.println("erro");
        }
    }

    @Override
    public ArrayList<Sufixo> selectDadosSufixo() throws Exception {
        ArrayList<Sufixo> sufixos = new ArrayList<>();

        StringBuilder query =  new StringBuilder();
        query.append("select * from sufixo;");

        Cursor cursor = sqLiteDatabase.rawQuery(query.toString(),null);

        if(cursor.moveToFirst()){
            do{
                try{
                    Sufixo sufixo = new Sufixo(cursor.getString(2), cursor.getString(1) );
                    sufixo.setId(Integer.parseInt(cursor.getString(0)));
                    sufixos.add(sufixo);
                }catch (Exception e){
                    throw new Exception("Erro ao listar dados IUPAC");

                }
            }while (cursor.moveToNext());
            return sufixos;
        }else{
            return null;
        }
    }

    @Override
    public String buscarSufixoQtd(String grupo) throws Exception {
        String sufixo;

        StringBuilder query =  new StringBuilder();
        query.append("select * from sufixo where grupo= '"+grupo+"';");

        Cursor cursor = sqLiteDatabase.rawQuery(query.toString(),null);

        if(cursor.moveToFirst()){
            do{
                try{
                    sufixo = (cursor.getString(1));
                }catch (Exception e){
                    throw new Exception("Erro ao pegar infixo");
                }
            }while (cursor.moveToNext());
            return sufixo;
        }else{
            return null;
        }
    }
}
