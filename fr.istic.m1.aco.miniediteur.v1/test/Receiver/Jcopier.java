package Receiver;

import static org.junit.Assert.*;

import org.junit.Test;

import Command.Command;
import Command.Copier;

public class Jcopier {

	@Test
	public void testCopier() {
		Moteur moteur = new MoteurImpl();
		Enregistreur enregistreur = new EnregistrerImpl();

		Command copier = new Copier(moteur,enregistreur);

		assertTrue(true);
		assertFalse(false);
	}

}
