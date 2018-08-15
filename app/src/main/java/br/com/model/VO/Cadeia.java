package br.com.model.VO;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import br.com.model.DAO.Fachada;

public class Cadeia extends CadeiaGeradora implements Comparable<Cadeia>{
    private List<Molecula> moleculas;
    private String nome;
    private int id = -1;
    private Context context = null;

   // private static Cadeia cadeia = new Cadeia();

    public Cadeia(){
        moleculas = new ArrayList<>();
    }


//    public static Cadeia getCadeia(){
//        return cadeia;
//    }

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


    //Lazy load
    public List<Molecula> getMoleculas() throws Exception {
        if(this.id==-1)
            return moleculas;
        else
            return Fachada.listarMoleculas(this,context);
    }


    public void setMoleculas(List<Molecula> moleculas) {
            this.moleculas = moleculas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int compareTo(Cadeia cadeia) {
        if (this.moleculas.size() > cadeia.moleculas.size()) {
            return -1;
        }
        if (this.moleculas.size() < cadeia.moleculas.size()) {
            return 1;
        }
        return 0;
    }
}