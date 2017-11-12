package Receiver;

import static org.junit.Assert.*;

import org.junit.Test;

import command.Coller;
import command.Command;
import command.Coller.CollerMemento;
import memento.Memento;
import receiver.EnregistrerImpl;
import receiver.Enregistreur;
import receiver.Moteur;
import receiver.MoteurImpl;
import state.Buffer;
import state.ClipBoard;
import state.ClipboardImpl;
import state.Selection;

/**
 * Fichier Test Coller
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 * 
 */

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
	
	/**
	 * Coller la chaine=abcdef et le stringBuffer=ABCDEFGH (concat�nation donne abcdefABCDEFGH )
	 * test en assertTrue
	 */
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
	
	
	/**
	 * selectionne le les 8 caract�res de la stringBuffer
	 * Coller  le stringBuffer=ABCDEFGH en premeier et la chaine=abcdef  (concat�nation donne ABCDEFGHabcdef )
	 * test en assertTrue
	 */

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

	
	/**
	 * selectionne le les 4 caract�res de la stringBuffer
	 * Coller  le stringBuffer=ABCD en premeier et la chaine=abcdef puis le reste de la stringBuffer=EFGH (concat�nation donne ABCDabcdefEFGH )
	 * test en assertTrue
	 */
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
