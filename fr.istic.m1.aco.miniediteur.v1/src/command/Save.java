package command;

import ihm.Ihm;
import receiver.Moteur;
import receiver.MoteurImpl;

/**
 * Concrete Command "Save" implementant l'interface Command
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 * 
 */
public class Save implements Command {

	/**
	 * Nouvelle instance de l'interface Moteur declarant la methode selectionner
	 * 
	 * @see Moteur
	 */
	private Moteur moteur;

	private Ihm ihm;

	/**
	 * Constructeur de la classe Save
	 * 
	 * @param moteur
	 * @param ihm
	 */
	public Save(Moteur moteur, Ihm ihm) {
		this.moteur = moteur;
		this.ihm = ihm;
	}

	// Operations

	/**
	 * Appel de la mise en oeuvre de la fonction "save" dans l'implementation
	 * Moteur.
	 * 
	 * @see MoteurImpl
	 * 
	 */
	@Override
	public void execute() {
		String filename = ihm.getFile();
		try {
			moteur.save(filename);
		} catch (Exception e) {
			System.out.println("Error during file saving. ");
		}
	}

	public void setIhm(Ihm ihm) {
		this.ihm = ihm;
	}

}
