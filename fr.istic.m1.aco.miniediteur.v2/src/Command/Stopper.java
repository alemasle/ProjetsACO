package Command;

import Memento.Memento;
import Receiver.Enregistreur;

/**
 * Concrete Command "Stopper" implementant Command
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 *
 */
public class Stopper implements Command {

	/**
	 * Nouvelle Instance d'enregistreur declarant la methode stopper
	 * 
	 * @see Enregistreur
	 */
	private Enregistreur enregistreur;

	/**
	 * Nouveau memento
	 */
	private Memento<StopperMemento> memento;

	/**
	 * Constructeur de la classe Stopper
	 * 
	 * @param enregistreur
	 */
	public Stopper(Enregistreur enregistreur) {
		this.enregistreur = enregistreur;
		this.memento = null;
	}

	/**
	 * Appel de la methode stopper de l'enregistreur
	 */
	public void execute() {
		enregistreur.stopper();

	}

	/**
	 * @return memento le memento courant
	 */
	public Memento<StopperMemento> getMemento() {
		return memento;
	}

	/**
	 * Met a jour le memento courant
	 */
	public void setMemento(Memento m) {
		this.memento = m;
	}

	/**
	 * Classe privee StopperMemento implementant Memento
	 * 
	 * @author Alexis LE MASLE et Fanny PRIEUR
	 *
	 */
	private class StopperMemento implements Memento<StopperMemento> {

		private Command command = new Stopper(enregistreur);

		public Command getCommand() {
			return command;
		}

	}

}
