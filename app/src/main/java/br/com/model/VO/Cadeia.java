package br.com.model.VO;

import java.util.ArrayList;
import java.util.List;

public class Cadeia {
    private List<Molecula> moleculas;

    private Cadeia(){
        moleculas = new ArrayList<>();
    }
    private static Cadeia cadeia = null;

    public static synchronized Cadeia getCadeia(){
        if(cadeia==null)
            cadeia = new Cadeia();
        return cadeia;
    }

    public List<Molecula> getMoleculas() {
        return moleculas;
    }
}
