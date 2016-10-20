package componentes;

public class MeuCampoCodigo extends MeuCampoInteiro{
    private boolean podeHabilitar;
    
    public MeuCampoCodigo(boolean obrigatorio, String dica, Integer tamanho, boolean permiteNegativo, boolean podeHabilitar) {
        super(obrigatorio, dica, tamanho, permiteNegativo);
        this.podeHabilitar = podeHabilitar;
    }
    
    @Override
    public boolean eValido(){
        return getText().isEmpty();
    }
    
    @Override
    public void habilitar (boolean status){
        setEnabled (podeHabilitar && status);
    }
}
