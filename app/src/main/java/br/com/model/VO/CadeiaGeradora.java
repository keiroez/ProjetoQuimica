package br.com.model.VO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class CadeiaGeradora {
    private List<Cadeia> radicais =  new ArrayList<>();
    private List<Molecula> cadeiaPrincipal = new ArrayList<>();


    //TEMPLATE METHOD
    public abstract int[] verificarLigacoes(String anterior, Molecula molecula);
    //public abstract int[] contarCarbono(int[] tmp, String anterior, Molecula molecula);

//    public int[] verificarCadeia(Molecula molecula, String anterior) throws Exception {
//        int contadorCarbono[] = new int[4];//verificarLigacoes(anterior, molecula);
//        if(anterior.equals(""))
//            contadorCarbono[0]=1;
//
//        if(molecula.getLigacaoSuperior()!=null && !anterior.equals("up")) {
//            for(int i=0; i<4;i++) {
//                contadorCarbono[i] += contarCarbono(verificarCadeia(molecula.getLigacaoSuperior(), "down"), anterior, molecula)[i];
//            }
//        }
//        if(molecula.getLigacaoDireita()!=null && !anterior.equals("right")) {
//            for(int i=0; i<4;i++) {
//                contadorCarbono[i] += contarCarbono(verificarCadeia(molecula.getLigacaoDireita(), "left"), anterior, molecula)[i];
//            }
//        }
//        if(molecula.getLigacaoInferior()!=null && !anterior.equals("down")){
//            for(int i=0; i<4;i++) {
//                contadorCarbono[i] += contarCarbono(verificarCadeia(molecula.getLigacaoInferior(), "up"), anterior, molecula)[i];
//            }
//        }
//        if(molecula.getLigacaoEsquerda()!=null && !anterior.equals("left")){
//            for(int i=0; i<4;i++) {
//                contadorCarbono[i] += contarCarbono(verificarCadeia(molecula.getLigacaoEsquerda(), "right"), anterior, molecula)[i];
//            }
//        }
//
//        return contadorCarbono;
//    };



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
