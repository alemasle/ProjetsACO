package command;

import receiver.Manager;

/**
 * Classe Refaire implementant CommandGeneral
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 *
 */
public class Refaire implements CommandGeneral {

	/**
	 * Le manager de defaire/refaire
	 */
	private Manager manager;

	/**
	 * Constructeur de la classe Refaire
	 * 
	 * @param manager
	 */
	public Refaire(Manager manager) {
		this.manager = manager;
	}

	@Override
	public void execute() {
		manager.refaire();
	}

}
