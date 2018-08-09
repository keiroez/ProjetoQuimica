package br.com.model.VO;

public class Sufixo {
    private int id;
    private String grupo;
    private String sufixo;

    public Sufixo(String grupo, String sufixo) {
        this.grupo = grupo;
        this.sufixo = sufixo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSufixo() {
        return sufixo;
    }

    public void setSufixo(String sufixo) {
        this.sufixo = sufixo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}
