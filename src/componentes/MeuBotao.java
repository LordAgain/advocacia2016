package componentes;
 
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MeuBotao extends JButton {
 
    public MeuBotao(String texto) {
        super(texto);
    }
 
    public MeuBotao(String localImagem, String nome, boolean areaFilled, boolean borderPainted, boolean focusable) {
        super(nome);
        Icon icone = new ImageIcon(localImagem);
        setIcon(icone);
        setContentAreaFilled(areaFilled);
        setBorderPainted(borderPainted);
        setFocusable(focusable);
        setFont();
    }
    
    public void setFont(){
        setFont(new Font("Arial", Font.PLAIN, 13));
    }
}