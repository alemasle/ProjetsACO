package receiverTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import command.Coller;
import command.Coller.CollerMemento;
import command.Command;
import command.Rejouer;
import receiver.EnregistrerImpl;
import receiver.Enregistreur;
import receiver.Manager;
import receiver.ManagerImpl;
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
	public void testGetMemento() {

		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);
		Enregistreur enregistreur = new EnregistrerImpl();
		Manager manager = new ManagerImpl(moteur);
		Command coller = new Coller(moteur, enregistreur, manager);
		CollerMemento memento = (CollerMemento) coller.getMemento();

		enregistreur.demarrer();

		coller.execute();

		enregistreur.stopper();

		assertTrue(memento instanceof Coller.CollerMemento);

	}

	@Test
	public void testColler2() {
		String chaine = "ABC";

		StringBuffer stringBuffer = new StringBuffer("abc");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Rejouer rejouer = new Rejouer(enregistreur);
		pressePapier.setClip(chaine);
		buffer.setBuffer(stringBuffer);
		selection.setDebut(3);
		selection.setFin(28);
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);
		Manager manager = new ManagerImpl(moteur);
		Command coller = new Coller(moteur, enregistreur, manager);

		enregistreur.demarrer();

		coller.execute();

		enregistreur.stopper();

		selection.setDebut(0);
		selection.setFin(0);

		rejouer.execute();
		manager.defaire();

		assertTrue(("abcABC").compareTo(buffer.getBuffer().toString()) == 0);

	}

	@Test
	public void testColler3() {
		String chaine = "ABC";

		StringBuffer stringBuffer = new StringBuffer("");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Rejouer rejouer = new Rejouer(enregistreur);
		pressePapier.setClip(chaine);
		buffer.setBuffer(stringBuffer);
		selection.setDebut(0);
		selection.setFin(2);
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);
		Manager manager = new ManagerImpl(moteur);
		Command coller = new Coller(moteur, enregistreur, manager);

		enregistreur.demarrer();

		coller.execute();

		enregistreur.stopper();

		rejouer.execute();
		rejouer.execute();
		rejouer.execute();
		manager.defaire();
		manager.refaire();

		assertTrue(("ABCABCABCABC").compareTo(buffer.getBuffer().toString()) == 0);

	}

	@Test
	public void testColler4() {
		String chaine = "ABC";

		StringBuffer stringBuffer = new StringBuffer("papapapa");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Rejouer rejouer = new Rejouer(enregistreur);
		pressePapier.setClip(chaine);
		buffer.setBuffer(stringBuffer);
		selection.setDebut(8);
		selection.setFin(28);
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);
		Manager manager = new ManagerImpl(moteur);
		Command coller = new Coller(moteur, enregistreur, manager);

		enregistreur.demarrer();

		coller.execute();

		enregistreur.stopper();
		manager.refaire();
		selection.setDebut(4);
		selection.setFin(5);
		
		rejouer.execute();
		manager.defaire();
		

		assertTrue(("papapapaABC").compareTo(buffer.getBuffer().toString()) == 0);

	}

}
