package componentes;

import javax.swing.JCheckBox;

public class MeuCampoCheckBox extends JCheckBox implements MeuComponente{    
    public String dica;
    private boolean obrigatorio;
    
    public MeuCampoCheckBox(String dica) {
        this.dica = dica;
        this.obrigatorio = obrigatorio;
    }
    
    @Override
    public boolean eObrigatorio() {
        return true;
    }

    @Override
    public boolean eValido() {
        return true;
    }

    @Override
    public boolean eVazio() {
        return false;
    }

    @Override
    public String getDica() {
        return dica;
    }

    @Override
    public void habilitar(boolean status) {
        setEnabled(status);
    }

    @Override
    public void limpar() {
        setSelected(false);
    }    

    @Override
    public Object getValor() {
        return (isSelected());      
    }

    @Override
    public void setValor(Object valor) {
        setSelected((Boolean) valor);
    }

    @Override
    public void showHint() {
        if (eObrigatorio()){
                setToolTipText("Este campo é obrigatório, por favor, preencha-o corretamente!");
            } else {
                setToolTipText("Este campo NÃO é obrigatório, preencha-o se houver necessidade!");
            }
    }
}
