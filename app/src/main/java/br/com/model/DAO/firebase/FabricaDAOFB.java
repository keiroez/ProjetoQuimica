package br.com.model.DAO.firebase;

import android.content.Context;

import br.com.model.DAO.fabricaDAO.CadeiaDAO;
import br.com.model.DAO.fabricaDAO.FabricaDAOs;
import br.com.model.DAO.fabricaDAO.InfixoDAO;
import br.com.model.DAO.fabricaDAO.PrefixoDAO;
import br.com.model.DAO.fabricaDAO.SufixoDAO;

public class FabricaDAOFB extends FabricaDAOs {
    @Override
    public CadeiaDAO createCadeiaDAO(Context context) {
        return null;
    }

    @Override
    public PrefixoDAO createPrefixoDAO(Context context) {
        return null;
    }

    @Override
    public InfixoDAO createInfixoDAO(Context context) {
        return null;
    }

    @Override
    public SufixoDAO createSufixoDAO(Context context) {
        return null;
    }
}
