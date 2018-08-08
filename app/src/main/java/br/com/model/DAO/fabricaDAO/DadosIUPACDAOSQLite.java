package br.com.model.DAO.fabricaDAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.com.model.VO.DadosUIPAC;
import br.com.model.VO.Infixo;
import br.com.model.VO.Prefixo;

public class DadosIUPACDAOSQLite extends DadosIUPACDAO {
    private SQLiteDatabase sqLiteDatabase;

    public DadosIUPACDAOSQLite(SQLiteDatabase sqLiteDatabase) {
        this.sqLiteDatabase = sqLiteDatabase;
    }

    @Override
    public void insertDados(DadosUIPAC dados) throws Exception {
        try {
            ContentValues values = new ContentValues();
            for (Prefixo prefixo: dados.getPrefixos()
                 ) {
                values.put("qtd", prefixo.getQtd());
                values.put("nome", prefixo.getPrefixo());


                if (this.sqLiteDatabase.insert("prefixo", null, values) > 0) {
                    //return;
                } else {
                    throw new Exception("Erro ao inserir dados IUPAC");
                }
            }

            for (Infixo infixo: dados.getInfixos()
                    ) {
                values.put("qtd", infixo.getQtd());
                values.put("qtdnome", infixo.getQtdNome());
                values.put("nome", infixo.getNome());


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
    public DadosUIPAC selectDados() throws Exception {
        DadosUIPAC dados =  new DadosUIPAC();

        StringBuilder query =  new StringBuilder();
        query.append("select * from prefixo order by qtd;");

        Cursor cursor = sqLiteDatabase.rawQuery(query.toString(),null);

        if(cursor.moveToFirst()){
            do{
                try{
                    Prefixo prefixo = new Prefixo(Integer.parseInt(cursor.getString(1)), cursor.getString(2));
                    prefixo.setId(Integer.parseInt(cursor.getString(0)));
                    dados.getPrefixos().add(prefixo);
                }catch (Exception e){
                    throw new Exception("Erro ao listar dados IUPAC");

                }
            }while (cursor.moveToNext());

//        query.append("select * from infixo;");
//
//        Cursor cursor = sqLiteDatabase.rawQuery(query.toString(),null);
//
//        if(cursor.moveToFirst()){
//            do{
//                try{
//                    Infixo prefixo = new Infixo(Integer.parseInt(cursor.getString(1)), cursor.getString(2),cursor.getColumnName(3));
//                    prefixo.setId(Integer.parseInt(cursor.getString(0)));
//                    dados.getInfixos().add(prefixo);
//                }catch (Exception e){
//                    throw new Exception("Erro ao listar dados IUPAC");
//
//                }
//            }while (cursor.moveToNext());

            return dados;
        }else{
            return null;
        }
    }


}
