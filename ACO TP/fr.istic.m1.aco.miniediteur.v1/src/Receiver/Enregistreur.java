package Receiver;

/**
 * 
 * Interface Enregistreur
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 *
 */
public interface Enregistreur {

	/**
	 * Methode demarrer commune a tous les enregistreurs Permet de demarrer
	 * l'enregistrement.
	 */
	public void demarrer();

	/**
	 * Methode permettant de stopper l'enregistrement en cours.
	 */
	public void stopper();

	/**
	 * Metohde permettant de rejouer le dernier enregistrement.
	 */
	public void rejouer();

}
