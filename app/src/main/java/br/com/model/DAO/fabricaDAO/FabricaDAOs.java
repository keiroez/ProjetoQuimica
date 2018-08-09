package br.com.model.DAO.fabricaDAO;

import android.content.Context;

public abstract class FabricaDAOs {
    public abstract CadeiaDAO createCadeiaDAO(Context context);
    public abstract PrefixoDAO createPrefixoDAO(Context context);
    public abstract InfixoDAO createInfixoDAO(Context context);
    public abstract SufixoDAO createSufixoDAO(Context context);
    public abstract MoleculaDAO createMoleculaDAO(Context context);

}
