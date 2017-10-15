package Receiver;

import static org.junit.Assert.*;

import org.junit.Test;

import Command.Command;
import Command.Selectionner;

public class Jselectionner {

	@Test
	public void testExecute1() {
		MoteurImpl moteur = new MoteurImpl();
		int deb = 0;
		int fin = 10;
		Command select = new Selectionner(moteur, deb, fin);

		assertTrue(deb <= fin);
		assertFalse(deb >= fin);
	}

	@Test
	public void testExecute2() {
		MoteurImpl moteur = new MoteurImpl();
		int deb = 10;
		int fin = 0;
		Command select = new Selectionner(moteur, deb, fin);

		assertTrue(deb >= fin);
		assertFalse(deb <= fin);
	}

	@Test
	public void testExecute3() {
		MoteurImpl moteur = new MoteurImpl();
		int deb = 5;
		int fin = 5;
		Command select = new Selectionner(moteur, deb, fin);

		assertTrue(deb <= fin);
		assertTrue(deb == fin);
		assertTrue(deb >= fin);
	}

}
