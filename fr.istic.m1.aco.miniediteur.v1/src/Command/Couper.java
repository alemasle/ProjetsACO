package Command;

import Memento.Memento;
import Receiver.Enregistreur;
import Receiver.Moteur;
import Receiver.MoteurImpl;

/**
 * Concrete Command "Couper" implementant l'interface Command
 *
 * @author Alexis LE MASLE et Fanny PRIEUR
 */
public class Couper implements Command {

	/**
	 * Nouvelle instance de l'interface Moteur declarant la methode couper
	 *
	 * @see Moteur
	 */
	private Moteur moteur;

	private Enregistreur enregistreur;

	private Memento<CouperMemento> memento;

	/**
	 * Constructeur de la classe Couper
	 *
	 * @param moteur
	 */
	public Couper(Moteur moteur, Enregistreur enregistreur) {
		this.moteur = moteur;
		this.memento = null;
		this.enregistreur = enregistreur;
	}

	// Operations

	/**
	 * Appel de la mise en oeuvre de la fonction "couper" dans l'implementation
	 * Moteur.
	 *
	 * @see MoteurImpl
	 */
	public void execute() {
		moteur.couper();
	}

	/**
	 * @return memento le memento courant
	 */
	public Memento<CouperMemento> getMemento() {
		return memento;
	}

	/**
	 * Met a jour le memento courant
	 */
	public void setMemento(Memento m) {
		this.memento = m;
	}

	public Enregistreur getEnregistreur() {
		return enregistreur;
	}

	public void setEnregistreur(Enregistreur enregistreur) {
		this.enregistreur = enregistreur;
	}

	/**
	 * Classe privee CouperMemento implementant Memento
	 *
	 * @author Alexis LE MASLE et Fanny PRIEUR
	 */
	public class CouperMemento implements Memento<CouperMemento> {

		private Command memCommand;

		private CouperMemento() {
			this.memCommand = new Couper(moteur, enregistreur);
		}

		public Command getCommand() {
			return memCommand;
		}
	}

}
