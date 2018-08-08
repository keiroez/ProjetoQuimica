package br.com.model.DAO.fabricaDAO;

import android.content.Context;

import br.com.model.DAO.SQLite.ConexaoSQLite;

public class FabricaDAOSQLite extends FabricaDAOs {
    @Override
    public CadeiaDAO createCadeiaDAO(Context context) {
        return new CadeiaDAOSQLite(context);
    }

    @Override
    public DadosIUPACDAO createDADOSIUPACdao(Context context) {
        return new DadosIUPACDAOSQLite(ConexaoSQLite.getConexaoSQLite(context));
    }
}
