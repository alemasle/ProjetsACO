package Command;

import Memento.Memento;

/**
 * Interface Command
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 * 
 * 
 */
public interface Command {
	/**
	 * 
	 * Methode commune a toutes les commandes implementant l'interface "Command"
	 * 
	 */

	public void execute();

	public Memento getMemento();

	public void setMemento(Memento m);

}
