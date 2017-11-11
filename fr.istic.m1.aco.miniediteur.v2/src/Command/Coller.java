package Command;

import Memento.*;
import Receiver.*;

/**
 * Concrete Command "Coller" implementant l'interface Command.
 *
 * @author Alexis LE MASLE et Fanny PRIEUR
 */
public class Coller implements Command {

	/**
	 * Nouvelle instance de l'interface Moteur declarant la methode coller
	 *
	 * @see Moteur
	 */
	private Moteur moteur;

	private Enregistreur enregistreur;

	/**
	 * Nouveau memento
	 */
	private Memento<CollerMemento> memento;

	/**
	 * Constructeur de la classe Coller
	 *
	 * @param moteur
	 *            le moteur
	 * @param enregistreur
	 *            l'enregistreur
	 */
	public Coller(Moteur moteur, Enregistreur enregistreur) {
		this.moteur = moteur;
		this.memento = null;
		this.enregistreur = enregistreur;
	}

	/**
	 * Appel de la mise en oeuvre de la fonction "coller" dans l'implementation
	 * Moteur.
	 *
	 * @see MoteurImpl
	 */
	public void execute() {
		if (enregistreur.getRecord()) {
			enregistreur.addMemento(getMemento());
		}
		moteur.coller();
	}

	/**
	 * @return memento le memento courant
	 */
	public Memento<CollerMemento> getMemento() {
		setMemento(new CollerMemento());
		return memento;
	}

	/**
	 * Met a jour le Memento courant
	 */
	public void setMemento(Memento m) {
		this.memento = m;
	}

	/**
	 * Classe privee CollerMemento implementant Memento
	 *
	 * @author Alexis LE MASLE et Fanny PRIEUR
	 */
	public class CollerMemento implements Memento<CollerMemento> {

		private Command memCommand;

		private CollerMemento() {
			this.memCommand = new Coller(moteur, enregistreur);
		}

		public Command getCommand() {
			return memCommand;
		}

	}

}
