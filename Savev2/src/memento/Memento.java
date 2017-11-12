package memento;

import command.Command;

/**
 * Interface Memento
 *
 * @author Alexis LE MASLE et Fanny PRIEUR
 */
public interface Memento<T> {

	Command getCommand();

}
