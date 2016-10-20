package componentes;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class MeuJTextField extends JTextField implements FocusListener, MeuComponente{
    private String dica;
    private boolean obrigatorio;
    /**
     * @param obrigatorio
     * @param dica
     * @param tamanho
     * @param permitido
     
    */
    public MeuJTextField (boolean obrigatorio, String dica, int tamanho,String permitido){
        super(tamanho);
        this.obrigatorio = obrigatorio;
        this.dica = dica; 
        setDocument(new TamanhoFixoJTextField(tamanho,permitido));
        //setDocument(new TeclasPermitidas());
        addFocusListener(this);
        setForeground(Color.black);
        limpar();
        showHint();
        //setFont(new Font("Arial", Font.PLAIN, 15));
    }
    
    @Override
    public String getDica (){
        return dica;
    }
    
    @Override
    public void limpar (){
        setText("");
        setBackground(new Color(253, 253, 253));
        if (eObrigatorio()){
            setBorder(new LineBorder(new Color(238, 118, 033)));
        }else {
            setBorder(new LineBorder(new Color(59, 59, 58)));
        }
    }
    
    @Override
    public void habilitar (boolean status){
        setEnabled (status);
    }
    
    @Override
    public boolean eObrigatorio (){
        return obrigatorio;
    }
    
    @Override
    public boolean eVazio (){
        return getText().trim().isEmpty();
    }
    
    @Override
    public boolean eValido (){
        return !getText().trim().isEmpty();
    }

    @Override
    public void focusGained(FocusEvent e) {
        setCaretPosition(0);
        setBackground(new Color(245, 245, 245)); 
    }
    
    @Override
    public void setValor(Object valor) {
        setText(" " + valor);
    }

    @Override
    public Object getValor() {
        return " " + getText ();
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
         if ((!eObrigatorio() && !eVazio()) && !eValido()) {
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
    public void showHint(){
            if (eObrigatorio()){
                setToolTipText("Este campo é obrigatório, por favor, preencha-o corretamente!");
            } else {
                setToolTipText("Este campo NÃO é obrigatório, preencha-o se houver necessidade!");
            }
    }
}
