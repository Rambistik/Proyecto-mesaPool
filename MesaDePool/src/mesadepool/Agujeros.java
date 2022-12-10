
package mesadepool;

import java.awt.Color;
import java.awt.Graphics;

public class Agujeros {

    public int x, y;

    public Agujeros(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillOval((int) x, (int) y, 20, 20);
    }
}
