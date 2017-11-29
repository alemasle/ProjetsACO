package command;

import ihm.Ihm;
import receiver.Moteur;
import receiver.MoteurImpl;

/**
 * Concrete Command "Load" implementant l'interface Command
 *
 * @since 1.1
 * @author Alexis LE MASLE et Fanny PRIEUR
 */
public class Load implements Command {

	/**
	 * Nouvelle instance de l'interface Moteur declarant la methode load
	 *
	 * @see Moteur
	 */
	private Moteur moteur;

	/**
	 * Ihm permettant d'obtenir le nom de fichier a charger
	 */
	private Ihm ihm;

	/**
	 * Constructeur de la classe Load
	 * 
	 * @param moteur
	 * @param ihm
	 */
	public Load(Moteur moteur, Ihm ihm) {
		this.moteur = moteur;
		this.ihm = ihm;
	}

	// Operations

	/**
	 * Appel de la mise en oeuvre de la fonction "load" dans l'implementation
	 * Moteur.
	 *
	 * @see MoteurImpl
	 */
	@Override
	public void execute() {
		String filename = ihm.getFile();
		try {
			moteur.load(filename);
		} catch (Exception e) {
			System.out.println("Error during loading file");
		}
	}

	public void setIhm(Ihm ihm) {
		this.ihm = ihm;
	}

}
