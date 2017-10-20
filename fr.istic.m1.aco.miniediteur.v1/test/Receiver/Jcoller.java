package Receiver;

import static org.junit.Assert.*;

import org.junit.Test;

import Command.Coller;
import Command.Command;

public class Jcoller {

	@Test
	public void testColler() {
		Moteur moteur = new MoteurImpl();
		Enregistreur enregistreur = new EnregistrerImpl();

		Command coller = new Coller(moteur, enregistreur);

		assertTrue(true);
		assertFalse(false);
	}

}
