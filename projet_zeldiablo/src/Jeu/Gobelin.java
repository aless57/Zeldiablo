package Jeu;

//Représente un monstre qui est un personnage non-joueur
public class Gobelin extends PersonnageNonJoueur{
	
	private static String[] sprites = {"src/Sprite/Gobelin/haut.png","src/Sprite/Gobelin/droite.png","src/Sprite/Gobelin/bas.png","src/Sprite/Gobelin/gauche.png"};
	
	private static String[] spritesAttaque = {"src/Sprite/Gobelin/haut_attaque.png","src/Sprite/Gobelin/droite_attaque.png","src/Sprite/Gobelin/bas_attaque.png","src/Sprite/Gobelin/gauche_attaque.png"};
	
	/**
	 * constructeur Gobelin
	 * @param j
	 * @param x
	 * 			  coordonnee x
	 * @param y
	 * 			  coordonnee y
	 */
	public Gobelin(ZeldiabloJeu jeu, int x, int y) {
		
		super(jeu, 5, false, true, 0.3, sprites, spritesAttaque, x, y);
		// TODO Auto-generated constructor stub
	}


	

}
