package componentes;

import javax.swing.text.MaskFormatter;

public class MeuCampoTelefone extends MeuCampoFormatado{    
    public MeuCampoTelefone(boolean obrigatorio, String dica, int tamanho) {
        super(obrigatorio, dica, tamanho);
        try {
            MaskFormatter mf = new MaskFormatter("(##)####-####");
            mf.setValidCharacters("0123456789");
            mf.install(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public boolean eVazio(){
        return getText().equals("(  )    -    ");
    }
    
    @Override
    public boolean eValido (){
        return getText().trim().length() == 13;
    }    
}