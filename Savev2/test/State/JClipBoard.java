package State;

import static org.junit.Assert.*;

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

		pressePapier.setClip("pressePaper");

		assertTrue((pressePapier.getClip().compareTo("pressePaper")) == 0);
	}

	@Test
	public void testClipboardImpl3() {
		ClipBoard pressePapier = new ClipboardImpl();

		pressePapier.setClip("pressePapeterie");

		assertFalse((pressePapier.getClip().compareTo("pressePap")) == 0);
	}

}
