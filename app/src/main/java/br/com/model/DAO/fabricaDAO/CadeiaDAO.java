package br.com.model.DAO.fabricaDAO;

import java.util.List;

import br.com.model.VO.Cadeia;

public abstract class CadeiaDAO {
    public abstract void insertDados(Cadeia cadeia);
    public abstract List<Cadeia> listarCadeias();
    public abstract Cadeia cadeiaById(int id);
}
