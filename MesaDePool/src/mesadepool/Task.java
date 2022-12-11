package mesadepool;

import java.awt.Graphics;
import java.util.TimerTask;

public class Task extends TimerTask {

    PanelPrincipal parent;
    Graphics g;

    public Task(PanelPrincipal myParent) {
        parent = myParent;
    }

    public void run() {
        parent.update();
    }
}