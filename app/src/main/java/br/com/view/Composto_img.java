package br.com.view;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import br.com.control.ControleCadeia;
import br.com.control.ControleComposto;
import br.com.quimicapp.R;

public class Composto_img {

    private int id;
    private static int contador = 1;

    private TextView elemento1, elemento2, qtdElemento1, qtdElemento2;
    private ImageView composto, addLeft, addRight, addUp, addDown, ligacaoLeft, ligacaoRight, ligacaoUp, ligacaoDown;
    private Context c;
    private AlertDialog alerta;

    public Composto_img(Context context, int x, int y) {

        c = context;
        composto = new ImageView(context);
        addRight = new ImageView(context);
        addLeft = new ImageView(context);
        addDown = new ImageView(context);
        addUp = new ImageView(context);
        elemento1 = new TextView(context);
        elemento2 = new TextView(context);
        qtdElemento1 = new TextView(context);
        qtdElemento2 = new TextView(context);
        ligacaoLeft = new ImageView(context);
        ligacaoDown = new ImageView(context);
        ligacaoRight = new ImageView(context);
        ligacaoUp = new ImageView(context);

        ControleCadeia controleCadeia = new ControleCadeia(c,this);

        ligacaoLeft.setOnClickListener(controleCadeia);
        ligacaoDown.setOnClickListener(controleCadeia);
        ligacaoUp.setOnClickListener(controleCadeia);
        ligacaoRight.setOnClickListener(controleCadeia);

        composto.setBackgroundResource(R.drawable.ic_circulo_40dp);
        addDown.setBackgroundResource(R.drawable.ic_add_24dp);
        addLeft.setBackgroundResource(R.drawable.ic_add_24dp);
        addUp.setBackgroundResource(R.drawable.ic_add_24dp);
        addRight.setBackgroundResource(R.drawable.ic_add_24dp);

        elemento1.setText("H");
        elemento2.setText("C");
        elemento1.setTextColor(Color.WHITE);
        elemento2.setTextColor(Color.WHITE);

        qtdElemento1.setText("2");
        qtdElemento1.setTextColor(Color.WHITE);
        qtdElemento2.setText("");
        qtdElemento2.setTextColor(Color.WHITE);

        qtdElemento1.setTextSize(10);
        qtdElemento2.setTextSize(10);


        composto.setX(x);
        composto.setY(y);
        addLeft.setX(composto.getX()-70);
        addLeft.setY(composto.getY()+20);

        addRight.setX(composto.getX()+120);
        addRight.setY(composto.getY()+20);

        addUp.setX(composto.getX()+20);
        addDown.setX(composto.getX()+20);
        addUp.setY(composto.getY()-70);
        addDown.setY(composto.getY()+120);

        elemento1.setX(composto.getX()+15);
        elemento1.setY(composto.getY()+20);
        elemento2.setX(elemento1.getX()+40);
        elemento2.setY(elemento1.getY());

        qtdElemento1.setX(elemento1.getX()+25);
        qtdElemento1.setY(elemento1.getY()+35);
        qtdElemento2.setX(elemento2.getX()+25);
        qtdElemento2.setY(elemento2.getY()+35);


        addUp.setOnClickListener(controleCadeia);
        addDown.setOnClickListener(controleCadeia);
        addRight.setOnClickListener(controleCadeia);
        addLeft.setOnClickListener(controleCadeia);
        composto.setOnClickListener(controleCadeia);

    }

    public static void zerarContador(){
        contador = 1;
    }


