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

        btLimpar.setOnClickListener(new ControleActivityCadeia(this));

        init();

        zoomLayout.setVisibility(View.VISIBLE);
    }

    public void init(){
        Composto_img ci = new Composto_img(this, 150, 700);

        relativeLayout.addView(ci.getComposto());
        relativeLayout.addView(ci.getAddRight());
        relativeLayout.addView(ci.getAddDown());
        relativeLayout.addView(ci.getAddUp());
        relativeLayout.addView(ci.getElemento1());
        relativeLayout.addView(ci.getElemento2());
        relativeLayout.addView(ci.getQtdElemento1());
        relativeLayout.addView(ci.getQtdElemento2());
    }

    public RelativeLayout getRelativeLayout() {
        return relativeLayout;
    }

    public void setRelativeLayout(RelativeLayout relativeLayout) {
        this.relativeLayout = relativeLayout;
    }
}
