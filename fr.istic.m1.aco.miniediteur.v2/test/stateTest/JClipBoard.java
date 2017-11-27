package stateTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import state.ClipBoard;
import state.ClipboardImpl;

/**
 * Fichier Test ClipBoard
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 * 
 */

public class JClipBoard {

	@Test
	public void testClipboardImpl() {
		ClipBoard pressePapier = new ClipboardImpl();

		pressePapier.setClip("");

		assertTrue((pressePapier.getClip().compareTo("")) == 0);
	}

	@Test
	public void testClipboardImpl2() {
		ClipBoard pressePapier = new ClipboardImpl();

		pressePapier.setClip("clipboard");

		assertTrue((pressePapier.getClip().compareTo("clipboard")) == 0);
	}

	@Test
	public void testClipboardImpl3() {
		ClipBoard pressePapier = new ClipboardImpl();

		pressePapier.setClip("clipboard");

		assertFalse((pressePapier.getClip().compareTo("clipbourde")) == 0);
	}

}
