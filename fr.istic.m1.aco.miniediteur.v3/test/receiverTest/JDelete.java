package receiverTest;

import static org.junit.Assert.*;

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

public class JDelete {

	@Test
	public void testJDelete1() {

	
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
		
		System.out.println("Entrer le mot: delete ");
		ajouter.execute();
		
		selection.setDebut(6);
		selection.setFin(6);

		enregistreur.demarrer();
		delete.execute();
		enregistreur.stopper();

		selection.setDebut(2);
		selection.setFin(3);
		rejouer.execute();
		
		manager.defaire();
		assertTrue(("delet").compareTo(buffer.getBuffer().toString()) == 0);
	
		manager.refaire();
		assertTrue(("dele").compareTo(buffer.getBuffer().toString()) == 0);
	}

	@Test
	public void testJDelete2() {

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
		
		System.out.println("Entrer le mot: delete ");
		ajouter.execute();
		selection.setDebut(0);
		selection.setFin(2);

		selection.setDebut(6);
		selection.setFin(6);

		enregistreur.demarrer();

		delete.execute();

		enregistreur.stopper();
		
		manager.defaire();
		
		rejouer.execute();
		rejouer.execute();
		rejouer.execute();
		
		assertTrue(("del").compareTo(buffer.getBuffer().toString()) == 0);
	}

	@Test
	public void testJDelete3() {

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
		
		System.out.println("Entrer le mot: deleteDELETE ");
		ajouter.execute();

		selection.setDebut(4);
		selection.setFin(7);
		delete.execute();
		selection.setDebut(4);
		selection.setFin(7);
		delete.execute();
		manager.defaire();
		manager.defaire();
		manager.refaire();
		manager.refaire();

		assertTrue(("deleteDELE").compareTo(buffer.getBuffer().toString()) == 0);
	}

}
