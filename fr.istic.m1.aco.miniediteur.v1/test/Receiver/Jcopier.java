package Receiver;

import static org.junit.Assert.*;
import Memento.Memento;

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
	
	@Test
	public void testExecute() {
		Moteur moteur = new MoteurImpl();
		Enregistreur enregistreur = new EnregistrerImpl();

		Command copier = new Copier(moteur,enregistreur);

		copier.execute();
		moteur.copier();
		
	}

	@Test
	public void testSetMemento() {
		//pas d'action
		
	}
	
	@Test
	public void testGetMemento() {
		Moteur moteur = new MoteurImpl();
		Enregistreur enregistreur = new EnregistrerImpl();

		Command copier = new Copier(moteur,enregistreur);

		Memento memento= copier.getMemento();
		
		assertTrue(memento instanceof Copier.CopierMemento);
		
		
	}
	
	
}
