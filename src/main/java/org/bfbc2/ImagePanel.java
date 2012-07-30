package org.bfbc2;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Alain
 * Date: 20 juin 2010
 * Time: 09:33:33
 * To change this template use File | Settings | File Templates.
 */
public class ImagePanel  extends JPanel {

	private Image image;

	ImagePanel(Image image) {
		this.image=image;
	    // Taille du panneau égale à la taille de l'image
	    //setPreferredSize(new Dimension(377,517));
		setPreferredSize(new Dimension(image.getWidth(this),image.getHeight(this)));
	}
	// Dessins de la fenêtre
	public void paintComponent(Graphics g) {
	    // Appel à la méthode de la super-classe
	    super.paintComponent(g);
	    // Dessin de l'image
	    g.drawImage(image, 0, 0, this);
	}


}
