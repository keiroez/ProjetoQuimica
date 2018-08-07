package br.com.model.VO;

public abstract class CadeiaGeradora {
    public abstract int[] verificarLigacoes(String anterior, Molecula molecula);

    public int[] gerarNomeclatura(Molecula molecula, String anterior){

        int contadorCarbono[] = verificarLigacoes(anterior, molecula);

        if(molecula.getLigacaoSuperior()!=null && !anterior.equals("up")) {

            int[] tmp = gerarNomeclatura(molecula.getLigacaoSuperior(), "down");

            contadorCarbono[0]+=tmp[0];
            contadorCarbono[1]+=tmp[1];
            contadorCarbono[2]+=tmp[2];
            contadorCarbono[3]+=tmp[3];
        }
        if(molecula.getLigacaoDireita()!=null && !anterior.equals("right")) {
            int[] tmp =gerarNomeclatura(molecula.getLigacaoDireita(),"left");

            contadorCarbono[0]+=tmp[0];
            contadorCarbono[1]+=tmp[1];
            contadorCarbono[2]+=tmp[2];
            contadorCarbono[3]+=tmp[3];
        }
        if(molecula.getLigacaoInferior()!=null && !anterior.equals("down")){

            int[] tmp =gerarNomeclatura(molecula.getLigacaoInferior(),"up");

            contadorCarbono[0]+=tmp[0];
            contadorCarbono[1]+=tmp[1];
            contadorCarbono[2]+=tmp[2];
            contadorCarbono[3]+=tmp[3];
        }
        if(molecula.getLigacaoEsquerda()!=null && !anterior.equals("left")){

            int[] tmp =gerarNomeclatura(molecula.getLigacaoEsquerda(),"right");

            contadorCarbono[0]+=tmp[0];
            contadorCarbono[1]+=tmp[1];
            contadorCarbono[2]+=tmp[2];
            contadorCarbono[3]+=tmp[3];
        }

        return contadorCarbono;
    }
}
