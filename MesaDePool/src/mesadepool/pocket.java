package mesadepool;

import java.awt.Color;
import java.awt.Graphics;

public class pocket {

    public int x, y;

    public pocket(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillOval((int) x, (int) y, 20, 20);
    }

    public boolean collidesWith(Bola b) {
        double dx = x - b.getX();
        double dy = y - b.getY();
        double dist = Math.sqrt(dx * dx + dy * dy);
        return dist < b.getRadio() * 2;
    }
}
