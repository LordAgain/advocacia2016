package telas;

import componentes.MeuCampoCodigo;
import componentes.MeuJTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import static telas.TelaCadastroCidade.telaCidade;

public class TelaCadastroEstado extends TelaCadastro{
    public static TelaCadastroEstado telaEstado;
    private MeuCampoCodigo campoCodigo = new MeuCampoCodigo(false, "Código", 3, false, false);
    private MeuJTextField campoNomeEstado = new MeuJTextField (true, "Nome do Estado", 30,"[^A-Z|^ |^^|^~|^´|^`]");
    private MeuJTextField campoSiglaEstado = new MeuJTextField (true, "Sigla do Estado", 2,"[^A-Z]");
    
    public TelaCadastroEstado (){
        super ("Cadastro de Estado");
        montarTela();
        IconeFrame ("/icone/Estado.png");
        minimoTamanhoTela();
    }
    
    public void montarTela (){
        adicionaComponentes(1, 1, 1, 1, campoCodigo);
        adicionaComponentes(3, 1, 1, 1, campoNomeEstado);
        adicionaComponentes(3, 5, 1, 1, campoSiglaEstado);
        pack();
        habilitaComponentes (false);
    }

    public static TelaCadastro getTela() { //Estático para poder ser chamado de outras classes sem a necessidade de ter criado um objeto anteriormente.

        if (telaEstado     == null) {   //Tela não está aberta, pode criar uma nova tela
            telaEstado = new TelaCadastroEstado();
             telaEstado.addInternalFrameListener(new InternalFrameAdapter() { //Adiciona um listener para verificar quando a tela for fechada, fazendo assim a remoção da mesma junto ao JDesktopPane da TelaSistema e setando a variável tela = null para permitir que a tela possa ser aberta novamente em outro momento. Basicamente o mesmo controle efetuado pela tela de pesquisa, porém de uma forma um pouco diferente.
                @Override
                public void internalFrameClosed(InternalFrameEvent e) {
                    TelaSistema.jdp.remove(telaEstado);
                    telaEstado = null;
                }
            });TelaSistema.jdp.add(telaEstado);
        }
        //Depois do teste acima, independentemente dela já existir ou não, ela é selecionada e movida para frente
        TelaSistema.jdp.setSelectedFrame(telaEstado);
        TelaSistema.jdp.moveToFront(telaEstado);
        
        return telaEstado;
    }
}
