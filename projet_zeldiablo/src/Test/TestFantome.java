package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Jeu.Fantome;
import Jeu.Gobelin;
import Jeu.Tour;
import Jeu.ZeldiabloJeu;
import moteurJeu.Commande;

public class TestFantome {

	ZeldiabloJeu z, z2;
	Commande c;
	
	@Before
	public void creationDeDonnees() {
		/** Test 01 **/
		z = new ZeldiabloJeu();
		z.setPersoNonJoueur(0, new Fantome(z, 0, 0));
		z.setPersoNonJoueur(1, new Fantome(z, Jeu.Tour.LONGUEUR-1, 0));
		z.setPersoNonJoueur(2, new Fantome(z, 0, Jeu.Tour.HAUTEUR-1));
		z.setPersoNonJoueur(3, new Fantome(z, Jeu.Tour.LONGUEUR-1, Jeu.Tour.HAUTEUR-1));
		z.getHeros().setXPerso(9);
		z.getHeros().setYPerso(8);
		z.getListePerso().get(0).bougerVers(1);
		z.getListePerso().get(1).bougerVers(2);
		z.getListePerso().get(2).bougerVers(4);
		z.getListePerso().get(3).bougerVers(3);
		
		/** Test 02 **/
		z2 = new ZeldiabloJeu();
		Fantome f = new Fantome(z2,1,1);
		z2.setPersoNonJoueur(0,f);
		f.bougerVers(2);
	}
	
	@Test
	public void test01_bougerVersSortArene() {
		assertEquals("le fantome est sorti de l'arene", 0, z.getListePerso().get(0).getYPerso());
		assertEquals("le fantome est sorti de l'arene", Jeu.Tour.LONGUEUR-1, z.getListePerso().get(1).getXPerso());
		assertEquals("le fantome est sorti de l'arene", 0, z.getListePerso().get(2).getXPerso());
		assertEquals("le fantome est sorti de l'arene", Jeu.Tour.HAUTEUR-1, z.getListePerso().get(3).getYPerso());
	}
	
	@Test 
	public void test02_bougerVersTraverseMur() {
		assertEquals("le fantome ne traverse pas le mur", 2, z2.getListePerso().get(0).getXPerso());
	}

}
