package componentes;

import java.text.SimpleDateFormat;
import javax.swing.text.MaskFormatter;

public class MeuCampoData extends MeuCampoFormatado {
    
    public MeuCampoData (boolean obrigatorio, String dica, int tamanho){
        super (obrigatorio, dica, tamanho);
        try {
            MaskFormatter mf = new MaskFormatter("##/##/####");
            mf.install(this);
            setColumns(tamanho);
        } catch (Exception e){
            e.printStackTrace();
        }
    } 
        
    @Override
    public boolean eVazio() {
        return getText().equals("  /  /    ");
    }

    @Override
    public boolean eValido() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            sdf.parse(getText());
            return true;
        } catch (Exception e) {
            return false;
        }
    }    
}

