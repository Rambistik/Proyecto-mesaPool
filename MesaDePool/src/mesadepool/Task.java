package mesadepool;

import java.awt.Graphics;
import java.util.TimerTask;

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