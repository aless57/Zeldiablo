package Jeu;

import java.awt.Color;

public class CasePotion extends Case {
	
	/** true quand la potion a deja ete utilise **/
	private boolean utilise;
	
	/**
 	 * constructeur case mur
 	 */
 	public CasePotion() {
		super(0, 0, "src/Sprite/Environnement/potion.png");
		utilise = false;
 	}

	@Override
	public void declencherAction(Heros h) {
		if (!utilise) {
			h.gainPv(2);
			utilise = true;
			setSprite("src/Sprite/Environnement/poussiere.png");
		}
		
	}

}
