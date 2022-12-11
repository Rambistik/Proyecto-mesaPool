package mesadepool;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MesaDePool extends JPanel implements MouseListener, ActionListener, MouseMotionListener {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args){ 
        MesaDePool m = new MesaDePool();
        m.setSize(1200, 850);
        m.init();
        Timer myTimer = new Timer();
        Task myTask = new Task(m);
        myTimer.schedule(myTask, 30, 5);
        m.setVisible(true);
    }
    
    
    
    private ArrayList<Bola> Bolas;
    private BolaBlanca BB;
    private ArrayList<Agujeros> Agujero;
    private PaloDeBillar Taco;

    private Image img;
    public MouseEvent press, release;
    public Graphics bufferGraphics;
    public BufferedImage offscreen;
    public Dimension dim;

    private AffineTransform myTransform;
    private AffineTransform myTranslate;
    private AffineTransform myStickOffset;
    private double powerOffset, power, angle;
    private boolean stopped;

    public void init() {

        angle = Math.PI / 2.0;
        power = 0.0;
        powerOffset = 0.0;
        stopped = false;
        Agujero = new ArrayList<Agujeros>();
        Bolas = new ArrayList<Bola>();

        Agujero.add(new Agujeros(101, 113));
        Agujero.add(new Agujeros(470, 107));
        Agujero.add(new Agujeros(841, 112));
        Agujero.add(new Agujeros(101, 467));
        Agujero.add(new Agujeros(471, 474));
        Agujero.add(new Agujeros(841, 467));

        BB = new BolaBlanca(225, 290);
        Taco = new PaloDeBillar();
        dim = new Dimension(1000, 700);

        offscreen = new BufferedImage(dim.width, dim.height, BufferedImage.TYPE_INT_RGB);
        bufferGraphics = offscreen.getGraphics();
        Graphics2D g2 = (Graphics2D) bufferGraphics;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHints(rh);

        try {
            img = ImageIO.read(getClass().getResource("/resources/table.jpg"));
        } catch (IOException e) {
        }
        
        addMouseListener(this);
        addMouseMotionListener(this);
        myTransform = new AffineTransform();
        myTransform.rotate(angle);
        myTranslate = new AffineTransform();
        myStickOffset = new AffineTransform();
        myStickOffset.setToTranslation(-6, 0);

        Bolas.add(new Bola(585, 290));

        Bolas.add(new Bola(604, 279));
        Bolas.add(new Bola(604, 301));

        Bolas.add(new Bola(623, 269));
        Bolas.add(new Bola(623, 290));
        Bolas.add(new Bola(623, 311));

        Bolas.add(new Bola(642, 258));
        Bolas.add(new Bola(642, 279));
        Bolas.add(new Bola(642, 301));
        Bolas.add(new Bola(642, 322));

        Bolas.add(new Bola(661, 248));
        Bolas.add(new Bola(661, 269));
        Bolas.add(new Bola(661, 290));
        Bolas.add(new Bola(661, 311));
        Bolas.add(new Bola(661, 332));
        Bola.parent = this;

    }

    public void update() {
        if (Bolas == null) {
            return;
        }
        stopped = true;
        for (int i = 0; i < Bolas.size(); i++) {
            Bola b = Bolas.get(i);
            if (b.getSpeed() > 0.001) {
                stopped = false;
            }
            for (Bola b2 : Bolas) {
                if (b2 != b) {
                    b.collides(b2);
                }
            }
            b.collides(BB);
            for (Agujeros agu : Agujero) {            //si la bola choca con el agujero es removida
                if (agu.collidesWith(b)) {
                    Bolas.remove(b);
                    i--;
                }
            }
        }
        for (Bola b : Bolas) {
            b.update();
        }
        for (Agujeros agu : Agujero) {                // si la bola blanca choca con un agujero entonces reaparece en el centro
            if (agu.collidesWith(BB)) {
                BB = new BolaBlanca(250, 275);
            }
        }
        if (BB.getSpeed() > 0.001) {
            stopped = false;
        }

        if (stopped) {
            myTranslate.setToTranslation(BB.getX() + 10, BB.getY() + 10); //para posicionar el palo de billar
        }
        BB.update();
        repaint();
    }


    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) bufferGraphics;
        AffineTransform temp = g2d.getTransform();
        AffineTransform temp2 = new AffineTransform();

        int dx1 = 0;
        int dy1 = 0;
        int dx2 = 960;
        int dy2 = 600;
        int sx1 = 0;
        int sy1 = 0;
        int sx2 = 480;
        int sy2 = 300;

        g2d.clearRect(0, 0, dim.width, dim.height);
        g2d.setColor(Color.black);

        g2d.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, this);
        for (Bola b : Bolas) {
            b.paint(g2d);
        }
        BB.paint(g2d);

        temp2.concatenate(myTranslate);                 //junta varios array y los traduce a graphics 2d para transformar el objeto
        temp2.concatenate(myTransform);
        temp2.concatenate(myStickOffset);
        g2d.setTransform(temp2);
        if (stopped) {
            Taco.paint(bufferGraphics, this);
        }
        g2d.setTransform(temp);

        if (stopped) {
            bufferGraphics.setColor(Color.black);
            int dx = (int) (1000 * Math.cos(angle - Math.PI / 2));
            int dy = (int) (1000 * Math.sin(angle - Math.PI / 2));
            int size = 10;
            bufferGraphics.drawLine((int) BB.getX() + size, (int) BB.getY() + size, (int) BB.getX() + dx + size, (int) BB.getY() + dy + size);
        }

        g.drawImage(offscreen, 0, 0, this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        double dx = e.getX() - BB.getX();
        double dy = e.getY() - BB.getY();
        powerOffset = Math.sqrt(dx * dx + dy * dy);

    }
    
    public double distance(MouseEvent e, Bola b){
        int x1 = e.getX();
        int y1 = e.getY();
        double x2 = b.getX();
        double y2 = b.getY();
        double dx = x1 - x2;
        double dy = y1 - y2;
        return Math.sqrt(dx * dx - dy * dy);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (stopped) {
            BB.Vx = power * Math.cos(angle - Math.PI / 2) * 0.1;
            BB.Vy = power * Math.sin(angle - Math.PI / 2) * 0.1;
        }
        angle = 0;
        myTransform.setToTranslation(0, 0);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        double dx = e.getX() - BB.getX();
        double dy = e.getY() - BB.getY();
        power = Math.sqrt(dx * dx + dy * dy) - powerOffset;
        angle = Math.atan2(dy, dx);
        myTransform.setToTranslation(power * Math.cos(angle), power * Math.sin(angle));
        angle -= Math.PI / 2;
        myTransform.rotate(angle);
    }
    
    public void mouseMoved(MouseEvent e) {
    }
    
    public void keyPressed(KeyEvent e) {
    }
    
    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void actionPerformed(ActionEvent e) {
    }
}
