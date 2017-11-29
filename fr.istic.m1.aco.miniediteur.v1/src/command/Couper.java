package command;

import receiver.Moteur;
import receiver.MoteurImpl;

/**
 * Concrete Command "Couper" implementant l'interface Command
 *
 * @author Alexis LE MASLE et Fanny PRIEUR
 */
public class Couper implements Command {

	/**
	 * Nouvelle instance de l'interface Moteur declarant la methode couper
	 *
	 * @see Moteur
	 */
	private Moteur moteur;

	/**
	 * Constructeur de la classe Couper
	 *
	 * @param moteur
	 */
	public Couper(Moteur moteur) {
		this.moteur = moteur;
	}

	// Operations

	/**
	 * Appel de la mise en oeuvre de la fonction "couper" dans l'implementation
	 * Moteur.
	 *
	 * @see MoteurImpl
	 */
	@Override
	public void execute() {
		moteur.couper();
	}

}
