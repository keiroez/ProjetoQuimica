package br.com.model.VO;

public enum TipoLigacao
{
    SIMPLES,
    DUPLA,
    TRIPLA;
    public String toString()
    {
        if (this==SIMPLES)
            return "SIMPLES";
        else
            return "TRIPLA";
    }
}