package receiverTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;
import java.util.Scanner;

import org.junit.Test;

import command.*;
import command.Selectionner;
import command.Selectionner.SelectionnerMemento;
import ihm.Ihm;
import receiver.EnregistrerImpl;
import receiver.Enregistreur;
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

	@Test
	public void testExecute1() {

		StringBuffer str = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
		Buffer buffer = new Buffer();
		ClipBoard clip = new ClipboardImpl();
		Selection selection = new Selection();
		Ihm ihm = null;
		Moteur moteur = new MoteurImpl(buffer, clip, selection);
		Enregistreur enregistreur = new EnregistrerImpl();
		Demarrer demarrer = new Demarrer(enregistreur);
		Stopper stopper = new Stopper(enregistreur);
		Rejouer rejouer = new Rejouer(enregistreur);
		Coller coller = new Coller(moteur, enregistreur);
		Copier copier = new Copier(moteur, enregistreur);
		Couper couper = new Couper(moteur, enregistreur);
		Inserer inserer = new Inserer(moteur, ihm, enregistreur);
		Selectionner selectionner = new Selectionner(moteur, ihm, enregistreur);
		Save save = new Save(moteur, ihm);
		Ajouter ajouter = new Ajouter(moteur, ihm, enregistreur);
		Delete delete = new Delete(moteur, enregistreur);
		Load load = new Load(moteur, ihm);
		Scanner scanner = new Scanner(System.in);
		ihm = new Ihm(copier, coller, couper, inserer, selectionner, buffer, selection, scanner, save, ajouter, delete,
				load, demarrer, stopper, rejouer);

		Command select = new Selectionner(moteur, ihm, enregistreur);

		buffer.setBuffer(str);

		SelectionnerMemento selmem = null;
		int deb = 0;
		int fin = 0;
		Random rn = null;

		for (int i = 0; i < 100; i++) {
			rn = new Random();
			deb = rn.nextInt(100) + 0;
			fin = rn.nextInt(100) + 0;

			selmem = (SelectionnerMemento) select.getMemento();
			selmem.setDeb(deb);
			selmem.setFin(fin);
			select.setMemento(selmem);
			enregistreur.setPlay(true);
			select.execute();
			enregistreur.setPlay(false);

			System.out.println("deb: " + selection.getDebut() + " fin: " + selection.getFin());
			assertTrue(selection.getDebut() <= selection.getFin());
		}
	}

	@Test
	public void testExecute2() {
		Buffer buffer = new Buffer();
		ClipBoard clip = new ClipboardImpl();
		Selection selection = new Selection();
		Ihm ihm = null;
		Moteur moteur = new MoteurImpl(buffer, clip, selection);
		Enregistreur enregistreur = new EnregistrerImpl();
		Demarrer demarrer = new Demarrer(enregistreur);
		Stopper stopper = new Stopper(enregistreur);
		Rejouer rejouer = new Rejouer(enregistreur);
		Coller coller = new Coller(moteur, enregistreur);
		Copier copier = new Copier(moteur, enregistreur);
		Couper couper = new Couper(moteur, enregistreur);
		Inserer inserer = new Inserer(moteur, ihm, enregistreur);
		Selectionner selectionner = new Selectionner(moteur, ihm, enregistreur);
		Save save = new Save(moteur, ihm);
		Ajouter ajouter = new Ajouter(moteur, ihm, enregistreur);
		Delete delete = new Delete(moteur, enregistreur);
		Load load = new Load(moteur, ihm);
		Scanner scanner = new Scanner(System.in);
		ihm = new Ihm(copier, coller, couper, inserer, selectionner, buffer, selection, scanner, save, ajouter, delete,
				load, demarrer, stopper, rejouer);

		Command select = new Selectionner(moteur, ihm, enregistreur);
		select.execute();

		assertFalse(selection.getDebut() >= selection.getFin());
		assertTrue(selection.getDebut() <= selection.getFin());
	}

	@Test
	public void testExecute3() {
		Buffer buffer = new Buffer();
		ClipBoard clip = new ClipboardImpl();
		Selection selection = new Selection();
		Ihm ihm = null;
		Moteur moteur = new MoteurImpl(buffer, clip, selection);
		Enregistreur enregistreur = new EnregistrerImpl();
		Demarrer demarrer = new Demarrer(enregistreur);
		Stopper stopper = new Stopper(enregistreur);
		Rejouer rejouer = new Rejouer(enregistreur);
		Coller coller = new Coller(moteur, enregistreur);
		Copier copier = new Copier(moteur, enregistreur);
		Couper couper = new Couper(moteur, enregistreur);
		Inserer inserer = new Inserer(moteur, ihm, enregistreur);
		Selectionner selectionner = new Selectionner(moteur, ihm, enregistreur);
		Save save = new Save(moteur, ihm);
		Ajouter ajouter = new Ajouter(moteur, ihm, enregistreur);
		Delete delete = new Delete(moteur, enregistreur);
		Load load = new Load(moteur, ihm);
		Scanner scanner = new Scanner(System.in);
		ihm = new Ihm(copier, coller, couper, inserer, selectionner, buffer, selection, scanner, save, ajouter, delete,
				load, demarrer, stopper, rejouer);

		Command select = new Selectionner(moteur, ihm, enregistreur);
		select.execute();

		assertTrue(selection.getDebut() <= selection.getFin());
		assertTrue(selection.getDebut() == selection.getFin());
		assertTrue(selection.getDebut() >= selection.getFin());
	}

	@Test
	public void testGetValues() {
		Buffer buffer = new Buffer();
		ClipBoard clip = new ClipboardImpl();
		Selection selection = new Selection();
		Ihm ihm = null;
		Moteur moteur = new MoteurImpl(buffer, clip, selection);
		Enregistreur enregistreur = new EnregistrerImpl();
		Demarrer demarrer = new Demarrer(enregistreur);
		Stopper stopper = new Stopper(enregistreur);
		Rejouer rejouer = new Rejouer(enregistreur);
		Coller coller = new Coller(moteur, enregistreur);
		Copier copier = new Copier(moteur, enregistreur);
		Couper couper = new Couper(moteur, enregistreur);
		Inserer inserer = new Inserer(moteur, ihm, enregistreur);
		Selectionner selectionner = new Selectionner(moteur, ihm, enregistreur);
		Save save = new Save(moteur, ihm);
		Ajouter ajouter = new Ajouter(moteur, ihm, enregistreur);
		Delete delete = new Delete(moteur, enregistreur);
		Load load = new Load(moteur, ihm);
		Scanner scanner = new Scanner(System.in);
		ihm = new Ihm(copier, coller, couper, inserer, selectionner, buffer, selection, scanner, save, ajouter, delete,
				load, demarrer, stopper, rejouer);

		Command select = new Selectionner(moteur, ihm, enregistreur);
		select.execute();

		assertNotEquals(selection.getDebut(), selection.getFin());
	}

}
