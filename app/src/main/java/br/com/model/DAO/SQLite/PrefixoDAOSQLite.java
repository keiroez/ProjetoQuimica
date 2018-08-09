package br.com.model.DAO.SQLite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.model.DAO.fabricaDAO.PrefixoDAO;
import br.com.model.VO.Prefixo;

public class PrefixoDAOSQLite extends PrefixoDAO {
    private SQLiteDatabase sqLiteDatabase;

    public PrefixoDAOSQLite(SQLiteDatabase sqLiteDatabase) {
        this.sqLiteDatabase = sqLiteDatabase;
    }


    @Override
    public void insertDadosPrefixo(List<Prefixo> prefixos) throws Exception {
        try {
            ContentValues values = new ContentValues();
            for (Prefixo prefixo: prefixos
                    ) {
                values.put("qtd", prefixo.getQtd());
                values.put("nome", prefixo.getPrefixo());


                if (this.sqLiteDatabase.insert("prefixo", null, values) > 0) {
                    //return;
                } else {
                    throw new Exception("Erro ao inserir dados IUPAC");
                }
            }
        return;
        }catch (Exception e){

        }
    }

    @Override
    public ArrayList<Prefixo> selectDadosPrefixo() throws Exception {
        ArrayList<Prefixo> prefixos = new ArrayList<>();

        StringBuilder query =  new StringBuilder();
        query.append("select * from prefixo;");

        Cursor cursor = sqLiteDatabase.rawQuery(query.toString(),null);

        if(cursor.moveToFirst()){
            do{
                try{
                    Prefixo prefixo = new Prefixo(Integer.parseInt(cursor.getString(1)), cursor.getString(2));
                    prefixo.setId(Integer.parseInt(cursor.getString(0)));
                    prefixos.add(prefixo);
                }catch (Exception e){
                    throw new Exception("Erro ao listar dados IUPAC");

                }
            }while (cursor.moveToNext());
            return prefixos;
        }else{
            return null;
        }
    }

    @Override
    public String buscarPrefixoQtd(int qtd) throws Exception {
        String prefixo;

        StringBuilder query =  new StringBuilder();
        query.append("select * from prefixo where qtd= "+qtd+";");

        Cursor cursor = sqLiteDatabase.rawQuery(query.toString(),null);

        if(cursor.moveToFirst()){
            do{
                try{
                    prefixo = (cursor.getString(2));
                }catch (Exception e){
                    throw new Exception("Erro ao pegar prefixo");

                }
            }while (cursor.moveToNext());
            return prefixo;
        }else{
            return null;
        }
    }
}
