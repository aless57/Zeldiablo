package Jeu;

import java.util.ArrayList;

public class LabyrintheJeu {

	/** tableau de cases formant le labyrinthe **/
	private Case[][] cases;
	
	public int getLongeur() {
		return Jeu.Tour.LONGUEUR;
	}
	
	public int getHauteur() {
		return Jeu.Tour.HAUTEUR;
	}
	
	public Case[][] getCases(){
		return cases;
	}
	
	public Case getCasesXY(int x, int y) {
		return cases[x][y];
	}

	public void setCasePiege(int x, int y) {
		cases[x][y] = new CasePiege();
	}
	
	/* Tableau repr�sentant les diff�rentes cases du plateau
		premi�re dimension = listes des colonnes*/
	
	public LabyrintheJeu(Case[][] lab) {
		cases = lab;
	}
}
