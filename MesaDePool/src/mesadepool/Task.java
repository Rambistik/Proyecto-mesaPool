package mesadepool;

import java.awt.Graphics;
import java.util.TimerTask;
/**
 * llama al metodo update
 * @author Josue Ahumada, Orlando Aravena, Rodrigo Cadiz
 */
public class Task extends TimerTask {

    MesaDePool parent;
    Graphics g;

    public Task(MesaDePool myParent) {
        parent = myParent;
    }

    public void run() {
        parent.update();
    }
}