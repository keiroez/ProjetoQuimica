package br.com.view;

import java.util.ArrayList;
import java.util.List;

public class CadeiaImagens {
    private List<Composto_img> compostos;
    private static CadeiaImagens cadeiaImagens = null;

    private CadeiaImagens (){compostos = new ArrayList<>();}

    public static synchronized CadeiaImagens getCadeiaImagens(){
        if(cadeiaImagens==null)
            cadeiaImagens = new CadeiaImagens();
        return cadeiaImagens;
    }

    public List<Composto_img> getCompostosImagens() {
        return compostos;
    }

}
