package telas;

import componentes.MeuJDesktopPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaSistema extends JFrame implements ActionListener {

    public static MeuJDesktopPane jdp = new MeuJDesktopPane();
    public JMenuBar jmb = new JMenuBar();
    TelaCadastroEstado telaEstado;
    TelaCadastroCidade telaCidade;
    TelaCadastroPessoa telaPessoa;
    TelaCadastroProcesso telaProcesso;
    TelaContasAPagar telaContasAPagar;
    TelaContasAReceber telaContasAReceber;

    public JMenu jmCadastros = new JMenu("Cadastros");
    public JMenu jmMovimentos = new JMenu("Movimentos");
    public JMenu jmRelatórios = new JMenu("Relatórios");

    public JMenuItem jmiPessoa = new JMenuItem("Pessoas");
    public JMenuItem jmiProcesso = new JMenuItem("Processos");
    public JMenuItem jmiCidade = new JMenuItem("Cidades");
    public JMenuItem jmiEstado = new JMenuItem("Estados");
    public JMenuItem jmiContasAPagar = new JMenuItem("Contas a Pagar");
    public JMenuItem jmiContasAReceber = new JMenuItem("Contas a Receber");
    public JMenuItem jmiRelatorios = new JMenuItem("Consulta");

    public TelaSistema() {

        setSize(1600, 900);
        setLocation(150, 50);

        setExtendedState(MAXIMIZED_BOTH);
        setTitle("Advocacia");
        getContentPane().add(jdp);
        setJMenuBar(jmb);

        jmb.add(jmCadastros);
        jmb.add(jmMovimentos);
        jmb.add(jmRelatórios);

        adicionaJMenuItem(jmCadastros, jmiPessoa);
        adicionaJMenuItem(jmCadastros, jmiProcesso);
        adicionaJMenuItem(jmCadastros, jmiCidade);
        adicionaJMenuItem(jmCadastros, jmiEstado);
        adicionaJMenuItem(jmMovimentos, jmiContasAPagar);
        adicionaJMenuItem(jmMovimentos, jmiContasAReceber);
        adicionaJMenuItem(jmRelatórios, jmiRelatorios);

        /*
         jmCadastros.add(jmiEstado);
         jmCadastros.add(jmiCidade);
         jmMovimentos.add(jmiCompra);
         jmiEstado.addActionListener(this);
         jmiCidade.addActionListener(this);
         jmiCompra.addActionListener(this);
         */
        inserirImagem();
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Fecha toda a aplicação
        setVisible(true);
    }

    private void adicionaJMenuItem(JMenu menu, JMenuItem item) {
        menu.add(item);
        //menu.addSeparator();
        item.addActionListener(this);
        menu.setFont(new Font("Arial", Font.BOLD, 15));
        item.setFont(new Font("Arial", Font.PLAIN, 13));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jmiPessoa) {
            telaPessoa = (TelaCadastroPessoa) telaPessoa.getTela();
            telaPessoa.setPosicao();

        } else if (ae.getSource() == jmiProcesso) {
            telaProcesso = (TelaCadastroProcesso) telaProcesso.getTela();
        } else if (ae.getSource() == jmiCidade) {
            telaCidade = (TelaCadastroCidade) telaCidade.getTela();
        } else if (ae.getSource() == jmiEstado) {
            telaEstado = (TelaCadastroEstado) telaEstado.getTela();
        } else if (ae.getSource() == jmiContasAPagar) {
            telaContasAPagar = (TelaContasAPagar) telaContasAPagar.getTela();
        } else if (ae.getSource() == jmiContasAReceber) {
          telaContasAReceber = (TelaContasAReceber) telaContasAReceber.getTela();
        }
    }

    private void inserirImagem() {
        jmiPessoa.setIcon(new ImageIcon(getClass().getResource("/icone/Pessoas.png")));
        jmiProcesso.setIcon(new ImageIcon(getClass().getResource("/icone/Processo.png")));
        jmiCidade.setIcon(new ImageIcon(getClass().getResource("/icone/Cidade.png")));
        jmiEstado.setIcon(new ImageIcon(getClass().getResource("/icone/Estado.png")));
        jmiContasAPagar.setIcon(new ImageIcon(getClass().getResource("/icone/Contas a Pagar.png")));
        jmiContasAReceber.setIcon(new ImageIcon(getClass().getResource("/icone/Contas a Receber.png")));

        jmCadastros.setIcon(new ImageIcon(getClass().getResource("/icone/Cadastro.png")));
        jmMovimentos.setIcon(new ImageIcon(getClass().getResource("/icone/Movimentação.png")));
        jmRelatórios.setIcon(new ImageIcon(getClass().getResource("/icone/Relatório.png")));

        URL url = this.getClass().getResource("/icone/Libra.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
    }
}
