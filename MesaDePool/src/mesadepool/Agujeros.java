package mesadepool;

/**
 * Agujeros cumple la funcion de las troneras.
 * @author Josue Ahumada, Orlando Aravena, Rodrigo Cadiz
 */ 
import java.awt.Color;
import java.awt.Graphics;

public class Agujeros {

    public int x, y;
/**
 * Crea agujeros recibiendo parametros x,y los cuales son las cordenadas.
 * @param x eje 
 * @param y eje
 */
    public Agujeros(int x, int y) {
        this.x = x;
        this.y = y;
    }
/**
 * Dibuja los agujeros en las pociciones designadas.
 * @param g 
 */
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillOval((int) x, (int) y, 20, 20);

    }
    /**
     * Calcula si alguna bola esta en la misma posicion que algun agujero.
     * @param b es una bola cualquiera llamada desde la clase bola.
     * @return 
     */
   
     public boolean collidesWith(Bola b) {
        double dx = x - b.getX();
        double dy = y - b.getY();
        double dist = Math.sqrt(dx * dx + dy * dy);
        return dist < b.getRadio() * 2;
    }

}
