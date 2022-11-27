package mesadepool;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

class PanelPrincipal extends JPanel {

    public PanelPrincipal() {
        super();
        setBackground(Color.gray);
        setSize(800, 600);
        setVisible(true);
    }
    

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(153,102,0));
        g.fillRect(0, 0, 20, 600);
        g.fillRect(765, 0, 20, 600);
        g.fillRect(0, 0, 800, 20);
        g.fillRect(0, 540, 800, 20);
        
        g.setColor(Color.green);
        g.fillRect(20, 20,750, 520);
    }
}

