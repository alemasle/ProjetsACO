package receiverTest;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

import command.Ajouter;
import command.Coller;
import command.Command;
import command.Copier;
import command.Couper;
import command.Delete;
import command.Inserer;
import command.Load;
import command.Save;
import command.Selectionner;
import ihm.Ihm;
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
		
		selectionner.execute();

		assertTrue(selection.getDebut() <= selection.getFin());
		assertFalse(selection.getDebut() > selection.getFin());
	}

	@Test
	public void testExecute2() {

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


		selectionner.execute();

		assertFalse(selection.getDebut() > selection.getFin());
		assertTrue(selection.getDebut() <= selection.getFin());
	}

	@Test
	public void testExecute3() {

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
	
		
		selectionner.execute();

		assertTrue(selection.getDebut() == selection.getFin());
	
	}

	@Test
	public void testGetValues() {
		StringBuffer stringBuffer = new StringBuffer("couper");
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

		selectionner.execute();

		if(selection.getDebut() > buffer.getBuffer().length()) {
			assertNotEquals(selection.getDebut(), selection.getFin());
		}
	}
	
}
