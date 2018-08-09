package br.com.model.DAO.fabricaDAO;

import java.util.ArrayList;
import java.util.List;

import br.com.model.VO.Infixo;

public abstract class InfixoDAO {
    public abstract void insertDadosInfixo(List<Infixo> infixos) throws Exception;
    public abstract ArrayList<Infixo> selectDadosInfixo() throws Exception;
    public abstract String buscarInfixoQtd(int qtd, String inicio) throws Exception;
}
