package Jeu;

import java.awt.Color;

public class CaseEpee extends Case {
	
	/** true quand la potion a deja ete utilise **/
	private boolean utilise;
	
	/**
 	 * constructeur case mur
 	 */
 	public CaseEpee() {
		super(0, 0, "src/Sprite/Environnement/epee.png");
 	}

	@Override
	public void declencherAction(Heros h) {
		
		if (!utilise) {
			h.changerArme(new Epee());
			utilise = true;
			setSprite("src/Sprite/Environnement/poussiere.png");
		}
	}

}
