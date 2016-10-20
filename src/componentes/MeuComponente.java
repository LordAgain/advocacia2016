package componentes;

public interface MeuComponente {
    public String getDica();
    public boolean eObrigatorio();
    public void habilitar(boolean status);
    public boolean eVazio();
    public boolean eValido();
    public void limpar();
    public void setValor(Object valor);
    public Object getValor();
    public void showHint();
}