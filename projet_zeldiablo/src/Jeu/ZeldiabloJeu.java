package Jeu;

import java.util.ArrayList;

import moteurJeu.Commande;
import moteurJeu.Jeu;
import projet_zeldiablo.EcranDefaite;

public class ZeldiabloJeu implements Jeu{

	/** boolean true quand perdu **/
	private boolean perdu;
	
	/** true quand fini **/
	private boolean fini;
	
	private Heros heros;
	
	private Tour tour;
	
	private LabyrintheJeu arene;
	
	private ArrayList<PersonnageNonJoueur> listePerso;
	
	/**
	 * constructeur du jeu
	 */
	public ZeldiabloJeu() {
		tour = new Tour(this);
		heros = new Heros(this);
		tour.initTour();
		tour.initMonstre();
		arene = tour.getListeLabyrinthe().get(0);
		listePerso = tour.getListeMonstreNiveaux().get(0);
	}
	
	public ArrayList<PersonnageNonJoueur> getListePerso() {
		return listePerso;
	}

	/**
	 * methode faisant evoluer le jeu en fonction du param
	 * @param commandUser
	 * 					  commande entree par l'utilisateur
	 */
	@Override
	public void evoluer(Commande commandeUser) {
		
		if (heros.etreMort()) {
			this.setFini(true);
		}
		
		heros.setaAttaqueACeTour(false);
		heros.evoluerCommande(commandeUser);
		
		//déclenche l'action de la case du heros
		heros.declenchementActionCase();
		
		/** declenchement action de la case **/
		Case c = arene.getCasesXY(heros.getXPerso(), heros.getYPerso());
		c.declencherAction(heros);
		
		for (int i = 0; i < listePerso.size(); i++) {
			listePerso.get(i).setaAttaqueACeTour(false);
			if (listePerso.get(i).etreMort()) {
				listePerso.remove(i);
			}
		}
		
		for(int i=0; i<listePerso.size(); i++) {
			listePerso.get(i).evolutionAutomatique();
		}
	}

	public void setArene(LabyrintheJeu arene) {
		this.arene = arene;
	}

	public void setListePerso(ArrayList<PersonnageNonJoueur> listePerso) {
		this.listePerso = listePerso;
	}

	/**
	 * methode renvoie true quand la partie est finie
	 */
	@Override
	public boolean etreFini() {
		return fini;
	}
	
	public void setFini(boolean val) {
		fini = val;
	}
	
	public Tour getTour() {
		return tour;
	}

	public Heros getHeros() {
		return this.heros;
	}
	
	public LabyrintheJeu getArene() {
		return this.arene;
	}
	
	public void setPersoNonJoueur(int i, PersonnageNonJoueur o) {
		listePerso.add(i, o);
	}
}