    public void adicionarComposto(String lado, ControleComposto.Verificador[] verificador){
        ((CadeiaActivity) c).relativeLayout.addView(this.getComposto());

        //Adicionar AddUp
        if(this.composto.getY()>150 && !lado.equals("down") && !verificador[0].vizinho )
            ((CadeiaActivity) c).relativeLayout.addView(this.getAddUp());

        //ADicionar AddDown
        if(this.composto.getY()<1150 && !lado.equals("up") && !verificador[2].vizinho)
            ((CadeiaActivity) c).relativeLayout.addView(this.getAddDown());

        //Adicionar addRight
        if(this.composto.getX()<1750 && !lado.equals("left") && !verificador[1].vizinho)
            ((CadeiaActivity) c).relativeLayout.addView(this.getAddRight());

        //adicionar addleft
        if(this.getComposto().getX()>150 && !lado.equals("right") && !verificador[3].vizinho)
            ((CadeiaActivity) c).relativeLayout.addView(this.getAddLeft());


        ((CadeiaActivity) c).relativeLayout.addView(this.getElemento1());
        ((CadeiaActivity) c).relativeLayout.addView(this.getElemento2());
        ((CadeiaActivity) c).relativeLayout.addView(this.getQtdElemento1());
        ((CadeiaActivity) c).relativeLayout.addView(this.getQtdElemento2());

        //Adicionando id
        this.id = contador;
        contador++;


        //Retirar add dos vizinhos ja existentes
        for (Composto_img composto: CadeiaImagens.getCadeiaImagens().getCompostosImagens()){
            for(int i = 0; i<4;i++){
                if(verificador[i].vizinho && verificador[i].posXvizinho==composto.getComposto().getX() &&
                        verificador[i].posYvizinho==composto.getComposto().getY()){
                    if(i==0){
                        ((CadeiaActivity) c).relativeLayout.removeView(composto.addDown);
                    }
                    if(i==1){
                        ((CadeiaActivity) c).relativeLayout.removeView(composto.addLeft);
                    }
                    if(i==2){
                        ((CadeiaActivity) c).relativeLayout.removeView(composto.addUp);
                    }
                    if(i==3){
                        ((CadeiaActivity) c).relativeLayout.removeView(composto.addRight);
                    }
                }
            }
        }

    }

    public void adicionarLigacao(String ligacao, String lado){

        if(lado.equals("left")) {
            if(addLeft!=null) {
                ligacaoLeft.setX(addLeft.getX());
                ligacaoLeft.setY(addLeft.getY());
                ((CadeiaActivity) c).getRelativeLayout().removeView(addLeft);
                addLeft = null;
            }
            else{
                ((CadeiaActivity) c).getRelativeLayout().removeView(ligacaoLeft);
            }


            if (ligacao.equals("simples")) {
                ligacaoLeft.setBackgroundResource(R.drawable.ic_ligacao_simples_h);
            } else if (ligacao.equals("dupla")) {
                ligacaoLeft.setBackgroundResource(R.drawable.ic_ligacao_dupla_h);
            } else if (ligacao.equals("tripla")) {
                ligacaoLeft.setBackgroundResource(R.drawable.ic_ligacao_tripla_h);
            }


            ((CadeiaActivity) c).getRelativeLayout().addView(ligacaoLeft);
        }

        if(lado.equals("up")) {
            if(addUp!=null) {
                ligacaoUp.setX(addUp.getX());
                ligacaoUp.setY(addUp.getY());
                ((CadeiaActivity) c).getRelativeLayout().removeView(addUp);
                addUp = null;
            }
            else{
                ((CadeiaActivity) c).getRelativeLayout().removeView(ligacaoUp);
            }

            if (ligacao.equals("simples")) {
                ligacaoUp.setBackgroundResource(R.drawable.ic_ligacao_simples_v);
            } else if (ligacao.equals("dupla")) {
                ligacaoUp.setBackgroundResource(R.drawable.ic_ligacao_dupla_v);
            } else if (ligacao.equals("tripla")) {
                ligacaoUp.setBackgroundResource(R.drawable.ic_ligacao_tripla_v);
            }



            ((CadeiaActivity) c).getRelativeLayout().addView(ligacaoUp);
        }

        if(lado.equals("right")) {
            if(addRight!=null) {
                ligacaoRight.setX(addRight.getX());
                ligacaoRight.setY(addRight.getY());

                ((CadeiaActivity) c).getRelativeLayout().removeView(addRight);
                addRight = null;
            }
            else{
                ((CadeiaActivity) c).getRelativeLayout().removeView(ligacaoRight);
            }


            if (ligacao.equals("simples")) {
                ligacaoRight.setBackgroundResource(R.drawable.ic_ligacao_simples_h);
            } else if (ligacao.equals("dupla")) {
                ligacaoRight.setBackgroundResource(R.drawable.ic_ligacao_dupla_h);
            } else if (ligacao.equals("tripla")) {
                ligacaoRight.setBackgroundResource(R.drawable.ic_ligacao_tripla_h);
            }


            ((CadeiaActivity) c).getRelativeLayout().addView(ligacaoRight);
        }

        if(lado.equals("down")) {
            if(addDown!=null) {
                ligacaoDown.setX(addDown.getX());
                ligacaoDown.setY(addDown.getY());

                ((CadeiaActivity) c).getRelativeLayout().removeView(addDown);
                addDown = null;
            }
            else{
                ((CadeiaActivity) c).getRelativeLayout().removeView(ligacaoDown);
            }

            if (ligacao.equals("simples")) {
                ligacaoDown.setBackgroundResource(R.drawable.ic_ligacao_simples_v);
            } else if (ligacao.equals("dupla")) {
                ligacaoDown.setBackgroundResource(R.drawable.ic_ligacao_dupla_v);
            } else if (ligacao.equals("tripla")) {
                ligacaoDown.setBackgroundResource(R.drawable.ic_ligacao_tripla_v);
            }


            ((CadeiaActivity) c).getRelativeLayout().addView(ligacaoDown);
        }



    }

