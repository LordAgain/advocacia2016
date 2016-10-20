package telas;

import componentes.MeuCampoComboBox;
import componentes.MeuCampoData;
import componentes.MeuCampoMonetario;
import componentes.MeuCampoTextArea;
import componentes.MeuJTextField;
import java.math.BigDecimal;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class TelaContasAReceber extends TelaCadastro implements Runnable{

    public static TelaContasAReceber telaContasAReceber;
    public String[][] parcelas = {
        {"", "1"},
        {"", "2"},
        {"", "3"},
        {"", "4"},
        {"", "5"},
        {"", "6"},
        {"", "7"},
        {"", "8"},
        {"", "9"},
        {"", "10"},
        {"", "11"},
        {"", "12"}
    };

    private MeuJTextField campoCliente = new MeuJTextField(true, "Nome do Cliente", 30, "[^A-Z|^ |^^|^~|^´|^`]");
    private MeuCampoComboBox campoParcela = new MeuCampoComboBox(true, "Quantidade de Parcelas", parcelas, true);
    private MeuCampoMonetario campoParcelaAPagar = new MeuCampoMonetario(true, "Valor da(s) Parcela(s)", false, 8);
    private MeuCampoMonetario campoTotal = new MeuCampoMonetario(true, "Total", false, 8);
    private MeuCampoData campoDataPag = new MeuCampoData(true, "Data de Pagamento", 8);
    private MeuCampoTextArea campoDescPag = new MeuCampoTextArea(true, "Descrição da Conta", 400, 150);

    public TelaContasAReceber() {
        super("Contas a Receber");
        montarTela();
        IconeFrame("/icone/Contas a Receber.png");
        minimoTamanhoTela();
 
    }

    public void montarTela() {
        adicionaComponentes(1, 1, 1, 1, campoCliente);
        adicionaComponentes(1, 3, 1, 1, campoParcela);
        adicionaComponentes(1, 5, 1, 1, campoParcelaAPagar);
        adicionaComponentes(3, 1, 1, 1, campoDescPag);

        adicionaComponentes(3, 3, 1, 1, campoDataPag);
        adicionaComponentes(5, 1, 1, 1, campoTotal);
        //adicionaComponentes(5, 1, 1, 1, campoDescPag);
        pack();
        habilitaComponentes(false);
    }

    public static TelaCadastro getTela() { //Estático para poder ser chamado de outras classes sem a necessidade de ter criado um objeto anteriormente.

        if (telaContasAReceber == null) {   //Tela não está aberta, pode criar uma nova tela
            telaContasAReceber = new TelaContasAReceber();
            telaContasAReceber.addInternalFrameListener(new InternalFrameAdapter() { //Adiciona um listener para verificar quando a tela for fechada, fazendo assim a remoção da mesma junto ao JDesktopPane da TelaSistema e setando a variável tela = null para permitir que a tela possa ser aberta novamente em outro momento. Basicamente o mesmo controle efetuado pela tela de pesquisa, porém de uma forma um pouco diferente.
                @Override
                public void internalFrameClosed(InternalFrameEvent e) {
                    TelaSistema.jdp.remove(telaContasAReceber);
                    telaContasAReceber = null;
                }
            });
            TelaSistema.jdp.add(telaContasAReceber);
        }
        //Depois do teste acima, independentemente dela já existir ou não, ela é selecionada e movida para frente
        TelaSistema.jdp.setSelectedFrame(telaContasAReceber);
        TelaSistema.jdp.moveToFront(telaContasAReceber);

        return telaContasAReceber;
    }

    /**
     *
     */
    @Override
    public void run() {

        BigDecimal parcela = new BigDecimal((double) campoParcela.getValor());
        BigDecimal valorParcela = new BigDecimal((char[]) campoParcelaAPagar.getValor());
        BigDecimal total = parcela.multiply(valorParcela);
        campoTotal.setValor(total);
    }

}
