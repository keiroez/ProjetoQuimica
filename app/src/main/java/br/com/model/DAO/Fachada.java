package br.com.model.DAO;

import android.content.Context;

import br.com.model.DAO.SQLite.FabricaDAOSQLite;
import br.com.model.DAO.fabricaDAO.FabricaDAOs;
import br.com.model.VO.DadosIUPAC;

public class Fachada {
    public static final FabricaDAOs fabricaDAO = new FabricaDAOSQLite();
    public static void inserirDadosIUPAC(DadosIUPAC dadosIUPAC, Context context) throws Exception {
        if(fabricaDAO.createPrefixoDAO(context).selectDadosPrefixo()==null){
            fabricaDAO.createPrefixoDAO(context).insertDadosPrefixo(dadosIUPAC.getPrefixos());
        }
        if(fabricaDAO.createInfixoDAO(context).selectDadosInfixo()==null){
            fabricaDAO.createInfixoDAO(context).insertDadosInfixo(dadosIUPAC.getInfixos());
        }
        if(fabricaDAO.createSufixoDAO(context).selectDadosSufixo()==null){
            fabricaDAO.createSufixoDAO(context).insertDadosSufixo(dadosIUPAC.getSufixos());
        }
    }

    public static DadosIUPAC listarDadosIUPAC(Context context) throws Exception {
        DadosIUPAC dadosIUPAC = new DadosIUPAC();

        if(fabricaDAO.createPrefixoDAO(context).selectDadosPrefixo()!=null &&
                fabricaDAO.createInfixoDAO(context).selectDadosInfixo()!=null &&
                    fabricaDAO.createSufixoDAO(context).selectDadosSufixo()!=null) {

            dadosIUPAC.setPrefixos(fabricaDAO.createPrefixoDAO(context).selectDadosPrefixo());
            dadosIUPAC.setInfixos(fabricaDAO.createInfixoDAO(context).selectDadosInfixo());
            dadosIUPAC.setSufixos(fabricaDAO.createSufixoDAO(context).selectDadosSufixo());

            return dadosIUPAC;
        }
        return null;
    }

    public static String  buscarPrefixoQtd(int qtd, Context context) throws Exception {
        String prefixo = fabricaDAO.createPrefixoDAO(context).buscarPrefixoQtd(qtd);

        return prefixo;
    }

    public static String  buscarInfixoQtd(int qtd, String inicio, Context context) throws Exception {
        String infixo = fabricaDAO.createInfixoDAO(context).buscarInfixoQtd(qtd, inicio);

        return infixo;
    }

    public static String  buscarSufixoGrupo(String grupo, Context context) throws Exception {
        String sufixo = fabricaDAO.createSufixoDAO(context).buscarSufixoQtd(grupo);

        return sufixo;
    }
}
