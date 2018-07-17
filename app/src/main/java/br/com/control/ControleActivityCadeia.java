package br.com.control;

import android.content.Intent;
import android.view.View;

import br.com.quimicapp.R;
import br.com.view.CadeiaActivity;

public class ControleActivityCadeia implements View.OnClickListener {
    CadeiaActivity context;

    public ControleActivityCadeia(CadeiaActivity context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.bt_limpar){
                    Intent i = new Intent(context, CadeiaActivity.class);
                    context.startActivity(i);
                    context.finish();
        }
    }
}
