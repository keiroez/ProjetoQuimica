package br.com.model;

import java.util.ArrayList;

public class Cadeia {
    private ArrayList<Molecula> moleculas;

    private Cadeia(){
        moleculas = new ArrayList<>();
    }
    private static Cadeia cadeia = null;

    public static synchronized Cadeia getCadeia(){
        if(cadeia==null)
            cadeia = new Cadeia();
        return cadeia;
    }

    public ArrayList<Molecula> getMoleculas() {
        return moleculas;
    }
}
