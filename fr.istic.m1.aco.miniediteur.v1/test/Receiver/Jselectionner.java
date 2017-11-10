package Receiver;

import static org.junit.Assert.*;

import org.junit.Test;

import Command.Command;
import Command.Selectionner;
import State.Buffer;
import State.ClipBoard;
import State.ClipboardImpl;
import State.Selection;

public class Jselectionner {

	@Test
	public void testExecute1() {

		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(pressePapier, selection, buffer);

		int deb = 0;
		int fin = 10;
		enregistreur.stopper();
		Command select = new Selectionner(moteur, deb, fin, enregistreur);
		select.execute();

		assertTrue(selection.getDebut() <= selection.getFin());
		assertFalse(selection.getDebut() >= selection.getFin());
	}

	@Test
	public void testExecute2() {

		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(pressePapier, selection, buffer);

		int deb = 10;
		int fin = 0;
		enregistreur.stopper();
		Command select = new Selectionner(moteur, deb, fin, enregistreur);
		select.execute();

		assertFalse(selection.getDebut() >= selection.getFin());
		assertTrue(selection.getDebut() <= selection.getFin());
	}

	@Test
	public void testExecute3() {

		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(pressePapier, selection, buffer);

		int deb = 5;
		int fin = 5;
		enregistreur.stopper();
		Command select = new Selectionner(moteur, deb, fin, enregistreur);
		select.execute();

		assertTrue(selection.getDebut() <= selection.getFin());
		assertTrue(selection.getDebut() == selection.getFin());
		assertTrue(selection.getDebut() >= selection.getFin());
	}

	@Test
	public void testGetValues() {
		StringBuffer stringBuffer = new StringBuffer("couper");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(pressePapier, selection, buffer);

		int deb = 5, fin = 2;
		enregistreur.stopper();
		Command select = new Selectionner(moteur, deb, fin, enregistreur);
		select.execute();

		assertNotEquals(selection.getDebut(), selection.getFin());
	}

}
