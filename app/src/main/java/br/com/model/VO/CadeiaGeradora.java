package br.com.model.VO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class CadeiaGeradora {
    private List<Cadeia> radicais =  new ArrayList<>();
    private List<Molecula> cadeiaPrincipal = new ArrayList<>();


    //TEMPLATE METHOD
    public abstract int[] verificarLigacoes(String anterior, Molecula molecula);

    public int[] contarCarbonosCadeiaPrincipal(String anterior, Molecula molecula){
        int contadorCarbono[] = new int[4];
        //Up
        if(anterior.equals("down"))
            contadorCarbono[0] = 1;
        else
            contadorCarbono[0] = 0;
        //Right
        if(anterior.equals("left"))
            contadorCarbono[1] = 1;
        else
            contadorCarbono[1] = 0;
        //Down
        if(anterior.equals("up"))
            contadorCarbono[2] = 1;
        else
            contadorCarbono[2] = 0;
        //Left
        if(anterior.equals("right"))
            contadorCarbono[3] = 1;
        else
            contadorCarbono[3] = 0;
        if(molecula.getLigacaoSuperior()!=null && !anterior.equals("up")) {
            int [] tmp = contarCarbonosCadeiaPrincipal("down", molecula.getLigacaoSuperior());

            contadorCarbono[0] += tmp[0];
            contadorCarbono[0] += tmp[1];
            contadorCarbono[0] += tmp[2];
            contadorCarbono[0] += tmp[3];
        }
        if(molecula.getLigacaoDireita()!=null && !anterior.equals("right")) {
            int [] tmp = contarCarbonosCadeiaPrincipal("left", molecula.getLigacaoDireita());

            contadorCarbono[1] += tmp[0];
            contadorCarbono[1] += tmp[1];
            contadorCarbono[1] += tmp[2];
            contadorCarbono[1] += tmp[3];

        }
        if(molecula.getLigacaoInferior()!=null && !anterior.equals("down")){
            int [] tmp = contarCarbonosCadeiaPrincipal("up", molecula.getLigacaoInferior());

            contadorCarbono[2] += tmp[0];
            contadorCarbono[2] += tmp[1];
            contadorCarbono[2] += tmp[2];
            contadorCarbono[2] += tmp[3];
        }
        if(molecula.getLigacaoEsquerda()!=null && !anterior.equals("left")){
            int [] tmp = contarCarbonosCadeiaPrincipal("right", molecula.getLigacaoEsquerda());

            contadorCarbono[3] += tmp[0];
            contadorCarbono[3] += tmp[1];
            contadorCarbono[3] += tmp[2];
            contadorCarbono[3] += tmp[3];
        }

        return contadorCarbono;
    }

    public int numerarCadeiaPrincipal(Molecula molecula, String anterior, String[] maiorMenor, Boolean inicio , String tipo){

        int contador = 0;

        if(inicio) {
            if (maiorMenor[1] == "up") {
                //numerarCadeiaPrincipal(molecula.getLigacaoSuperior(),"down", null, false);
                molecula.setNumeracaoNaCadeia(numerarCadeiaPrincipal(molecula.getLigacaoSuperior(),"down", null, false, "menor")+1);
            }

            else if (maiorMenor[1] == "right") {
               //numerarCadeiaPrincipal(molecula.getLigacaoDireita(), "left", null, false);
                molecula.setNumeracaoNaCadeia(numerarCadeiaPrincipal(molecula.getLigacaoDireita(), "left", null, false, "menor")+1);
            }

            else if (maiorMenor[1] == "down") {
               //numerarCadeiaPrincipal(molecula.getLigacaoInferior(),"up", null, false);
                molecula.setNumeracaoNaCadeia(numerarCadeiaPrincipal(molecula.getLigacaoInferior(),"up", null, false, "menor")+1);

            }

            else if (maiorMenor[1] == "left") {
              //numerarCadeiaPrincipal(molecula.getLigacaoEsquerda(), "right", null, false);
                molecula.setNumeracaoNaCadeia(numerarCadeiaPrincipal(molecula.getLigacaoEsquerda(), "right", null, false, "menor")+1);
            }


            if(maiorMenor[0]=="up"){
                numerarCadeiaPrincipal(molecula.getLigacaoSuperior(),"down", null, false, "maior");
            }
            else if(maiorMenor[0]=="right"){
                numerarCadeiaPrincipal(molecula.getLigacaoDireita(),"left", null, false, "maior");
            }
            else if(maiorMenor[0]=="down"){
                numerarCadeiaPrincipal(molecula.getLigacaoInferior(),"up", null, false, "maior");

            }else if(maiorMenor[0]=="left"){
                numerarCadeiaPrincipal(molecula.getLigacaoEsquerda(),"right", null, false, "maior");
            }
        }
        else {
            if(tipo.equals("menor")) {
                if (anterior.equals("down")) {
                    if (molecula.getLigacaoSuperior() == null && molecula.getLigacaoDireita() == null && molecula.getLigacaoEsquerda() == null) {
                        molecula.setNumeracaoNaCadeia(1);

                    } else if (molecula.getLigacaoSuperior() != null && !anterior.equals("up"))
                        molecula.setNumeracaoNaCadeia(numerarCadeiaPrincipal(molecula.getLigacaoSuperior(), "down", null, false, "menor") + 1);

                    else if (molecula.getLigacaoDireita() != null && !anterior.equals("right"))
                        molecula.setNumeracaoNaCadeia(numerarCadeiaPrincipal(molecula.getLigacaoDireita(), "left", null, false, "menor") + 1);

                    else if (molecula.getLigacaoEsquerda() != null && !anterior.equals("left"))
                        molecula.setNumeracaoNaCadeia(numerarCadeiaPrincipal(molecula.getLigacaoEsquerda(), "right", null, false, "menor") + 1);


                }

                if (anterior.equals("left")) {
                    if (molecula.getLigacaoSuperior() == null && molecula.getLigacaoDireita() == null && molecula.getLigacaoInferior() == null) {
                        molecula.setNumeracaoNaCadeia(1);
                    } else if (molecula.getLigacaoDireita() != null && !anterior.equals("right"))
                        molecula.setNumeracaoNaCadeia(numerarCadeiaPrincipal(molecula.getLigacaoDireita(), "left", null, false, "menor") + 1);

                    else if (molecula.getLigacaoSuperior() != null && !anterior.equals("up"))
                        molecula.setNumeracaoNaCadeia(numerarCadeiaPrincipal(molecula.getLigacaoSuperior(), "down", null, false, "menor") + 1);


                    else if (molecula.getLigacaoInferior() != null && !anterior.equals("down"))
                        molecula.setNumeracaoNaCadeia(numerarCadeiaPrincipal(molecula.getLigacaoInferior(), "up", null, false, "menor") + 1);

                }

                if (anterior.equals("up")) {
                    if (molecula.getLigacaoInferior() == null && molecula.getLigacaoDireita() == null && molecula.getLigacaoEsquerda() == null) {
                        molecula.setNumeracaoNaCadeia(1);
                    } else if (molecula.getLigacaoInferior() != null && !anterior.equals("down"))
                        molecula.setNumeracaoNaCadeia(numerarCadeiaPrincipal(molecula.getLigacaoInferior(), "up", null, false, "menor") + 1);

                    else if (molecula.getLigacaoDireita() != null && !anterior.equals("right"))
                        molecula.setNumeracaoNaCadeia(numerarCadeiaPrincipal(molecula.getLigacaoDireita(), "left", null, false, "menor") + 1);

                    else if (molecula.getLigacaoEsquerda() != null && !anterior.equals("left"))
                        molecula.setNumeracaoNaCadeia(numerarCadeiaPrincipal(molecula.getLigacaoEsquerda(), "right", null, false, "menor") + 1);

                }

                if (anterior.equals("right")) {
                    if (molecula.getLigacaoSuperior() == null && molecula.getLigacaoInferior() == null && molecula.getLigacaoEsquerda() == null) {
                        molecula.setNumeracaoNaCadeia(1);
                    } else if (molecula.getLigacaoEsquerda() != null && !anterior.equals("left"))
                        molecula.setNumeracaoNaCadeia(numerarCadeiaPrincipal(molecula.getLigacaoEsquerda(), "right", null, false, "menor") + 1);

                    else if (molecula.getLigacaoSuperior() != null && !anterior.equals("up"))
                        molecula.setNumeracaoNaCadeia(numerarCadeiaPrincipal(molecula.getLigacaoSuperior(), "down", null, false, "menor") + 1);

                    else if (molecula.getLigacaoInferior() != null && !anterior.equals("down"))
                        molecula.setNumeracaoNaCadeia(numerarCadeiaPrincipal(molecula.getLigacaoInferior(), "up", null, false, "menor") + 1);

                }
            }

            if(tipo.equals("maior")){
                if(anterior.equals("down")){
                    if (molecula.getLigacaoSuperior() == null && molecula.getLigacaoDireita() == null && molecula.getLigacaoEsquerda() == null) {
                        molecula.setNumeracaoNaCadeia(molecula.getLigacaoInferior().getNumeracaoNaCadeia()+1);

                    } else if (molecula.getLigacaoSuperior() != null && !anterior.equals("up")){
                        molecula.setNumeracaoNaCadeia(molecula.getLigacaoInferior().getNumeracaoNaCadeia()+1);
                        numerarCadeiaPrincipal(molecula.getLigacaoSuperior(), "down", null, false, "maior");
                    }

                    else if (molecula.getLigacaoDireita() != null && !anterior.equals("right")) {
                        molecula.setNumeracaoNaCadeia(molecula.getLigacaoInferior().getNumeracaoNaCadeia() + 1);
                        numerarCadeiaPrincipal(molecula.getLigacaoDireita(), "left", null, false, "maior");
                    }
                    else if (molecula.getLigacaoEsquerda() != null && !anterior.equals("left")){
                        molecula.setNumeracaoNaCadeia(molecula.getLigacaoInferior().getNumeracaoNaCadeia()+1);
                        numerarCadeiaPrincipal(molecula.getLigacaoEsquerda(), "right", null, false, "maior");
                    }
                }

                if(anterior.equals("left")){
                    if (molecula.getLigacaoSuperior() == null && molecula.getLigacaoDireita() == null && molecula.getLigacaoInferior() == null) {
                        molecula.setNumeracaoNaCadeia(molecula.getLigacaoEsquerda().getNumeracaoNaCadeia()+1);

                    } else if (molecula.getLigacaoSuperior() != null && !anterior.equals("up")){
                        molecula.setNumeracaoNaCadeia(molecula.getLigacaoEsquerda().getNumeracaoNaCadeia()+1);
                        numerarCadeiaPrincipal(molecula.getLigacaoSuperior(), "down", null, false, "maior");
                    }

                    else if (molecula.getLigacaoDireita() != null && !anterior.equals("right")) {
                        molecula.setNumeracaoNaCadeia(molecula.getLigacaoEsquerda().getNumeracaoNaCadeia() + 1);
                        numerarCadeiaPrincipal(molecula.getLigacaoDireita(), "left", null, false, "maior");
                    }
                    else if (molecula.getLigacaoInferior() != null && !anterior.equals("left")){
                        molecula.setNumeracaoNaCadeia(molecula.getLigacaoEsquerda().getNumeracaoNaCadeia()+1);
                        numerarCadeiaPrincipal(molecula.getLigacaoInferior(), "up", null, false, "maior");
                    }
                }

                if(anterior.equals("up")){
                    if (molecula.getLigacaoInferior() == null && molecula.getLigacaoDireita() == null && molecula.getLigacaoEsquerda() == null) {
                        molecula.setNumeracaoNaCadeia(molecula.getLigacaoSuperior().getNumeracaoNaCadeia()+1);

                    } else if (molecula.getLigacaoEsquerda() != null && !anterior.equals("left")){
                        molecula.setNumeracaoNaCadeia(molecula.getLigacaoSuperior().getNumeracaoNaCadeia()+1);
                        numerarCadeiaPrincipal(molecula.getLigacaoEsquerda(), "right", null, false, "maior");
                    }

                    else if (molecula.getLigacaoDireita() != null && !anterior.equals("right")) {
                        molecula.setNumeracaoNaCadeia(molecula.getLigacaoSuperior().getNumeracaoNaCadeia() + 1);
                        numerarCadeiaPrincipal(molecula.getLigacaoDireita(), "left", null, false, "maior");
                    }
                    else if (molecula.getLigacaoInferior() != null && !anterior.equals("down")){
                        molecula.setNumeracaoNaCadeia(molecula.getLigacaoSuperior().getNumeracaoNaCadeia()+1);
                        numerarCadeiaPrincipal(molecula.getLigacaoInferior(), "up", null, false, "maior");
                    }
                }

                if(anterior.equals("right")){
                    if (molecula.getLigacaoSuperior() == null && molecula.getLigacaoInferior() == null && molecula.getLigacaoEsquerda() == null) {
                        molecula.setNumeracaoNaCadeia(molecula.getLigacaoDireita().getNumeracaoNaCadeia()+1);

                    } else if (molecula.getLigacaoSuperior() != null && !anterior.equals("left")){
                        molecula.setNumeracaoNaCadeia(molecula.getLigacaoDireita().getNumeracaoNaCadeia()+1);
                        numerarCadeiaPrincipal(molecula.getLigacaoSuperior(), "down", null, false, "maior");
                    }

                    else if (molecula.getLigacaoEsquerda() != null && !anterior.equals("right")) {
                        molecula.setNumeracaoNaCadeia(molecula.getLigacaoDireita().getNumeracaoNaCadeia() + 1);
                        numerarCadeiaPrincipal(molecula.getLigacaoEsquerda(), "right", null, false, "maior");
                    }
                    else if (molecula.getLigacaoInferior() != null && !anterior.equals("down")){
                        molecula.setNumeracaoNaCadeia(molecula.getLigacaoDireita().getNumeracaoNaCadeia()+1);
                        numerarCadeiaPrincipal(molecula.getLigacaoInferior(), "up", null, false, "maior");
                    }
                }
            }
        }



        return molecula.getNumeracaoNaCadeia();
    }



    public String[] verificarRamificacaoMaior(int[] contadorCarbono){
        String maior = "";
        String menor = "";

        //Maior UP
        if(contadorCarbono[0]>=contadorCarbono[1] && contadorCarbono[0]>=contadorCarbono[2] &&
                contadorCarbono[0]>=contadorCarbono[3] && contadorCarbono[0]>0){
            maior = "up";
            if(contadorCarbono[1]>=contadorCarbono[2] && contadorCarbono[1]>=contadorCarbono[3] && contadorCarbono[1]>0){
                menor = "right";
            }
            else if(contadorCarbono[2]>=contadorCarbono[1] && contadorCarbono[2]>=contadorCarbono[3] && contadorCarbono[2]>0){
                menor = "down";
            }
            else if(contadorCarbono[3]>=contadorCarbono[1] && contadorCarbono[3]>=contadorCarbono[2] && contadorCarbono[3]>0){
                menor = "left";
            }
        }

        //Maior Right
        else if(contadorCarbono[1]>=contadorCarbono[0] && contadorCarbono[1]>=contadorCarbono[2] &&
                contadorCarbono[1]>=contadorCarbono[3] && contadorCarbono[1]>0){
            maior = "right";
            if(contadorCarbono[0]>=contadorCarbono[2] && contadorCarbono[0]>=contadorCarbono[3] && contadorCarbono[0]>0){
                menor = "up";
            }
            else if(contadorCarbono[2]>=contadorCarbono[0] && contadorCarbono[2]>=contadorCarbono[3] && contadorCarbono[2]>0){
                menor = "down";
            }
            else if(contadorCarbono[3]>=contadorCarbono[0] && contadorCarbono[3]>=contadorCarbono[2] && contadorCarbono[3]>0){
                menor = "left";
            }
        }

        //Maior Down
       else if(contadorCarbono[2]>=contadorCarbono[0] && contadorCarbono[2]>=contadorCarbono[1] &&
                contadorCarbono[2]>=contadorCarbono[3] && contadorCarbono[2]>0){
            maior = "down";
            if(contadorCarbono[0]>=contadorCarbono[1] && contadorCarbono[0]>=contadorCarbono[3] && contadorCarbono[0]>0){
                menor = "up";
            }
            else if(contadorCarbono[1]>=contadorCarbono[0] && contadorCarbono[1]>=contadorCarbono[3] && contadorCarbono[1]>0){
                menor = "right";
            }
            else if(contadorCarbono[3]>=contadorCarbono[0] && contadorCarbono[3]>=contadorCarbono[1] && contadorCarbono[3]>0){
                menor = "left";
            }
        }

        //Maior Left
        else if(contadorCarbono[3]>=contadorCarbono[0] && contadorCarbono[3]>=contadorCarbono[1] &&
                contadorCarbono[3]>=contadorCarbono[2] && contadorCarbono[3]>1){
            maior = "left";
            if(contadorCarbono[0]>=contadorCarbono[1] && contadorCarbono[0]>=contadorCarbono[2] && contadorCarbono[0]>0){
                menor = "up";
            }
            else if(contadorCarbono[1]>=contadorCarbono[0] && contadorCarbono[1]>=contadorCarbono[2] && contadorCarbono[1]>0){
                menor = "right";
            }
            else if(contadorCarbono[2]>=contadorCarbono[0] && contadorCarbono[2]>=contadorCarbono[1] && contadorCarbono[2]>0){
                menor = "down";
            }
        }

        String[] maiorMenor = new String[2];
        maiorMenor[0] = maior;
        maiorMenor[1] = menor;
        return maiorMenor;
    }


    public int[] gerarNomeclatura(Molecula molecula, String anterior){

        int contadorCarbono[] = verificarLigacoes(anterior, molecula);

        if(molecula.getLigacaoSuperior()!=null && !anterior.equals("up")) {

            int[] tmp = gerarNomeclatura(molecula.getLigacaoSuperior(), "down");
            //contador C
            contadorCarbono[0]+=tmp[0];
            //contador ligacao simples
            contadorCarbono[1]+=tmp[1];
            //contador ligacao dupla
            contadorCarbono[2]+=tmp[2];
            //contador ligacao tripla
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



    public List<Molecula> verificarCadeiaPrincipal(Molecula molecula, String anterior, Boolean inicial) throws Exception {
        Cadeia cadeiaPrincipal = new Cadeia();
        Cadeia cadeiaPrincipalUp = new Cadeia();
        Cadeia cadeiaPrincipalRight = new Cadeia();
        Cadeia cadeiaPrincipalDown = new Cadeia();
        Cadeia cadeiaPrincipalLeft = new Cadeia();

        Boolean up = false;
        Boolean right = false;
        Boolean down = false;
        Boolean left = false;

        cadeiaPrincipal.getMoleculas().add(molecula);


        if(molecula.getLigacaoSuperior()!=null && !anterior.equals("up")) {
            for (Molecula m: verificarCadeiaPrincipal(molecula.getLigacaoSuperior(),"down", false)
                 ) {
                cadeiaPrincipalUp.getMoleculas().add(m);
            }
        }
        if(molecula.getLigacaoDireita()!=null && !anterior.equals("right")) {
            for (Molecula m: verificarCadeiaPrincipal(molecula.getLigacaoDireita(),"left", false)
                    ) {
                cadeiaPrincipalRight.getMoleculas().add(m);
            }
        }
        if(molecula.getLigacaoInferior()!=null && !anterior.equals("down")){
            for (Molecula m: verificarCadeiaPrincipal(molecula.getLigacaoInferior(),"up",false)
                    ) {
                cadeiaPrincipalDown.getMoleculas().add(m);
            }
        }
        if(molecula.getLigacaoEsquerda()!=null && !anterior.equals("left")){
            for (Molecula m: verificarCadeiaPrincipal(molecula.getLigacaoEsquerda(),"right", false)
                    ) {
                cadeiaPrincipalLeft.getMoleculas().add(m);
            }
        }
//        if(molecula.getLigacaoSuperior()!=null && molecula.getLigacaoDireita()!=null && molecula.getLigacaoInferior()!=null &&
//                molecula.getLigacaoEsquerda()!=null){
//            cadeiaPrincipal.getMoleculas().add(molecula);
//        }


        //Verificar ligaçoes duplas e triplas
        if(!inicial) {
            for (Molecula m : cadeiaPrincipalUp.getMoleculas()
                    ) {
                if (m.getTipoLigUp().equals("tripla") || m.getTipoLigRight().equals("tripla") || m.getTipoLigDown().equals("tripla") || m.getTipoLigLeft().equals("tripla")
                        || m.getTipoLigUp().equals("dupla") || m.getTipoLigRight().equals("dupla") || m.getTipoLigDown().equals("dupla") || m.getTipoLigLeft().equals("dupla")) {
                    for (Molecula molec : cadeiaPrincipalUp.getMoleculas()
                            ) {
                        cadeiaPrincipal.getMoleculas().add(molec);
                    }
                    up = true;
                    break;
                }
            }
            for (Molecula m : cadeiaPrincipalRight.getMoleculas()
                    ) {
                if (m.getTipoLigUp().equals("tripla") || m.getTipoLigRight().equals("tripla") || m.getTipoLigDown().equals("tripla") || m.getTipoLigLeft().equals("tripla")
                        || m.getTipoLigUp().equals("dupla") || m.getTipoLigRight().equals("dupla") || m.getTipoLigDown().equals("dupla") || m.getTipoLigLeft().equals("dupla")) {
                    for (Molecula molec : cadeiaPrincipalRight.getMoleculas()
                            ) {
                        cadeiaPrincipal.getMoleculas().add(molec);
                    }
                    right = true;
                    break;
                }
            }

            for (Molecula m : cadeiaPrincipalDown.getMoleculas()
                    ) {
                if (m.getTipoLigUp().equals("tripla") || m.getTipoLigRight().equals("tripla") || m.getTipoLigDown().equals("tripla") || m.getTipoLigLeft().equals("tripla")
                        || m.getTipoLigUp().equals("dupla") || m.getTipoLigRight().equals("dupla") || m.getTipoLigDown().equals("dupla") || m.getTipoLigLeft().equals("dupla")) {
                    for (Molecula molec : cadeiaPrincipalDown.getMoleculas()
                            ) {
                        cadeiaPrincipal.getMoleculas().add(molec);
                    }
                    down = true;
                    break;
                }

            }

            for (Molecula m : cadeiaPrincipalLeft.getMoleculas()
                    ) {
                if (m.getTipoLigUp().equals("tripla") || m.getTipoLigRight().equals("tripla") || m.getTipoLigDown().equals("tripla") || m.getTipoLigLeft().equals("tripla")
                        || m.getTipoLigUp().equals("dupla") || m.getTipoLigRight().equals("dupla") || m.getTipoLigDown().equals("dupla") || m.getTipoLigLeft().equals("dupla")) {
                    for (Molecula molec : cadeiaPrincipalLeft.getMoleculas()
                            ) {
                        cadeiaPrincipal.getMoleculas().add(molec);
                    }
                    left = true;
                    break;
                }

            }

            if (!up && !right && !down && !left) {
                //Verificar cadeia maior
                if (cadeiaPrincipalUp.getMoleculas().size() > cadeiaPrincipalRight.getMoleculas().size()
                        && cadeiaPrincipalUp.getMoleculas().size() > cadeiaPrincipalDown.getMoleculas().size()
                        && cadeiaPrincipalUp.getMoleculas().size() > cadeiaPrincipalLeft.getMoleculas().size()) {
                    for (Molecula m : cadeiaPrincipalUp.getMoleculas()
                            ) {
                        cadeiaPrincipal.getMoleculas().add(m);
                    }
                } else if (cadeiaPrincipalRight.getMoleculas().size() > cadeiaPrincipalUp.getMoleculas().size()
                        && cadeiaPrincipalRight.getMoleculas().size() > cadeiaPrincipalDown.getMoleculas().size()
                        && cadeiaPrincipalRight.getMoleculas().size() > cadeiaPrincipalLeft.getMoleculas().size()) {
                    for (Molecula m : cadeiaPrincipalRight.getMoleculas()
                            ) {
                        cadeiaPrincipal.getMoleculas().add(m);
                    }
                } else if (cadeiaPrincipalDown.getMoleculas().size() > cadeiaPrincipalRight.getMoleculas().size()
                        && cadeiaPrincipalDown.getMoleculas().size() > cadeiaPrincipalUp.getMoleculas().size()
                        && cadeiaPrincipalDown.getMoleculas().size() > cadeiaPrincipalLeft.getMoleculas().size()) {
                    for (Molecula m : cadeiaPrincipalDown.getMoleculas()
                            ) {
                        cadeiaPrincipal.getMoleculas().add(m);
                    }
                } else if (cadeiaPrincipalLeft.getMoleculas().size() > cadeiaPrincipalRight.getMoleculas().size()
                        && cadeiaPrincipalLeft.getMoleculas().size() > cadeiaPrincipalDown.getMoleculas().size()
                        && cadeiaPrincipalLeft.getMoleculas().size() > cadeiaPrincipalUp.getMoleculas().size()) {
                    for (Molecula m : cadeiaPrincipalLeft.getMoleculas()
                            ) {
                        cadeiaPrincipal.getMoleculas().add(m);
                    }
                }

                //ramificaçoes iguais
                else {
                    //UP
                    if (cadeiaPrincipalUp.getMoleculas().size() == cadeiaPrincipalRight.getMoleculas().size()) {
                        for (Molecula m : cadeiaPrincipalUp.getMoleculas()
                                ) {
                            cadeiaPrincipal.getMoleculas().add(m);
                        }
                    } else if (cadeiaPrincipalUp.getMoleculas().size() == cadeiaPrincipalDown.getMoleculas().size()) {
                        for (Molecula m : cadeiaPrincipalUp.getMoleculas()
                                ) {
                            cadeiaPrincipal.getMoleculas().add(m);
                        }
                    } else if (cadeiaPrincipalUp.getMoleculas().size() == cadeiaPrincipalLeft.getMoleculas().size()) {
                        for (Molecula m : cadeiaPrincipalUp.getMoleculas()
                                ) {
                            cadeiaPrincipal.getMoleculas().add(m);
                        }
                    }

                    //Right
                    else if (cadeiaPrincipalRight.getMoleculas().size() == cadeiaPrincipalDown.getMoleculas().size()) {
                        for (Molecula m : cadeiaPrincipalRight.getMoleculas()
                                ) {
                            cadeiaPrincipal.getMoleculas().add(m);
                        }
                    } else if (cadeiaPrincipalRight.getMoleculas().size() == cadeiaPrincipalLeft.getMoleculas().size()) {
                        for (Molecula m : cadeiaPrincipalRight.getMoleculas()
                                ) {
                            cadeiaPrincipal.getMoleculas().add(m);
                        }
                    }

                    //Down
                    else if (cadeiaPrincipalDown.getMoleculas().size() == cadeiaPrincipalLeft.getMoleculas().size()) {
                        for (Molecula m : cadeiaPrincipalDown.getMoleculas()
                                ) {
                            cadeiaPrincipal.getMoleculas().add(m);
                        }
                    }
                }
            }
        }




        if(inicial){
            List<Cadeia> cadeias = new ArrayList<>();
            cadeias.add(cadeiaPrincipalUp);
            cadeias.add(cadeiaPrincipalRight);
            cadeias.add(cadeiaPrincipalDown);
            cadeias.add(cadeiaPrincipalLeft);

            Collections.sort(cadeias);
                    for (int i = 0; i < 2; i++) {
                        for (Molecula m : cadeias.get(i).getMoleculas()) {
                            cadeiaPrincipal.getMoleculas().add(m);
                        }
                    }


//
//            for (Molecula m: cadeiaPrincipalUp.getMoleculas()
//                 ) {
//                cadeiaPrincipal.getMoleculas().add(m);
//            }
//            for (Molecula m: cadeiaPrincipalRight.getMoleculas()
//                    ) {
//                cadeiaPrincipal.getMoleculas().add(m);
//            }
//            for (Molecula m: cadeiaPrincipalDown.getMoleculas()
//                    ) {
//                cadeiaPrincipal.getMoleculas().add(m);
//            }
//            for (Molecula m: cadeiaPrincipalLeft.getMoleculas()
//                    ) {
//                cadeiaPrincipal.getMoleculas().add(m);
//            }
        }


        return cadeiaPrincipal.getMoleculas();

    }




    private void verificarRamificacoes(){

    }

    public List<Molecula> verificarCadeiaPrincipal2(Molecula molecula, String anterior, Boolean inicial) throws Exception {
        Cadeia cadeiaPrincipal = new Cadeia();
        Cadeia cadeiaPrincipalUp = new Cadeia();
        Cadeia cadeiaPrincipalRight = new Cadeia();
        Cadeia cadeiaPrincipalDown = new Cadeia();
        Cadeia cadeiaPrincipalLeft = new Cadeia();


        cadeiaPrincipal.getMoleculas().add(molecula);


        if(molecula.getLigacaoSuperior()!=null && !anterior.equals("up")) {
            for (Molecula m: verificarCadeiaPrincipal2(molecula.getLigacaoSuperior(),"down", false)
                    ) {
                cadeiaPrincipalUp.getMoleculas().add(m);
            }
        }
        if(molecula.getLigacaoDireita()!=null && !anterior.equals("right")) {
            for (Molecula m: verificarCadeiaPrincipal2(molecula.getLigacaoDireita(),"left", false)
                    ) {
                cadeiaPrincipalRight.getMoleculas().add(m);
            }
        }
        if(molecula.getLigacaoInferior()!=null && !anterior.equals("down")){
            for (Molecula m: verificarCadeiaPrincipal2(molecula.getLigacaoInferior(),"up",false)
                    ) {
                cadeiaPrincipalDown.getMoleculas().add(m);
            }
        }
        if(molecula.getLigacaoEsquerda()!=null && !anterior.equals("left")){
            for (Molecula m: verificarCadeiaPrincipal2(molecula.getLigacaoEsquerda(),"right", false)
                    ) {
                cadeiaPrincipalLeft.getMoleculas().add(m);
            }
        }

        if(!inicial) {
            //Verificar cadeia maior
            if (cadeiaPrincipalUp.getMoleculas().size() > cadeiaPrincipalRight.getMoleculas().size()
                    && cadeiaPrincipalUp.getMoleculas().size() > cadeiaPrincipalDown.getMoleculas().size()
                    && cadeiaPrincipalUp.getMoleculas().size() > cadeiaPrincipalLeft.getMoleculas().size()) {
                for (Molecula m : cadeiaPrincipalUp.getMoleculas()
                        ) {
                    cadeiaPrincipal.getMoleculas().add(m);
                }
            } else if (cadeiaPrincipalRight.getMoleculas().size() > cadeiaPrincipalUp.getMoleculas().size()
                    && cadeiaPrincipalRight.getMoleculas().size() > cadeiaPrincipalDown.getMoleculas().size()
                    && cadeiaPrincipalRight.getMoleculas().size() > cadeiaPrincipalLeft.getMoleculas().size()) {
                for (Molecula m : cadeiaPrincipalRight.getMoleculas()
                        ) {
                    cadeiaPrincipal.getMoleculas().add(m);
                }
            } else if (cadeiaPrincipalDown.getMoleculas().size() > cadeiaPrincipalRight.getMoleculas().size()
                    && cadeiaPrincipalDown.getMoleculas().size() > cadeiaPrincipalUp.getMoleculas().size()
                    && cadeiaPrincipalDown.getMoleculas().size() > cadeiaPrincipalLeft.getMoleculas().size()) {
                for (Molecula m : cadeiaPrincipalDown.getMoleculas()
                        ) {
                    cadeiaPrincipal.getMoleculas().add(m);
                }
            } else if (cadeiaPrincipalLeft.getMoleculas().size() > cadeiaPrincipalRight.getMoleculas().size()
                    && cadeiaPrincipalLeft.getMoleculas().size() > cadeiaPrincipalDown.getMoleculas().size()
                    && cadeiaPrincipalLeft.getMoleculas().size() > cadeiaPrincipalUp.getMoleculas().size()) {
                for (Molecula m : cadeiaPrincipalLeft.getMoleculas()
                        ) {
                    cadeiaPrincipal.getMoleculas().add(m);
                }
            }
        }

            //ramificaçoes iguais
                //UP
                if (cadeiaPrincipalUp.getMoleculas().size() == cadeiaPrincipalRight.getMoleculas().size()) {
                    for (Molecula m : cadeiaPrincipalUp.getMoleculas()
                            ) {
                        cadeiaPrincipal.getMoleculas().add(m);
                    }
                } else if (cadeiaPrincipalUp.getMoleculas().size() == cadeiaPrincipalDown.getMoleculas().size()) {
                    for (Molecula m : cadeiaPrincipalUp.getMoleculas()
                            ) {
                        cadeiaPrincipal.getMoleculas().add(m);
                    }
                } else if (cadeiaPrincipalUp.getMoleculas().size() == cadeiaPrincipalLeft.getMoleculas().size()) {
                    for (Molecula m : cadeiaPrincipalUp.getMoleculas()
                            ) {
                        cadeiaPrincipal.getMoleculas().add(m);
                    }
                }

                //Right
                else if (cadeiaPrincipalRight.getMoleculas().size() == cadeiaPrincipalDown.getMoleculas().size()) {
                    for (Molecula m : cadeiaPrincipalRight.getMoleculas()
                            ) {
                        cadeiaPrincipal.getMoleculas().add(m);
                    }
                } else if (cadeiaPrincipalRight.getMoleculas().size() == cadeiaPrincipalLeft.getMoleculas().size()) {
                    for (Molecula m : cadeiaPrincipalRight.getMoleculas()
                            ) {
                        cadeiaPrincipal.getMoleculas().add(m);
                    }
                }

                //Down
                else if (cadeiaPrincipalDown.getMoleculas().size() == cadeiaPrincipalLeft.getMoleculas().size()) {
                    for (Molecula m : cadeiaPrincipalDown.getMoleculas()
                            ) {
                        cadeiaPrincipal.getMoleculas().add(m);
                    }
                }

        if(inicial){
            for (Molecula m: cadeiaPrincipalUp.getMoleculas()
                    ) {
                cadeiaPrincipal.getMoleculas().add(m);
            }
            for (Molecula m: cadeiaPrincipalRight.getMoleculas()
                    ) {
                cadeiaPrincipal.getMoleculas().add(m);
            }
            for (Molecula m: cadeiaPrincipalDown.getMoleculas()
                    ) {
                cadeiaPrincipal.getMoleculas().add(m);
            }
            for (Molecula m: cadeiaPrincipalLeft.getMoleculas()
                    ) {
                cadeiaPrincipal.getMoleculas().add(m);
            }
        }

        return cadeiaPrincipal.getMoleculas();

    }
}
