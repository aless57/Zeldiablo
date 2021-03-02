package Jeu;

public class Troll extends PersonnageNonJoueur {
	
	private static String[] sprites = {"src/Sprite/Troll/haut.png","src/Sprite/Troll/droite.png","src/Sprite/Troll/bas.png","src/Sprite/Troll/gauche.png"};
	
	private static String[] spritesAttaque = {"src/Sprite/Troll/haut_attaque.png","src/Sprite/Troll/droite_attaque.png","src/Sprite/Troll/bas_attaque.png","src/Sprite/Troll/gauche_attaque.png"};
	
	/**
	 * constructeur Troll
	 * @param jeu
	 * @param x
	 * 			  coordonnee x
	 * @param y
	 * 			  coordonnee y
	 */
	public Troll(ZeldiabloJeu jeu, int x, int y) {
		super(jeu, 3, false, true, 0.3, sprites, spritesAttaque ,x, y);
	}
	
	@Override
	public void evolutionAutomatique() {
		super.evolutionAutomatique();
		gagnerVie();
	}
	
	public void gagnerVie() {
		if(this.pdv < 10) {
			this.pdv += 0.1;
		}
	}
}
