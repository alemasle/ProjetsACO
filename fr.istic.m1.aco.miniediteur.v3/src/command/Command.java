package command;

import memento.Memento;
import receiver.Moteur;

/**
 * Interface Command implementant CommandGeneral, l'interface des classes ayant
 * un memento.
 *
 * @author Alexis LE MASLE et Fanny PRIEUR
 */
public interface Command extends CommandGeneral {

	/**
	 * Methodes communes a toutes les commandes implementant l'interface "Command"
	 */

	Memento<?> getMemento();

	void setMemento(Memento<?> mem);

	void setMoteur(Moteur moteur);

	Moteur getMoteur();

	Command clone();

}
