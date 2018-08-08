package br.com.model.VO;

public class Prefixo {
    private int id;
    private int qtd;
    private String prefixo;

    public Prefixo(int qtd, String prefixo) {
        this.qtd = qtd;
        this.prefixo = prefixo;
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

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }
}
