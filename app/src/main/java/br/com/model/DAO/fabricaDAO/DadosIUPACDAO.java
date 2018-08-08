package br.com.model.DAO.fabricaDAO;

import br.com.model.VO.DadosUIPAC;

public abstract class DadosIUPACDAO {
    public abstract void insertDados(DadosUIPAC dados) throws Exception;
    public abstract DadosUIPAC selectDados() throws Exception;
}
