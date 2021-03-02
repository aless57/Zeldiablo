package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Jeu.Gobelin;
import Jeu.PersonnageNonJoueur;
import Jeu.ZeldiabloJeu;
import moteurJeu.Commande;

public class TestPersonnageNonJoueur {

	ZeldiabloJeu z, z2, z3, z4;
	Commande c, c2, c4;
	
	@Before
	public void creationDeDonnees() {
		
		/** Test 01 et 02 **/
		z = new ZeldiabloJeu();
		z.getHeros().setPDV(10);
		c = new Commande();
		
		/** Test 02 **/
		z2 = new ZeldiabloJeu();
		z2.getHeros().setPDV(10);
		c2 = new Commande();
		z2.getHeros().setXPerso(15);
		z2.getHeros().setYPerso(15);
		z2.setPersoNonJoueur(0, new Gobelin(z,6,6));
		
		/** Test 03 **/
		z3 = new ZeldiabloJeu();
		z3.getHeros().setXPerso(10);
		z3.getHeros().setYPerso(10);
		z3.setPersoNonJoueur(0, new Gobelin(z3, 11,10));
		z3.setPersoNonJoueur(1, new Gobelin(z3, 1,1));
		
		/** Test 04 **/
		z4 = new ZeldiabloJeu();
		c4 = new Commande();
		z4.getListePerso().add(0,new Gobelin(z4,1,2));
		z4.getListePerso().get(0).setPDV(000.1);
		c4.f_bas = true;
		z4.evoluer(c4);
		c4.attaque = true;
		z4.evoluer(c4);
	}
	
	@Test
	public void test01_AttaqueDuMonstre() {
		double pdvDebutH = z.getHeros().getPdv();
		z.setPersoNonJoueur(0, new Gobelin(z, 1, 2));
		double attaqueM = z.getListePerso().get(0).getAttaque();
		z.evoluer(c);
		assertEquals("Le joueur doit se faire attaquer par le monstre",(int)(pdvDebutH-(attaqueM)),(int)z.getHeros().getPdv());
	}
	
	@Test
	public void test02_PasDAttaque() {
		assertEquals("Le joueur ne doit pas se faire attaquer par le monstre", 10,(int)z.getHeros().getPdv());
	}
	
	@Test
	public void test03_estACoteDuJoueur() {
		assertEquals("la methode doit retourner true", true, z3.getListePerso().get(0).estACoteDuJoueur());
		assertEquals("la methode doit retourner false", false, z3.getListePerso().get(1).estACoteDuJoueur());
	}
	
	@Test
	public void test04_monstreMort() {
		PersonnageNonJoueur g = z4.getListePerso().get(z4.getListePerso().size()-1);
		int sizeInit = z4.getListePerso().size();
		assertEquals("le monstre doit etre mort", true, g.etreMort());
		z4.evoluer(c4);
		assertEquals("le monstre ne doit plus être dans la liste", sizeInit-1, z4.getListePerso().size());
	}
}
