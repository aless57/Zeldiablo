package Jeu;

import java.awt.Color;

public class CasePiege extends Case {
	
	/** true quand heros deja marche dessus **/
	private boolean revele;
	
	/**
 	 * constructeur case mur
 	 */
 	public CasePiege() {
		super(0, 1, "src/Sprite/Environnement/piege_cache.png");
		revele = false;
 	}

	@Override
	public void declencherAction(Heros h) {
		h.subirAttaque(1);
		
		if (!revele) {
			setSprite("src/Sprite/Environnement/piege_revele.png");
			revele = true;
		}
		
	}

}
