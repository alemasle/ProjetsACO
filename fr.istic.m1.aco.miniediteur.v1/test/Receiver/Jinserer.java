package Receiver;

import static org.junit.Assert.*;

import org.junit.Test;

import Command.Command;
import Command.Inserer;
import State.Buffer;
import State.ClipBoard;
import State.ClipboardImpl;
import State.Selection;


/**
 * Fichier Test Inserer
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 * 
 */



public class Jinserer {

	@Test
	public void testInserer1() {
		String str = new String("abcdef");
		StringBuffer stringBuffer = new StringBuffer("insere");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(pressePapier, selection, buffer);

		buffer.setBuffer(stringBuffer);
		enregistreur.stopper();
		selection.setDebut(0);
		Command inserer = new Inserer(moteur, str, enregistreur);
		inserer.execute();

		assertTrue(("abcdefinsere").compareTo(buffer.getBuffer().toString()) == 0);

	}

	@Test
	public void testInserer2() {
		String str = new String("abcdef");
		StringBuffer stringBuffer = new StringBuffer("insere");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(pressePapier, selection, buffer);

		Command inserer = new Inserer(moteur, str, enregistreur);
		inserer.execute();
		assertNotNull("La chaine n'est pas vide", str);
	}

	@Test
	public void testInserer3() {

		String str = new String("abcdef");
		StringBuffer stringBuffer = new StringBuffer("insere");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(pressePapier, selection, buffer);

		buffer.setBuffer(stringBuffer);
		enregistreur.stopper();
		selection.setDebut(6);
		Command inserer = new Inserer(moteur, str, enregistreur);
		inserer.execute();

		assertTrue(("insereabcdef").compareTo(buffer.getBuffer().toString()) == 0);

	}

	@Test
	public void testInserer4() {

		String str = new String("abcdef");
		StringBuffer stringBuffer = new StringBuffer("insere");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(pressePapier, selection, buffer);

		buffer.setBuffer(stringBuffer);
		enregistreur.stopper();
		selection.setDebut(3);
		Command inserer = new Inserer(moteur, str, enregistreur);
		inserer.execute();

		assertTrue(("insabcdefere").compareTo(buffer.getBuffer().toString()) == 0);

	}

}
