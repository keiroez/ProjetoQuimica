package br.com.model.DAO.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexaoSQLite extends SQLiteOpenHelper {
    private static SQLiteDatabase database;

    private ConexaoSQLite(Context context) {
        super(context, "banco_quimicapp",null,1);
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
        queryPrefixo.append("qtd integer, ");
        queryPrefixo.append("qtdnome varchar(20), ");
        queryInfixo.append("nome varchar(20) );");
        db.execSQL(queryInfixo.toString());

        StringBuilder querySufixo = new StringBuilder();
        querySufixo.append("create table sufixo (" );
        querySufixo.append("id integer primary key, ");
        querySufixo.append("nome varchar(20) );");
        db.execSQL(querySufixo.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        String sql = "DROP TABLE IF EXISTS infixo";
//        db.execSQL(sql);
//        onCreate(db);
    }

    public static synchronized SQLiteDatabase getConexaoSQLite(Context context){
        if(database==null || !database.isOpen()){
            ConexaoSQLite conn = new ConexaoSQLite(context);
            database = conn.getWritableDatabase();
        }
        return database;
    }
}
