package Receiver;

import static org.junit.Assert.*;

import org.junit.Test;

import Command.Coller;
import Command.Command;

public class Jcoller {

	@Test
	public void testColler() {
		Moteur moteur = new MoteurImpl();
		
		Command coller = new Coller(moteur);
		
		assertTrue(true);
		assertFalse(false);
	}
	
}
