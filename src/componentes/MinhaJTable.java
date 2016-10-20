package componentes;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import telas.TelaContasAPagar;

public class MinhaJTable extends JPanel implements MeuComponente{
    
    private boolean obrigatorio;
    private String dica;
    private int largura;
    
    private JTable table;
    private JScrollPane jsp;

    private JPanel dados;
    private JPanel tableDados;
    
    private ArrayList<TelaContasAPagar> tcp;
    
    public MinhaJTable(boolean obrigatorio, String dica, int largura){
        this.obrigatorio = obrigatorio;
        this.dica = dica;
        this.largura = largura;
        
        dados = new JPanel(new GridLayout(4, 2));
        tableDados = new JPanel();
        tcp = new ArrayList<TelaContasAPagar>();
        table = new JTable();
        jsp = new JScrollPane(table);
    }

    @Override
    public String getDica() {
        return dica;
    }

    @Override
    public boolean eObrigatorio() {
        return obrigatorio;
    }

    @Override
    public void habilitar(boolean status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eVazio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eValido() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void limpar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setValor(Object valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showHint() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
