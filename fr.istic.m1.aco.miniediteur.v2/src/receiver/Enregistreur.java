package receiver;

import command.Command;
import memento.Memento;

/**
 * Interface Enregistreur
 *
 * @since v2
 * @author Alexis LE MASLE et Fanny PRIEUR
 */
public interface Enregistreur {

	/**
	 * Methode demarrer commune a tous les enregistreurs Permet de demarrer
	 * l'enregistrement.
	 */
	void demarrer();

	/**
	 * Methode permettant de stopper l'enregistrement en cours.
	 */
	void stopper();

	/**
	 * Metohde permettant de rejouer le dernier enregistrement.
	 */
	void rejouer();

	boolean getRecord();

	void addMemento(Memento<?> m);

	void addCommand(Command cmd);

	boolean getPlay();

	void setPlay(boolean play);

}
