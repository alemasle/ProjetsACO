package command;

import receiver.Enregistreur;

/**
 * Concrete Command Rejouer implementant l'interface CommandGeneral
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 *
 */
public class Rejouer implements CommandGeneral {

	/**
	 * Nouvelle instance de l'enregistreur
	 * 
	 * @see Enregistreur
	 */
	private Enregistreur enregistreur;

	/**
	 * Constructeur de la classe Rejouer
	 * 
	 * @param enregistreur
	 */
	public Rejouer(Enregistreur enregistreur) {
		this.enregistreur = enregistreur;
	}

	/**
	 * Appel a la methode rejouer de l'enregistreur.
	 */
	@Override
	public void execute() {
		enregistreur.rejouer();

	}

}
