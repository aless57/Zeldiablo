package Jeu;

import moteurJeu.Commande;

public class Heros extends Personnage {
	
	private Armes armeEnMain;
	
	private static String[] sprites = {"src/Sprite/Heros/haut.png","src/Sprite/Heros/droite.png","src/Sprite/Heros/bas.png","src/Sprite/Heros/gauche.png"};
	
	private static String[] spritesAttaque = {"src/Sprite/Heros/haut_attaque.png","src/Sprite/Heros/droite_attaque.png","src/Sprite/Heros/bas_attaque.png","src/Sprite/Heros/gauche_attaque.png"};
	
	private static String[] spritesVictoire = {"src/Sprite/Heros/gagne.png","src/Sprite/Heros/gagne.png"};

	/**
	 * constructeur du heros
	 * @param jeu
	 */
	public Heros(ZeldiabloJeu jeu) {
		super(jeu, 10, false, true, 2, sprites, spritesAttaque, 1, 1);
		armeEnMain = new Poing();
	}
	
	@Override
	public void attaquer() {
		int xH = jeu.getHeros().getXPerso();
		int yH = jeu.getHeros().getYPerso();
		
		for (int i = 0; i < jeu.getListePerso().size(); i++) {
			
			PersonnageNonJoueur m = jeu.getListePerso().get(i);
			int xM = m.getXPerso();
			int yM = m.getYPerso();
			
			switch (direction) {
			case 1:
				if (xH == xM && yH-1  == yM) {
					m.subirAttaque(this.attaque*armeEnMain.getCoeffArme());
				}
				break;
			case 2:
				if (xH == xM-1 && yH == yM) {
					m.subirAttaque(this.attaque*armeEnMain.getCoeffArme());
				}
				break;
			case 3:
				if (xH == xM && yH+1 == yM) {
					m.subirAttaque(this.attaque*armeEnMain.getCoeffArme());
				}
				break;
			case 4:
				if (xH == xM+1 && yH == yM) {
					m.subirAttaque(this.attaque*armeEnMain.getCoeffArme());
				}
				break;
			}
			
		}
		this.aAttaqueACeTour = true;
	}
	
	/**
	 * methode faisant evoluer le heros en fonction du parametre
	 * @param c 
	 * 			commande entree par l'utilisateur
	 */
	public void evoluerCommande(Commande c) {
		
		if (c.f_bas) {
			direction = 3;
		}
		
		if (c.f_haut) {
			direction = 1;
		}

		if (c.f_droite) {
			direction = 2;
		}

		if (c.f_gauche) {
			direction = 4;
		}
		
		if (c.attaque) {
			
			this.attaquer();
			
		} else {
			if (c.bas) {
				direction = 3;
				if (yPerso + 1 < Jeu.Tour.HAUTEUR && !this.testCollision(3)) {
					bougerVers(3);
				}
			}
			
			if (c.haut) {
				direction = 1;
				if (yPerso - 1 >= 0 && !this.testCollision(1)) {
					bougerVers(1);
				}
			}
			
			if (c.droite) {
				direction = 2;
				if (xPerso + 1 < Jeu.Tour.LONGUEUR && !this.testCollision(2)) {
					bougerVers(2);
				}
			}
			
			if (c.gauche) {
				direction = 4;
				if (xPerso - 1 >= 0 && !this.testCollision(4)) {
					bougerVers(getDirection());
				}
			}
		}
		
		
	}
	
	public void changerArme(Armes nvArme) {
		this.armeEnMain = nvArme;
	}
	
	/**
	 * Declenche l'action de la case sur laquelle est le personnage
	 */
	public void declenchementActionCase() {
		jeu.getArene().getCases()[this.getXPerso()][this.getYPerso()].declencherAction(this);
	}
	
	@Override
	public double getAttaque() {
		return attaque*armeEnMain.getCoeffArme();
	}
	
	public String getSpriteVictoire(int val) {
		return spritesVictoire[val];
	}
	
	public void gainPv(int val) {
		if (pdv + val > 10) {
			pdv = 10;
		} else {
			pdv += val;
		}
	}
	
}
