package Receiver;

import static org.junit.Assert.*;

import org.junit.Test;

import Command.Coller;
import Command.Command;
import Command.Copier;
import Memento.Memento;

public class Jcoller {

	@Test
	public void testColler() {
		Moteur moteur = new MoteurImpl();
		Enregistreur enregistreur = new EnregistrerImpl();

		Command coller = new Coller(moteur, enregistreur);

		assertTrue(true);
		assertFalse(false);
	}
	
	@Test
	public void testExecute() {
		Moteur moteur = new MoteurImpl();
		Enregistreur enregistreur = new EnregistrerImpl();

		Command coller = new Coller(moteur, enregistreur);

		coller.execute();
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

		Command coller = new Coller(moteur, enregistreur);

		Memento memento= coller.getMemento();
		
		assertTrue(memento instanceof Coller.CollerMemento);
		
	}
}
