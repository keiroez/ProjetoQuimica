package br.com.model.DAO.SQLite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.model.DAO.fabricaDAO.MoleculaDAO;
import br.com.model.VO.Cadeia;
import br.com.model.VO.Molecula;

public class MoleculaDAOSQLite extends MoleculaDAO {
    private SQLiteDatabase sqLiteDatabase;

    public MoleculaDAOSQLite(SQLiteDatabase sqLiteDatabase) {
        this.sqLiteDatabase = sqLiteDatabase;
    }
    @Override
    public void inserirMoleculas(Cadeia cadeia) throws Exception{
        try {
            ContentValues values = new ContentValues();
            for (Molecula molecula: cadeia.getMoleculas()
                    ) {
                values.put("posX", molecula.getPosX());
                values.put("posY", molecula.getPosY());
                values.put("id_cadeia", cadeia.getId());


                if (this.sqLiteDatabase.insert("molecula", null, values) > 0) {
                    //return;
                } else {
                    throw new Exception("Erro ao inserir cadeia");
                }
            }
            return;
        }catch (Exception e){

        }
    }

    @Override
    public List<Molecula> listaDeMoleculas(int idCadeia)throws Exception {
        List<Molecula> moleculas = new ArrayList<>();
        StringBuilder query =  new StringBuilder();
        query.append("select * from molecula where id_cadeia="+idCadeia+";");

        Cursor cursor = sqLiteDatabase.rawQuery(query.toString(),null);

        if(cursor.moveToFirst()){
            do{
                try{
                    moleculas.add(new Molecula(Integer.parseInt(cursor.getString(1)),Integer.parseInt(cursor.getString(2))));
                }catch (Exception e){
                    throw new Exception("Erro ao pegar prefixo");
                }
            }while (cursor.moveToNext());
            return moleculas;
        }else{
            return null;
        }
    }
}
