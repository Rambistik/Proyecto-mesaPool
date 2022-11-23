package mesadepool;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

class PanelPrincipal extends JPanel {

    public PanelPrincipal() {
        super();
        setBackground(Color.green);
        setSize(800, 600);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.yellow);
        g.drawLine(600, 100, 200, 200);
    }
}

