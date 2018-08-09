package br.com.model.VO;

import java.util.ArrayList;

public class DadosIUPAC {
    private ArrayList<Prefixo> prefixos = new ArrayList<>();
    private ArrayList<Sufixo> sufixos = new ArrayList<>();
    private ArrayList<Infixo> infixos = new ArrayList<>();

    public ArrayList<Prefixo> getPrefixos() {
        return prefixos;
    }

    public void setPrefixos(ArrayList<Prefixo> prefixos) {
        this.prefixos = prefixos;
    }

    public ArrayList<Sufixo> getSufixos() {
        return sufixos;
    }

    public void setSufixos(ArrayList<Sufixo> sufixos) {
        this.sufixos = sufixos;
    }

    public ArrayList<Infixo> getInfixos() {
        return infixos;
    }

    public void setInfixos(ArrayList<Infixo> infixos) {
        this.infixos = infixos;
    }
}
