package br.com.view;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import br.com.control.ControleActivityCadeia;
import br.com.quimicapp.R;
import libs.ZoomLayout;
import libs.ZoomLogger;

public class CadeiaActivity extends AppCompatActivity {
    public RelativeLayout relativeLayout;
    public Button btGerar, btLimpar;
    private AlertDialog alerta;
    private ControleActivityCadeia controle = null;

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


        try {
            controle = new ControleActivityCadeia(this, ciNovo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        btLimpar.setOnClickListener(controle);
        btGerar.setOnClickListener(controle);

        zoomLayout.setVisibility(View.VISIBLE);
    }


    public void alertNomenclatura(String nome) {
        //LayoutInflater é utilizado para inflar nosso layout em uma view.
        //-pegamos nossa instancia da classe
        LayoutInflater li = (this).getLayoutInflater();

        //inflamos o layout alerta.xml na view
        View view = null;

        view = li.inflate(R.layout.modelo_inf_nomenclatura, null);
        TextView tvNomenclatura = view.findViewById(R.id.tv_nomenclatura);
        ImageView imgClose = view.findViewById(R.id.img_close);
        Button btOk = view.findViewById(R.id.bt_ok);

        imgClose.setOnClickListener(controle);
        btOk.setOnClickListener(controle);
        tvNomenclatura.setText(nome);


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        alerta = builder.create();
        alerta.show();
    }


    public RelativeLayout getRelativeLayout() {
        return relativeLayout;
    }

    public void setRelativeLayout(RelativeLayout relativeLayout) {
        this.relativeLayout = relativeLayout;
    }

    public AlertDialog getAlerta() {
        return alerta;
    }

    public void setAlerta(AlertDialog alerta) {
        this.alerta = alerta;
    }
}
