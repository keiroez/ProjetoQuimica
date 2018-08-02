package br.com.control;

import android.content.Context;
import android.view.View;

import br.com.view.Composto_img;

public class ControleCadeia implements View.OnClickListener {

    private Context c;
    private Composto_img ci;
    private String ligacao;

    public ControleCadeia(Context c, Composto_img ci) {
        this.c = c;
        this.ci = ci;

    }

    @Override
    public void onClick(View v) {

        if(v==ci.getAddDown()){

            Composto_img composto_img = new Composto_img(c,(int)ci.getComposto().getX(),(int)ci.getComposto().getY()+200);
            ci.alertComposto("ligacaoComposto", "down",composto_img);
            //composto_img.adicionarComposto("down");
            //adicionarMolecula(composto_img);
        }

        if(v==ci.getAddRight()){

            Composto_img composto_img = new Composto_img(c,(int)ci.getComposto().getX()+200,(int)ci.getComposto().getY());
            ci.alertComposto("ligacaoComposto", "right",composto_img);
//            composto_img.adicionarComposto("right");
//            adicionarMolecula(composto_img);
        }

        if(v==ci.getAddLeft()){

            Composto_img composto_img = new Composto_img(c,(int)ci.getComposto().getX()-200,(int)ci.getComposto().getY());
            ci.alertComposto("ligacaoComposto", "left",composto_img);
//            composto_img.adicionarComposto("left");
//            adicionarMolecula(composto_img);
        }

        if(v==ci.getAddUp()){

            Composto_img composto_img = new Composto_img(c,(int)ci.getComposto().getX(),(int)ci.getComposto().getY()-200);
            ci.alertComposto("ligacaoComposto", "up",composto_img);
//            composto_img.adicionarComposto("up");
//            adicionarMolecula(composto_img);
        }

        if(v==ci.getComposto()){
            ci.alertComposto("composto", "composto");
        }

        if(v==ci.getLigacaoDown()){
            ci.alertComposto("ligacao", "down");
        }

        if(v==ci.getLigacaoLeft()){
            ci.alertComposto("ligacao", "left");
        }

        if(v==ci.getLigacaoRight()){
            ci.alertComposto("ligacao", "right");
        }

        if(v==ci.getLigacaoUp()){
            ci.alertComposto("ligacao", "up");
        }

    }


    public void verificarLigacao(View view){

    }
}
