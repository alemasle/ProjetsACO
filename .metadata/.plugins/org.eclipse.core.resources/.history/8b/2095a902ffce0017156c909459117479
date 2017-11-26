package main;

import java.util.Scanner;

import command.*;
import ihm.Ihm;
import receiver.EnregistrerImpl;
import receiver.Enregistreur;
import receiver.Moteur;
import receiver.MoteurImpl;
import state.Buffer;
import state.ClipBoard;
import state.ClipboardImpl;
import state.Selection;

public class Main {

	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		ClipBoard clip = new ClipboardImpl();
		Selection selection = new Selection();
		Ihm ihm = null;

		Moteur moteur = new MoteurImpl(buffer, clip, selection);
		Enregistreur enregistreur = new EnregistrerImpl();

		Coller coller = new Coller(moteur, enregistreur);
		Copier copier = new Copier(moteur, enregistreur);
		Couper couper = new Couper(moteur, enregistreur);
		Inserer inserer = new Inserer(moteur, ihm, enregistreur);
		Selectionner selectionner = new Selectionner(moteur, ihm, enregistreur);
		Save save = new Save(moteur, ihm);
		Ajouter ajouter = new Ajouter(moteur, ihm, enregistreur);
		Delete delete = new Delete(moteur, enregistreur);
		Load load = new Load(moteur, ihm);
		Demarrer demarrer = new Demarrer(enregistreur);
		Stopper stopper = new Stopper(enregistreur);
		Rejouer rejouer = new Rejouer(enregistreur);

		Scanner input = new Scanner(System.in);

		ihm = new Ihm(copier, coller, couper, inserer, selectionner, buffer, selection, input, save, ajouter, delete,
				load, demarrer, stopper, rejouer);

		inserer.setIhm(ihm);
		selectionner.setIhm(ihm);
		save.setIhm(ihm);
		ajouter.setIhm(ihm);
		load.setIhm(ihm);

		ihm.executeCommand();

	}

}
