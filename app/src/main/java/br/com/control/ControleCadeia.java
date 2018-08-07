package br.com.control;

import android.content.Context;
import android.view.View;

import br.com.view.Composto_img;

public class ControleCadeia implements View.OnClickListener {

    private Context context;
    private Composto_img ciExistente;
    private String ligacao;

    public ControleCadeia(Context c, Composto_img ciExistente) {
        this.context = c;
        this.ciExistente = ciExistente;
    }


    @Override
    public void onClick(View v) {

        if(v== ciExistente.getAddDown()){

            Composto_img composto_img = new Composto_img(context,(int) ciExistente.getComposto().getX(),(int) ciExistente.getComposto().getY()+200);
            ciExistente.alertComposto("ligacaoComposto", "down",composto_img);
            //composto_img.adicionarComposto("down");
            //adicionarListas(composto_img);
        }

        if(v== ciExistente.getAddRight()){

            Composto_img composto_img = new Composto_img(context,(int) ciExistente.getComposto().getX()+200,(int) ciExistente.getComposto().getY());
            ciExistente.alertComposto("ligacaoComposto", "right",composto_img);
//            composto_img.adicionarComposto("right");
//            adicionarListas(composto_img);
        }

        if(v== ciExistente.getAddLeft()){

            Composto_img composto_img = new Composto_img(context,(int) ciExistente.getComposto().getX()-200,(int) ciExistente.getComposto().getY());
            ciExistente.alertComposto("ligacaoComposto", "left",composto_img);
//            composto_img.adicionarComposto("left");
//            adicionarListas(composto_img);
        }

        if(v== ciExistente.getAddUp()){

            Composto_img composto_img = new Composto_img(context,(int) ciExistente.getComposto().getX(),(int) ciExistente.getComposto().getY()-200);
            ciExistente.alertComposto("ligacaoComposto", "up",composto_img);
//            composto_img.adicionarComposto("up");
//            adicionarListas(composto_img);
        }

        if(v== ciExistente.getComposto()){
            ciExistente.alertComposto("composto", "composto");
        }

        if(v== ciExistente.getLigacaoDown()){
            ciExistente.alertComposto("ligacao", "down");
        }

        if(v== ciExistente.getLigacaoLeft()){
            ciExistente.alertComposto("ligacao", "left");
        }

        if(v== ciExistente.getLigacaoRight()){
            ciExistente.alertComposto("ligacao", "right");
        }

        if(v== ciExistente.getLigacaoUp()){
            ciExistente.alertComposto("ligacao", "up");
        }

    }


    public void verificarLigacao(View view){

    }
}
