package receiverTest;

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
import receiver.Manager;
import receiver.ManagerImpl;
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

	/**
	 * 
	 * Genere 10000 selections differentes aleatoirement et test si les bornes sont
	 * conformes aux attentes
	 * 
	 */
	@Test
	public void testExecute1() {

		StringBuffer str = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
		Buffer buffer = new Buffer();
		ClipBoard clip = new ClipboardImpl();
		Selection selection = new Selection();
		Ihm ihm = null;
		Moteur moteur = new MoteurImpl(buffer, clip, selection);
		Manager manager = new ManagerImpl(moteur);
		Enregistreur enregistreur = new EnregistrerImpl();
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

		Command select = new Selectionner(moteur, ihm, enregistreur, manager);

		buffer.setBuffer(str);

		SelectionnerMemento selmem = null;
		int deb = 0;
		int fin = 0;
		Random rn = null;

		for (int i = 0; i < 10000; i++) {
			rn = new Random();
			deb = rn.nextInt(1000) - 500;
			fin = rn.nextInt(1000) - 500;

			selmem = (SelectionnerMemento) select.getMemento();
			selmem.setDeb(deb);
			selmem.setFin(fin);
			select.setMemento(selmem);
			enregistreur.setPlay(true);
			select.execute();
			enregistreur.setPlay(false);

			int debut = selection.getDebut();
			int fi = selection.getFin();
			int len = buffer.getBuffer().length();

			assertTrue(debut <= fi);
			assertTrue(debut >= 0 && debut <= len);
			assertTrue(fi >= 0 && fi <= len);
		}
	}

}
