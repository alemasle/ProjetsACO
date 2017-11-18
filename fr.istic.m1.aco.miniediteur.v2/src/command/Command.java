package command;

import memento.Memento;

/**
 * Interface Command
 *
 * @author Alexis LE MASLE et Fanny PRIEUR
 */
public interface Command {

	/**
	 * Methodes communes a toutes les commandes implementant l'interface "Command"
	 */

	void execute();

	Memento<?> getMemento();

	void setReplay(boolean bool);

}
