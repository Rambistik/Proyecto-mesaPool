package mesadepool;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bola {

    private double x, y;
    public double Vx, Vy;
    private double radio;

    public double getSpeed() {
        return Vx * Vx + Vy * Vy;
    }

    public double getRadio() {
        return radio;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Bola(double x, double y) {
        radio = 10;
        this.x = x;
        this.y = y;
        Vx = 0;
        Vy = 0;
    }

    private void generarbola() {
        Rectangle bola = new Rectangle();
        bola.width = 32;
        bola.height = 32;
        bola.add(bola);
    }

    public void paint(Graphics g) {
        g.setColor(Color.white);

        g.setColor(Color.black);

        g.setColor(Color.red);

        g.setColor(Color.red);

        g.setColor(Color.green);

        g.setColor(Color.green);

        g.setColor(Color.blue);

        g.setColor(Color.blue);

        g.setColor(Color.yellow);

        g.setColor(Color.yellow);

        g.setColor(new Color(102, 0, 153));

        g.setColor(new Color(102, 0, 153));

        g.setColor(new Color(255, 102, 0));

        g.setColor(new Color(255, 102, 0));

        g.setColor(new Color(102, 52, 0));

        g.setColor(new Color(102, 52, 0));
        
        int diametro = (int) (radio * 2);
        
        g.fillOval((int) x, (int) y, diametro, diametro);
    }

}
