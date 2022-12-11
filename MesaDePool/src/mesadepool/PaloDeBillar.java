package mesadepool;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Codigo para el palo de billar,
 * @author Josue Ahumada, Orlando Aravena, Rodrigo Cadiz
 */

class PaloDeBillar {
     private Image cue;
     /**
      * carga la imagen de palo de billar con un try catch.
      */
     public PaloDeBillar()
    {
		try {
			cue = ImageIO.read(getClass().getResource("/resources/CueStick.png"));
		} catch (IOException e) {}
    }

    /**
     * pone la imagen de palo de billar
     * @param g paint
     * @param observer imagen.
     */    
    public void paint(Graphics g ,ImageObserver observer)
    {
        g.drawImage(cue,0,0, observer);
    }
}
