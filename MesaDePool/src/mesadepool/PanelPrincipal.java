package mesadepool;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

class PanelPrincipal extends JPanel implements MouseListener, ActionListener {

    private Agujeros agu;
    private ArrayList<Bola> Bolas;
    private BolaBlanca BB;

    public PanelPrincipal() {
        super();
        agu = new Agujeros(5, 5);
        setBackground(Color.gray);
        setSize(800, 600);
        setVisible(true);
        Botones();
    }
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
        BB = new BolaBlanca(225, 290);

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
    }

    public void Botones() {
        JButton reiniciar = new JButton("REINICIAR PARTIDA");
        reiniciar.setBounds(425, 500, 100, 40);
        JButton masbola = new JButton("+ Bola");
        masbola.setBounds(525, 500, 100, 40);
        JButton menosbola = new JButton("- Bola");
        menosbola.setBounds(625, 500, 100, 40);
        this.add(reiniciar);
        this.add(masbola);
        this.add(menosbola);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(new Color(153, 102, 0));
        g.fillRect(0, 0, 20, 600);
        g.fillRect(765, 0, 20, 600);
        g.fillRect(0, 0, 800, 20);
        g.fillRect(0, 540, 800, 20);

        g.setColor(Color.green);
        g.fillRect(20, 20, 750, 520);
        agu.paint(g);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
