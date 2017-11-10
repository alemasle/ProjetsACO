package Receiver;

import static org.junit.Assert.*;

import Memento.Memento;
import State.Buffer;
import State.ClipBoard;
import State.ClipboardImpl;
import State.Selection;

import org.junit.Test;

import Command.Command;
import Command.Copier;
import Command.Copier.CopierMemento;

public class Jcopier {

	@Test
	public void testCopier() {

		StringBuffer stringBuffer = new StringBuffer("copier");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(pressePapier, selection, buffer);

		buffer.setBuffer(stringBuffer);
		enregistreur.stopper();
		selection.setDebut(3);
		selection.setFin(3);
		Command copier = new Copier(moteur, enregistreur);
		copier.execute();

		assertTrue(("").compareTo(pressePapier.getClip()) == 0);

	}

	@Test
	public void testCopie2() {
		StringBuffer stringBuffer = new StringBuffer("copier");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(pressePapier, selection, buffer);

		buffer.setBuffer(stringBuffer);
		enregistreur.stopper();
		selection.setDebut(0);
		selection.setFin(6);
		Command copier = new Copier(moteur, enregistreur);
		copier.execute();

		assertTrue(("copier").compareTo(pressePapier.getClip()) == 0);

	}

	@Test
	public void testSetMemento() {
		// pas d'action

	}

	@Test
	public void testGetMemento() {
		StringBuffer stringBuffer = new StringBuffer("copier");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(pressePapier, selection, buffer);

		Command copier = new Copier(moteur, enregistreur);

		Memento<CopierMemento> memento = copier.getMemento();

		assertTrue(memento instanceof Copier.CopierMemento);

	}

	@Test
	public void testCopie3() {
		StringBuffer stringBuffer = new StringBuffer("copier");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(pressePapier, selection, buffer);

		buffer.setBuffer(stringBuffer);
		enregistreur.stopper();
		selection.setDebut(4);
		selection.setFin(6);
		Command copier = new Copier(moteur, enregistreur);
		copier.execute();

		assertTrue(("er").compareTo(pressePapier.getClip()) == 0);

	}

}
