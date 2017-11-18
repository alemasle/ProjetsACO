package receiverTest;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

import command.Coller;
import command.Command;
import command.Copier;
import command.Couper;
import command.Inserer;
import command.Selectionner;
import receiver.Moteur;
import receiver.MoteurImpl;
import state.Buffer;
import state.ClipBoard;
import state.ClipboardImpl;
import state.Selection;

/**
 * Fichier Test Selectionner
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 * 
 */

public class Jselectionner {
	/*
	@Test
	public void testExecute1() {

		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);

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
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);

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
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);
	
		int deb = 5;
		int fin = 5;
		
		Command select = new Selectionner(moteur, deb, fin);
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
		
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);

		int deb = 5, fin = 2;
	
		Command select = new Selectionner(moteur, deb, fin);
		select.execute();

		assertNotEquals(selection.getDebut(), selection.getFin());
	}
	*/
}
