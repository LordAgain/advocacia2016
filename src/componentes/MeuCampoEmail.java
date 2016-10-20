/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

/**
 *
 * @author renato
 */
public class MeuCampoEmail extends MeuJTextField {

    public MeuCampoEmail(boolean obrigatorio, String dica, int tamanho, String permitido) {
        super(obrigatorio, dica, tamanho, permitido);
    }
    
    @Override
    public boolean eValido(){
        
        return !getText().trim().isEmpty() && validaEmail();
    }

    public boolean validaEmail() {

        if ((getText().contains("@"))
                && (getText().contains("."))
                && (!getText().contains(" "))) {

            String usuario = new String(getText().substring(0,
                    getText().lastIndexOf('@')));

            String dominio = new String(getText().substring(getText().lastIndexOf('@') + 1, getText().length()));

            if ((usuario.length() >= 1) && (!usuario.contains("@"))
                    && (dominio.contains(".")) && (!dominio.contains("@")) && (dominio.indexOf(".")
                    >= 1) && (dominio.lastIndexOf(".") < dominio.length() - 1)) {

                return true;

            } else {

                return false;

            }

        } else {
            return false;

        }

    }

}
