package br.com.control;

import android.content.Intent;
import android.view.View;

import br.com.model.VO.Cadeia;
import br.com.model.VO.Molecula;
import br.com.quimicapp.R;
import br.com.view.CadeiaActivity;
import br.com.view.Composto_img;

public class ControleActivityCadeia implements View.OnClickListener {
    CadeiaActivity context;

    public ControleActivityCadeia(CadeiaActivity context, Composto_img composto_img) {
        this.context = context;
        Molecula molecula = new Molecula((int)composto_img.getComposto().getX(),(int)composto_img.getComposto().getY());
        Cadeia.getCadeia().getMoleculas().add(molecula);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.bt_limpar){
                    Cadeia.getCadeia().getMoleculas().clear();
                    Intent i = new Intent(context, CadeiaActivity.class);
                    context.startActivity(i);
                    context.finish();
        }
    }

}
