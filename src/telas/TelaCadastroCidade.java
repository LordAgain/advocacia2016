package telas;

import componentes.MeuCampoCodigo;
import componentes.MeuCampoComboBox;
import componentes.MeuJTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class TelaCadastroCidade extends TelaCadastro{
    
    public String[][] argumentos = {
        {"","São Paulo"},
        {"","Paraná"}
    };
    public static TelaCadastroCidade telaCidade;
    private MeuCampoCodigo campoCodigo = new MeuCampoCodigo(false, "Código", 3, false, false);
    private MeuJTextField campoNomeCidade = new MeuJTextField (true, "Nome da Cidade", 30,"[^A-Z|^ ]");
    private MeuCampoComboBox campoComboBox = new MeuCampoComboBox(true, "Estado", argumentos, true);
    public TelaCadastroCidade (){
        super ("Cadastro de Cidade");
        montarTela();
        IconeFrame ("/icone/Cidade.png");
        minimoTamanhoTela();
    }
    
    public void montarTela (){       
        adicionaComponentes(1, 1, 1, 1, campoCodigo);
        adicionaComponentes(1, 3, 1, 1, campoNomeCidade);
        adicionaComponentes(3, 1, 1, 1, campoComboBox); 
        pack();
        habilitaComponentes (false);
    }
    public static TelaCadastro getTela() { //Estático para poder ser chamado de outras classes sem a necessidade de ter criado um objeto anteriormente.

        if (telaCidade     == null) {   //Tela não está aberta, pode criar uma nova tela
            telaCidade = new TelaCadastroCidade();
             telaCidade.addInternalFrameListener(new InternalFrameAdapter() { //Adiciona um listener para verificar quando a tela for fechada, fazendo assim a remoção da mesma junto ao JDesktopPane da TelaSistema e setando a variável tela = null para permitir que a tela possa ser aberta novamente em outro momento. Basicamente o mesmo controle efetuado pela tela de pesquisa, porém de uma forma um pouco diferente.
                @Override
                public void internalFrameClosed(InternalFrameEvent e) {
                    TelaSistema.jdp.remove(telaCidade);
                    telaCidade = null;
                }
            });TelaSistema.jdp.add(telaCidade);
        }
        //Depois do teste acima, independentemente dela já existir ou não, ela é selecionada e movida para frente
        TelaSistema.jdp.setSelectedFrame(telaCidade);
        TelaSistema.jdp.moveToFront(telaCidade);
        
        return telaCidade;
    }
}
