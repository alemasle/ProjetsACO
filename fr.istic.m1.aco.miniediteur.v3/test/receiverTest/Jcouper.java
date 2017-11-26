package receiverTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import command.Command;
import command.Couper;
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
 * Fichier Test Couper
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 * 
 */

public class Jcouper {

	/**
	 * 
	 * 
	 *
	 */

	// TODO
	@Test
	public void testCouper() {
		StringBuffer stringBuffer = new StringBuffer("couper");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(pressePapier, selection, buffer);

		buffer.setBuffer(stringBuffer);
		enregistreur.stopper();
		selection.setDebut(3);
		selection.setFin(3);
		Command couper = new Couper(moteur, enregistreur);
		couper.execute();

		assertTrue(("").compareTo(pressePapier.getClip()) == 0);
		assertTrue(("couper").compareTo(buffer.getBuffer().toString()) == 0);
	}

	/**
	 * test le stringBuffer après sélection des caractères de 0 à 6 soit "couper"
	 * test en assertTrue que "couper" est bien dans le presse papier et est
	 * supprimé du buffer
	 *
	 */
	@Test
	public void testCouper2() {
		StringBuffer stringBuffer = new StringBuffer("couper");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(pressePapier, selection, buffer);

		buffer.setBuffer(stringBuffer);
		enregistreur.stopper();
		selection.setDebut(0);
		selection.setFin(6);
		Command couper = new Couper(moteur, enregistreur);
		couper.execute();

		assertTrue(("couper").compareTo(pressePapier.getClip()) == 0);
		assertTrue(("").compareTo(buffer.getBuffer().toString()) == 0);

	}

	@Test
	public void testSetMemento() {
		// pas d'action
	}

	@Test
	public void testGetMementon() {
		StringBuffer stringBuffer = new StringBuffer("couper");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(pressePapier, selection, buffer);

		Command couper = new Couper(moteur, enregistreur);

		Memento<CouperMemento> memento = couper.getMemento();

		assertTrue(memento instanceof Couper.CouperMemento);

	}

	/**
	 * test le stringBuffer après sélection des caractères de 2 à 5 soit "upe" que
	 * l'on coupe du pressepapier et il reste donc les caractères "cor" dans le
	 * buffer
	 *
	 */
	@Test
	public void testCouper3() {
		StringBuffer stringBuffer = new StringBuffer("couper");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(pressePapier, selection, buffer);

		buffer.setBuffer(stringBuffer);
		enregistreur.stopper();
		selection.setDebut(2);
		selection.setFin(5);
		Command couper = new Couper(moteur, enregistreur);
		couper.execute();

		assertTrue(("upe").compareTo(pressePapier.getClip()) == 0);
		assertTrue(("cor").compareTo(buffer.getBuffer().toString()) == 0);

	}
}
