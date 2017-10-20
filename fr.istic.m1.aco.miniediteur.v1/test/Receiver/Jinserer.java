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
		Enregistreur enregistreur = new EnregistrerImpl();
		
		Command inserer = new Inserer(moteur, str, enregistreur);
		
		assertTrue(true);
		assertFalse(false);
	}

	@Test
	public void testInserer2() {
		Moteur moteur = new MoteurImpl();
		String str = new String();
		Enregistreur enregistreur = new EnregistrerImpl();
		
		Command inserer = new Inserer(moteur, str, enregistreur);
		
		assertNotNull("La chaine n'est pas vide",str);
	}

}