    public void alertComposto(String text, String lado) {
        //LayoutInflater é utilizado para inflar nosso layout em uma view.
        //-pegamos nossa instancia da classe
        LayoutInflater li = ((CadeiaActivity) c).getLayoutInflater();

        //inflamos o layout alerta.xml na view
        View view = null;

        if(text.equals("composto")) {
            view = li.inflate(R.layout.modelo_inf_composto, null);
            Spinner spinner1 = view.findViewById(R.id.spinner);
            ImageView imgClose = view.findViewById(R.id.img_close);
            ControleComposto cc = new ControleComposto("composto", this, lado);
            cc.preencherSpinner(c,spinner1);
            imgClose.setOnClickListener(cc);
            spinner1.setOnItemSelectedListener(cc);
        }
        else if(text.equals("ligacao")){
            view = li.inflate(R.layout.modelo_inf_ligacao, null);
            Spinner spinner1 = view.findViewById(R.id.spinnerLigacao);
            ImageView imgClose = view.findViewById(R.id.img_close);
            ControleComposto cc = new ControleComposto("ligacao", this, lado);
            imgClose.setOnClickListener(cc);
            cc.preencherSpinner(c,spinner1);
            spinner1.setOnItemSelectedListener(cc);
        }
        else{
            view = li.inflate(R.layout.modelo_inf_comp_ligacao, null);
            Spinner spinner1 = view.findViewById(R.id.spinnerComp);
            Spinner spinner2 = view.findViewById(R.id.spinnerLig);
            ImageView imgClose = view.findViewById(R.id.img_close);
            ControleComposto cc = new ControleComposto("composto", this, lado);
            cc.preencherSpinner(c,spinner1);
            imgClose.setOnClickListener(cc);
            ControleComposto cc2 = new ControleComposto("ligacao", this, lado);
            cc2.preencherSpinner(c,spinner2);
            spinner2.setOnItemSelectedListener(cc2);

            Button btInserir = view.findViewById(R.id.bt_inserir);
            btInserir.setOnClickListener(cc);
            Button btCancelar = view.findViewById(R.id.bt_cancelar);
            btCancelar.setOnClickListener(cc);
        }


        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setView(view);
        alerta = builder.create();
        alerta.show();
    }


