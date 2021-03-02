package Jeu;

import java.util.ArrayList;
import java.util.ListResourceBundle;

public class Tour {
	
	/** longueur de l'arene **/
	public static final int LONGUEUR = 14;
	
	/** largeur de l'arene **/
	public static final int HAUTEUR = 14;
	
	/** niveau actuel **/
	private int etageActuel;
	
	/** liste des labyrinthes (un pour chaque niveaux) **/
	private ArrayList<LabyrintheJeu> listeLabyrinthe;
	
	/** liste des listes des monstres par niveaux **/
	private ArrayList<ArrayList<PersonnageNonJoueur>> listeMonstreNiveaux; 
	
	private ZeldiabloJeu jeu;
	
	public Tour(ZeldiabloJeu j) {
		etageActuel = 1;
		jeu = j;
		listeLabyrinthe = new ArrayList<LabyrintheJeu>();
		listeMonstreNiveaux = new ArrayList<ArrayList<PersonnageNonJoueur>>();
	}
	
	/**
	 * Initialiser les étages de la tour
	 */
	public void initTour() {
		niv1();
		niv2();
		niv3();
		niv4();
		niv5();
	}
	
	/**
	 * Initialise les monstres de la tour
	 */
	public void initMonstre() {
		
		for(int i=0; i<5; i++) {
			listeMonstreNiveaux.add(new ArrayList<PersonnageNonJoueur>());
		}
		
		//Niveau 1
		ArrayList<PersonnageNonJoueur> monstres = listeMonstreNiveaux.get(0);
		listeMonstreNiveaux.add(monstres);
		
		for(int i=0; i<3;i++) {
			monstres.add(new Gobelin(jeu, 0, 0));
			monstres.get(monstres.size()-1).chargerMonstre(1);
			monstres.add(new Fantome(jeu, 0, 0));
			monstres.get(monstres.size()-1).chargerMonstre(1);
			monstres.add(new Troll(jeu, 0, 0));
			monstres.get(monstres.size()-1).chargerMonstre(1);
		}
	
		//Niveau 2
				ArrayList<PersonnageNonJoueur> monstresEt2 = listeMonstreNiveaux.get(1);
				listeMonstreNiveaux.add(monstresEt2);
				
				for(int i=0; i<3;i++) {
					monstresEt2.add(new Gobelin(jeu, 0, 0));
					monstresEt2.get(monstresEt2.size()-1).chargerMonstre(2);
					monstresEt2.add(new Fantome(jeu, 0, 0));
					monstresEt2.get(monstresEt2.size()-1).chargerMonstre(2);
					monstresEt2.add(new Troll(jeu, 0, 0));
					monstresEt2.get(monstresEt2.size()-1).chargerMonstre(2);
				}
				listeMonstreNiveaux.add(monstresEt2);
			
			//Niveau 3
				ArrayList<PersonnageNonJoueur> monstresEt3 = listeMonstreNiveaux.get(2);
				listeMonstreNiveaux.add(monstresEt3);
				
				for(int i=0; i<3;i++) {
					monstresEt3.add(new Gobelin(jeu, 0, 0));
					monstresEt3.get(monstresEt3.size()-1).chargerMonstre(3);
					monstresEt3.add(new Fantome(jeu, 0, 0));
					monstresEt3.get(monstresEt3.size()-1).chargerMonstre(3);
					monstresEt3.add(new Troll(jeu, 0, 0));
					monstresEt3.get(monstresEt3.size()-1).chargerMonstre(3);
				}
				
				//Niveau 4
				ArrayList<PersonnageNonJoueur> monstresEt4 = listeMonstreNiveaux.get(3);
				listeMonstreNiveaux.add(monstresEt4);
				
				for(int i=0; i<3;i++) {
					monstresEt4.add(new Gobelin(jeu, 0, 0));
					monstresEt4.get(monstresEt4.size()-1).chargerMonstre(4);
					monstresEt4.add(new Fantome(jeu, 0, 0));
					monstresEt4.get(monstresEt4.size()-1).chargerMonstre(4);
					monstresEt4.add(new Troll(jeu, 0, 0));
					monstresEt4.get(monstresEt4.size()-1).chargerMonstre(4);
				}
				
				//Niveau 5
				ArrayList<PersonnageNonJoueur> monstresEt5 = listeMonstreNiveaux.get(4);
				listeMonstreNiveaux.add(monstresEt5);
				
				for(int i=0; i<3;i++) {
					monstresEt5.add(new Gobelin(jeu, 0, 0));
					monstresEt5.get(monstresEt5.size()-1).chargerMonstre(5);
					monstresEt5.add(new Fantome(jeu, 0, 0));
					monstresEt5.get(monstresEt5.size()-1).chargerMonstre(5);
					monstresEt5.add(new Troll(jeu, 0, 0));
					monstresEt5.get(monstresEt5.size()-1).chargerMonstre(5);
				}
		
	}
	
