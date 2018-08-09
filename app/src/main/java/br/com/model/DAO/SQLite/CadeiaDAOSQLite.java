package br.com.model.DAO.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.model.DAO.fabricaDAO.CadeiaDAO;
import br.com.model.VO.Cadeia;

public class CadeiaDAOSQLite extends CadeiaDAO {
    private SQLiteDatabase sqLiteDatabase;

    public CadeiaDAOSQLite(Context context) {
        super();
        sqLiteDatabase = ConexaoSQLite.getConexaoSQLite(context);
    }

    @Override
    public void insertDados(Cadeia cadeia)throws Exception {
        try {
            ContentValues values = new ContentValues();
                values.put("nome", cadeia.getNome());


                if (this.sqLiteDatabase.insert("cadeia", null, values) > 0) {
                    //return;
                } else {
                    throw new Exception("Erro ao inserir dados IUPAC");
                }

            return;
        }catch (Exception e){

        }
    }

    @Override
    public List<Cadeia> listarCadeias()throws Exception {
        ArrayList<Cadeia> cadeias = new ArrayList<>();

        StringBuilder query =  new StringBuilder();
        query.append("select * from prefixo;");

        Cursor cursor = sqLiteDatabase.rawQuery(query.toString(),null);

        if(cursor.moveToFirst()){
            do{
                try{
                    Cadeia cadeia = new Cadeia();
                    cadeia.setId(Integer.parseInt(cursor.getString(0)));
                    cadeia.setNome(cursor.getString(Integer.parseInt(cursor.getString(2))));
                    cadeias.add(cadeia);
                }catch (Exception e){
                    throw new Exception("Erro ao listar dados IUPAC");

                }
            }while (cursor.moveToNext());
            return cadeias;
        }else{
            return null;
        }
    }

    @Override
    public Cadeia cadeiaById(int id) throws Exception{
        Cadeia cadeia = new Cadeia();

        StringBuilder query =  new StringBuilder();
        query.append("select * from prefixo where id="+id+";");

        Cursor cursor = sqLiteDatabase.rawQuery(query.toString(),null);

        if(cursor.moveToFirst()){
            do{
                try{
                    cadeia = new Cadeia();
                    cadeia.setId(Integer.parseInt(cursor.getString(0)));
                    cadeia.setNome(cursor.getString(Integer.parseInt(cursor.getString(2))));

                }catch (Exception e){
                    throw new Exception("Erro ao listar dados IUPAC");

                }
            }while (cursor.moveToNext());
            return cadeia;
        }else{
            return null;
        }
    }
}
