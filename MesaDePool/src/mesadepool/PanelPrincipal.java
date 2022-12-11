package mesadepool;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;

class PanelPrincipal extends JPanel {
    
    MesaDePool parent;
    Graphics g;

    public PanelPrincipal(MesaDePool myparent) {

        super();
        parent = myparent;
        setBackground(Color.gray);
        setSize(800, 600);
        setVisible(true);
        Botones();
    }

    PanelPrincipal() {
    }

    public void run() {
        parent.update();
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
    }
}
