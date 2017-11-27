package stateTest;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import state.Selection;

/**
 * Fichier Test Selection
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 * 
 */

public class JSelection {

	@Test
	public void testSelectionFor() {
		Selection selection = new Selection();
		Random rn = null;
		int deb = -1;
		int fin = -1;

		for (int i = 0; i < 10000; i++) {

			rn = new Random();
			deb = rn.nextInt(1000) - 500;
			fin = rn.nextInt(1000) - 500;

			if (deb <= fin) {
				selection.setDebut(deb);
				selection.setFin(fin);

				assertTrue(selection.getDebut() >= 0);
				assertTrue(selection.getFin() >= 0);
				assertTrue(selection.getDebut() <= selection.getFin());
			}

		}
	}

}