    //Alerta para adição de novo elemento
    public void alertComposto(String text, String lado, Composto_img composto_imgNovo) {
        //LayoutInflater é utilizado para inflar nosso layout em uma view.
        //-pegamos nossa instancia da classe
        LayoutInflater li = ((CadeiaActivity) c).getLayoutInflater();

        //inflamos o layout alerta.xml na view
        View view = null;

            view = li.inflate(R.layout.modelo_inf_comp_ligacao, null);

            Spinner spinner1 = view.findViewById(R.id.spinnerComp);
            Spinner spinner2 = view.findViewById(R.id.spinnerLig);

            ImageView imgClose = view.findViewById(R.id.img_close);

            ControleComposto controleComposto = new ControleComposto("",this,lado, composto_imgNovo);

            controleComposto.preencherSpinner(c,spinner1);

            imgClose.setOnClickListener(controleComposto);


            controleComposto.preencherSpinner(c,spinner2);
            spinner2.setOnItemSelectedListener(controleComposto);



            Button btInserir = view.findViewById(R.id.bt_inserir);
            btInserir.setOnClickListener(controleComposto);
            Button btCancelar = view.findViewById(R.id.bt_cancelar);
            btCancelar.setOnClickListener(controleComposto);

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setView(view);
        alerta = builder.create();
        alerta.show();
    }

    public TextView getElemento1() {
        return elemento1;
    }

    public void setElemento1(TextView elemento1) {
        this.elemento1 = elemento1;
    }

    public TextView getElemento2() {
        return elemento2;
    }

    public void setElemento2(TextView elemento2) {
        this.elemento2 = elemento2;
    }

    public TextView getQtdElemento1() {
        return qtdElemento1;
    }

    public void setQtdElemento1(TextView qtdElemento1) {
        this.qtdElemento1 = qtdElemento1;
    }

    public TextView getQtdElemento2() {
        return qtdElemento2;
    }

    public void setQtdElemento2(TextView qtdElemento2) {
        this.qtdElemento2 = qtdElemento2;
    }

    public ImageView getComposto() {
        return composto;
    }

    public void setComposto(ImageView composto) {
        this.composto = composto;
    }

    public ImageView getAddLeft() {
        return addLeft;
    }

    public void setAddLeft(ImageView addLeft) {
        this.addLeft = addLeft;
    }

    public ImageView getAddRight() {
        return addRight;
    }

    public void setAddRight(ImageView addRight) {
        this.addRight = addRight;
    }

    public ImageView getAddUp() {
        return addUp;
    }

    public void setAddUp(ImageView addUp) {
        this.addUp = addUp;
    }

    public ImageView getAddDown() {
        return addDown;
    }

    public void setAddDown(ImageView addDown) {
        this.addDown = addDown;
    }

    public ImageView getLigacaoLeft() {
        return ligacaoLeft;
    }

    public void setLigacaoLeft(ImageView ligacaoLeft) {
        this.ligacaoLeft = ligacaoLeft;
    }

    public ImageView getLigacaoRight() {
        return ligacaoRight;
    }

    public void setLigacaoRight(ImageView ligacaoRight) {
        this.ligacaoRight = ligacaoRight;
    }

    public ImageView getLigacaoUp() {
        return ligacaoUp;
    }

    public void setLigacaoUp(ImageView ligacaoUp) {
        this.ligacaoUp = ligacaoUp;
    }

    public ImageView getLigacaoDown() {
        return ligacaoDown;
    }

    public void setLigacaoDown(ImageView ligacaoDown) {
        this.ligacaoDown = ligacaoDown;
    }

    public Context getC() {
        return c;
    }

    public void setC(Context c) {
        this.c = c;
    }

    public AlertDialog getAlerta() {
        return alerta;
    }

    public void setAlerta(AlertDialog alerta) {
        this.alerta = alerta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getContador() {
        return contador;
    }
    public static void setContador(){
        contador++;
    }
}
