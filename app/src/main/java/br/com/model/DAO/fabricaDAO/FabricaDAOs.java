package br.com.model.DAO.fabricaDAO;

import android.content.Context;

public abstract class FabricaDAOs {
    public abstract CadeiaDAO createCadeiaDAO(Context context);
    public abstract DadosIUPACDAO createDADOSIUPACdao(Context context);
}
