package br.com.control;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import br.com.model.VO.Cadeia;
import br.com.model.VO.Molecula;
import br.com.quimicapp.R;
import br.com.view.Composto_img;


public class ControleComposto implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private List<String> nomesLigacao = new ArrayList<String>();
    private List<String> nomesCompostos = new ArrayList<String>();
    private Composto_img ci;
    private String lado;
    private  Composto_img composto_img;
    private boolean adicao = false;
    private String ligacao;

    public ControleComposto(String texto, Composto_img ci, String lado) {

            nomesCompostos.add("Hidrocarboneto");
            nomesLigacao.add("simples");
            nomesLigacao.add("dupla");
            nomesLigacao.add("tripla");

        this.ci = ci;
        this.lado = lado;
    }

    public ControleComposto(String texto, Composto_img ci, String lado, Composto_img composto_img) {

            nomesCompostos.add("Hidrocarboneto");

            nomesLigacao.add("simples");
            nomesLigacao.add("dupla");
            nomesLigacao.add("tripla");

        this.ci = ci;
        this.lado = lado;
        this.composto_img = composto_img;
        adicao = true;
        ligacao = "simples";
    }

    //Adicionar molecula à cadeia
    public void adicionarMolecula(Composto_img composto){
        Molecula molecula = new Molecula((int)composto.getComposto().getX(),(int)composto.getComposto().getY());
        Cadeia.getCadeia().getMoleculas().add(molecula);

        for (Molecula molecula1:Cadeia.getCadeia().getMoleculas()) {
            System.out.println(molecula1.getId()+" "+molecula1.getPosX()+" "+molecula1.getPosY());
        }
    }

    //Verificar se há molecula ao lado sem ligacao
    public Boolean[] verificarVizinho(Composto_img cpi){
        Boolean[] vizinhos = new Boolean[4];
        vizinhos[0] = false;
        vizinhos[1] = false;
        vizinhos[2] = false;
        vizinhos[3] = false;
        for (Molecula m: Cadeia.getCadeia().getMoleculas()){
            //Up
            if(cpi.getComposto().getY()-200==m.getPosY() && cpi.getComposto().getX()==m.getPosX()){
                vizinhos[0] = true;
            }
            //Right
            else if (cpi.getComposto().getX() + 200 == m.getPosX() && cpi.getComposto().getY()==m.getPosY()) {
                vizinhos[1] = true;
            }

            //Down
            else if (cpi.getComposto().getY() + 200 == m.getPosY() && cpi.getComposto().getX()==m.getPosX()) {
                vizinhos[2] = true;
            }

            //Left
            else if (cpi.getComposto().getX() - 200 == m.getPosX() && cpi.getComposto().getY()==m.getPosY()) {
                vizinhos[3] = true;
            }
        }
        return vizinhos;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.img_close){
            ci.getAlerta().dismiss();
        }

        if(v.getId()==R.id.bt_inserir){
            if(lado=="down"){
                composto_img.adicionarComposto("down",verificarVizinho(composto_img));
                ci.adicionarLigacao(ligacao,lado);
                adicionarMolecula(composto_img);
               ci.getAlerta().dismiss();
            }

            if(lado=="up"){
                composto_img.adicionarComposto("up",verificarVizinho(composto_img));
                ci.adicionarLigacao(ligacao,lado);
                adicionarMolecula(composto_img);
                ci.getAlerta().dismiss();
            }

            if(lado=="left"){
                composto_img.adicionarComposto("left",verificarVizinho(composto_img));
                ci.adicionarLigacao(ligacao,lado);
                adicionarMolecula(composto_img);
                ci.getAlerta().dismiss();
            }

            if(lado=="right"){
                composto_img.adicionarComposto("right", verificarVizinho(composto_img));
                ci.adicionarLigacao(ligacao,lado);
                adicionarMolecula(composto_img);
                ci.getAlerta().dismiss();
            }
        }

        if(v.getId()==R.id.bt_cancelar){
            ci.getAlerta().dismiss();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(parent.getId()==R.id.spinnerLigacao) {
                if (parent.getItemAtPosition(position).toString().equals("simples")) {
                    ci.adicionarLigacao("simples", lado);
                } else if (parent.getItemAtPosition(position).toString().equals("dupla")) {
                    ci.adicionarLigacao("dupla", lado);
                } else if (parent.getItemAtPosition(position).toString().equals("tripla")) {
                    ci.adicionarLigacao("tripla", lado);
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
}
