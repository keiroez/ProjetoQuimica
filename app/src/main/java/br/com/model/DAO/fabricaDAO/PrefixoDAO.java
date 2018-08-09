package br.com.model.DAO.fabricaDAO;

import java.util.ArrayList;
import java.util.List;

import br.com.model.VO.Prefixo;

public abstract class PrefixoDAO {
    public abstract void insertDadosPrefixo(List<Prefixo> prefixos) throws Exception;
    public abstract ArrayList<Prefixo> selectDadosPrefixo() throws Exception;
    public abstract String buscarPrefixoQtd(int qtd) throws Exception;
}
