package br.com.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import br.com.control.ControleActivityCadeia;
import br.com.quimicapp.R;
import libs.ZoomLayout;
import libs.ZoomLogger;

public class CadeiaActivity extends AppCompatActivity {
    public RelativeLayout relativeLayout;
    public Button btGerar, btLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ZoomLogger.setLogLevel(ZoomLogger.LEVEL_INFO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadeia);

        final ZoomLayout zoomLayout = findViewById(R.id.zoom_layout);
        relativeLayout = findViewById(R.id.rlayout);

        btGerar = findViewById(R.id.bt_gerar);
        btLimpar = findViewById(R.id.bt_limpar);

        Composto_img ciNovo = new Composto_img(this, 150, 700);
        ciNovo.setId(Composto_img.getContador());
        Composto_img.setContador();
        CadeiaImagens.getCadeiaImagens().getCompostosImagens().add(ciNovo);

        relativeLayout.addView(ciNovo.getComposto());
        relativeLayout.addView(ciNovo.getAddRight());
        relativeLayout.addView(ciNovo.getAddDown());
        relativeLayout.addView(ciNovo.getAddUp());
        relativeLayout.addView(ciNovo.getElemento1());
        relativeLayout.addView(ciNovo.getElemento2());
        relativeLayout.addView(ciNovo.getQtdElemento1());
        relativeLayout.addView(ciNovo.getQtdElemento2());

        btLimpar.setOnClickListener(new ControleActivityCadeia(this, ciNovo));

        zoomLayout.setVisibility(View.VISIBLE);
    }

    public RelativeLayout getRelativeLayout() {
        return relativeLayout;
    }

    public void setRelativeLayout(RelativeLayout relativeLayout) {
        this.relativeLayout = relativeLayout;
    }
}
