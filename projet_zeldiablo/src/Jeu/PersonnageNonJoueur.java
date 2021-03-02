package Jeu;

import java.util.ArrayList;

public abstract class PersonnageNonJoueur extends Personnage{

	private String nomPNJ;
	
	public PersonnageNonJoueur(ZeldiabloJeu jeu, double pointsDeVies, boolean invincible, boolean solide, double d, String[] sprite, String[] spriteAtt, int x, int y) {
		super(jeu, pointsDeVies, invincible, solide, d, sprite, spriteAtt, x, y);
	}
	
	/*
	 * Fait evoluer automatiquement le monstre, si la méthode n'est
	 * pas redefinie dans la classe du monstre alors le déplacement
	 * est aléatoire (si un déplacement est possible)
	 * Le monstre attaque dès qu'il le peut
	 */
	public void evolutionAutomatique() {
		if(estACoteDuJoueur()) {
			orienterVersJoueur();
			attaquer();
		}
		else {
			deplacementAleatoire();
		}		
	}
	
	/**
	 * Indique si le monstre est à cote du joueur
	 * @return vrai si le monstre est à cote du joueur 
	 */
	public boolean estACoteDuJoueur() {
		
		int xJ = this.jeu.getHeros().getXPerso();
		int yJ = this.jeu.getHeros().getYPerso();
		
		int x = this.getXPerso();
		int y = this.getYPerso();
		
		return Math.abs(xJ-x)+Math.abs(yJ-y) == 1;

	}
	
	/**
	 * Oriente le monstre vers le joueur, à utiliser quand le monstre est à côté du joueur
	 */
	public void orienterVersJoueur() {
		
		int xJ = this.jeu.getHeros().getXPerso();
		int yJ = this.jeu.getHeros().getYPerso();
		
		int x = this.getXPerso();
		int y = this.getYPerso();
		
		if(xJ-x > 0) {
			//s'orienter a droite
			this.direction = 2;
		}
		if(xJ-x < 0) {
			//s'orienter a gauche
			this.direction = 4;
		}
		if(yJ-y > 0) {
			//s'orienter en bas
			this.direction = 3;
		}
		if(yJ-y < 0) {
			//s'orienter a haut
			this.direction = 1;
		}
		
	}
	
	@Override
	/**
	 * Permet d'attaquer le joueur s'il est en face du monstre (dépend de sa direction)
	 */
	public void attaquer() {
		//on recupere la position du heros
		int xH = jeu.getHeros().getXPerso();
		int yH = jeu.getHeros().getYPerso();
		
		Heros heros = jeu.getHeros();
		
		//position de this
		int xThis = this.getXPerso();
		int yThis = this.getYPerso();
			
			switch (direction) {
			case 1:
				if (xH == xThis && yH+1  == yThis) {
					heros.subirAttaque(this.attaque);
				}
				break;
			case 2:
				if (xH-1 == xThis && yH == yThis) {
					heros.subirAttaque(this.attaque);
				}
				break;
			case 3:
				if (xH == xThis && yH-1 == yThis) {
					heros.subirAttaque(this.attaque);
				}
				break;
			case 4:
				if (xH+1 == xThis && yH == yThis) {
					heros.subirAttaque(this.attaque);
				}
				break;
			}

			this.aAttaqueACeTour = true;
		}
	
	public void deplacementAleatoire() {
		//nbre aléatoire entre 1 et 4
		int nbAleatoire = (int) Math.round(Math.random()*3)+1;
		
		int i = 0;
		while(i<=3) {
			if(!testCollision(nbAleatoire)) {
				bougerVers(nbAleatoire);
				break;
			}
			else {
				nbAleatoire++;
				if(nbAleatoire == 5) {
					nbAleatoire = 1;
				}
				i++;
			}
		}	
	}
	
	/**
	 * Permet de placer un nouveau monstre sur un emplacement aléatoire libre de l'arène
	 * @param monstre
	 */
	public void chargerMonstre(int etageDansTour) {
		boolean estValide = false;
		int xRand = 0;
		int yRand = 0;
		
		while(!estValide) {
			xRand = (int) Math.round((Math.random()*(Tour.LONGUEUR-3)+1));
			yRand = (int) Math.round((Math.random()*(Tour.HAUTEUR-3)+1));
			//test mur
			estValide = this.estLibreCase(xRand, yRand, jeu.getTour().getEtageActuel());
		}
		this.xPerso = xRand;
		this.yPerso = yRand;
		this.jeu.getTour().getListeMonstreNiveaux().get(etageDansTour-1).add(this);	
	}
	
	
}
