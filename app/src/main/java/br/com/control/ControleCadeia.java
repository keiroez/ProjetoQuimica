package br.com.control;

import android.content.Context;
import android.view.View;

import br.com.model.Cadeia;
import br.com.model.Molecula;
import br.com.view.Composto_img;

public class ControleCadeia implements View.OnClickListener {

    private Context c;
    private Composto_img ci;

    public ControleCadeia(Context c, Composto_img ci) {
        this.c = c;
        this.ci = ci;

    }

    @Override
    public void onClick(View v) {

        if(v==ci.getAddDown()){
            ci.alertComposto("ligacaoComposto", "down");
            Composto_img composto_img = new Composto_img(c,(int)ci.getComposto().getX(),(int)ci.getComposto().getY()+200);
            composto_img.adicionarComposto("down");
            adicionarMolecula(composto_img);
        }

        if(v==ci.getAddRight()){
            ci.alertComposto("ligacaoComposto", "right");
            Composto_img composto_img = new Composto_img(c,(int)ci.getComposto().getX()+200,(int)ci.getComposto().getY());
            composto_img.adicionarComposto("right");
            adicionarMolecula(composto_img);
        }

        if(v==ci.getAddLeft()){
            ci.alertComposto("ligacaoComposto", "left");
            Composto_img composto_img = new Composto_img(c,(int)ci.getComposto().getX()-200,(int)ci.getComposto().getY());
            composto_img.adicionarComposto("left");
            adicionarMolecula(composto_img);
        }

        if(v==ci.getAddUp()){
            ci.alertComposto("ligacaoComposto", "up");
            Composto_img composto_img = new Composto_img(c,(int)ci.getComposto().getX(),(int)ci.getComposto().getY()-200);
            composto_img.adicionarComposto("up");
            adicionarMolecula(composto_img);
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

    //Adicionar molecula à cadeia
    public void adicionarMolecula(Composto_img ci){
        Molecula molecula = new Molecula((int)ci.getComposto().getX(),(int)ci.getComposto().getY());
        Cadeia.getCadeia().getMoleculas().add(molecula);

        for (Molecula molecula1:Cadeia.getCadeia().getMoleculas()) {
            System.out.println(molecula1.getId()+" "+molecula1.getPosX()+" "+molecula1.getPosY());
        }
    }
}
