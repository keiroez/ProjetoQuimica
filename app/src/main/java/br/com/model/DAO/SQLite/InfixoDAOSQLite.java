package br.com.model.DAO.SQLite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.model.DAO.fabricaDAO.InfixoDAO;
import br.com.model.VO.Infixo;

public class InfixoDAOSQLite extends InfixoDAO {
    private SQLiteDatabase sqLiteDatabase;

    public InfixoDAOSQLite(SQLiteDatabase sqLiteDatabase) {
        this.sqLiteDatabase = sqLiteDatabase;
    }



    @Override
    public void insertDadosInfixo(List<Infixo> infixos) throws Exception {
        try {
            ContentValues values = new ContentValues();
            for (Infixo infixo: infixos
                    ) {
                values.put("qtd", infixo.getQtd());
                values.put("nome", infixo.getNome());
                values.put("qtdnome", infixo.getQtdNome());


                if (this.sqLiteDatabase.insert("infixo", null, values) > 0) {
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
    public ArrayList<Infixo> selectDadosInfixo() throws Exception {
        ArrayList<Infixo> infixos = new ArrayList<>();

        StringBuilder query =  new StringBuilder();
        query.append("select * from infixo;");

        Cursor cursor = sqLiteDatabase.rawQuery(query.toString(),null);

        if(cursor.moveToFirst()){
            do{
                try{
                    Infixo infixo = new Infixo(Integer.parseInt(cursor.getString(1)), cursor.getString(2), cursor.getString(3) );
                    infixo.setId(Integer.parseInt(cursor.getString(0)));
                    infixos.add(infixo);
                }catch (Exception e){
                    throw new Exception("Erro ao listar dados IUPAC");

                }
            }while (cursor.moveToNext());
            return infixos;
        }else{
            return null;
        }
    }

    @Override
    public String buscarInfixoQtd(int qtd, String inicio) throws Exception {
        String infixo;

        StringBuilder query =  new StringBuilder();
        query.append("select * from infixo where qtd= "+qtd+" and nome='"+inicio+"';");

        Cursor cursor = sqLiteDatabase.rawQuery(query.toString(),null);

        if(cursor.moveToFirst()){
            do{
                try{
                    infixo = (cursor.getString(2)+cursor.getString(3));
                }catch (Exception e){
                    throw new Exception("Erro ao pegar infixo");
                }
            }while (cursor.moveToNext());
            return infixo;
        }else{
            return null;
        }
    }

}
