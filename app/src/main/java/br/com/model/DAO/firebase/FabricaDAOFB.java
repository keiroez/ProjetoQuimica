package br.com.model.DAO.firebase;

import android.content.Context;

import br.com.model.DAO.fabricaDAO.CadeiaDAO;
import br.com.model.DAO.fabricaDAO.FabricaDAOs;
import br.com.model.DAO.fabricaDAO.InfixoDAO;
import br.com.model.DAO.fabricaDAO.MoleculaDAO;
import br.com.model.DAO.fabricaDAO.PrefixoDAO;
import br.com.model.DAO.fabricaDAO.SufixoDAO;

public class FabricaDAOFB extends FabricaDAOs {
    @Override
    public CadeiaDAO createCadeiaDAO(Context context) {
        return new CadeiaDAOFB();
    }

    @Override
    public PrefixoDAO createPrefixoDAO(Context context) {
        return new PrefixoDAOFB();
    }

    @Override
    public InfixoDAO createInfixoDAO(Context context) {
        return new InfixoDAOFB();
    }

    @Override
    public SufixoDAO createSufixoDAO(Context context) {
        return new SufixoDAOFB();
    }

    @Override
    public MoleculaDAO createMoleculaDAO(Context context) {
        return null;
    }
}
