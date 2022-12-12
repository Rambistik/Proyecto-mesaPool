package mesadepool;

import java.awt.Color;
import java.awt.Graphics;

class BolaBlanca extends Bola {

    public BolaBlanca(double x, double y) {
        super(x, y);
    }
/**
 * pinta la bola blanca
 * @param g 
 */
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillOval((int) super.getX(), (int) super.getY(), 20, 20);
    }
}
