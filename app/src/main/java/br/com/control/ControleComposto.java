package br.com.control;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import br.com.quimicapp.R;
import br.com.view.Composto_img;


public class ControleComposto implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private List<String> nomes = new ArrayList<String>();
    private Composto_img ci;
    private String lado;

    public ControleComposto(String texto, Composto_img ci, String lado) {
        if(texto.equals("composto")) {
            nomes.add("Hidrocarboneto");
        }
        else if(texto.equals("ligacao")) {
            nomes.add("simples");
            nomes.add("dupla");
            nomes.add("tripla");
        }
        this.ci = ci;
        this.lado = lado;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.img_close){
            ci.getAlerta().dismiss();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        if(parent.getId()== R.id.spinnerLig || parent.getId()==R.id.spinnerLigacao) {
            if (parent.getItemAtPosition(position).toString().equals("simples")){
                ci.adicionarLigacao("simples", lado);
            }
            else if(parent.getItemAtPosition(position).toString().equals("dupla")){
                ci.adicionarLigacao("dupla", lado);
            }
            else if(parent.getItemAtPosition(position).toString().equals("tripla")){
                ci.adicionarLigacao("tripla", lado);
            }
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void preencherSpinner(Context c, Spinner spinner){
        Spinner spn1 = spinner;
        //Cria um ArrayAdapter usando um padrão de layout da classe R do android, passando o ArrayList nomes
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(c, android.R.layout.simple_spinner_dropdown_item, nomes);
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
