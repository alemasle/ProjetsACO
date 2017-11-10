package Receiver;

import static org.junit.Assert.*;

import org.junit.Test;

import Command.Coller;
import Command.Coller.CollerMemento;
import Command.Command;
import Command.Copier;
import Command.Selectionner;
import Memento.Memento;
import State.Buffer;
import State.ClipBoard;
import State.ClipboardImpl;
import State.Selection;

public class Jcoller {

	@Test
	public void testColler() {
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Moteur moteur = new MoteurImpl(pressePapier, selection, buffer);
		Enregistreur enregistreur = new EnregistrerImpl();

		Command coller = new Coller(moteur, enregistreur);

		assertTrue(true);
		assertFalse(false);
	}

	@Test
	public void testExecute() {
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Moteur moteur = new MoteurImpl(pressePapier, selection, buffer);
		Enregistreur enregistreur = new EnregistrerImpl();

		Command coller = new Coller(moteur, enregistreur);

	}

	@Test
	public void testSetMemento() {
		// pas d'action
	}

	// TODO à revoir
	@Test
	public void testGetMemento() {
		StringBuffer stringBuffer = new StringBuffer("ABCDEFGHabcdef");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Moteur moteur = new MoteurImpl(pressePapier, selection, buffer);
		Enregistreur enregistreur = new EnregistrerImpl();
		enregistreur.demarrer();

		Command coller = new Coller(moteur, enregistreur);

		enregistreur.stopper();

		Memento<CollerMemento> memento = coller.getMemento();

		assertTrue(memento instanceof Coller.CollerMemento);
		assertTrue(("ABCDEFGHabcdef").compareTo(buffer.getBuffer().toString()) == 0);

	}

	@Test
	public void testColler2() {
		String chaine = "abcdef";

		StringBuffer stringBuffer = new StringBuffer("ABCDEFGH");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();

		pressePapier.setClip(chaine);
		buffer.setBuffer(stringBuffer);
		enregistreur.stopper();
		Moteur moteur = new MoteurImpl(pressePapier, selection, buffer);
		Command coller = new Coller(moteur, enregistreur);
		coller.execute();

		assertTrue(("abcdefABCDEFGH").compareTo(buffer.getBuffer().toString()) == 0);

	}

	@Test
	public void testColler3() {
		String chaine = "abcdef";

		StringBuffer stringBuffer = new StringBuffer("ABCDEFGH");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();

		pressePapier.setClip(chaine);
		buffer.setBuffer(stringBuffer);
		enregistreur.stopper();
		selection.setDebut(8);
		Moteur moteur = new MoteurImpl(pressePapier, selection, buffer);
		Command coller = new Coller(moteur, enregistreur);
		coller.execute();

		assertTrue(("ABCDEFGHabcdef").compareTo(buffer.getBuffer().toString()) == 0);

	}

	@Test
	public void testColler4() {
		String chaine = "abcdef";

		StringBuffer stringBuffer = new StringBuffer("ABCDEFGH");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();

		pressePapier.setClip(chaine);
		buffer.setBuffer(stringBuffer);
		enregistreur.stopper();
		selection.setDebut(4);
		Moteur moteur = new MoteurImpl(pressePapier, selection, buffer);
		Command coller = new Coller(moteur, enregistreur);
		coller.execute();

		assertTrue(("ABCDabcdefEFGH").compareTo(buffer.getBuffer().toString()) == 0);

	}

}
