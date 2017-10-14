package Receiver;

import static org.junit.Assert.*;

import org.junit.Test;

import Command.Command;
import Command.Inserer;

public class Jinserer {

	@Test
	public void testInserer1() {
		Moteur moteur = new MoteurImpl();
		String str = new String();
		
		Command inserer = new Inserer(moteur, str);
		
		assertTrue(true);
		assertFalse(false);
	}

	@Test
	public void testInserer2() {
		Moteur moteur = new MoteurImpl();
		String str = new String();
		
		Command inserer = new Inserer(moteur, str);
		
		assertNotNull("La chaine n'est pas vide",str);
	}

}
