package Graphisme;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;

/**
 * classe qui peut charger des images et les afficher
 * 
 * <pre>
 * Les images ne sont chargées qu'une fois. On doit leur donner un nom au
 * chargement
 * 
 * <pre>
 * tout est en statique pour y acceder facilement
 * 
 * @author vthomas
 *
 */
public class Sprites {

	/**
	 * la map qui stocke les images
	 */
	private static Map<String, BufferedImage> images = new HashMap<String, BufferedImage>();

	/**
	 * methode de chargement d'une image.
	 * 
	 * <pre>
	 * Charge completement l'image nomFichier et lui attribue le nom nom
	 * 
	 * @param nom
	 *            nom de reference de l'image chargee
	 * @param nomFichier
	 *            nom du fichier à charger
	 */
	public static void chargerImage(String nom, String nomFichier) {
		// verifie nom est disponible
		if (images.containsKey(nom))
			throw new Error("nom " + nom + " deja pris");

		// charge image
		BufferedImage res = null;
		try {
			res = ImageIO.read(new File(nomFichier));
		} catch (IOException e) {
			throw new Error("probleme de lecture de fichier " + nomFichier);
		}

		// ajoute l'image
		images.put(nom, res);
	}

	/**
	 * methode de chargement d'une image.
	 * 
	 * <pre>
	 * charge le morceau (x, y) -> (x+tx, y+ty) de l'image souhaitée nomFichier
	 * et lui attribue le nom nom
	 * 
	 * @param nom
	 *            nom de reference de l'image chargee
	 * @param nomFichier
	 *            nom du fichier à charger
	 * @param dx
	 *            pos de départ
	 * @param dy
	 *            pos de départ
	 * @param tx
	 *            taille X
	 * @param ty
	 *            taille Y
	 *
	 * 
	 */
	public static void chargerImage(String nom, String nomFichier, int dx, int dy, int tx, int ty) {
		// verifie nom est disponible
		if (images.containsKey(nom))
			throw new Error("nom " + nom + " deja pris");

		// charge image
		BufferedImage res = null;
		try {
			res = ImageIO.read(new File(nomFichier));
		} catch (IOException e) {
			throw new Error("probleme de lecture de fichier " + nomFichier);
		}

		// extrait le morceau
		res = res.getSubimage(dx, dy, tx, ty);

		// ajoute l'image
		images.put(nom, res);
	}

	/**
	 * permet de charger une feuille de sprite réguliere à partir de la feuille
	 * et du nombre de ligne et de colonnes.
	 * 
	 * <pre>
	 * chaque sprite est sauve sous le nom "NomRacine_x_y"
	 * 
	 * @param nomRacine
	 *            nomRacine de la feuille
	 * @param nomFichier
	 *            nom du fichier contenant la feuille de sprites
	 * @param nx
	 *            nombre de sprites par ligne
	 * @param ny
	 *            nombre de sprites par colonne
	 */
	public static void chargerFeuille(String nomRacine, String nomFichier, int nx, int ny) {
		// si contient deja la planche
		if (images.containsKey(nomRacine + "_0_0")) {
			throw new Error("Planche " + nomRacine + " deja presente");
		}

		// charge image
		BufferedImage res = null;
		try {
			res = ImageIO.read(new File(nomFichier));
		} catch (IOException e) {
			throw new Error("probleme de lecture de fichier " + nomFichier);
		}

		// calcule taille des sprites
		int tx = res.getWidth() / nx;
		int ty = res.getHeight() / ny;

		// parcours l'image et en extrait les sprites
		for (int i = 0; i < nx; i++)
			for (int j = 0; j < ny; j++) {
				BufferedImage extraite = res.getSubimage(i * tx, j * ty, tx, ty);
				images.put(nomRacine + "_" + i + "_" + j, extraite);
			}
	}

	/**
	 * recupere une image chargee
	 * 
	 * @param nom
	 *            image chargee
	 */
	public static Image getImage(String nom) {
		return (images.get(nom));
	}

	/**
	 * permet de dessiner l'image sur le graphics
	 * 
	 * @param g
	 *            graphics avec lequel dessiner
	 * @param x
	 *            position en x
	 * @param y
	 *            position en y
	 */
	public static void dessiner(Graphics g, String nom, int x, int y) {
		Image image = getImage(nom);
		if (image == null)
			throw new Error("ressource image " + nom + " inexistante");
		g.drawImage(image, x, y, null);
	}
	
	/**
	 * permet de dessiner l'image de anière centree sur le graphics
	 * 
	 * @param g
	 *            graphics avec lequel dessiner
	 * @param x
	 *            position en x
	 * @param y
	 *            position en y
	 */
	public static void dessinerCentre(Graphics g, String nom, int x, int y) {
		Image image = getImage(nom);
		if (image == null)
			throw new Error("ressource image " + nom + " inexistante");
		int dx=x-image.getWidth(null)/2;
		int dy=y-image.getHeight(null)/2;
		
		g.drawImage(image, dx, dy, null);
	}

}
