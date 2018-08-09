package br.com.model.DAO.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexaoSQLite extends SQLiteOpenHelper {
    private static SQLiteDatabase database;

    private ConexaoSQLite(Context context) {
        super(context, "bd_quimicapp_v1_0_0_2",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder queryPrefixo = new StringBuilder();
        queryPrefixo.append("create table prefixo (" );
        queryPrefixo.append("id integer primary key, ");
        queryPrefixo.append("qtd integer, ");
        queryPrefixo.append("nome varchar(20) );");
        db.execSQL(queryPrefixo.toString());

        StringBuilder queryInfixo = new StringBuilder();
        queryInfixo.append("create table infixo (" );
        queryInfixo.append("id integer primary key, ");
        queryInfixo.append("qtd integer, ");
        queryInfixo.append("qtdnome varchar(20), ");
        queryInfixo.append("nome varchar(20) );");
        db.execSQL(queryInfixo.toString());

        StringBuilder querySufixo = new StringBuilder();
        querySufixo.append("create table sufixo (" );
        querySufixo.append("id integer primary key, ");
        querySufixo.append("nome varchar(20),");
        querySufixo.append("grupo varchar(20) );");
        db.execSQL(querySufixo.toString());

        StringBuilder queryCadeia = new StringBuilder();
        queryCadeia.append("create table cadeia (" );
        queryCadeia.append("id integer primary key, ");
        queryCadeia.append("nome varchar(100));");
        db.execSQL(queryCadeia.toString());

        StringBuilder queryMolecula = new StringBuilder();
        queryMolecula.append("create table molecula (" );
        queryMolecula.append("id integer primary key, ");
        queryMolecula.append("posX int,");
        queryMolecula.append("posY int,");
        queryMolecula.append("id_cadeia int,");
        queryMolecula.append("FOREIGN KEY(id_cadeia) REFERENCES cadeia(id));");
        db.execSQL(queryMolecula.toString());



        System.out.println("criou bd");
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS prefixo");
//        db.execSQL("DROP TABLE IF EXISTS infixo");
//        db.execSQL("DROP TABLE IF EXISTS sufixo");
//        onCreate(db);
    }

    //SINGLETON
    public static synchronized SQLiteDatabase getConexaoSQLite(Context context){
        if(database==null || !database.isOpen()){
            ConexaoSQLite conn = new ConexaoSQLite(context);
            database = conn.getWritableDatabase();
        }
        return database;
    }
}
