package mesadepool;

import java.awt.Graphics;
import java.util.TimerTask;

public class Task extends TimerTask {

    Bola parent;
    Graphics g;

    public Task(Bola myParent) {
        parent = myParent;
    }

    public void run() {
        parent.update();
    }
}
