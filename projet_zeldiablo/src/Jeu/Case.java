package Jeu;

import java.awt.Color;

public abstract class Case {
	
	/** solidite = 1 si mur **/
	private int solidite;
	
	/** degat > 0 si case piege **/
	private int degats;
	
	/** sprite de la case **/
	private String sprite;
	
	public Case(int s, int d, String sprite) {
		solidite = s;
		degats = d;
		this.sprite = sprite;
	}
	
	/**
	 * methode declenche action de la case 
	 * @return
	 */
	public abstract void declencherAction(Heros h);
	
	/**
	 * getteur solidite
	 * @return solidite de la case (1 si mur)
	 */
	public int getSolidite() {
		return solidite;
	}

	/**
	 * getteur degats
	 * @return degats de la case 
	 */
	public int getDegats() {
		return degats;
	}

	/**
	 * getteur sprite
	 * @return sprite de la case
	 */
	public String getSprite() {
		return sprite;
	}
	
	public void setSprite(String s) {
		sprite = s;
	}
	
}
