package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Jeu.CaseMur;
import Jeu.Gobelin;
import Jeu.LabyrintheJeu;
import Jeu.ZeldiabloJeu;
import moteurJeu.Commande;

public class TestHeros {
	
	ZeldiabloJeu z1, z2, z3, z4, z5, z6, z8, z9, z10;
	Commande c1, c2, c3, c4, c6, c8, c9, c10;
	
	@Before
	public void creationDeDonnees() {
		//** Test 01 **/
		z1 = new ZeldiabloJeu();
		c1 = new Commande();
		z1.getHeros().setXPerso(3);
		z1.getHeros().setYPerso(7);
		
		/** Test 02 **/
		z2 = new ZeldiabloJeu();
		c2 = new Commande();
		
		/** Test 03 **/
		z3 = new ZeldiabloJeu();		
		c3 = new Commande();
		
		/** Test 04 **/
		z4 = new ZeldiabloJeu();
		z4.getHeros().setXPerso(3);
		z4.getHeros().setYPerso(7);
		z4.setPersoNonJoueur(0, new Gobelin(z4, 4, 7));
		z4.setPersoNonJoueur(1, new Gobelin(z4, 3, 8));
		
		/** Test 05 **/
		z5 = new ZeldiabloJeu();
		z5.getHeros().setXPerso(9);
		z5.getHeros().setYPerso(9);
		
		/** Test 06 et 07 **/
		z6 = new ZeldiabloJeu();
		z6.getHeros().setPDV(10);
		z6.getHeros().setXPerso(4);
		z6.getHeros().setYPerso(1);
		c6 = new Commande();
		
		/** Test 08 **/
		z8 = new ZeldiabloJeu();
		z8.getHeros().setXPerso(10);
		z8.getHeros().setYPerso(10);
		c8 = new Commande();
		
		/** Test 09 **/
		z9 = new ZeldiabloJeu();
		z9.getHeros().setXPerso(10);
		z9.getHeros().setYPerso(10);
		c9 = new Commande();
		
		/** Test 10 **/
		z10 = new ZeldiabloJeu();
		z10.getHeros().setXPerso(10);
		z10.getHeros().setYPerso(10);
		c10 = new Commande();
	
	}
	
	@Test
	public void test01_deplacementPerso() {
		c1.droite = true;
		z1.evoluer(c1);
		assertEquals("le perso ne se deplace pas vers la droite", 4, z1.getHeros().getXPerso());
		c1.droite = false;
		c1.gauche = true;
		z1.evoluer(c1);
		assertEquals("le perso ne se deplace pas vers la gauche", 3, z1.getHeros().getXPerso());
		c1.gauche = false;
		c1.haut = true;
		z1.evoluer(c1);
		assertEquals("le perso ne se deplace pas vers le haut", 6, z1.getHeros().getYPerso());
		c1.haut = false;
		c1.bas = true;
		z1.evoluer(c1);
		assertEquals("le perso ne se deplace pas vers le bas", 7, z1.getHeros().getYPerso());
	}
	
	@Test 
	public void test02_collisionMur() {
		z2.getHeros().setXPerso(1);
		c2.haut = true;
		z2.evoluer(c2);		
		assertEquals("le perso est sorti de l'arene par le haut", 1, z2.getHeros().getXPerso());
		z2.getHeros().setYPerso(Jeu.Tour.HAUTEUR-1);
		c2.haut = false;
		c2.bas = true;
		z2.evoluer(c2);
		assertEquals("le perso est sorti de l'arene par le bas", Jeu.Tour.HAUTEUR-1, z2.getHeros().getYPerso());
		z2.getHeros().setXPerso(Jeu.Tour.LONGUEUR-2);
		c2.bas = false;
		c2.gauche = true;
		z2.evoluer(c2);
		assertEquals("le perso est sorti de l'arene pas la gauche", Jeu.Tour.LONGUEUR-2, z2.getHeros().getXPerso());
		z2.getHeros().setYPerso(Jeu.Tour.LONGUEUR-2);
		c2.gauche = false;
		c2.droite = true;
		z2.evoluer(c2);
		assertEquals("le perso est sorti de l'arene par la droite", Jeu.Tour.LONGUEUR-2, z2.getHeros().getYPerso());
	}
	
