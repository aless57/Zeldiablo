package projet_zeldiablo;

import java.util.Scanner;

import Graphisme.ZeldiabloDessin;
import Jeu.ZeldiabloJeu;
import moteurJeu.MoteurGraphique;

public class Launcher {

	public static void main(String[] args) throws InterruptedException {
		
		// creation du jeu particulier et de son afficheur
		ZeldiabloJeu jeu = new ZeldiabloJeu();
		ZeldiabloDessin aff = new ZeldiabloDessin(jeu);
		
		// classe qui lance le moteur de jeu generique
		MoteurGraphique moteur = new MoteurGraphique(jeu, aff);
		// lance la boucle de jeu qui tourne jusque la fin du jeu
		moteur.lancerJeu(32*jeu.getArene().getHauteur(), 32*jeu.getArene().getLongeur()+ZeldiabloDessin.HAUTEUR_MENU);
		
		//Le jeu s'arrète
		if(jeu.etreFini() && jeu.getHeros().etreMort()) {
			System.out.print("defaite");
			new EcranDefaite();
		}
		else {
			System.out.print("victoire");
			new EcranVictoire();
		}
		
	}

}
