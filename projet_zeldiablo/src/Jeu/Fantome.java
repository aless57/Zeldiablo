package Jeu;

public class Fantome extends PersonnageNonJoueur {
	
	private static String[] sprites = {"src/Sprite/Fantome/haut.png","src/Sprite/Fantome/droite.png","src/Sprite/Fantome/bas.png","src/Sprite/Fantome/gauche.png"};

	private static String[] spritesAttaque = {"src/Sprite/Fantome/haut_attaque.png","src/Sprite/Fantome/droite_attaque.png","src/Sprite/Fantome/bas_attaque.png","src/Sprite/Fantome/gauche_attaque.png"};
	
	/**
	 * constructeur Fantome
	 * @param j
	 * @param x
	 * 			  coordonnee x
	 * @param y
	 * 			  coordonnee y
	 */
	public Fantome(ZeldiabloJeu j, int x, int y) {
		super(j, 10, false, false, 0.2, sprites, spritesAttaque, x, y);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Permet au personnage de se déplacer d'une case
	 * @param direction - 1=NORD; 2=EST; 3=SUD; 4=OUEST
	 */
	@Override
	public void bougerVers(int direction) {
		
		switch (direction) {
		case 1 :
			this.direction = 1;
			if (this.getYPerso() > 1) {
				super.bougerVers(direction);
			}
		break;
		case 2 :
			this.direction = 2;
			if (this.getXPerso() < Jeu.Tour.LONGUEUR - 2) {
				super.bougerVers(direction);
			}
		break;
		case 3 :
			this.direction = 3;
			if (this.getYPerso() < Jeu.Tour.HAUTEUR - 2) {
				super.bougerVers(direction);
			}
		break;
		case 4 :
			this.direction = 4;
			if (this.getXPerso() > 1) {
				super.bougerVers(direction);
			}
		break;
		}

	}

	
}
