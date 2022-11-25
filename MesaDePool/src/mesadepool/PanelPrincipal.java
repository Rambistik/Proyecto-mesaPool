package mesadepool;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;

class PanelPrincipal extends JPanel {

    public PanelPrincipal() {
        super();
        setBackground(Color.green);
        setSize(800, 600);
        setVisible(true);
        Botones();
    }
    
     public void Botones(){
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
        g.setColor(Color.yellow);
        g.drawLine(600, 100, 200, 200);
    }
}

