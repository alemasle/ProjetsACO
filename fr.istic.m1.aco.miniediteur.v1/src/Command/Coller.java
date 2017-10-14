package Command;

import Memento.Memento;
import Receiver.Moteur;
import Receiver.MoteurImpl;

/**
 * Concrete Command "Coller" implementant l'interface Command.
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 * 
 */
public class Coller implements Command {

	/**
	 * Nouvelle instance de l'interface Moteur declarant la methode coller
	 * 
	 * @see Moteur
	 */
	private Moteur moteur;

	/**
	 * Nouveau memento
	 */
	private CollerMemento memento;

	/**
	 * Constructeur de la classe Coller
	 * 
	 * @param moteur
	 */
	public Coller(Moteur moteur) {
		this.moteur = moteur;
		this.memento = null;
	}

	// Operations

	/**
	 * Appel de la mise en oeuvre de la fonction "coller" dans l'implementation
	 * Moteur.
	 * 
	 * @see MoteurImpl
	 * 
	 */
	public void execute() {
		moteur.coller();
	}

	/**
	 * @return memento le memento cournat
	 */
	public Memento getMemento() {
		return memento;
	}

	/**
	 * met a jour le Memento courant
	 */
	public void setMemento(Memento m) {
		this.memento = (CollerMemento) m;
	}

	/**
	 * Classe privee CollerMemento implementant Memento
	 * 
	 * @author Alexis LE MASLE et Fanny PRIEUR
	 *
	 */
	private class CollerMemento implements Memento {

	}

}
