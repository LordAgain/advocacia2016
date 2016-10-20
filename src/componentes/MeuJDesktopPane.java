package componentes;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class MeuJDesktopPane extends JDesktopPane {

    private Image imagem, imagem2;

    public MeuJDesktopPane() {
        try {
            imagem = new ImageIcon("E:\\Users\\Renato\\Documents\\NetBeansProjects\\Aulas\\src\\Imagens\\Background.jpg").getImage();
            imagem2 = new ImageIcon("E:\\Users\\Renato\\Documents\\NetBeansProjects\\Aulas\\src\\Imagens\\LOGO.png").getImage();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel ler a imagem");
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension dimension = this.getSize();
        Graphics2D g2 = (Graphics2D) g;

        g.drawImage(imagem, 0, 0, (int) dimension.getWidth(), (int) dimension.getHeight(), this);
        g2.drawImage(imagem2, 45, 200, this);
    }
}