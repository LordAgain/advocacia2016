package componentes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class MeuCampoTextArea extends JScrollPane implements MeuComponente, FocusListener {
    public JTextArea jta = new JTextArea();
    public boolean obrigatorio;
    public String dica;
    
    public MeuCampoTextArea(boolean obrigatorio, String dica, int largura, int altura) {
        this.obrigatorio = obrigatorio;
        this.dica = dica;
        setPreferredSize(new Dimension(largura, altura));
        jta.setLineWrap(true);
        setViewportView(jta);
        setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
        setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jta.addFocusListener(this);
        jta.setForeground(Color.black);
        limpar();
        showHint();
        //jta.setFont(new Font("Arial", Font.PLAIN, 15));
    }

    @Override
    public boolean eObrigatorio() {
        return obrigatorio;
    }

    @Override
    public boolean eValido() {
        return !jta.getText().trim().isEmpty();
    }

    @Override
    public boolean eVazio() {
        return jta.getText().trim().isEmpty();
    }

    @Override
    public String getDica() {
        return dica;
    }

    @Override
    public void habilitar(boolean status) {
        jta.setEnabled(status);
    }

    @Override
    public void limpar() {
        jta.setText("");
        setBackground(new Color(253, 253, 253));
        if (eObrigatorio()){
            setBorder(new LineBorder(new Color(238, 118, 033)));
        }else {
            setBorder(new LineBorder(new Color(59, 59, 58)));
        }
    }       

    @Override
    public void focusGained(FocusEvent fe) {
        jta.setBackground(new Color(245, 245, 245));
        jta.setCaretPosition(0);
    }

    @Override
    public void focusLost(FocusEvent e) {
        setBackground(new Color(253, 253, 253));
        if (eObrigatorio()) {
            setBorder(new LineBorder(new Color(238, 118, 033)));
        } else {
            setBorder(new LineBorder(new Color(59, 59, 58)));
        }
        if ((eObrigatorio() && !eVazio()) && !eValido()) {
            setBorder(new LineBorder(new Color(255, 0, 0)));
            setBackground(new Color(250, 222, 222));
        }
        if (eObrigatorio() && eVazio()) {
            setBorder(new LineBorder(new Color(255, 0, 0)));
            setBackground(new Color(250, 222, 222));
            limpar();
        }
        if ((eObrigatorio() || !eObrigatorio()) && eValido()) {
            setBorder(new LineBorder(new Color(000, 205, 102)));
        }
    }

    @Override
    public Object getValor() {
        return jta.getText();
    }

    @Override
    public void setValor(Object valor) {
        jta.setText("" + valor);
    }
    
    @Override
    public void showHint(){
            if (eObrigatorio()){
                jta.setToolTipText("Este campo é obrigatório, por favor, preencha-o corretamente!");
            } else {
                jta.setToolTipText("Este campo NÃO é obrigatório, preencha-o se houver necessidade!");
            }
    }
}