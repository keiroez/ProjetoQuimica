package br.com.control;

import android.content.Intent;
import android.view.View;

import java.util.ArrayList;

import br.com.model.DAO.fabricaDAO.FabricaDAOSQLite;
import br.com.model.VO.Cadeia;
import br.com.model.VO.DadosUIPAC;
import br.com.model.VO.Infixo;
import br.com.model.VO.Molecula;
import br.com.model.VO.Prefixo;
import br.com.quimicapp.R;
import br.com.view.CadeiaActivity;
import br.com.view.CadeiaImagens;
import br.com.view.Composto_img;

public class ControleActivityCadeia implements View.OnClickListener {
    private CadeiaActivity context;
    private DadosUIPAC dadosUIPAC;

    public ControleActivityCadeia(CadeiaActivity context, Composto_img composto_img) throws Exception {
        this.context = context;
        Molecula molecula = new Molecula((int)composto_img.getComposto().getX(),(int)composto_img.getComposto().getY());
        Cadeia.getCadeia().getMoleculas().add(molecula);

        dadosUIPAC = new DadosUIPAC();
        String[] dados = preencherDadosPrefixos();

        for(int i=0; i<69;i++){
            dadosUIPAC.getPrefixos().add(new Prefixo(i, dados[i]));
        }

        dadosUIPAC.setInfixos(preencherDadosInfixos());


        FabricaDAOSQLite fabricaDAOSQLite =  new FabricaDAOSQLite();
        if(fabricaDAOSQLite.createDADOSIUPACdao(context).selectDados()==null)
            fabricaDAOSQLite.createDADOSIUPACdao(context).insertDados(dadosUIPAC);

//        for (Infixo p: fabricaDAOSQLite.createDADOSIUPACdao(context).selectDados().getInfixos()
//             ) {
//            System.out.println(p.getNome());
//        }

    }



    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.bt_gerar){
            int[] cont = Cadeia.getCadeia().gerarNomeclatura(Cadeia.getCadeia().getMoleculas().get(0),"");
            System.out.println("Qtd C= "+cont[0]);
            System.out.println("simples= "+cont[1]);
            System.out.println("dupla= "+cont[2]);
            System.out.println("tripla= "+cont[3]);
        }

        if(v.getId()== R.id.bt_limpar){
            Cadeia.getCadeia().getMoleculas().clear();
            CadeiaImagens.getCadeiaImagens().getCompostosImagens().clear();

            Molecula.zerarContador();
            Composto_img.zerarContador();

            Intent i = new Intent(context, CadeiaActivity.class);
            context.startActivity(i);
            context.finish();
        }
    }

    public ArrayList<Infixo> preencherDadosInfixos(){
        ArrayList<Infixo> infixos =  new ArrayList();

        infixos.add(new Infixo(1,"mono","an"));
        infixos.add(new Infixo(1,"mono","en"));
        infixos.add(new Infixo(1,"mono","in"));

        infixos.add(new Infixo(2,"di","an"));
        infixos.add(new Infixo(2,"di","en"));
        infixos.add(new Infixo(2,"di","in"));

        infixos.add(new Infixo(3,"tri","an"));
        infixos.add(new Infixo(3,"tri","en"));
        infixos.add(new Infixo(3,"tri","in"));

        infixos.add(new Infixo(4,"tetra","an"));
        infixos.add(new Infixo(4,"tetra","en"));
        infixos.add(new Infixo(4,"tetra","in"));

        infixos.add(new Infixo(5,"penta","an"));
        infixos.add(new Infixo(5,"penta","en"));
        infixos.add(new Infixo(5,"penta","in"));

        infixos.add(new Infixo(6,"hexa","an"));
        infixos.add(new Infixo(6,"hexa","en"));
        infixos.add(new Infixo(6,"hexa","in"));

        infixos.add(new Infixo(7,"hepta","an"));
        infixos.add(new Infixo(7,"hepta","en"));
        infixos.add(new Infixo(7,"hepta","in"));

        infixos.add(new Infixo(8,"octa","an"));
        infixos.add(new Infixo(8,"octa","en"));
        infixos.add(new Infixo(8,"octa","in"));

        infixos.add(new Infixo(9,"nona","an"));
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
}
