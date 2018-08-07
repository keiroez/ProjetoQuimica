package br.com.model.VO;

import java.util.ArrayList;
import java.util.List;

public class Cadeia extends CadeiaGeradora {
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

    public int [] verificarLigacoes(String anterior, Molecula molecula){
        int[] contadorLigacao = new int[4];
        contadorLigacao[0] = 1;
        contadorLigacao[1] = 0;
        contadorLigacao[2] = 0;
        contadorLigacao[3] = 0;

        if(anterior.equals("up")) {
            if (molecula.getTipoLigUp().equals("simples"))
                contadorLigacao[1] = 1;
            else if (molecula.getTipoLigUp().equals("dupla"))
                contadorLigacao[2] = 1;
            else if (molecula.getTipoLigUp().equals("tripla"))
                contadorLigacao[3] = 1;
        }

        if(anterior.equals("right")) {
            if (molecula.getTipoLigRight().equals("simples"))
                contadorLigacao[1] = 1;
            else if (molecula.getTipoLigRight().equals("dupla"))
                contadorLigacao[2] = 1;
            else if (molecula.getTipoLigRight().equals("tripla"))
                contadorLigacao[3] = 1;
        }

        if(anterior.equals("down")) {
            if (molecula.getTipoLigDown().equals("simples"))
                contadorLigacao[1] = 1;
            else if (molecula.getTipoLigDown().equals("dupla"))
                contadorLigacao[2] = 1;
            else if (molecula.getTipoLigDown().equals("tripla"))
                contadorLigacao[3] = 1;
        }

        if(anterior.equals("left")) {
            if (molecula.getTipoLigLeft().equals("simples"))
                contadorLigacao[1] = 1;
            else if (molecula.getTipoLigLeft().equals("dupla"))
                contadorLigacao[2] = 1;
            else if (molecula.getTipoLigLeft().equals("tripla"))
                contadorLigacao[3] = 1;
        }

            return contadorLigacao;
    }
}
