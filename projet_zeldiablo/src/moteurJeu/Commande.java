package moteurJeu;

/**
 * permet de representer une commande de l'utilisateur
 * 
 * @author vthomas
 *
 */
public class Commande {

	/**
	 * boolean representant la commande de l'utilisateur
	 */
	public boolean gauche;
	public boolean droite;
	public boolean haut;
	public boolean bas;
	
	/**
	 * changement de direction du presonnage avec les fleches directionnelles
	 */
	public boolean f_gauche;
	public boolean f_droite;
	public boolean f_haut;
	public boolean f_bas;
	
	/**
	 * touche pour attaquer
	 */
	public boolean attaque;
	

	public Commande()
	{
		
	}
	
	/**
	 * constructeur par copie
	 * copie la commande pour en creer une nouvelle
	 * @param commandeACopier
	 */
	public Commande(Commande commandeACopier)
	{
		this.bas=commandeACopier.bas;
		this.haut=commandeACopier.haut;
		this.gauche=commandeACopier.gauche;
		this.droite=commandeACopier.droite;	
		this.f_bas=commandeACopier.f_bas;
		this.f_haut=commandeACopier.f_haut;
		this.f_droite=commandeACopier.f_droite;
		this.f_gauche=commandeACopier.f_gauche;
		this.attaque=commandeACopier.attaque;
	}
	
}
