package br.com.model.VO;

import android.content.Context;

import br.com.model.DAO.Fachada;


//ADAPTER
public class CadeiaAdapter {
    public static String transformarString(int[] vetor, Context context) throws Exception {
        String nomeclatura="";
        int[] cadeiaVetor = vetor;

        String prefixo = Fachada.buscarPrefixoQtd(cadeiaVetor[0], context);
        String infixo = Fachada.buscarInfixoQtd(1,"an", context);


        if(vetor[2]>0 && vetor[3]==0){
            infixo = Fachada.buscarInfixoQtd(vetor[2],"en", context);
        }

        if(vetor[3]>0 && vetor[2]==0){
            infixo = Fachada.buscarInfixoQtd(vetor[3],"in", context);
        }

        if(vetor[3]>0 && vetor[2]>0){
            infixo="enin";
        }

        String sufixo = Fachada.buscarSufixoGrupo("hidrocarboneto", context);

        nomeclatura = prefixo+infixo+sufixo;


        return nomeclatura;
    }

    public static String transformarStringRadical(int[] vetor, Context context) throws Exception {
        String nomeclatura="";
        int[] cadeiaVetor = vetor;

        String prefixo = Fachada.buscarPrefixoQtd(cadeiaVetor[0], context);


        String sufixo = "il";

        nomeclatura = prefixo+sufixo;


        return nomeclatura;
    }


}