	public int getEtageActuel() {
		return etageActuel;
	}
	
	public ArrayList<ArrayList<PersonnageNonJoueur>> getListeMonstreNiveaux() {
		return listeMonstreNiveaux;
	}
	
	public void convertirLab(int[][] tab) {
		Case[][] res = new Case[LONGUEUR][HAUTEUR];
		
		for (int i = 0; i < LONGUEUR; i++) {
			for (int k = 0; k < HAUTEUR; k++) {
				switch (tab[i][k]) {
					case 0: 
						res[k][i] = new CaseSol();
					break;
					case 1: 
						res[k][i] = new CaseMur();
					break;
					case 2: 
						res[k][i] = new CasePiege();
					break;
					case 3:
						res[k][i] = new CasePotion();
					break;
					case 4:
						res[k][i] = new CaseEpee();
					break;
					case 8: 
						res[k][i] = new CaseDepart();
					break;
					case 9: 
						res[k][i] = new CaseSortie();
					break;
				}
			}
		}
		listeLabyrinthe.add(new LabyrintheJeu(res));
	}
	
	/**
	 * depart = 8
	 * arrivee = 9
	 * piege = 2
	 * potion = 3
	 * epee = 4
	 * vide = 0
	 */
	public void niv1() {
		int[][] labChiffre = 
			   {{1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,8,1,2,0,0,0,1,0,0,0,0,0,1},
				{1,0,1,1,1,0,0,1,0,0,0,0,0,1},
				{1,0,1,1,1,0,0,1,0,1,1,1,0,1},
				{1,0,1,1,1,0,0,0,0,1,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,1,1,1,0,1},
				{1,0,0,0,0,0,0,0,0,2,0,0,0,1},
				{1,0,0,0,0,0,1,1,1,0,0,1,1,1},
				{1,1,1,1,1,2,1,3,1,0,1,0,0,1},
				{1,0,0,4,1,1,1,0,1,0,0,0,9,1},
				{1,0,1,1,1,0,0,0,1,0,0,0,0,1},
				{1,0,1,1,1,0,0,0,1,0,1,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,1,0,0,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
		
		convertirLab(labChiffre);
		
	}
	
	public void niv2() {
		int[][] labChiffre = 
			   {{1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,1,1,1,1,0,0,0,0,1,0,0,1},
				{1,0,1,1,1,1,0,0,1,1,1,1,0,1},
				{1,0,0,0,0,1,0,0,1,0,3,1,0,1},
				{1,0,1,0,0,1,0,0,1,0,1,1,0,1},
				{1,0,1,0,0,1,0,0,1,0,0,0,0,1},
				{1,2,1,0,0,1,2,1,1,0,0,1,1,1},
				{1,1,1,0,0,1,0,0,0,0,0,2,8,1},
				{1,0,0,0,0,1,0,1,1,0,1,1,0,1},
				{1,0,0,0,1,1,0,0,1,0,1,2,0,1},
				{1,9,1,1,1,4,1,0,1,0,1,1,0,1},
				{1,2,2,2,2,0,0,0,0,0,0,0,0,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
		
		convertirLab(labChiffre);

	}
	
	public void niv3() {
		int[][] labChiffre = 
			   {{1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,1,1,0,1,0,0,1,1,0,0,9,1},
				{1,0,0,1,0,1,0,1,0,1,0,0,0,1},
				{1,0,0,1,0,2,0,1,0,2,0,0,0,1},
				{1,1,2,1,0,0,0,1,0,2,0,0,0,1},
				{1,1,0,1,0,1,0,1,0,1,1,1,0,1},
				{1,0,0,0,0,1,0,0,0,1,0,0,0,1},
				{1,1,1,1,0,1,2,0,0,1,0,0,0,1},
				{1,0,0,0,0,1,1,1,0,1,0,0,0,1},
				{1,0,1,1,0,1,4,0,0,1,1,1,0,1},
				{1,0,1,0,0,1,1,1,2,1,0,1,0,1},
				{1,8,1,0,0,0,0,0,0,0,0,0,0,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
		
		convertirLab(labChiffre);
		
	}
	
	public void niv4() {
		int[][] labChiffre = 
			   {{1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,0,0,0,1,0,0,0,0,0,0,0,8,1},
				{1,0,1,0,1,0,0,1,1,1,1,0,0,1},
				{1,0,1,0,1,0,1,1,0,0,1,1,1,1},
				{1,0,1,0,0,0,0,0,0,1,1,0,9,1},
				{1,0,1,1,1,1,1,1,1,1,0,0,2,1},					
				{1,0,0,0,0,0,0,2,1,0,0,1,1,1},
				{1,0,1,0,0,0,0,2,1,2,0,0,1,1},
				{1,0,1,2,1,1,0,1,1,1,1,0,0,1},
				{1,2,1,3,1,1,0,1,3,2,1,1,0,1},
				{1,1,1,1,1,0,0,1,2,2,0,0,0,1},
				{1,2,1,1,0,0,1,1,1,1,1,1,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
		
		convertirLab(labChiffre);
		
	}
	
	public void niv5() {
		int[][] labChiffre = 
			   {{1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,0,0,0,1,0,0,0,1,1,0,4,0,1},
				{1,0,1,0,0,0,1,0,0,1,0,1,0,1},
				{1,0,1,1,1,1,1,1,0,1,0,1,8,1},
				{1,0,0,1,0,0,0,0,0,1,0,1,0,1},
				{1,1,0,1,0,1,1,1,1,1,0,1,0,1},
				{1,1,0,1,0,1,2,2,2,1,0,0,0,1},
				{1,0,0,1,0,1,2,1,2,1,1,1,0,1},
				{1,3,1,1,0,0,0,1,0,0,0,0,0,1},
				{1,2,1,1,1,1,0,1,0,1,1,1,1,1},
				{1,2,1,0,0,0,0,1,0,0,0,0,0,1},
				{1,2,1,0,1,1,1,1,1,1,1,1,0,1},
				{1,9,1,0,0,0,0,0,0,0,0,0,0,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
		
		convertirLab(labChiffre);
		
		
	}
	
	public void monterEtage() {
		if(etageActuel<= this.listeLabyrinthe.size()-1) {
			this.etageActuel++;	
		} else {
			jeu.setFini(true);
		}
		actualiserEtage();
		
	}
	
	public void descendreEtage() {
		if(etageActuel >= 2) {
			this.etageActuel--;			
		}
		actualiserEtage();
	}
	
	private void actualiserEtage() {
		this.jeu.setArene(this.listeLabyrinthe.get(etageActuel-1));
		this.jeu.setListePerso(this.listeMonstreNiveaux.get(etageActuel-1));
	}
	
	public ArrayList<LabyrintheJeu> getListeLabyrinthe(){
		return listeLabyrinthe;
	}
	
}
