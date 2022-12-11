package mesadepool;

import java.util.Timer;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class Ventana extends JFrame {

    public Ventana() {
        PanelPrincipal panel = new PanelPrincipal();
        add(panel);
    }
}
