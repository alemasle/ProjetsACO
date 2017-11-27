package receiverTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Test;

import command.Ajouter;
import command.Coller;

import command.Copier;
import command.Couper;
import command.Delete;
import command.Demarrer;
import command.Inserer;
import command.Load;
import command.Rejouer;
import command.Save;
import command.Selectionner;
import command.Stopper;
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
		Demarrer demarrer = new Demarrer(enregistreur);
		Stopper stopper = new Stopper(enregistreur);
		Rejouer rejouer = new Rejouer(enregistreur);
		Coller coller = new Coller(moteur,enregistreur);
		Copier copier = new Copier(moteur,enregistreur);
		Couper couper = new Couper(moteur,enregistreur);
		Inserer inserer = new Inserer(moteur, ihm,enregistreur);
		Selectionner selectionner = new Selectionner(moteur, ihm,enregistreur);
		Save save = new Save(moteur, ihm);
		Ajouter ajouter = new Ajouter(moteur, ihm, enregistreur);
		Delete delete = new Delete(moteur,enregistreur);
		Load load = new Load(moteur, ihm);

		Scanner scanner = new Scanner(System.in);

		ihm = new Ihm(copier, coller, couper, inserer, selectionner, buffer,
				selection, scanner,save, ajouter, delete, load,
				demarrer, stopper, rejouer);

		inserer.setIhm(ihm);
		selectionner.setIhm(ihm);
		save.setIhm(ihm);
		ajouter.setIhm(ihm);
		load.setIhm(ihm);
		String str = new String("insere");
		StringBuffer stringBuffer = new StringBuffer("abcdef");

		buffer.setBuffer(stringBuffer);
		
		enregistreur.demarrer();
		
		selection.setDebut(6);
		selection.setFin(6);
		System.out.println("Entrer le mot insere : \n");
		inserer.execute();
		
		enregistreur.stopper();
		enregistreur.rejouer();
		
		assertTrue(("abcdefinsereinsere").compareTo(buffer.getBuffer().toString()) == 0);

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
		Demarrer demarrer = new Demarrer(enregistreur);
		Stopper stopper = new Stopper(enregistreur);
		Rejouer rejouer = new Rejouer(enregistreur);
		Coller coller = new Coller(moteur,enregistreur);
		Copier copier = new Copier(moteur,enregistreur);
		Couper couper = new Couper(moteur,enregistreur);
		Inserer inserer = new Inserer(moteur, ihm,enregistreur);
		Selectionner selectionner = new Selectionner(moteur, ihm,enregistreur);
		Save save = new Save(moteur, ihm);
		Ajouter ajouter = new Ajouter(moteur, ihm, enregistreur);
		Delete delete = new Delete(moteur,enregistreur);
		Load load = new Load(moteur, ihm);

		Scanner scanner = new Scanner(System.in);

		ihm = new Ihm(copier, coller, couper, inserer, selectionner, buffer,
				selection, scanner,save, ajouter, delete, load,
				demarrer, stopper, rejouer);

	
		inserer.setIhm(ihm);
		selectionner.setIhm(ihm);
		save.setIhm(ihm);
		ajouter.setIhm(ihm);
		load.setIhm(ihm);
		
		
		inserer.execute();
		assertNotNull("La chaine n'est pas vide", str);
	}

	@Test
	public void testInserer3() {

		String str = new String("abcdef");
		StringBuffer stringBuffer = new StringBuffer("insere");
		
		Buffer buffer = new Buffer();
		ClipBoard clip = new ClipboardImpl();
		Selection selection = new Selection();
		Ihm ihm = null;

		Moteur moteur = new MoteurImpl(buffer, clip, selection);
		Enregistreur enregistreur = new EnregistrerImpl();
		Demarrer demarrer = new Demarrer(enregistreur);
		Stopper stopper = new Stopper(enregistreur);
		Rejouer rejouer = new Rejouer(enregistreur);
		Coller coller = new Coller(moteur,enregistreur);
		Copier copier = new Copier(moteur,enregistreur);
		Couper couper = new Couper(moteur,enregistreur);
		Inserer inserer = new Inserer(moteur, ihm,enregistreur);
		Selectionner selectionner = new Selectionner(moteur, ihm,enregistreur);
		Save save = new Save(moteur, ihm);
		Ajouter ajouter = new Ajouter(moteur, ihm, enregistreur);
		Delete delete = new Delete(moteur,enregistreur);
		Load load = new Load(moteur, ihm);

		Scanner scanner = new Scanner(System.in);

		ihm = new Ihm(copier, coller, couper, inserer, selectionner, buffer,
				selection, scanner,save, ajouter, delete, load,
				demarrer, stopper, rejouer);

		inserer.setIhm(ihm);
		selectionner.setIhm(ihm);
		save.setIhm(ihm);
		ajouter.setIhm(ihm);
		load.setIhm(ihm);

		buffer.setBuffer(stringBuffer);

		selection.setDebut(6);
		selection.setFin(11);
		moteur.ajouter(str);

		assertTrue(("insereabcdef").compareTo(buffer.getBuffer().toString()) == 0);

	}

	@Test
	public void testInserer4() {

		String str = new String("abcdef");
		StringBuffer stringBuffer = new StringBuffer("insere");
		
		Buffer buffer = new Buffer();
		ClipBoard clip = new ClipboardImpl();
		Selection selection = new Selection();
		Ihm ihm = null;

		Moteur moteur = new MoteurImpl(buffer, clip, selection);
		Enregistreur enregistreur = new EnregistrerImpl();
		Demarrer demarrer = new Demarrer(enregistreur);
		Stopper stopper = new Stopper(enregistreur);
		Rejouer rejouer = new Rejouer(enregistreur);
		Coller coller = new Coller(moteur,enregistreur);
		Copier copier = new Copier(moteur,enregistreur);
		Couper couper = new Couper(moteur,enregistreur);
		Inserer inserer = new Inserer(moteur, ihm,enregistreur);
		Selectionner selectionner = new Selectionner(moteur, ihm,enregistreur);
		Save save = new Save(moteur, ihm);
		Ajouter ajouter = new Ajouter(moteur, ihm, enregistreur);
		Delete delete = new Delete(moteur,enregistreur);
		Load load = new Load(moteur, ihm);

		Scanner scanner = new Scanner(System.in);

		ihm = new Ihm(copier, coller, couper, inserer, selectionner, buffer,
				selection, scanner,save, ajouter, delete, load,
				demarrer, stopper, rejouer);

		inserer.setIhm(ihm);
		selectionner.setIhm(ihm);
		save.setIhm(ihm);
		ajouter.setIhm(ihm);
		load.setIhm(ihm);

		buffer.setBuffer(stringBuffer);

		selection.setDebut(3);
		selection.setFin(3);

		moteur.ajouter(str);

		assertTrue(("insabcdefere").compareTo(buffer.getBuffer().toString()) == 0);

	}

	@Test
	public void testInserer5() {

		String str = new String("abcdef");
		StringBuffer stringBuffer = new StringBuffer("insere");
		
		Buffer buffer = new Buffer();
		ClipBoard clip = new ClipboardImpl();
		Selection selection = new Selection();
		Ihm ihm = null;

		Moteur moteur = new MoteurImpl(buffer, clip, selection);
		Enregistreur enregistreur = new EnregistrerImpl();
		Demarrer demarrer = new Demarrer(enregistreur);
		Stopper stopper = new Stopper(enregistreur);
		Rejouer rejouer = new Rejouer(enregistreur);
		Coller coller = new Coller(moteur,enregistreur);
		Copier copier = new Copier(moteur,enregistreur);
		Couper couper = new Couper(moteur,enregistreur);
		Inserer inserer = new Inserer(moteur, ihm,enregistreur);
		Selectionner selectionner = new Selectionner(moteur, ihm,enregistreur);
		Save save = new Save(moteur, ihm);
		Ajouter ajouter = new Ajouter(moteur, ihm, enregistreur);
		Delete delete = new Delete(moteur,enregistreur);
		Load load = new Load(moteur, ihm);

		Scanner scanner = new Scanner(System.in);

		ihm = new Ihm(copier, coller, couper, inserer, selectionner, buffer,
				selection, scanner,save, ajouter, delete, load,
				demarrer, stopper, rejouer);

		inserer.setIhm(ihm);
		selectionner.setIhm(ihm);
		save.setIhm(ihm);
		ajouter.setIhm(ihm);
		load.setIhm(ihm);

		buffer.setBuffer(stringBuffer);

		selection.setDebut(3);
		selection.setFin(6);

		moteur.ajouter(str);

		assertTrue(("insabcdef").compareTo(buffer.getBuffer().toString()) == 0);

	}

}
