package br.com.model.DAO.fabricaDAO;

import java.util.List;

import br.com.model.VO.Cadeia;

public abstract class CadeiaDAO {
    public abstract void insertDados(Cadeia cadeia) throws Exception;
    public abstract List<Cadeia> listarCadeias() throws Exception;
    public abstract Cadeia cadeiaById(int id) throws Exception;
}
