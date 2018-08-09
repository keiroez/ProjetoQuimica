package br.com.model.DAO.fabricaDAO;

import java.util.ArrayList;
import java.util.List;

import br.com.model.VO.Sufixo;

public abstract class SufixoDAO {
    public abstract void insertDadosSufixo(List<Sufixo> sufixo) throws Exception;
    public abstract ArrayList<Sufixo> selectDadosSufixo() throws Exception;
    public abstract String buscarSufixoQtd(String grupo) throws Exception;
}
