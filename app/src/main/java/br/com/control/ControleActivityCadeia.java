package br.com.control;

import android.content.Intent;
import android.view.View;

import java.util.ArrayList;

import br.com.model.DAO.Fachada;
import br.com.model.VO.Cadeia;
import br.com.model.VO.CadeiaAdapter;
import br.com.model.VO.DadosIUPAC;
import br.com.model.VO.Infixo;
import br.com.model.VO.Molecula;
import br.com.model.VO.Prefixo;
import br.com.model.VO.Sufixo;
import br.com.quimicapp.R;
import br.com.view.CadeiaActivity;
import br.com.view.CadeiaImagens;
import br.com.view.Composto_img;

public class ControleActivityCadeia implements View.OnClickListener {
    private CadeiaActivity context;
    private DadosIUPAC dadosIUPAC;
    private static final Cadeia cadeia = new Cadeia();

    public ControleActivityCadeia(CadeiaActivity context, Composto_img composto_img) throws Exception {
        this.context = context;
        Molecula molecula = new Molecula((int)composto_img.getComposto().getX(),(int)composto_img.getComposto().getY());
        this.getCadeia().getMoleculas().add(molecula);



        dadosIUPAC = new DadosIUPAC();
        String[] dados = preencherDadosPrefixos();

        for(int i=0; i<69;i++){
            dadosIUPAC.getPrefixos().add(new Prefixo(i+1, dados[i]));
        }
        dadosIUPAC.setInfixos(preencherDadosInfixos());
        dadosIUPAC.setSufixos(preencherDadosSufixos());

        //Inserir dados IUPAC(Prefixos, infixos e sufixos)
        Fachada.inserirDadosIUPAC(dadosIUPAC,this.context);

    }



    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.bt_gerar){
            int[] cont = new int[0];
            try {
                cont = this.getCadeia().gerarNomeclatura(this.getCadeia().getMoleculas().get(0),"");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Qtd C= "+cont[0]);
            System.out.println("simples= "+cont[1]);
            System.out.println("dupla= "+cont[2]);
            System.out.println("tripla= "+cont[3]);
            String nome = "Erro";
            try {
                nome = CadeiaAdapter.transformarString(
                        this.getCadeia().gerarNomeclatura(this.getCadeia().getMoleculas().get(0), ""), context);
                System.out.println(nome);
            } catch (Exception e) {
                e.printStackTrace();
            }
            context.alertNomenclatura(nome);
        }

        if(v.getId()== R.id.bt_limpar){
            try {
                this.getCadeia().getMoleculas().clear();
            } catch (Exception e) {
                e.printStackTrace();
            }
            CadeiaImagens.getCadeiaImagens().getCompostosImagens().clear();

            Molecula.zerarContador();
            Composto_img.zerarContador();

            Intent i = new Intent(context, CadeiaActivity.class);
            context.startActivity(i);
            context.finish();
        }

        if(v.getId()==R.id.img_close || v.getId()==R.id.bt_ok){
            context.getAlerta().dismiss();
        }
    }

    public ArrayList<Sufixo> preencherDadosSufixos(){
        ArrayList<Sufixo> sufixos = new ArrayList<>();

        sufixos.add(new Sufixo("hidrocarboneto", "o"));
        sufixos.add(new Sufixo("alcool", "ol"));
        sufixos.add(new Sufixo("aldeido", "al"));
        sufixos.add(new Sufixo("cetona", "ona"));
        sufixos.add(new Sufixo("ácido carboxilico", "óico"));
        return sufixos;
    }

    public ArrayList<Infixo> preencherDadosInfixos(){
        ArrayList<Infixo> infixos =  new ArrayList();

        infixos.add(new Infixo(1,"","an"));
        infixos.add(new Infixo(1,"","en"));
        infixos.add(new Infixo(1,"","in"));

        infixos.add(new Infixo(2,"","an"));
        infixos.add(new Infixo(2,"di","en"));
        infixos.add(new Infixo(2,"di","in"));

        infixos.add(new Infixo(3,"","an"));
        infixos.add(new Infixo(3,"tri","en"));
        infixos.add(new Infixo(3,"tri","in"));

        infixos.add(new Infixo(4,"","an"));
        infixos.add(new Infixo(4,"tetra","en"));
        infixos.add(new Infixo(4,"tetra","in"));

        infixos.add(new Infixo(5,"","an"));
        infixos.add(new Infixo(5,"penta","en"));
        infixos.add(new Infixo(5,"penta","in"));

        infixos.add(new Infixo(6,"","an"));
        infixos.add(new Infixo(6,"hexa","en"));
        infixos.add(new Infixo(6,"hexa","in"));

        infixos.add(new Infixo(7,"","an"));
        infixos.add(new Infixo(7,"hepta","en"));
        infixos.add(new Infixo(7,"hepta","in"));

        infixos.add(new Infixo(8,"","an"));
        infixos.add(new Infixo(8,"octa","en"));
        infixos.add(new Infixo(8,"octa","in"));

        infixos.add(new Infixo(9,"","an"));
        infixos.add(new Infixo(9,"nona","en"));
        infixos.add(new Infixo(9,"nona","in"));


        return infixos;

    };


    public String[] preencherDadosPrefixos(){
        String[] palavras = new String[100];

        //Prefixos
        palavras[0]="met";
        palavras[1]="et";
        palavras[2]="prop";
        palavras[3]="but";
        palavras[4]="pent";
        palavras[5]="hex";
        palavras[6]="hept";
        palavras[7]="oct";
        palavras[8]="non";
        palavras[9]="dec";
        palavras[10]="undec";
        palavras[11]="dodec";
        palavras[12]="tridec";
        palavras[13]="tetradec";
        palavras[14]="pentadec";
        palavras[15]="hexadec";
        palavras[16]="heptadec";
        palavras[17]="octadec";
        palavras[18]="nonadec";
        palavras[19]="eicos";
        palavras[20]="heneicos";
        palavras[21]="docos";
        palavras[22]="tricos";
        palavras[23]="tetracos";
        palavras[24]="pentacos";
        palavras[25]="hexacos";
        palavras[26]="heptacos";
        palavras[27]="octacos";
        palavras[28]="nonacos";
        palavras[29]="triacont";
        palavras[30]="hentriacont";
        palavras[31]="dotriacont";
        palavras[32]="tritriacont";
        palavras[33]="tetratriacont";
        palavras[34]="pentatriacont";
        palavras[35]="hexatriacont";
        palavras[36]="heptriacont";
        palavras[37]="octatriacont";
        palavras[38]="nonatriacont";
        palavras[39]="tetracont";
        palavras[40]="hentetracont";
        palavras[41]="dotetracont";
        palavras[42]="tritetracont";
        palavras[43]="tetratetracont";
        palavras[44]="pentatetracont";
        palavras[45]="hexatetracont";
        palavras[46]="heptetracont";
        palavras[47]="octatetracont";
        palavras[48]="nonatetracont";
        palavras[49]="pentacont";
        palavras[50]="henpentacont";
        palavras[51]="dopentacont";
        palavras[52]="tripentacont";
        palavras[53]="tetrapentacont";
        palavras[54]="pentapentacont";
        palavras[55]="hexapentacont";
        palavras[56]="heptpentacont";
        palavras[57]="octapentacont";
        palavras[58]="nonapentacont";
        palavras[59]="hexacont";
        palavras[60]="henhexacont";
        palavras[61]="dohexacont";
        palavras[62]="trihexacont";
        palavras[63]="tetrahexacont";
        palavras[64]="pentahexacont";
        palavras[65]="hexahexacont";
        palavras[66]="hepthexacont";
        palavras[67]="octahexacont";
        palavras[68]="nonahexacont";

        return palavras;
    }

    public static Cadeia getCadeia() {
        return cadeia;
    }
}
