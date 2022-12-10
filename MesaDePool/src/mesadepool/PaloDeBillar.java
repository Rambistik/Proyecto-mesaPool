package mesadepool;

import java.awt.Graphics;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.*;

public class PaloDeBillar {

    private Image cue;

    public PaloDeBillar() {
        try {
            cue = ImageIO.read(getClass().getResource("/resources/cuestick.png"));
        } catch (IOException e) {
        }
    }

    public void paint(Graphics g, ImageObserver observer) {
        g.drawImage(cue, 0, 0, observer);
    }
}
