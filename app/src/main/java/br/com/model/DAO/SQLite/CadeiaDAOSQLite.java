package br.com.model.DAO.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.com.model.DAO.fabricaDAO.CadeiaDAO;
import br.com.model.VO.Cadeia;

public class CadeiaDAOSQLite extends CadeiaDAO {
    private SQLiteDatabase database;

    public CadeiaDAOSQLite(Context context) {
        super();
        database = ConexaoSQLite.getConexaoSQLite(context);
    }

    @Override
    public void insertDados(Cadeia cadeia) {

    }

    @Override
    public List<Cadeia> listarCadeias() {
        return null;
    }

    @Override
    public Cadeia cadeiaById(int id) {
        return null;
    }
}
