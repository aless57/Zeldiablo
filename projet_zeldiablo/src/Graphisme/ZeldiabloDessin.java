package Graphisme;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Jeu.Case;
import Jeu.CaseMur;
import Jeu.CasePiege;
import Jeu.CaseSol;
import Jeu.Fantome;
import Jeu.Gobelin;
import Jeu.Heros;
import Jeu.Personnage;
import Jeu.ZeldiabloJeu;
import moteurJeu.*;

public class ZeldiabloDessin implements DessinJeu{

	private ZeldiabloJeu jeu;
	
	public static final int HAUTEUR_MENU = 45;
	public static final int LARGEUR_BARRE_VIE = 167;
	public static final int DEBUT_BARRE_VIE_GAUCHE = 241;
	public static final int DEBUT_BARRE_VIE_HAUT = 460;
	
	public ZeldiabloDessin(ZeldiabloJeu j) {
		this.jeu = j;
	}

	@Override
	public void dessiner(BufferedImage image) {
		Graphics g = image.getGraphics();
		int w = image.getWidth();
		int h = image.getHeight();
		
		//dessins simplifiés avec des formes colorés
		Case[][] cases = jeu.getArene().getCases();
		for(int i=0; i< w/32; i++) {
			for(int j=0; j< (h-this.HAUTEUR_MENU)/32; j++) {
				BufferedImage img;
				if(cases[i][j] instanceof Case) {
					try {
						img = ImageIO.read(new File(cases[i][j].getSprite()));
						g.drawImage(img, i*32, j*32, null);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		Heros pj = jeu.getHeros();
		dessinerDirection(pj, g);
		
		for(int i=0; i<jeu.getListePerso().size(); i++) {
			dessinerDirection(jeu.getListePerso().get(i), g);
		}
		
		//dessin barre de vie
		try {
			BufferedImage img = ImageIO.read(new File("src/Sprite/Environnement/barrevie.png"));
			g.drawImage(img, 0, 32*jeu.getTour().HAUTEUR, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//remplissage barre de vie
		remplirBarreVie(g);
		
	}

	public void dessinerDirection(Personnage perso, Graphics g) {
					
		String sprite = perso.getSprite(perso.getDirection());
		BufferedImage img;
		try {
			img = ImageIO.read(new File(sprite));
			g.drawImage(img, perso.getXPerso()*32, perso.getYPerso()*32, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (perso.isaAttaqueACeTour()) {
			sprite = perso.getSpriteAttaque(perso.getDirection());
			
			try {
				img = ImageIO.read(new File(sprite));
				g.drawImage(img, perso.getXPerso()*32, perso.getYPerso()*32, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	public void remplirBarreVie(Graphics g) {
		double pv = jeu.getHeros().getPdv();
		int longueurPv = (int) Math.round((this.LARGEUR_BARRE_VIE/(10/pv)));
		
		g.setColor(Color.RED);
		g.fillRect(this.DEBUT_BARRE_VIE_GAUCHE, this.DEBUT_BARRE_VIE_HAUT, longueurPv, 25);
		
		
	}
	
	
	
}
