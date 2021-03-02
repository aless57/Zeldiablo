package Jeu;

import java.awt.Color;

public class CaseDepart extends Case {

	public CaseDepart() {
		super(0, 0, "src/Sprite/Environnement/depart.png");
	}

	@Override
	public void declencherAction(Heros h) {
		h.jeu.getTour().descendreEtage();
	}

}
