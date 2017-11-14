package memento;

import command.Command;

/**
 * Class Memento
 *
 * @author Alexis LE MASLE et Fanny PRIEUR
 */
public class Memento {

	private Command cmd;

	public Memento(Command cmd) {
		this.cmd = cmd;
	}

	public Command getCommand() {
		return cmd;
	}

}
