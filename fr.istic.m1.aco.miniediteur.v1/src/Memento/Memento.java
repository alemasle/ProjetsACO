package Memento;

import Command.Command;

/**
 * Interface Memento
 *
 * @author Alexis LE MASLE et Fanny PRIEUR
 */
public interface Memento<T> {

    Command getCommand();

}
