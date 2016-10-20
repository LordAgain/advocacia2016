package sistema;

import de.javasoft.plaf.synthetica.SyntheticaWhiteVisionLookAndFeel;
import javax.swing.UIManager;
import telas.TelaSistema;

public class Sistema {

    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(new SyntheticaWhiteVisionLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }

        TelaSistema telaSistema = new TelaSistema();

    }
}
