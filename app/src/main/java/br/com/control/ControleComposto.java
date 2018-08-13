package br.com.control;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import br.com.model.VO.Molecula;
import br.com.quimicapp.R;
import br.com.view.CadeiaImagens;
import br.com.view.Composto_img;


public class ControleComposto implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private List<String> nomesLigacao = new ArrayList<String>();
    private List<String> nomesCompostos = new ArrayList<String>();
    private Composto_img existenteCompostoImg;
    private String lado;
    private  Composto_img NovoCompostoImg;
    private boolean adicao = false;
    private String ligacao;

    public ControleComposto(String texto, Composto_img ciExistente, String lado) {

            nomesCompostos.add("Hidrocarboneto");
         //   nomesLigacao.add("simples");
           // nomesLigacao.add("dupla");
           // nomesLigacao.add("tripla");

        this.existenteCompostoImg = ciExistente;

        Molecula molecula = buscarMolecula();

        if(molecula.getLigacoes()>=3) {
            nomesLigacao.add("simples");
            nomesLigacao.add("dupla");
            nomesLigacao.add("tripla");
        }
        else if(molecula.getLigacoes()==2){
            nomesLigacao.add("simples");
            nomesLigacao.add("dupla");
        }
        else if(molecula.getLigacoes()==1){
            nomesLigacao.add("simples");
        }

        this.lado = lado;
    }

    public ControleComposto(String texto, Composto_img ciExistente, String lado, Composto_img ciNovo) {



        this.existenteCompostoImg = ciExistente;
        this.lado = lado;
        this.NovoCompostoImg = ciNovo;
        adicao = true;
        ligacao = "simples";

        nomesCompostos.add("Hidrocarboneto");
        Molecula molecula = buscarMolecula();

        if(molecula.getLigacoes()>=3) {
            nomesLigacao.add("simples");
            nomesLigacao.add("dupla");
            nomesLigacao.add("tripla");
        }
        else if(molecula.getLigacoes()==2){
            nomesLigacao.add("simples");
            nomesLigacao.add("dupla");
        }
        else if(molecula.getLigacoes()==1){
            nomesLigacao.add("simples");
        }



    }

    public void alterarLigacao(){
        Molecula molecula = null;
        System.out.println(lado);
        Molecula moleculaCriadora = buscarMolecula();

        if(lado.equals("right"))
            molecula = moleculaCriadora.getLigacaoDireita();
        else if(lado.equals("down"))
            molecula = moleculaCriadora.getLigacaoInferior();
        else if(lado.equals("left"))
            molecula = moleculaCriadora.getLigacaoEsquerda();
        else if(lado.equals("up")){
            molecula = moleculaCriadora.getLigacaoSuperior();
        }

        moleculaCriadora.setRamificacao(moleculaCriadora.getRamificacao()+1);
        molecula.setRamificacao(molecula.getRamificacao()+1);


        //mudar ligaçao
        if(lado.equals("up")){
            molecula.setLigacaoInferior(moleculaCriadora);
            molecula.setTipoLigDown(ligacao);

            moleculaCriadora.setLigacaoSuperior(molecula);
            molecula.setTipoLigUp(ligacao);
        }

        if(lado.equals("right")){
            molecula.setLigacaoEsquerda(moleculaCriadora);
            molecula.setTipoLigLeft(ligacao);

            moleculaCriadora.setLigacaoDireita(molecula);
            molecula.setTipoLigRight(ligacao);
        }

        if(lado.equals("down")){
            molecula.setLigacaoSuperior(moleculaCriadora);
            molecula.setTipoLigUp(ligacao);

            moleculaCriadora.setLigacaoInferior(molecula);
            molecula.setTipoLigDown(ligacao);
        }

        if(lado.equals("left")){
            molecula.setLigacaoDireita(moleculaCriadora);
            molecula.setTipoLigRight(ligacao);

            moleculaCriadora.setLigacaoEsquerda(molecula);
            molecula.setTipoLigLeft(ligacao);
        }

        Composto_img compostoNovo = null;
        for (Composto_img compostoImg: CadeiaImagens.getCadeiaImagens().getCompostosImagens()
             ) {
            if(lado.equals("up")){
                if(moleculaCriadora.getLigacaoSuperior().getId()==compostoImg.getId()){
                    compostoNovo = compostoImg;
                }
            }
            else if(lado.equals("right")){
                if(moleculaCriadora.getLigacaoDireita().getId()==compostoImg.getId()){
                    compostoNovo = compostoImg;
                }
            }
            else if(lado.equals("down")){
                if(moleculaCriadora.getLigacaoInferior().getId()==compostoImg.getId()){
                    compostoNovo = compostoImg;
                }
            }
            else if(lado.equals("left")){
                if(moleculaCriadora.getLigacaoEsquerda().getId()==compostoImg.getId()){
                    compostoNovo = compostoImg;
                }
            }
        }

        if(ligacao.equals("simples")){
            moleculaCriadora.setLigacoes(moleculaCriadora.getLigacoes()-1);
            molecula.setLigacoes(molecula.getLigacoes()-1);
            if(moleculaCriadora.getLigacoes()>0) {
                int qtdNova = Integer.parseInt((existenteCompostoImg.getQtdElemento1().getText()).toString()) - 1;
                existenteCompostoImg.getQtdElemento1().setText(String.valueOf(qtdNova));
            }
            else {
                existenteCompostoImg.getElemento1().setText("");
                existenteCompostoImg.getQtdElemento1().setText("");
                existenteCompostoImg.getElemento2().setX(existenteCompostoImg.getElemento1().getX()+17);
            }
            int qtdNova = Integer.parseInt(compostoNovo.getQtdElemento1().getText().toString()) -1;
            compostoNovo.getQtdElemento1().setText(String.valueOf(qtdNova));
        }
        else if(ligacao.equals("dupla")){
            moleculaCriadora.setLigacoes(moleculaCriadora.getLigacoes()-2);
            molecula.setLigacoes(molecula.getLigacoes()-2);
            if(moleculaCriadora.getLigacoes()>0) {
                int qtdNova = Integer.parseInt((existenteCompostoImg.getQtdElemento1().getText()).toString()) - 2;
                existenteCompostoImg.getQtdElemento1().setText(String.valueOf(qtdNova));
            }
            else {
                existenteCompostoImg.getElemento1().setText("");
                existenteCompostoImg.getQtdElemento1().setText("");
                existenteCompostoImg.getElemento2().setX(existenteCompostoImg.getElemento1().getX()+17);
            }
            int qtdNova = Integer.parseInt(compostoNovo.getQtdElemento1().getText().toString()) -2;
            compostoNovo.getQtdElemento1().setText(String.valueOf(qtdNova));
        }
        else if(ligacao.equals("tripla")){
            moleculaCriadora.setLigacoes(moleculaCriadora.getLigacoes()-3);
            molecula.setLigacoes(molecula.getLigacoes()-3);
            if(moleculaCriadora.getLigacoes()>0) {
                int qtdNova = Integer.parseInt((existenteCompostoImg.getQtdElemento1().getText()).toString()) - 3;
                existenteCompostoImg.getQtdElemento1().setText(String.valueOf(qtdNova));
            }
            else {
                existenteCompostoImg.getElemento1().setText("");
                existenteCompostoImg.getQtdElemento1().setText("");
                existenteCompostoImg.getElemento2().setX(existenteCompostoImg.getElemento1().getX()+17);
            }
            int qtdNova = Integer.parseInt(compostoNovo.getQtdElemento1().getText().toString()) -3;
            compostoNovo.getQtdElemento1().setText(String.valueOf(qtdNova));
        }

    }

    //Adicionar molecula as listas de compostos
    public void adicionarListas(Composto_img compostoNovo){
        Molecula molecula = new Molecula((int)compostoNovo.getComposto().getX(),(int)compostoNovo.getComposto().getY());

        Molecula moleculaCriadora = buscarMolecula();

        moleculaCriadora.setRamificacao(moleculaCriadora.getRamificacao()+1);
        molecula.setRamificacao(molecula.getRamificacao()+1);


        //Adicionar ligaçao
        if(lado.equals("up")){
            molecula.setLigacaoInferior(moleculaCriadora);
            molecula.setTipoLigDown(ligacao);

            moleculaCriadora.setLigacaoSuperior(molecula);
            molecula.setTipoLigUp(ligacao);
        }

        if(lado.equals("right")){
            molecula.setLigacaoEsquerda(moleculaCriadora);
            molecula.setTipoLigLeft(ligacao);

            moleculaCriadora.setLigacaoDireita(molecula);
            molecula.setTipoLigRight(ligacao);
        }

        if(lado.equals("down")){
            molecula.setLigacaoSuperior(moleculaCriadora);
            molecula.setTipoLigUp(ligacao);

            moleculaCriadora.setLigacaoInferior(molecula);
            molecula.setTipoLigDown(ligacao);
        }

        if(lado.equals("left")){
            molecula.setLigacaoDireita(moleculaCriadora);
            molecula.setTipoLigRight(ligacao);

            moleculaCriadora.setLigacaoEsquerda(molecula);
            molecula.setTipoLigLeft(ligacao);
        }

        try {
            ControleActivityCadeia.getCadeia().getMoleculas().add(molecula);
        } catch (Exception e) {
            e.printStackTrace();
        }
        CadeiaImagens.getCadeiaImagens().getCompostosImagens().add(compostoNovo);


        if(ligacao.equals("simples")){
            moleculaCriadora.setLigacoes(moleculaCriadora.getLigacoes()-1);
            molecula.setLigacoes(molecula.getLigacoes()-1);
            if(moleculaCriadora.getLigacoes()>0) {
                int qtdNova = Integer.parseInt((existenteCompostoImg.getQtdElemento1().getText()).toString()) - 1;
                existenteCompostoImg.getQtdElemento1().setText(String.valueOf(qtdNova));
            }
            else {
                existenteCompostoImg.getElemento1().setText("");
                existenteCompostoImg.getQtdElemento1().setText("");
                existenteCompostoImg.getElemento2().setX(existenteCompostoImg.getElemento1().getX()+17);
            }
            int qtdNova = Integer.parseInt(compostoNovo.getQtdElemento1().getText().toString()) -1;
            compostoNovo.getQtdElemento1().setText(String.valueOf(qtdNova));
        }
        else if(ligacao.equals("dupla")){
            moleculaCriadora.setLigacoes(moleculaCriadora.getLigacoes()-2);
            molecula.setLigacoes(molecula.getLigacoes()-2);
            if(moleculaCriadora.getLigacoes()>0) {
                int qtdNova = Integer.parseInt((existenteCompostoImg.getQtdElemento1().getText()).toString()) - 2;
                existenteCompostoImg.getQtdElemento1().setText(String.valueOf(qtdNova));
            }
            else {
                existenteCompostoImg.getElemento1().setText("");
                existenteCompostoImg.getQtdElemento1().setText("");
                existenteCompostoImg.getElemento2().setX(existenteCompostoImg.getElemento1().getX()+17);
            }
            int qtdNova = Integer.parseInt(compostoNovo.getQtdElemento1().getText().toString()) -2;
            compostoNovo.getQtdElemento1().setText(String.valueOf(qtdNova));
        }
        else if(ligacao.equals("tripla")){
            moleculaCriadora.setLigacoes(moleculaCriadora.getLigacoes()-3);
            molecula.setLigacoes(molecula.getLigacoes()-3);
            if(moleculaCriadora.getLigacoes()>0) {
                int qtdNova = Integer.parseInt((existenteCompostoImg.getQtdElemento1().getText()).toString()) - 3;
                existenteCompostoImg.getQtdElemento1().setText(String.valueOf(qtdNova));
            }
            else {
                existenteCompostoImg.getElemento1().setText("");
                existenteCompostoImg.getQtdElemento1().setText("");
                existenteCompostoImg.getElemento2().setX(existenteCompostoImg.getElemento1().getX()+17);
            }
            int qtdNova = Integer.parseInt(compostoNovo.getQtdElemento1().getText().toString()) -3;
            compostoNovo.getQtdElemento1().setText(String.valueOf(qtdNova));
        }

//        for (Molecula m: Cadeia.getCadeia().getMoleculas()){
//            System.out.println("ID:"+ m.getId());
//            if(m.getLigacaoSuperior()!=null)
//                System.out.println("Ligação up: "+m.getLigacaoSuperior().getId());
//            if(m.getLigacaoDireita()!=null)
//                System.out.println("Ligação right:"+m.getLigacaoDireita().getId());
//            if(m.getLigacaoInferior()!=null)
//                System.out.println("Ligação down: "+m.getLigacaoInferior().getId());
//            if(m.getLigacaoEsquerda()!=null)
//                System.out.println("Ligação Left: "+m.getLigacaoEsquerda().getId());
//        }
    }

    public Molecula buscarMolecula(){
        Molecula molecula = null;

        try {
            for (Molecula m: ControleActivityCadeia.getCadeia().getMoleculas()
                 ) {
                if(m.getId()==existenteCompostoImg.getId()){
                    molecula = m;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return molecula;
    }

    //Verificar se há molecula ao lado sem ligacao
    public Verificador[] verificarVizinho(Composto_img cpi){
        Verificador[] verificador = new Verificador[4];

        verificador[0] = new Verificador();
        verificador[1] = new Verificador();
        verificador[2] = new Verificador();
        verificador[3] = new Verificador();

        verificador[0].vizinho = false;
        verificador[1].vizinho = false;
        verificador[2].vizinho = false;
        verificador[3].vizinho = false;

        try {
            for (Molecula m: ControleActivityCadeia.getCadeia().getMoleculas()){
                //Up
                if(cpi.getComposto().getY()-200==m.getPosY() && cpi.getComposto().getX()==m.getPosX()){
                    verificador[0].vizinho = true;
                    verificador[0].posXvizinho = m.getPosX();
                    verificador[0].posYvizinho = m.getPosY();
                }
                //Right
                else if (cpi.getComposto().getX() + 200 == m.getPosX() && cpi.getComposto().getY()==m.getPosY()) {
                    verificador[1].vizinho = true;
                    verificador[1].posXvizinho = m.getPosX();
                    verificador[1].posYvizinho = m.getPosY();
                }

                //Down
                else if (cpi.getComposto().getY() + 200 == m.getPosY() && cpi.getComposto().getX()==m.getPosX()) {
                    verificador[2].vizinho = true;
                    verificador[2].posXvizinho = m.getPosX();
                    verificador[2].posYvizinho = m.getPosY();
                }

                //Left
                else if (cpi.getComposto().getX() - 200 == m.getPosX() && cpi.getComposto().getY()==m.getPosY()) {
                    verificador[3].vizinho = true;
                    verificador[3].posXvizinho = m.getPosX();
                    verificador[3].posYvizinho = m.getPosY();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return verificador;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.img_close){
            existenteCompostoImg.getAlerta().dismiss();
        }

        if(v.getId()==R.id.bt_inserir){
            if(lado=="down"){
                adicionarListas(NovoCompostoImg);
                NovoCompostoImg.adicionarComposto("down",verificarVizinho(NovoCompostoImg));
                existenteCompostoImg.adicionarLigacao(ligacao,lado, buscarMolecula().getLigacoes());

               existenteCompostoImg.getAlerta().dismiss();
            }

            if(lado=="up"){
                adicionarListas(NovoCompostoImg);
                NovoCompostoImg.adicionarComposto("up",verificarVizinho(NovoCompostoImg));
                existenteCompostoImg.adicionarLigacao(ligacao,lado, buscarMolecula().getLigacoes());

                existenteCompostoImg.getAlerta().dismiss();
            }

            if(lado=="left"){
                adicionarListas(NovoCompostoImg);
                NovoCompostoImg.adicionarComposto("left",verificarVizinho(NovoCompostoImg));
                existenteCompostoImg.adicionarLigacao(ligacao,lado, buscarMolecula().getLigacoes());

                existenteCompostoImg.getAlerta().dismiss();
            }

            if(lado=="right"){
                adicionarListas(NovoCompostoImg);
                NovoCompostoImg.adicionarComposto("right", verificarVizinho(NovoCompostoImg));
                existenteCompostoImg.adicionarLigacao(ligacao,lado, buscarMolecula().getLigacoes());

                existenteCompostoImg.getAlerta().dismiss();
            }
        }

        if(v.getId()==R.id.bt_cancelar){
            existenteCompostoImg.getAlerta().dismiss();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(parent.getId()==R.id.spinnerLigacao) {
                if (parent.getItemAtPosition(position).toString().equals("simples")) {
//                    existenteCompostoImg.adicionarLigacao("simples", lado, buscarMolecula().getLigacoes());
//                    ligacao = "simples";
                    alterarLigacao();
                } else if (parent.getItemAtPosition(position).toString().equals("dupla")) {
//                    existenteCompostoImg.adicionarLigacao("dupla", lado, buscarMolecula().getLigacoes());
//                    ligacao = "dupla";
//                    alterarLigacao();
                } else if (parent.getItemAtPosition(position).toString().equals("tripla")) {
//                    existenteCompostoImg.adicionarLigacao("tripla", lado, buscarMolecula().getLigacoes());
//                    ligacao = "tripla";
//                    alterarLigacao();
                }
        }
        if(parent.getId()== R.id.spinnerLig){
            if (parent.getItemAtPosition(position).toString().equals("simples")) {
                ligacao = "simples";
            } else if (parent.getItemAtPosition(position).toString().equals("dupla")) {
                ligacao = "dupla";
            } else if (parent.getItemAtPosition(position).toString().equals("tripla")) {
                ligacao = "tripla";
            }

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void preencherSpinner(Context c, Spinner spinner){
        Spinner spn1 = spinner;
        List<String> lista;
        if(spn1.getId()==R.id.spinnerLigacao || spn1.getId()==R.id.spinnerLig){
            lista = nomesLigacao;
        }
        else {
            lista = nomesCompostos;
        }
        //Cria um ArrayAdapter usando um padrão de layout da classe R do android, passando o ArrayList nomesLigacao
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(c, android.R.layout.simple_spinner_dropdown_item, lista);
        ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spn1.setAdapter(spinnerArrayAdapter);


        //Método do Spinner para capturar o item selecionado
        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
                //pega nome pela posição
                String nome = parent.getItemAtPosition(posicao).toString();
                //imprime um Toast na tela com o nome que foi selecionado
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    //Verificador de vizinhos
    public class Verificador{
        public Boolean vizinho = false;
        public int posXvizinho;
        public int posYvizinho;

        public Verificador() {
            this.vizinho = false;
        }
    }
}
