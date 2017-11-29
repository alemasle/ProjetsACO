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

	/**
	 * Permet d'ajouter un memento a la liste des mementos de l'enregistreur
	 * 
	 * @param m
	 */
	void addMemento(Memento<?> m);

	/**
	 * Permet d'ajouter une commande a la liste des commandes de l'enregistreur
	 * 
	 * @param cmd
	 */
	void addCommand(Command cmd);

	boolean getPlay();

	void setPlay(boolean play);

}
