package receiverTest;

import static org.junit.Assert.*;

import org.junit.Test;

import command.Delete;
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

public class JDelete {

	@Test
	public void testJDelete1() {

		StringBuffer stringBuffer = new StringBuffer("delete");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Rejouer rejouer = new Rejouer(enregistreur);
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);
		Manager manager = new ManagerImpl(moteur);
		Delete delete = new Delete(moteur, enregistreur,manager);

		buffer.setBuffer(stringBuffer);

		selection.setDebut(6);
		selection.setFin(6);

		enregistreur.demarrer();
		delete.execute();
		enregistreur.stopper();

		selection.setDebut(2);
		selection.setFin(3);

		rejouer.execute();
		System.out.println(buffer.getBuffer().toString());
		manager.defaire();
		manager.refaire();
		
		System.out.println(buffer.getBuffer().toString());
		assertTrue(("deet").compareTo(buffer.getBuffer().toString()) == 0);
	}

	@Test
	public void testJDelete2() {

		StringBuffer stringBuffer = new StringBuffer("delete");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Rejouer rejouer = new Rejouer(enregistreur);
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);
		Manager manager = new ManagerImpl(moteur);
		Delete delete = new Delete(moteur, enregistreur,manager);

		buffer.setBuffer(stringBuffer);
		selection.setDebut(0);
		selection.setFin(2);

		selection.setDebut(6);
		selection.setFin(6);

		enregistreur.demarrer();

		delete.execute();

		enregistreur.stopper();

		rejouer.execute();
		rejouer.execute();
		rejouer.execute();

		assertTrue(("de").compareTo(buffer.getBuffer().toString()) == 0);
	}

	@Test
	public void testJDelete3() {

		StringBuffer stringBuffer = new StringBuffer("deleteDELETE");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);
		Manager manager = new ManagerImpl(moteur);
		Delete delete = new Delete(moteur, enregistreur,manager);

		buffer.setBuffer(stringBuffer);

		selection.setDebut(4);
		selection.setFin(7);
		delete.execute();
		selection.setDebut(4);
		selection.setFin(7);
		delete.execute();

		assertTrue(("deleTE").compareTo(buffer.getBuffer().toString()) == 0);
	}

}
