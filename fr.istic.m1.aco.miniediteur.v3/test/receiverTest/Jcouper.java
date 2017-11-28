package receiverTest;

import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Test;

import command.Ajouter;
import command.Coller;
import command.Command;
import command.CommandGeneral;
import command.Copier;
import command.Couper;
import command.Defaire;
import command.Delete;
import command.Demarrer;
import command.Inserer;
import command.Load;
import command.NewLine;
import command.Refaire;
import command.Rejouer;
import command.Save;
import command.Selectionner;
import command.Stopper;
import ihm.Ihm;
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

	
	@Test
	public void testCouper() {
		Buffer buffer = new Buffer();
		ClipBoard pressePapier = new ClipboardImpl();
		Selection selection = new Selection();
		Ihm ihm = null;

		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);
		Enregistreur enregistreur = new EnregistrerImpl();
		Manager manager = new ManagerImpl(moteur);

		Coller coller = new Coller(moteur, enregistreur, manager);
		Copier copier = new Copier(moteur, enregistreur, manager);
		Couper couper = new Couper(moteur, enregistreur, manager);
		Inserer inserer = new Inserer(moteur, ihm, enregistreur, manager);
		Selectionner selectionner = new Selectionner(moteur, ihm, enregistreur, manager);
		Save save = new Save(moteur, ihm);
		Ajouter ajouter = new Ajouter(moteur, ihm, enregistreur, manager);
		Delete delete = new Delete(moteur, enregistreur, manager);
		Load load = new Load(moteur, ihm);
		NewLine newLine = new NewLine(moteur, enregistreur, manager);
		Demarrer demarrer = new Demarrer(enregistreur);
		Stopper stopper = new Stopper(enregistreur);
		Rejouer rejouer = new Rejouer(enregistreur);
		Defaire defaire = new Defaire(manager);
		Refaire refaire = new Refaire(manager);

		Scanner scanner = new Scanner(System.in);
	

		ihm = new Ihm(copier, coller, couper, inserer, selectionner, buffer, selection, scanner, save, ajouter, delete,
				load, demarrer, stopper, rejouer, newLine, defaire, refaire);

		inserer.setIhm(ihm);
		selectionner.setIhm(ihm);
		save.setIhm(ihm);
		ajouter.setIhm(ihm);
		load.setIhm(ihm);
		
		System.out.println("Entrer le mot: couper ");
		ajouter.execute();
		selection.setDebut(3);
		selection.setFin(3);
		
		couper.execute();
		manager.defaire();
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
	
		Buffer buffer = new Buffer();
		ClipBoard pressePapier = new ClipboardImpl();
		Selection selection = new Selection();
		Ihm ihm = null;

		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);
		Enregistreur enregistreur = new EnregistrerImpl();
		Manager manager = new ManagerImpl(moteur);

		Coller coller = new Coller(moteur, enregistreur, manager);
		Copier copier = new Copier(moteur, enregistreur, manager);
		Couper couper = new Couper(moteur, enregistreur, manager);
		Inserer inserer = new Inserer(moteur, ihm, enregistreur, manager);
		Selectionner selectionner = new Selectionner(moteur, ihm, enregistreur, manager);
		Save save = new Save(moteur, ihm);
		Ajouter ajouter = new Ajouter(moteur, ihm, enregistreur, manager);
		Delete delete = new Delete(moteur, enregistreur, manager);
		Load load = new Load(moteur, ihm);
		NewLine newLine = new NewLine(moteur, enregistreur, manager);
		Demarrer demarrer = new Demarrer(enregistreur);
		Stopper stopper = new Stopper(enregistreur);
		Rejouer rejouer = new Rejouer(enregistreur);
		Defaire defaire = new Defaire(manager);
		Refaire refaire = new Refaire(manager);

		Scanner scanner = new Scanner(System.in);

		ihm = new Ihm(copier, coller, couper, inserer, selectionner, buffer, selection, scanner, save, ajouter, delete,
				load, demarrer, stopper, rejouer, newLine, defaire, refaire);

		inserer.setIhm(ihm);
		selectionner.setIhm(ihm);
		save.setIhm(ihm);
		ajouter.setIhm(ihm);
		load.setIhm(ihm);
		

		System.out.println("Entrer le mot: couper ");
		ajouter.execute();
		selection.setDebut(0);
		selection.setFin(6);
		
		couper.execute();
		manager.defaire();
		
		
		assertTrue(("couper").compareTo(pressePapier.getClip()) == 0);
		
		assertTrue(("couper").compareTo(buffer.getBuffer().toString()) == 0);

	}


	@Test
	public void testGetMemento() {
		StringBuffer stringBuffer = new StringBuffer("couper");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);
		Manager manager = new ManagerImpl(moteur);

		CommandGeneral couper = new Couper(moteur, enregistreur,manager);
		CommandGeneral coller = new Coller(moteur, enregistreur, manager);

		buffer.setBuffer(stringBuffer);

		enregistreur.demarrer();
		selection.setDebut(0);
		selection.setFin(3);
		couper.execute();
		selection.setDebut(3);
		selection.setFin(3);
		coller.execute();

		enregistreur.stopper();

		assertTrue(("cou").compareTo(pressePapier.getClip()) == 0);
		assertTrue("percou".compareTo(buffer.getBuffer().toString()) == 0);
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
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);
		Manager manager = new ManagerImpl(moteur);

		buffer.setBuffer(stringBuffer);
		enregistreur.stopper();
		selection.setDebut(2);
		selection.setFin(5);
		Command couper = new Couper(moteur, enregistreur, manager);
		couper.execute();

		assertTrue(("upe").compareTo(pressePapier.getClip()) == 0);
		assertTrue(("cor").compareTo(buffer.getBuffer().toString()) == 0);

	}
}
