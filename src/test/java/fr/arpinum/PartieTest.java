package fr.arpinum;

import static fr.arpinum.cocoritest.Affirmations.*;

import org.junit.Before;
import org.junit.Test;

public class PartieTest {

	@Before
	public void avantChaqueTest() {
		partie = new Partie();
	}

	@Test
	public void siUnJoueurFaitTomberUneQuilleIlMarqueLaValeurDeLaQuille() {
		partie.metsAJourLePointageAvecLeLancer(3);

		alorsLePointageEst(3);
	}

	@Test
	public void siUnJoueurFaitTomberPlusieursQuillesIlMarqueLeNombreDeQuilles() {
		partie.metsAJourLePointageAvecLeLancer(1, 2);

		alorsLePointageEst(2);
	}

	@Test
	public void lePointageEstLeCumulDePlusieursLancers() {
		partie.metsAJourLePointageAvecLeLancer(1);
		partie.metsAJourLePointageAvecLeLancer(1);

		alorsLePointageEst(2);
	}

	@Test
	public void siUnJoueurAtteint50PointsIlAGagnéLaPartie() {
		partie.metsAJourLePointageAvecLeLancer(50);

		boolean gagnée = partie.gagnée();

		alors().ceci(gagnée).estVrai();
	}

	@Test
	public void siUnJoueurAMoinsDe50PointsIlNAPasGagné() {
		partie.metsAJourLePointageAvecLeLancer(1);

		boolean gagnée = partie.gagnée();

		alors().ceci(gagnée).estFaux();
	}

	@Test
	public void siUnJoueurDépasse50PointsIlRedescendA25() {
		partie.metsAJourLePointageAvecLeLancer(51);

		alorsLePointageEst(25);
	}

	private void alorsLePointageEst(int pointageAttendu) {
		int pointage = partie.donneLePointage();
		alors().le(pointage).est(pointageAttendu);
	}

	private Partie partie;
}
