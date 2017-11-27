package receiverTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import command.Coller;
import command.Command;
import command.CommandGeneral;
import command.Copier;
import receiver.EnregistrerImpl;
import receiver.Enregistreur;
import receiver.Moteur;
import receiver.MoteurImpl;
import state.Buffer;
import state.ClipBoard;
import state.ClipboardImpl;
import state.Selection;

/**
 * Fichier Test Copier
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 * 
 */

public class Jcopier {

	/**
	 * 
	 *
	 */
	@Test
	public void testCopier() {

		StringBuffer stringBuffer = new StringBuffer("copier");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);

		buffer.setBuffer(stringBuffer);
		selection.setDebut(3);
		selection.setFin(3);
		Command copier = new Copier(moteur, enregistreur);
		copier.execute();

		assertTrue(("").compareTo(pressePapier.getClip()) == 0);

	}

	/**
	 * test le stringBuffer après sélection des caractères de 0 à 6 soit "copier"
	 * test en assertTrue que "copier" est bien dans le presse papier
	 *
	 */
	@Test
	public void testCopie2() {
		StringBuffer stringBuffer = new StringBuffer("copier");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);

		buffer.setBuffer(stringBuffer);
		selection.setDebut(0);
		selection.setFin(6);
		Command copier = new Copier(moteur, enregistreur);
		copier.execute();

		assertTrue(("copier").compareTo(pressePapier.getClip()) == 0);

	}

	/**
	 * test le stringBuffer après sélection des caractères de 4 à 6 soit "er" test
	 * en assertTrue que "er" est bien dans le presse papier
	 *
	 */
	@Test
	public void testCopie3() {
		StringBuffer stringBuffer = new StringBuffer("copier");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);

		buffer.setBuffer(stringBuffer);

		selection.setDebut(4);
		selection.setFin(6);
		Command copier = new Copier(moteur, enregistreur);
		copier.execute();

		assertTrue(("er").compareTo(pressePapier.getClip()) == 0);

	}

	@Test
	public void testGetMemento() {
		StringBuffer stringBuffer = new StringBuffer("abcdef");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);

		CommandGeneral copier = new Copier(moteur, enregistreur);
		CommandGeneral coller = new Coller(moteur, enregistreur);

		buffer.setBuffer(stringBuffer);
		selection.setDebut(0);
		selection.setFin(6);

		copier.execute();
		coller.execute();
		coller.execute();

		enregistreur.demarrer();
		selection.setDebut(0);
		selection.setFin(6);
		copier.execute();
		selection.setDebut(6);
		selection.setFin(6);
		coller.execute();
		enregistreur.stopper();
		enregistreur.rejouer();

		assertTrue("abcdef".compareTo(pressePapier.getClip()) == 0);

	}

}
