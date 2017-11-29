package command;

import receiver.Manager;

/**
 * Classe Defaire implementant CommandGeneral
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 *
 */
public class Defaire implements CommandGeneral {

	/**
	 * Le manager de Defaire/refaire
	 */
	private Manager manager;

	/**
	 * Constructeur de la calsse Defaire
	 * 
	 * @param manager
	 */
	public Defaire(Manager manager) {
		this.manager = manager;
	}

	@Override
	public void execute() {
		manager.defaire();
	}

}
