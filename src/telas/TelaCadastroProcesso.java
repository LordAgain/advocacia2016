package telas;

import componentes.MeuCampoCodigo;
import componentes.MeuCampoData;
import componentes.MeuCampoTextArea;
import componentes.MeuJTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import static telas.TelaCadastroPessoa.telaCadastro;

public class TelaCadastroProcesso extends TelaCadastro{
    public static TelaCadastroProcesso telaProcesso;
    private MeuCampoCodigo campoCodigo = new MeuCampoCodigo(false, "Código do Processo", 3, false, false);
    private MeuJTextField campoNomeProcesso = new MeuJTextField (true, "Nome do Processo", 20,"[^A-Z|^ |^^|^~|^´|^`]");
    private MeuCampoData campoDataInclusao = new MeuCampoData (true, "Data de Início", 8);
    private MeuCampoData campoDataTermino = new MeuCampoData (false, "Data de Término", 8);
    private MeuJTextField campoAdvogado = new MeuJTextField (true, "Advogado", 30,"[^A-Z|^ |^^|^~|^´|^`]");
    private MeuJTextField campoCliente = new MeuJTextField (true, "Cliente", 30,"[^A-Z|^ |^^|^~|^´|^`]");
    private MeuCampoTextArea campoDescricao = new MeuCampoTextArea(false, "Descrição", 400, 150);
    
     public TelaCadastroProcesso (){
        super ("Cadastro de Processo");
        montarTela();
        IconeFrame ("/icone/Processo.png");
        minimoTamanhoTela();
    }
     
     public void montarTela (){
        adicionaComponentes(1, 1, 1, 1, campoCodigo);
        adicionaComponentes(1, 3, 1, 1, campoNomeProcesso);
        adicionaComponentes(3, 1, 1, 1, campoDataInclusao);
        adicionaComponentes(3, 3, 1, 1, campoDataTermino);
        adicionaComponentes(5, 1, 1, 1, campoAdvogado);
        adicionaComponentes(7, 1, 1, 1, campoCliente);
        adicionaComponentes(9, 1, 1, 1, campoDescricao);
        pack();
        habilitaComponentes (false);
    }
     public static TelaCadastro getTela() { //Estático para poder ser chamado de outras classes sem a necessidade de ter criado um objeto anteriormente.

        if (telaProcesso == null) {   //Tela não está aberta, pode criar uma nova tela
            telaProcesso = new TelaCadastroProcesso();
             telaProcesso.addInternalFrameListener(new InternalFrameAdapter() { //Adiciona um listener para verificar quando a tela for fechada, fazendo assim a remoção da mesma junto ao JDesktopPane da TelaSistema e setando a variável tela = null para permitir que a tela possa ser aberta novamente em outro momento. Basicamente o mesmo controle efetuado pela tela de pesquisa, porém de uma forma um pouco diferente.
                @Override
                public void internalFrameClosed(InternalFrameEvent e) {
                    TelaSistema.jdp.remove(telaProcesso);
                    telaProcesso = null;
                }
            });TelaSistema.jdp.add(telaProcesso);
        }
        //Depois do teste acima, independentemente dela já existir ou não, ela é selecionada e movida para frente
        TelaSistema.jdp.setSelectedFrame(telaProcesso);
        TelaSistema.jdp.moveToFront(telaProcesso);
        
        return telaProcesso;
    }
    
}
