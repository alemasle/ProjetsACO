package receiverTest;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

import command.*;
import receiver.Moteur;
import receiver.MoteurImpl;
import state.Buffer;
import state.ClipBoard;
import state.ClipboardImpl;
import state.Selection;
import ihm.Ihm;

/**
 * Fichier Test Inserer
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 * 
 */

public class Jinserer {

	@Test
	public void testGetInserer() {
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);

		String str = "InsererTest";
		moteur.inserer(str);
		assertEquals("Contenu different � l'appel de getTexte()", buffer.getBuffer().toString(), str);
	}

	@Test
	public void testInserer1() {
		Buffer buffer = new Buffer();
		ClipBoard clip = new ClipboardImpl();
		Selection selection = new Selection();
		Ihm ihm = null;

		Moteur moteur = new MoteurImpl(buffer, clip, selection);

		Coller coller = new Coller(moteur);
		Copier copier = new Copier(moteur);
		Couper couper = new Couper(moteur);
		Inserer inserer = new Inserer(moteur, ihm);
		Selectionner selectionner = new Selectionner(moteur, ihm);
		Save save = new Save(moteur, ihm);
		Ajouter ajouter = new Ajouter(moteur, ihm);
		Delete delete = new Delete(moteur);
		Load load = new Load(moteur, ihm);

		Scanner input = new Scanner(System.in);

		ihm = new Ihm(copier, coller, couper, inserer, selectionner, buffer, selection, input, save, ajouter, delete,
				load);

		inserer.setIhm(ihm);
		selectionner.setIhm(ihm);
		save.setIhm(ihm);
		ajouter.setIhm(ihm);
		load.setIhm(ihm);
		String str = new String("insere");
		StringBuffer stringBuffer = new StringBuffer("abcdef");

		buffer.setBuffer(stringBuffer);

		selection.setDebut(6);
		selection.setFin(6);
		moteur.inserer(str);

		assertTrue(("abcdefinsere").compareTo(buffer.getBuffer().toString()) == 0);

	}

	@Test
	public void testInserer2() {
		String str = new String("abcdef");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();

		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);

		Ihm ihm = null;

		Coller coller = new Coller(moteur);
		Copier copier = new Copier(moteur);
		Couper couper = new Couper(moteur);
		Inserer inserer = new Inserer(moteur, ihm);
		Selectionner selectionner = new Selectionner(moteur, ihm);
		Save save = new Save(moteur, ihm);
		Ajouter ajouter = new Ajouter(moteur, ihm);
		Delete delete = new Delete(moteur);
		Load load = new Load(moteur, ihm);

		Scanner input = new Scanner(System.in);

		ihm = new Ihm(copier, coller, couper, inserer, selectionner, buffer, selection, input, save, ajouter, delete,
				load);

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
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();

		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);

		Ihm ihm = null;

		Coller coller = new Coller(moteur);
		Copier copier = new Copier(moteur);
		Couper couper = new Couper(moteur);
		Inserer inserer = new Inserer(moteur, ihm);
		Selectionner selectionner = new Selectionner(moteur, ihm);
		Save save = new Save(moteur, ihm);
		Ajouter ajouter = new Ajouter(moteur, ihm);
		Delete delete = new Delete(moteur);
		Load load = new Load(moteur, ihm);

		Scanner input = new Scanner(System.in);

		ihm = new Ihm(copier, coller, couper, inserer, selectionner, buffer, selection, input, save, ajouter, delete,
				load);

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
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();

		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);

		Ihm ihm = null;

		Coller coller = new Coller(moteur);
		Copier copier = new Copier(moteur);
		Couper couper = new Couper(moteur);
		Inserer inserer = new Inserer(moteur, ihm);
		Selectionner selectionner = new Selectionner(moteur, ihm);
		Save save = new Save(moteur, ihm);
		Ajouter ajouter = new Ajouter(moteur, ihm);
		Delete delete = new Delete(moteur);
		Load load = new Load(moteur, ihm);

		Scanner input = new Scanner(System.in);

		ihm = new Ihm(copier, coller, couper, inserer, selectionner, buffer, selection, input, save, ajouter, delete,
				load);

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
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();

		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);

		Ihm ihm = null;

		Coller coller = new Coller(moteur);
		Copier copier = new Copier(moteur);
		Couper couper = new Couper(moteur);
		Inserer inserer = new Inserer(moteur, ihm);
		Selectionner selectionner = new Selectionner(moteur, ihm);
		Save save = new Save(moteur, ihm);
		Ajouter ajouter = new Ajouter(moteur, ihm);
		Delete delete = new Delete(moteur);
		Load load = new Load(moteur, ihm);

		Scanner input = new Scanner(System.in);

		ihm = new Ihm(copier, coller, couper, inserer, selectionner, buffer, selection, input, save, ajouter, delete,
				load);

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
