package telas;

import componentes.MeuCampoComboBox;
import componentes.MeuCampoData;
import componentes.MeuCampoMonetario;
import componentes.MeuCampoTextArea;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import static telas.TelaCadastroCidade.telaCidade;

public class TelaContasAPagar extends TelaCadastro{
    public static TelaContasAPagar telaContasAPagar;
    public String[][] parcelas = {
        {"","1"},
        {"","2"},
        {"","3"},
        {"","4"},
        {"","5"},
        {"","6"},
        {"","7"},
        {"","8"},
        {"","9"},
        {"","10"},
        {"","11"},
        {"","12"}
    };
        
    private MeuCampoTextArea campoDescricao = new MeuCampoTextArea(true, "Descrição da Conta", 400, 150);
    private MeuCampoComboBox campoParcela = new MeuCampoComboBox(true, "Quantiade de Parcelas", parcelas, true);
    private MeuCampoMonetario campoParcelaAPagar = new MeuCampoMonetario(true, "Valor da(s) Parcela(s)", false, 8);
    private MeuCampoMonetario campoTotal = new MeuCampoMonetario(true, "Total", false, 8);
    private MeuCampoData campoDataVenc = new MeuCampoData(true, "Data de Vencimento", 8);
    
    public TelaContasAPagar (){
        super ("Contas a Pagar");     
        montarTela();
        IconeFrame ("/icone/Contas a Pagar.png");
        minimoTamanhoTela();
    }
     
    public void montarTela(){
    adicionaComponentes(1, 1, 1, 1, campoDescricao);
    adicionaComponentes(1, 3, 1, 1, campoParcela);
    adicionaComponentes(1, 5, 1, 1, campoParcelaAPagar);
    adicionaComponentes(3, 1, 1, 1, campoTotal);
    adicionaComponentes(3, 3, 1, 1, campoDataVenc);
    pack();
    habilitaComponentes (false);    
    } 
    public static TelaCadastro getTela() { //Estático para poder ser chamado de outras classes sem a necessidade de ter criado um objeto anteriormente.

        if (telaContasAPagar     == null) {   //Tela não está aberta, pode criar uma nova tela
            telaContasAPagar = new TelaContasAPagar();
             telaContasAPagar.addInternalFrameListener(new InternalFrameAdapter() { //Adiciona um listener para verificar quando a tela for fechada, fazendo assim a remoção da mesma junto ao JDesktopPane da TelaSistema e setando a variável tela = null para permitir que a tela possa ser aberta novamente em outro momento. Basicamente o mesmo controle efetuado pela tela de pesquisa, porém de uma forma um pouco diferente.
                @Override
                public void internalFrameClosed(InternalFrameEvent e) {
                    TelaSistema.jdp.remove(telaContasAPagar);
                    telaContasAPagar = null;
                }
            });TelaSistema.jdp.add(telaContasAPagar);
        }
        //Depois do teste acima, independentemente dela já existir ou não, ela é selecionada e movida para frente
        TelaSistema.jdp.setSelectedFrame(telaContasAPagar);
        TelaSistema.jdp.moveToFront(telaContasAPagar);
        
        return telaContasAPagar;
    }
}
