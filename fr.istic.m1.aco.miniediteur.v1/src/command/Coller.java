package command;

import receiver.Moteur;
import receiver.MoteurImpl;

/**
 * Concrete Command "Coller" implementant l'interface Command.
 *
 * @author Alexis LE MASLE et Fanny PRIEUR
 */
public class Coller implements Command {

	/**
	 * Nouvelle instance de l'interface Moteur declarant la methode coller
	 *
	 * @see Moteur
	 */
	private Moteur moteur;

	/**
	 * Constructeur de la classe Coller
	 * 
	 * @param moteur
	 */
	public Coller(Moteur moteur) {
		this.moteur = moteur;
	}

	/**
	 * Appel de la mise en oeuvre de la fonction "coller" dans l'implementation
	 * Moteur.
	 *
	 * @see MoteurImpl
	 */
	@Override
	public void execute() {
		moteur.coller();
	}

}
