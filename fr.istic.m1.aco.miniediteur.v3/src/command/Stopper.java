package command;

import receiver.Enregistreur;

/**
 * Concrete Command "Stopper" implementant Command
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 *
 */
public class Stopper implements CommandGeneral {

	/**
	 * Nouvelle Instance d'enregistreur declarant la methode stopper
	 * 
	 * @see Enregistreur
	 */
	private Enregistreur enregistreur;

	/**
	 * Constructeur de la classe Stopper
	 * 
	 * @param enregistreur
	 */
	public Stopper(Enregistreur enregistreur) {
		this.enregistreur = enregistreur;
	}

	/**
	 * Appel de la methode stopper de l'enregistreur
	 */
	@Override
	public void execute() {
		enregistreur.stopper();
	}

}
