package Receiver;

import static org.junit.Assert.*;

import org.junit.Test;

import Command.Coller;
import Command.Command;
import Command.Couper;
import Memento.Memento;

public class Jcouper {

	@Test
	public void testCouper() {
		Moteur moteur = new MoteurImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		
		Command couper = new Couper(moteur, enregistreur);
		
		assertTrue(true);
		assertFalse(false);
	}

	@Test
	public void testExecute() {
		Moteur moteur = new MoteurImpl();
		Enregistreur enregistreur = new EnregistrerImpl();

		Command couper = new Couper(moteur, enregistreur);

		couper.execute();
		moteur.coller();
		
	}
	
	@Test
	public void testSetMemento() {
		//pas d'action
	}

	@Test
	public void testGetMementon() {
		Moteur moteur = new MoteurImpl();
		Enregistreur enregistreur = new EnregistrerImpl();

		Command couper = new Couper(moteur, enregistreur);

		Memento memento= couper.getMemento();
		
		assertTrue(memento instanceof Couper.CouperMemento);
		
	}
}
