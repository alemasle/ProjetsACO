package Receiver;

import static org.junit.Assert.*;

import org.junit.Test;

import Command.Command;
import Command.Couper;

public class Jcouper {

	@Test
	public void testCouper() {
		Moteur moteur = new MoteurImpl();
		
		Command couper = new Couper(moteur);
		
		assertTrue(true);
		assertFalse(false);
	}

}
