package telas;

import componentes.MeuCampoCep;
import componentes.MeuCampoCheckBox;
import componentes.MeuCampoCodigo;
import componentes.MeuCampoComboBox;
import componentes.MeuCampoCpf;
import componentes.MeuCampoData;
import componentes.MeuCampoEmail;
import componentes.MeuCampoInteiro;
import componentes.MeuCampoRg;
import componentes.MeuCampoTelefone;
import componentes.MeuJTextField;
//import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
//import static telas.TelaCadastro.telaCadastro;

public class TelaCadastroPessoa extends TelaCadastro{
    
    //JLabel label = new JLabel("<html><hr width = 300 align = center size = 2>");
    
    public String[][] estados = {
        {"","São Paulo"},
        {"","Paraná"}
    };
    
    public String[][] cidades = {
        {"","São Paulo"},
        {"","Umuarama"}
    };
    public static TelaCadastroPessoa telaPessoa;
    private MeuCampoCodigo campoCodPessoa = new MeuCampoCodigo(false, "Código da Pessoa", 3, false, false);
    private MeuJTextField campoNomePessoa = new MeuJTextField (true, "Nome da Pessoa", 30,"[^A-Z|^ " +padrao);
    private MeuJTextField campoRua = new MeuJTextField(true, "Rua", 20,"[^A-Z|^|^^|^~|^´|^` ]");
    private MeuJTextField campoComplemento = new MeuJTextField(false, "Complemento", 20,"");
    private MeuCampoEmail campoEmail = new MeuCampoEmail(false, "E-mail", 30,"[^A-Z|^_|^-|^@|^.]");
    private MeuCampoCpf campoCpf = new MeuCampoCpf (true, "CPF", 9);
    private MeuCampoRg campoRg = new MeuCampoRg (true, "RG", 9);
    private MeuCampoCheckBox campoCcb1 = new MeuCampoCheckBox("Cliente");
    private MeuCampoCheckBox campoCcb2 = new MeuCampoCheckBox("Advogado");
    private MeuCampoData campoData = new MeuCampoData (true, "Data Nascimento", 8);
    private MeuCampoCep campoCep = new MeuCampoCep (true, "CEP", 8);
    private MeuCampoInteiro campoInt = new MeuCampoInteiro (true, "Nº", 10, false);
    private MeuCampoComboBox campoEstado = new MeuCampoComboBox (true, "Estado", estados, true);
    private MeuCampoComboBox campoCidade = new MeuCampoComboBox (true, "Cidade", cidades, true);
    private MeuCampoTelefone campoTelefone = new MeuCampoTelefone (false, "Telefone", 10);
    private MeuCampoTelefone campoCelular = new MeuCampoTelefone (false, "Celular", 10);
    
    public TelaCadastroPessoa (){
        super ("Cadastro de Pessoa");
        montarTela();  
        IconeFrame("/icone/Pessoas.png");
        minimoTamanhoTela();
    }
    public static TelaCadastro getTela() { //Estático para poder ser chamado de outras classes sem a necessidade de ter criado um objeto anteriormente.

        if (telaPessoa     == null) {   //Tela não está aberta, pode criar uma nova tela
            telaPessoa = new TelaCadastroPessoa();
            
             telaPessoa.addInternalFrameListener(new InternalFrameAdapter() { //Adiciona um listener para verificar quando a tela for fechada, fazendo assim a remoção da mesma junto ao JDesktopPane da TelaSistema e setando a variável tela = null para permitir que a tela possa ser aberta novamente em outro momento. Basicamente o mesmo controle efetuado pela tela de pesquisa, porém de uma forma um pouco diferente.
                @Override
                public void internalFrameClosed(InternalFrameEvent e) {
                    TelaSistema.jdp.remove(telaPessoa);
                    telaPessoa = null;
                }
            });TelaSistema.jdp.add(telaPessoa);
        }
        //Depois do teste acima, independentemente dela já existir ou não, ela é selecionada e movida para frente
        
        TelaSistema.jdp.setSelectedFrame(telaPessoa);
        TelaSistema.jdp.moveToFront(telaPessoa);
        
        return telaPessoa;
    }

    public void montarTela (){
        adicionaComponentes(1, 1, 1, 1, campoCodPessoa);
        adicionaComponentes(3, 1, 1, 1, campoNomePessoa);
        adicionaComponentes(3, 3, 1, 1, campoData);
        adicionaComponentes(5, 1, 1, 1, campoCpf);
        adicionaComponentes(5, 2, 1, 1, campoRg);
        adicionaComponentes(7, 1, 1, 1, campoTelefone);
        adicionaComponentes(7, 2, 1, 1, campoCelular);
        adicionaComponentes(9, 1, 1, 1, campoEmail);
        adicionaComponentes(11, 1, 1, 1, campoCcb1);
        adicionaComponentes(11, 2, 1, 1, campoCcb2);
        adicionaComponentes(13, 1, 1, 1, campoEstado);
        adicionaComponentes(13, 2, 1, 1, campoCidade);
        adicionaComponentes(15, 1, 1, 1, campoRua);
        adicionaComponentes(15, 2, 1, 1, campoInt);
        adicionaComponentes(17, 1, 1, 1, campoComplemento);
        adicionaComponentes(17, 2, 1, 1, campoCep);  
        pack();///
        habilitaComponentes (false);
    }
    
    @Override
    public boolean validaComponentes(){
        boolean retorno = super.validaComponentes();        
        if (!campoCcb1.isSelected() && !campoCcb2.isSelected()){
            JOptionPane.showMessageDialog(null, "<html><body><h4><font color=red>" + "Selecione o tipo de pessoa (Cliente/Advogado)!" + "</font></h4></body></html>");
            retorno = false;
        }
        return retorno;
    }
}
