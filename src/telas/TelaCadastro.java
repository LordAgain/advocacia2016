package telas;

import componentes.MeuBotao;
import componentes.MeuComponente;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TelaCadastro extends JInternalFrame implements ActionListener {
    public static TelaCadastro telaCadastro;
    public static String padrao = "|^Á,É,Â,Ã,À,Ê,Í,Ì,Ç]";
    public JPanel jpComponentes = new JPanel();
    public JPanel jpBotoes = new JPanel();
    public List<MeuComponente> componentes = new ArrayList();
    public MeuBotao jbIncluir = new MeuBotao("E:\\Users\\Renato\\Documents\\NetBeansProjects\\Aulas\\src\\Imagens\\Ícones Botões\\Add.png", "Incluir", true, true, true);
    public MeuBotao jbAlterar = new MeuBotao("E:\\Users\\Renato\\Documents\\NetBeansProjects\\Aulas\\src\\Imagens\\Ícones Botões\\Alter.png", "Alterar", true, true, true);
    public MeuBotao jbExcluir = new MeuBotao("E:\\Users\\Renato\\Documents\\NetBeansProjects\\Aulas\\src\\Imagens\\Ícones Botões\\Delete.png", "Excluir", true, true, true);
    public MeuBotao jbConsultar = new MeuBotao("E:\\Users\\Renato\\Documents\\NetBeansProjects\\Aulas\\src\\Imagens\\Ícones Botões\\Search.png", "Consultar", true, true, true);
    public MeuBotao jbConfirmar = new MeuBotao("E:\\Users\\Renato\\Documents\\NetBeansProjects\\Aulas\\src\\Imagens\\Ícones Botões\\Ok.png", "Confirmar", true, true, true);
    public MeuBotao jbCancelar = new MeuBotao("E:\\Users\\Renato\\Documents\\NetBeansProjects\\Aulas\\src\\Imagens\\Ícones Botões\\Cancel.png", "Cancelar", true, true, true);

    public final int PADRAO = 0;
    public final int INCLUINDO = 1;
    public final int ALTERANDO = 2;
    public final int CONSULTANDO = 3;
    public final int EXCLUINDO = 4;

    public int estadoDaTela = PADRAO;
    public boolean temDadosNaTela = false;

    public TelaCadastro(String titulo) {
        super(titulo, true, true, true, true);
        setVisible(true);
        jpBotoes.setLayout(new GridLayout(1, 6));
        jpComponentes.setLayout(new GridBagLayout());
        getContentPane().add("Center", jpComponentes);
        getContentPane().add("South", jpBotoes);
        adicionaBotoes(jpBotoes, jbIncluir);
        adicionaBotoes(jpBotoes, jbAlterar);
        adicionaBotoes(jpBotoes, jbExcluir);
        adicionaBotoes(jpBotoes, jbConsultar);
        adicionaBotoes(jpBotoes, jbConfirmar);
        adicionaBotoes(jpBotoes, jbCancelar);
        pack();
        habilitaBotoes();
        
        //setFont();
    }
    
    private void adicionaBotoes(JPanel painel, JButton botao) {
        painel.add(botao);
        botao.addActionListener(this);
    }

    public void adicionaComponentes(int linha, int coluna, int altura, int largura, JComponent componente) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = linha;
        gbc.gridx = coluna;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;

        String texto = "" + (((MeuComponente) componente).getDica());

        //if (((MeuComponente)componente).eObrigatorio()) {
        //    texto = texto + " ";
        //}
        texto = texto + " :";

        JLabel rotulo = new JLabel(texto);
        jpComponentes.add(rotulo, gbc);
        rotulo.setFont(new Font("Arial", Font.BOLD, 17));

        gbc.gridx++;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridheight = altura;
        gbc.gridwidth = largura;
        gbc.anchor = GridBagConstraints.WEST;

        jpComponentes.add(componente, gbc);

        componentes.add((MeuComponente) componente);
    }

    public void habilitaComponentes(boolean status) {
        for (int i = 0; i < componentes.size(); i++) {
            componentes.get(i).habilitar(status);
        }
    }

    public boolean validaComponentes() {
        String errosObrigatorio = "", errosInvalido = "", errosTotal = "";
        for (int i = 0; i < componentes.size(); i++) {
            if (componentes.get(i).eObrigatorio() && componentes.get(i).eVazio()) {
                errosObrigatorio = errosObrigatorio + componentes.get(i).getDica() + "\n";
            }
            if (!componentes.get(i).eValido() && !componentes.get(i).eVazio()) {
                errosInvalido = errosInvalido + componentes.get(i).getDica() + "\n";
            }
        }
        if (!errosObrigatorio.isEmpty()) {
            errosTotal = "O(s) campo(s) abaixo é (são) obrigatório(s) e não foi (foram) preenchido(s): \n\n" + errosObrigatorio;
        }
        if (!errosInvalido.isEmpty()) {
            errosTotal = errosTotal + "\n\n\n" + "<html><body><h4><font color=red>" + "O(s) campo(s) abaixo é (são) inválido(s): \n\n" + errosInvalido;
        }
        if (!errosTotal.isEmpty()) {
            JOptionPane.showMessageDialog(null, "<html><body><h4><font color=red>" + errosTotal);
        }
        return errosTotal.isEmpty();
    }

    public void limparCampos() {
        for (int i = 0; i < componentes.size(); i++) {
            componentes.get(i).limpar();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jbIncluir) {
            incluir();
        } else if (ae.getSource() == jbAlterar) {
            alterar();
        } else if (ae.getSource() == jbExcluir) {
            excluir();
        } else if (ae.getSource() == jbConsultar) {
            consultar();
        } else if (ae.getSource() == jbConfirmar) {
            confirmar();
        } else if (ae.getSource() == jbCancelar) {
            cancelar();
        }
    }

    public void habilitaBotoes() {
        jbIncluir.setEnabled(estadoDaTela == PADRAO);
        jbAlterar.setEnabled(estadoDaTela == PADRAO && temDadosNaTela);
        jbExcluir.setEnabled(estadoDaTela == PADRAO && temDadosNaTela);
        jbConsultar.setEnabled(estadoDaTela == PADRAO);
        jbConfirmar.setEnabled(estadoDaTela != PADRAO);
        jbCancelar.setEnabled(estadoDaTela != PADRAO);
    }

    public void incluir() {
        estadoDaTela = INCLUINDO;
        habilitaBotoes();
        habilitaComponentes(true);
    }

    public void alterar() {
        estadoDaTela = ALTERANDO;
        habilitaBotoes();
    }

    public void excluir() {
        estadoDaTela = EXCLUINDO;
        habilitaBotoes();
    }

    public void consultar() {
        estadoDaTela = CONSULTANDO;
        habilitaBotoes();
    }

    public void confirmar() {
        if (estadoDaTela == INCLUINDO) {
            if (!validaComponentes() || !incluirBD()) {
                return;
            } else {
                limparCampos();
                habilitaComponentes(false);
            }
        } else if (estadoDaTela == ALTERANDO && validaComponentes()) {
            if (!alterarBD()) {
                return;
            }
        } else if (estadoDaTela == EXCLUINDO) {
            if (!excluirBD()) {
                return;
            }
        }
        estadoDaTela = PADRAO;
        habilitaBotoes();
    }

    public void cancelar() {
        estadoDaTela = PADRAO;
        habilitaBotoes();
        habilitaComponentes(false);
        limparCampos();
    }

    public boolean incluirBD() {
        return true;
    }

    public boolean alterarBD() {
        return true;
    }

    public boolean excluirBD() {
        return true;
    }

    public void IconeFrame(String path) {
        setFrameIcon(new ImageIcon(this.getClass().getResource(path)));
    }

    public void minimoTamanhoTela() {
        setMinimumSize(new Dimension(getWidth(), getHeight()));
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    public void setFont() {
        setFont(new Font("Open Sans", Font.PLAIN, 17));
    }
}
