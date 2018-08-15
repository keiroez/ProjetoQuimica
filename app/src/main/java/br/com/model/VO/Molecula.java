package br.com.model.VO;

public class Molecula {
    private int id;
    private Molecula ligacaoDireita = null;
    private Molecula ligacaoEsquerda = null;
    private Molecula ligacaoSuperior = null;
    private Molecula ligacaoInferior = null;
    private String tipoLigLeft = "";
    private String tipoLigRight = "";
    private String tipoLigUp="";
    private String tipoLigDown="";
    private int posX;
    private int posY;
    private static int contador = 1;
    private int ligacoes = 4;
    private int numeracaoNaCadeia = 0;
    private Boolean principal = false;

    private int ramificacao= 0;

    public Molecula(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.id = contador;
        contador++;
    }

    public static void zerarContador(){
        contador = 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Molecula getLigacaoDireita() {
        return ligacaoDireita;
    }

    public void setLigacaoDireita(Molecula ligacaoDireita) {
        this.ligacaoDireita = ligacaoDireita;
    }

    public Molecula getLigacaoEsquerda() {
        return ligacaoEsquerda;
    }

    public void setLigacaoEsquerda(Molecula ligacaoEsquerda) {
        this.ligacaoEsquerda = ligacaoEsquerda;
    }

    public Molecula getLigacaoSuperior() {
        return ligacaoSuperior;
    }

    public void setLigacaoSuperior(Molecula ligacaoSuperior) {
        this.ligacaoSuperior = ligacaoSuperior;
    }

    public Molecula getLigacaoInferior() {
        return ligacaoInferior;
    }

    public void setLigacaoInferior(Molecula ligacaoInferior) {
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

    public int getRamificacao() {
        return ramificacao;
    }

    public void setRamificacao(int ramificacao) {
        this.ramificacao = ramificacao;
    }

    public int getLigacoes() {
        return ligacoes;
    }

    public void setLigacoes(int ligacoes) {
        this.ligacoes = ligacoes;
    }

    public int getNumeracaoNaCadeia() {
        return numeracaoNaCadeia;
    }

    public void setNumeracaoNaCadeia(int numeracaoNaCadeia) {
        this.numeracaoNaCadeia = numeracaoNaCadeia;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }
}
