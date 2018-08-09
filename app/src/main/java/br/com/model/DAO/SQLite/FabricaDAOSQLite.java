package br.com.model.DAO.SQLite;

import android.content.Context;

import br.com.model.DAO.fabricaDAO.CadeiaDAO;
import br.com.model.DAO.fabricaDAO.FabricaDAOs;
import br.com.model.DAO.fabricaDAO.InfixoDAO;
import br.com.model.DAO.fabricaDAO.MoleculaDAO;
import br.com.model.DAO.fabricaDAO.PrefixoDAO;
import br.com.model.DAO.fabricaDAO.SufixoDAO;

public class FabricaDAOSQLite extends FabricaDAOs {
    @Override
    public CadeiaDAO createCadeiaDAO(Context context) {
        return new CadeiaDAOSQLite(context);
    }

    @Override
    public PrefixoDAO createPrefixoDAO(Context context) {
        return new PrefixoDAOSQLite(ConexaoSQLite.getConexaoSQLite(context));
    }

    @Override
    public InfixoDAO createInfixoDAO(Context context) {
        return new InfixoDAOSQLite(ConexaoSQLite.getConexaoSQLite(context));
    }

    @Override
    public SufixoDAO createSufixoDAO(Context context) {
        return new SufixoDAOSQLite(ConexaoSQLite.getConexaoSQLite(context));
    }

    @Override
    public MoleculaDAO createMoleculaDAO(Context context) {
        return new MoleculaDAOSQLite(ConexaoSQLite.getConexaoSQLite(context));
    }

}
