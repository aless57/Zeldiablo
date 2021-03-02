package Jeu;

import java.awt.Color;

public class CaseSortie extends Case {

	public CaseSortie() {
		super(0, 0, "src/Sprite/Environnement/sortie.png");
	}

	@Override
	public void declencherAction(Heros h) {
		h.jeu.getTour().monterEtage();
	}

}
