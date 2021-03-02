package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Jeu.CaseMur;
import Jeu.ZeldiabloJeu;

public class TestLabyrintheJeu {

	ZeldiabloJeu z;
	
	@Before
	public void creationDeDonnees() {
		//creation d'un jeu Zeldiablo
		z = new ZeldiabloJeu();
	}
	
	@Test
	public void test01_constructeur() {		
		/** verification creation des murs exterieurs **/
		boolean verif = false;
		for (int i = 0; i < z.getArene().getLongeur(); i++) {
			verif = z.getArene().getCasesXY(0, i) instanceof CaseMur;
		}
		for (int i = 0; i < z.getArene().getLongeur(); i++) {
			verif = z.getArene().getCasesXY(i, 0) instanceof CaseMur;
		}
		for (int i = 0; i < z.getArene().getLongeur(); i++) {
			verif = z.getArene().getCasesXY(i, z.getArene().getHauteur()-1) instanceof CaseMur;
		}
		for (int i = 0; i < z.getArene().getLongeur(); i++) {
			verif = z.getArene().getCasesXY(z.getArene().getLongeur()-1, i) instanceof CaseMur;
		}
		assertEquals("le labyrinthe n'est pas bien construit", true, verif);
	}
	
	@Test
	public void test02_emplacementJoueur() {
		assertEquals("Le joueur est mal place en x", 1, this.z.getHeros().getXPerso());
		assertEquals("Le joueur est mal place en y", 1, this.z.getHeros().getYPerso());
	}
}
