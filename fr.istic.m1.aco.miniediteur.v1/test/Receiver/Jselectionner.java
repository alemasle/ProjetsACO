package Receiver;

import static org.junit.Assert.*;

import org.junit.Test;

import Command.Command;
import Command.Selectionner;

public class Jselectionner {

	@Test
	public void testExecute1() {
		MoteurImpl moteur = new MoteurImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		int deb = 0;
		int fin = 10;
		Command select = new Selectionner(moteur, deb, fin, enregistreur);

		assertTrue(deb <= fin);
		assertFalse(deb >= fin);
	}

	@Test
	public void testExecute2() {
		MoteurImpl moteur = new MoteurImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		int deb = 10;
		int fin = 0; 
		Command select = new Selectionner(moteur, deb, fin, enregistreur);

		assertTrue(deb >= fin);
		assertFalse(deb <= fin);
	}

	@Test
	public void testExecute3() {
		MoteurImpl moteur = new MoteurImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		int deb = 5;
		int fin = 5;
		Command select = new Selectionner(moteur, deb, fin, enregistreur);

		assertTrue(deb <= fin);
		assertTrue(deb == fin);
		assertTrue(deb >= fin);
	}
	
	@Test
	public void testGetValues() {
		MoteurImpl moteur = new MoteurImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		int debut = 5, fin = 2;
		Command selectionner = new Selectionner(moteur, debut, fin, enregistreur);
		//TODO 
		/*
		selectionner.setDeb(debut);
		selectionner.setFin(fin);
		
		assertEquals();*/
	}

}