	@Test 
	public void test03_changementDirection() {
		c3.f_droite = true;
		z3.evoluer(c3);
		assertEquals("le perso n'est pas dirige vers la droite", 2, z3.getHeros().getDirection());
		c3.f_droite = false;
		c3.f_bas = true;
		z3.evoluer(c3);
		assertEquals("le perso n'est pas dirige vers le bas", 3, z3.getHeros().getDirection());
		c3.f_bas = false;
		c3.f_gauche = true;
		z3.evoluer(c3);
		assertEquals("le perso n'est pas dirige vers la gauche", 4, z3.getHeros().getDirection());
		c3.f_gauche = false;
		c3.f_haut = true;
		z3.evoluer(c3);
		assertEquals("le perso n'est pas dirige vers le haut", 1, z3.getHeros().getDirection());
	}
	
	@Test 
	public void test04_testerCollision() {
		assertEquals("la collision devrait etre detectee", true, z4.getHeros().testCollision(2));
		assertEquals("il ne doit pas y avoir de collision", false, z4.getHeros().testCollision(4));
		assertEquals("la collision devrait etre detectee", true, z4.getHeros().testCollision(3));
		assertEquals("la collision devrait etre detectee", false, z4.getHeros().testCollision(1));
	}
	
	@Test
	public void test05_bougerVers() {
		z5.getHeros().bougerVers(2);
		assertEquals("le personnage ne s'est pas dirige vers la droite", 10, z5.getHeros().getXPerso());
		z5.getHeros().bougerVers(3);
		assertEquals("le personnage ne s'est pas dirige vers la droite", 10, z5.getHeros().getYPerso());
		z5.getHeros().bougerVers(4);
		assertEquals("le personnage ne s'est pas dirige vers la droite", 9, z5.getHeros().getXPerso());
		z5.getHeros().bougerVers(1);
		assertEquals("le personnage ne s'est pas dirige vers la droite", 9, z5.getHeros().getYPerso());
	}
	
	@Test
	public void test06_PDVEnMoins() {
		c6.gauche=true;
		z6.getHeros().evoluerCommande(c6);
		assertEquals("Le joueur doit perdre 1 point de vie",9,(int)z6.getHeros().getPdv());
	}
	
	@Test
	public void test07_PDVInchanges() {
		c6.gauche = false;
		c6.droite=true;
		z6.getHeros().evoluerCommande(c6);
		assertEquals("Le joueur ne doit pas perdre de points de vie",10,(int)z6.getHeros().getPdv());
	}
	
	@Test 
	public void test08_testAttaque() {
		c8.f_droite = true;
		z8.evoluer(c8);
		c8.f_droite = false;
		z8.setPersoNonJoueur(0, new Gobelin(z8,11,10));
		double pdvDebut = z8.getListePerso().get(0).getPdv();
		c8.attaque = true;
		z8.evoluer(c8);
		assertEquals("le monstre doit subir des degats", (int)(pdvDebut-1), (int)(z8.getListePerso().get(0).getPdv()));
	}
	
	@Test
	public void test09_testAttaqueAucunMonstre() {
		z9.setPersoNonJoueur(0, new Gobelin(z9,1,1));
		double pdvDebut = z9.getListePerso().get(0).getPdv();
		c9.attaque = true;
		z9.evoluer(c9);
		c9.attaque = false;
		assertEquals("le monstre ne doit pas subir de degats", (int)pdvDebut, (int)z9.getListePerso().get(0).getPdv());
	}
	
	@Test
	public void test10_testAttaquePlusieursMonstreAutour() {
		c10.f_droite = true;
		z10.evoluer(c10);
		c10.f_droite = false;
		z10.setPersoNonJoueur(0, new Gobelin(z10,11,10));
		z10.setPersoNonJoueur(1, new Gobelin(z10,10,11));
		double pdvDebutP1 = z10.getListePerso().get(0).getPdv();
		double pdvDebutP2 = z10.getListePerso().get(1).getPdv();
		c10.attaque = true;
		z10.evoluer(c10);
		assertEquals("le monstre n'a pas subi de degats", (int)pdvDebutP1-1, (int)z10.getListePerso().get(0).getPdv());
		assertEquals("le monstre a subi des degats", (int)pdvDebutP2, (int)z10.getListePerso().get(1).getPdv());
	}

}
