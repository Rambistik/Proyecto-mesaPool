
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
        g.fillOval(5, 10, 80, 80);
        g.fillOval(703, 10, 80, 80);
        g.fillOval(703, 470, 80, 80);
        g.fillOval(5, 470, 80, 80);
        g.fillOval(350, 470, 80, 80);
        g.fillOval(350,10, 80, 80);
        
        
        
    }
}
