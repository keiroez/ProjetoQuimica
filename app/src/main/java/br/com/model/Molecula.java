package br.com.model;

public class Molecula {
    private int id;
    private int ligacaoDireita;
    private int ligacaoEsquerda;
    private int ligacaoSuperior;
    private int ligacaoInferior;
    private String tipoLigLeft, tipoLigRight,tipoLigUp, tipoLigDown;
    private int posX;
    private int posY;
    private static int contador = 1;

    public Molecula(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.id = contador;
        contador++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLigacaoDireita() {
        return ligacaoDireita;
    }

    public void setLigacaoDireita(int ligacaoDireita) {
        this.ligacaoDireita = ligacaoDireita;
    }

    public int getLigacaoEsquerda() {
        return ligacaoEsquerda;
    }

    public void setLigacaoEsquerda(int ligacaoEsquerda) {
        this.ligacaoEsquerda = ligacaoEsquerda;
    }

    public int getLigacaoSuperior() {
        return ligacaoSuperior;
    }

    public void setLigacaoSuperior(int ligacaoSuperior) {
        this.ligacaoSuperior = ligacaoSuperior;
    }

    public int getLigacaoInferior() {
        return ligacaoInferior;
    }

    public void setLigacaoInferior(int ligacaoInferior) {
        this.ligacaoInferior = ligacaoInferior;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public String getTipoLigLeft() {
        return tipoLigLeft;
    }

    public void setTipoLigLeft(String tipoLigLeft) {
        this.tipoLigLeft = tipoLigLeft;
    }

    public String getTipoLigRight() {
        return tipoLigRight;
    }

    public void setTipoLigRight(String tipoLigRight) {
        this.tipoLigRight = tipoLigRight;
    }

    public String getTipoLigUp() {
        return tipoLigUp;
    }

    public void setTipoLigUp(String tipoLigUp) {
        this.tipoLigUp = tipoLigUp;
    }

    public String getTipoLigDown() {
        return tipoLigDown;
    }

    public void setTipoLigDown(String tipoLigDown) {
        this.tipoLigDown = tipoLigDown;
    }
}
