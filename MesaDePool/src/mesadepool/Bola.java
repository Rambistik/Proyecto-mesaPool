package mesadepool;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


/**
 * las bolas son las que se utilizaran en el juego.
 * @author Josue Ahumada, Orlando Aravena, Rodrigo Cadiz
 */


public class Bola{ 
    
    public static MesaDePool parent;
    private double anteriorX, anteriorY;
    private double x, y;
    public double Vx, Vy;
    private double radio;
    
    /**
     * 
     * @return 
     */
    
    public double getSpeed(){
        return Vx * Vx + Vy* Vy;
    }
    
    /**
     * Funcion para obtener el radio.
     * @return Retorna el radio.
     */
    public double getRadio(){
        return radio;
    }
    
    /**
     * Funcion para obtener el eje x.
     * @return  Retrorna el eje x.
     */
    public double getX(){
        return x;
    }
    
    /**
     * Funcion para retornar el eje y,
     * @return Retorna el eje y.
     */
    public double getY(){
        return y;
    }
    
    /**
     * Crea una bola recibiendo 2 parametros, el eje x y el eje y, ademas que define su radio y velocidad inical.
     * @param x eje.
     * @param y eje.
     */

    public Bola(double x, double y){
        radio = 10;
        this.x = x;
        this.y = y;
        Vx = 0;
        Vy = 0;
    }
    private void generarbola(){
    Rectangle bola = new Rectangle();
    bola.width = 32;
    bola.height = 32;
    bola.add(bola);
    }
    
    /**
     * dibuja las bolas, define su color y diametro.
     * @param g paint.
     */
    
    public void paint(Graphics g){
 
        g.setColor(new Color(255,128,0));
        
        int diametro = (int) (radio * 2);
        
        g.fillOval((int) x, (int) y, diametro, diametro);
    }
 
    /**
     * 
     */
    public void update(){
        anteriorX = x;
        anteriorY = y;
        Vy *= 0.998;
        Vx *= 0.998;
        if (getSpeed() < 0.05){
            Vx = 0;
            Vy = 0;
        }
        if (y >= 460 && Vy >= 0){
            Vy *= -0.75;
        }
        if (y <= 120 && Vy <= 0){
            Vy *= -0.75;
        }
        if (x >= 832 && Vx >= 0){
            Vx *= -0.75;
        }
        if (x <= 110 && Vx <= 0){
            Vx *= -0.75;
        }
        x += Vx;
        y += Vy;

    }
    /**
     * 
     * @param otra
     * @return 
     */

    public boolean hitTest(Bola otra){
        double dx = x - otra.x;
        double dy = y - otra.y;
        return Math.sqrt(dx * dx + dy * dy) < 2 * radio;
    }
    public void collides(Bola otra){
        if (hitTest(otra)){
            x = anteriorX;
            y = anteriorY;
            otra.x = otra.anteriorX;
            otra.y = otra.anteriorY;
            double dx = otra.x - x;
            double dy = otra.y - y;
            double dist = Math.sqrt(dx * dx + dy * dy);
            if (dist == 0){
                dx = 0;
                dy = 0;
            } else{
                dx /= dist;
                dy /= dist;
            }
            double scale = (dx * Vx + dy * Vy) - (dx * otra.Vx + dy * otra.Vy);
            Vx -= dx * scale;
            Vy -= dy * scale;
            otra.Vx += dx * scale;
            otra.Vy += dy * scale;
        }
    }
}
