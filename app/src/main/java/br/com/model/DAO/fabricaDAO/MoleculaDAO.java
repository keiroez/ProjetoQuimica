package br.com.model.DAO.fabricaDAO;

import java.util.List;

import br.com.model.VO.Cadeia;
import br.com.model.VO.Molecula;

public abstract class MoleculaDAO {
    public abstract void inserirMoleculas(Cadeia cadeia) throws Exception;
    public abstract List<Molecula> listaDeMoleculas(int idCadeia) throws Exception;
}
