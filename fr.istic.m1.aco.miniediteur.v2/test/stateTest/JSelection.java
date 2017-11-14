package stateTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
	public void testSelection() {
		Selection selection = new Selection();

		selection.setDebut(0);
		selection.setFin(10);

		assertTrue(selection.getDebut() >= 0);
		assertTrue(selection.getFin() >= 0);
		assertTrue(selection.getDebut() <= selection.getFin());

	}

	@Test
	public void testSelection2() {
		Selection selection = new Selection();

		selection.setDebut(10);
		selection.setFin(10);

		assertTrue(selection.getDebut() >= 0);
		assertTrue(selection.getFin() >= 0);
		assertTrue(selection.getDebut() <= selection.getFin());

	}

	@Test
	public void testSelection3() {
		Selection selection = new Selection();

		selection.setDebut(10);
		selection.setFin(0);

		assertTrue(selection.getDebut() >= 0);
		assertTrue(selection.getFin() >= 0);
		assertFalse(selection.getDebut() <= selection.getFin());

	}

	@Test
	public void testSelection4() {
		Selection selection = new Selection();

		selection.setDebut(0);
		selection.setFin(0);

		assertTrue(selection.getDebut() >= 0);
		assertTrue(selection.getFin() >= 0);
		assertTrue(selection.getDebut() <= selection.getFin());

	}

	@Test
	public void testSelection5() {
		Selection selection = new Selection();

		selection.setDebut(-5);
		selection.setFin(-10);

		assertFalse(selection.getDebut() >= 0);
		assertFalse(selection.getFin() >= 0);
		assertFalse(selection.getDebut() <= selection.getFin());

	}

}
