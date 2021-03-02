package Jeu;

import java.util.ArrayList;

import moteurJeu.Commande;
import moteurJeu.Jeu;

public abstract class Personnage {
	
	/** point de vie du personnage **/
	protected double pdv;
	
	/** true quand personnage invincible **/
	private boolean invincible;
	
	/** true quand le personnage ne peut pas traverser les murs **/
	private boolean solide;
	
	/** points d'attaque **/
	protected double attaque;
	
	/** sprite mouvements **/
	private String[] sprite;
	
	/** sprite attaque **/
	private String[] spriteAttaque;
	
	/** coordonnee x du personnage **/
	protected int xPerso;
	
	/** coordonnee y du personnage **/
	protected int yPerso;
	
	/** direction - 1=NORD; 2=EST; 3=SUD; 4=OUEST **/
	protected int direction;
	
	protected ZeldiabloJeu jeu;
	
	protected boolean aAttaqueACeTour;
	
	public int getXPerso() {
		return xPerso;
	}

	public void setXPerso(int xPerso) {
		this.xPerso = xPerso;
	}

	public int getYPerso() {
		return yPerso;
	}

	public void setYPerso(int yPerso) {
		this.yPerso = yPerso;
	}

	/**
	 * constructeur du personnage 
	 * @param j
	 * 			jeu Zeldiablo
	 * @param ptV
	 * 			point de vie
	 * @param i
	 * 			true si invincible
	 * @param c
	 * 			true si ne peut pas traverser les murs
	 * @param a
	 * 			points d'attaque
	 * @param s
	 * 			sprite
	 * @param x
	 * 			coordonnee x 
	 * @param y
	 * 			coordonnee y
	 */
	public Personnage(ZeldiabloJeu jeu, double pointsDeVies, boolean invincible, boolean solide, double d, String[] sprite, String[] spriteA, int x, int y) {
		this.jeu = jeu;
		this.pdv = pointsDeVies;
		this.invincible = invincible;
		this.solide = solide;
		this.attaque = d;
		this.sprite = sprite;
		this.spriteAttaque = spriteA;
		this.xPerso = x;
		this.yPerso = y;
		
		this.direction = 1;
		this.aAttaqueACeTour = false;
	}
	
	/**
	 * Indique si un personnage peut se déplacer dans une case
	 * @param direction - 1=NORD; 2=EST; 3=SUD; 4=OUEST
	 * @return False si le personnage peut se déplacer
	 */
	public boolean testCollision(int direction) {
		//boolean collisionDetecte = false;
		int x = xPerso;
		int y = yPerso;
		
		switch (direction) {
		case 1 :
			y--;
			break;
		case 2 :
			x++;
			break;
		case 3 :
			y++;
			break;
		case 4 :
			x--;
			break;
		}
		
		return !estLibreCase(x, y, jeu.getTour().getEtageActuel());

	}
	
	/**
	 * Permet de savoir si une case est occupée sur le labyrinthe en paramètre
	 * @param x
	 * @param y
	 * @param tour
	 * @param etageDeLaTour - étage auquel on veut ajouter un monstre 
	 * @return
	 */
	public boolean estLibreCase(int x, int y, int etageDeLaTour) {
		boolean caseOccupee = false;
		
		ArrayList<PersonnageNonJoueur> listeMonstre = jeu.getTour().getListeMonstreNiveaux().get(etageDeLaTour-1);
		LabyrintheJeu laby = jeu.getTour().getListeLabyrinthe().get(etageDeLaTour-1);
				
		//on teste les collisions avec les monstres
		for(int i=0; i< listeMonstre.size() && !caseOccupee; i++) {
			//il y a collision si le perso n'est pas celui-ci
			//et est au même endroit
			caseOccupee = !listeMonstre.get(i).equals(this)
					&& listeMonstre.get(i).xPerso == x
					&& listeMonstre.get(i).yPerso == y;
	
		}
				
		//puis avec le joueur
		if(!caseOccupee && etageDeLaTour == jeu.getTour().getEtageActuel() 
				&& !(this instanceof Heros)) {
			
			caseOccupee = jeu.getHeros().getXPerso() == x
					&& jeu.getHeros().getYPerso() == y;
		}
				
		//et enfin avec les murs et autres cases solides
		if(!caseOccupee && this.solide && !caseOccupee) {
			caseOccupee = laby.getCases()[x][y].getSolidite() >= 1;				
				}
				
		return !caseOccupee;
	}
	
	
	
	/**
	 * Permet au personnage de se déplacer d'une case
	 * @param direction - 1=NORD; 2=EST; 3=SUD; 4=OUEST
	 */
	public void bougerVers(int direction) {
		switch (direction) {
		case 1 :
			this.direction = 1;
			yPerso--;
		break;
		case 2 :
			this.direction = 2;
			xPerso++;
		break;
		case 3 :
			this.direction = 3;
			yPerso++;
		break;
		case 4 :
			this.direction = 4;
			xPerso--;
		break;
		}
		
	}
	
	/*
	 * Le personnage attaque devant lui et inflige à toute entité les dégats de son attribut attaque.
	 * Peut être Override pour changer le comportement d'attaque
	 */
	abstract public void attaquer();
	
	public boolean isaAttaqueACeTour() {
		return aAttaqueACeTour;
	}

	public void setaAttaqueACeTour(boolean aAttaqueACeTour) {
		this.aAttaqueACeTour = aAttaqueACeTour;
	}

	/**
	 * methode verifie si personnage est mort
	 * @return true quand pdv = 0
	 */
	public boolean etreMort() {
		return pdv == 0;
	}
	
	public void subirAttaque(double degat) {
		this.pdv -= degat;
		if(this.pdv<0) {
			this.pdv = 0;
		}
	}
	
	
	
	
	public double getPdv() {
		return pdv;
	}

	public boolean isInvincible() {
		return invincible;
	}

	public boolean isSolide() {
		return solide;
	}

	public double getAttaque() {
		return attaque;
	}

	public String getSprite(int direction) {
		return sprite[direction-1];
	}
	
	public String getSpriteAttaque(int direction) {
		return spriteAttaque[direction-1];
	}
	
	public void setPDV(double p) {
		this.pdv=p;
	}

	public int getDirection() {
		return direction;
	}
	

}







