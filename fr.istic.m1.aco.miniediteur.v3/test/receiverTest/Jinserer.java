package receiverTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Test;

import command.Ajouter;
import command.Coller;

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
 * Fichier Test Inserer
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 * 
 */

public class Jinserer {

	@Test
	public void testInserer1() {
		Buffer buffer = new Buffer();
		ClipBoard clip = new ClipboardImpl();
		Selection selection = new Selection();
		Ihm ihm = null;

		Moteur moteur = new MoteurImpl(buffer, clip, selection);
		Enregistreur enregistreur = new EnregistrerImpl();
		Manager manager = new ManagerImpl(moteur);
		Demarrer demarrer = new Demarrer(enregistreur);
		Stopper stopper = new Stopper(enregistreur);
		Rejouer rejouer = new Rejouer(enregistreur);
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

		System.out.println("Test1: Entrez le mot abcdef :\n");
		ajouter.execute();
		enregistreur.demarrer();
		
		selection.setDebut(6);
		selection.setFin(6);
		System.out.println("Test1: Entrez le mot insere : \n");
		inserer.execute();

		enregistreur.stopper();
		enregistreur.rejouer();
		System.out.println(buffer.getBuffer().toString());
		manager.defaire();
		System.out.println(buffer.getBuffer().toString());
		assertTrue(("abcdefinsere").compareTo(buffer.getBuffer().toString()) == 0);

	}

	@Test
	public void testInserer2() {

		String str = " ";

		Buffer buffer = new Buffer();
		ClipBoard clip = new ClipboardImpl();
		Selection selection = new Selection();
		Ihm ihm = null;

		Moteur moteur = new MoteurImpl(buffer, clip, selection);
		Enregistreur enregistreur = new EnregistrerImpl();
		Manager manager = new ManagerImpl(moteur);
		Demarrer demarrer = new Demarrer(enregistreur);
		Stopper stopper = new Stopper(enregistreur);
		Rejouer rejouer = new Rejouer(enregistreur);
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

		System.out.println("Test2: Veuillez entrer un texte: \n");
		inserer.execute();
		manager.defaire();
		manager.refaire();
		assertNotNull("La chaine n'est pas vide", str);
	}

	@Test
	public void testInserer3() {

		
		Buffer buffer = new Buffer();
		ClipBoard clip = new ClipboardImpl();
		Selection selection = new Selection();
		Ihm ihm = null;

		Moteur moteur = new MoteurImpl(buffer, clip, selection);
		Enregistreur enregistreur = new EnregistrerImpl();
		Manager manager = new ManagerImpl(moteur);
		Demarrer demarrer = new Demarrer(enregistreur);
		Stopper stopper = new Stopper(enregistreur);
		Rejouer rejouer = new Rejouer(enregistreur);
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

		System.out.println("Test3: Entrez le mot insere :\n");
		ajouter.execute();
		selection.setDebut(6);
		selection.setFin(11);
		System.out.println("Entrer abcdef: \n");
		ajouter.execute();
		System.out.println("Entrer abcdef: \n");
		ajouter.execute();
		
		manager.defaire();
		manager.defaire();
		manager.refaire();
		
		assertTrue(("insereabcdef").compareTo(buffer.getBuffer().toString()) == 0);

	}

	@Test
	public void testInserer4() {

		Buffer buffer = new Buffer();
		ClipBoard clip = new ClipboardImpl();
		Selection selection = new Selection();
		Ihm ihm = null;

		Moteur moteur = new MoteurImpl(buffer, clip, selection);
		Enregistreur enregistreur = new EnregistrerImpl();
		Manager manager = new ManagerImpl(moteur);
		Demarrer demarrer = new Demarrer(enregistreur);
		Stopper stopper = new Stopper(enregistreur);
		Rejouer rejouer = new Rejouer(enregistreur);
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

		System.out.println("Test4: Entrez le mot insere :\n");
		ajouter.execute();
		manager.refaire();
		manager.refaire();
		manager.defaire();
		manager.refaire();
		selection.setDebut(3);
		selection.setFin(3);
		System.out.println("Test4: Entrez le mot abcdef :\n");
		enregistreur.demarrer();
		ajouter.execute();
		enregistreur.stopper();
		
		System.out.println(buffer.getBuffer().toString());
		assertTrue(("insabcdefere").compareTo(buffer.getBuffer().toString()) == 0);

	}

	@Test
	public void testInserer5() {

		Buffer buffer = new Buffer();
		ClipBoard clip = new ClipboardImpl();
		Selection selection = new Selection();
		Ihm ihm = null;

		Moteur moteur = new MoteurImpl(buffer, clip, selection);
		Enregistreur enregistreur = new EnregistrerImpl();
		Manager manager = new ManagerImpl(moteur);
		Demarrer demarrer = new Demarrer(enregistreur);
		Stopper stopper = new Stopper(enregistreur);
		Rejouer rejouer = new Rejouer(enregistreur);
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

		System.out.println("Test5: Entrez le mot insere :\n");
		ajouter.execute();
		manager.defaire();
		manager.defaire();
		manager.refaire();
		selection.setDebut(3);
		selection.setFin(6);
		System.out.println("Test5: Entrez le mot abcdef :\n");
		ajouter.execute();
		
		
		assertTrue(("insabcdef").compareTo(buffer.getBuffer().toString()) == 0);

	}

}
