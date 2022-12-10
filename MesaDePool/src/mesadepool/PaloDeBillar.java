package mesadepool;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.IOException;
import javax.imageio.ImageIO;


class PaloDeBillar {
     private Image cue;
     public PaloDeBillar()
    {
		try {
			cue = ImageIO.read(getClass().getResource("/resources/CueStick.png"));
		} catch (IOException e) {}
    }

    public void paint(Graphics g ,ImageObserver observer)
    {
        g.drawImage(cue,0,0, observer);
    }
}
