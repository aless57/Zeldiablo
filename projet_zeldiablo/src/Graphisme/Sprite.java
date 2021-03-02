package Graphisme;

import java.awt.Graphics;

/**
 * un sprite correspond à une image positionnée à un endroit de la scene
 * 
 * @author vthomas
 *
 */
public class Sprite {

	/**
	 * le nom de l'image stockée dans Images
	 */
	String nomImage;

	/**
	 * la position du sprite
	 */
	int x, y;

	/**
	 * creation du sprite
	 * 
	 * @param nom
	 *            nom de l'imaeg
	 */
	public Sprite(String nom) {
		this.nomImage = nom;
		this.x = 0;
		this.y = 0;
	}

	/**
	 * permet de dessiner le sprite avec un graphics
	 * 
	 * @param g
	 *            graphics pour dessiner
	 */
	public void dessiner(Graphics g) {
		Sprites.dessiner(g, this.nomImage, this.x, this.y);
	}

}
