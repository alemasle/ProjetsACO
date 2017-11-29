package command;

import receiver.Moteur;
import receiver.MoteurImpl;

/**
 * Concrete Command "Delete" implementant l'interface Command
 *
 * @since 1.1
 * @author Alexis LE MASLE et Fanny PRIEUR
 */
public class Delete implements Command {

	/**
	 * Nouvelle instance de l'interface Moteur declarant la methode delete
	 *
	 * @see Moteur
	 */
	private Moteur moteur;

	/**
	 * Constructeur de la classe Delete
	 *
	 * @param moteur
	 */
	public Delete(Moteur moteur) {
		this.moteur = moteur;
	}

	// Operations

	/**
	 * Appel de la mise en oeuvre de la fonction "delete" dans l'implementation
	 * Moteur.
	 *
	 * @see MoteurImpl
	 */
	@Override
	public void execute() {
		moteur.delete();
	}

}
