package br.com.model.DAO.fabricaDAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import br.com.model.DAO.SQLite.ConexaoSQLite;

public class CadeiaDAOSQLite extends CadeiaDAO {
    private SQLiteDatabase database;

    public CadeiaDAOSQLite(Context context) {
        super();
        database = ConexaoSQLite.getConexaoSQLite(context);
    }

    @Override
    public void insertDados() {

    }
}
