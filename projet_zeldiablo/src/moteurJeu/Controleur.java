package moteurJeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * classe qui represente un controleur en lien avec un KeyListener
 * 
 * @author vthomas
 * 
 */
public class Controleur implements KeyListener {

	/**
	 * commande en cours
	 */
	private Commande commandeEnCours;
	/**
	 * commande a retourner la difference avec la commandeencours vient du fait
	 * qu'on veut memoriser une touche appuyee
	 */
	private  Commande commandeARetourner;

	/**
	 * construction du controleur par defaut le controleur n'a pas de commande
	 */
	public Controleur() {
		this.commandeEnCours = new Commande();
		this.commandeARetourner = new Commande();
	}

	/**
	 * quand on demande les commandes, le controleur retourne la commande en
	 * cours
	 * 
	 * @return commande faite par le joueur
	 */
	public Commande getCommande() {
		Commande aRetourner = this.commandeARetourner;
		this.commandeARetourner = new Commande(this.commandeEnCours);
		return (aRetourner);
	}

	@Override
	/**
	 * met a jour les commandes en fonctions des touches appuyees
	 */
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		// si on appuie sur 'q',commande joueur est gauche
		case 81:
			this.commandeEnCours.gauche = true;
			this.commandeARetourner.gauche = true;
			break;
		// si on appuie sur 'd',commande joueur est droite
		case 68:
			this.commandeEnCours.droite = true;
			this.commandeARetourner.droite = true;
			break;
		// si on appuie sur 'z',commande joueur est haut
		case 90:
			this.commandeEnCours.haut = true;
			this.commandeARetourner.haut = true;
			break;
		// si on appuie sur 's',commande joueur est bas
		case 83:
			this.commandeEnCours.bas = true;
			this.commandeARetourner.bas = true;
			break;
		// si on appuie sur fleche du bas, direction joueur est bas
		case 40:
			this.commandeEnCours.f_bas = true;
			this.commandeARetourner.f_bas = true;
			break;
		// si on appuie sur fleche du haut, direction joueur est haut
		case 38:
			this.commandeEnCours.f_haut = true;
			this.commandeARetourner.f_haut = true;
			break;
		// si on appuie sur fleche de droite, direction joueur est droite
		case 37:
			this.commandeEnCours.f_gauche = true;
			this.commandeARetourner.f_gauche = true;
			break;
		// si on appuie sur fleche de gauche, direction joueur est gauche
		case 39: 
			this.commandeEnCours.f_droite = true;
			this.commandeARetourner.f_droite = true;
			break;
		// si on appuie sur 'a', le joueur attaque
		case 32:
			this.commandeEnCours.attaque = true;
			this.commandeARetourner.attaque = true;
			break;
		}

	}

	@Override
	/**
	 * met a jour les commandes quand le joueur relache une touche
	 */
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 81:
			this.commandeEnCours.gauche = false;
			break;
		case 68:
			this.commandeEnCours.droite = false;
			break;
		case 90:
			this.commandeEnCours.haut = false;
			break;
		case 83:
			this.commandeEnCours.bas = false;
			break;
		case 40:
			this.commandeEnCours.f_bas = false;
			break;
		case 38:
			this.commandeEnCours.f_haut = false;
			break;
		case 37:
			this.commandeEnCours.f_gauche = false;
			break;
		case 39: 
			this.commandeEnCours.f_droite = false;
		case 32:
			this.commandeEnCours.attaque = false;
		}

	}

	@Override
	/**
	 * ne fait rien
	 */
	public void keyTyped(KeyEvent e) {

	}

}
