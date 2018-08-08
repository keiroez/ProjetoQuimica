package br.com.model.VO;

public class Infixo {
    private int id;
    private int qtd;
    private String qtdNome;
    private String nome;

    public Infixo(int qtd, String qtdNome, String sufixo) {
        this.qtd = qtd;
        this.qtdNome = qtdNome;
        this.nome = sufixo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQtdNome() {
        return qtdNome;
    }

    public void setQtdNome(String qtdNome) {
        this.qtdNome = qtdNome;
    }
}
