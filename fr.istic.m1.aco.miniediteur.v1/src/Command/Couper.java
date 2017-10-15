package Command;

import Memento.Memento;
import Receiver.Moteur;
import Receiver.MoteurImpl;

/**
 * Concrete Command "Couper" implementant l'interface Command
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 * 
 */
public class Couper implements Command {

	/**
	 * Nouvelle instance de l'interface Moteur declarant la methode couper
	 * 
	 * @see Moteur
	 */
	private Moteur moteur;

	private CouperMemento memento;

	/**
	 * Constructeur de la classe Couper
	 * 
	 * @param moteur
	 */
	public Couper(Moteur moteur) {
		this.moteur = moteur;
		this.memento = null;
	}

	// Operations

	/**
	 * Appel de la mise en oeuvre de la fonction "couper" dans l'implementation
	 * Moteur.
	 * 
	 * @see MoteurImpl
	 * 
	 */
	public void execute() {
		moteur.couper();
	}

	/**
	 * @return memento le memento courant
	 */
	public Memento getMemento() {
		return memento;
	}

	/**
	 * Met a jour le memento courant
	 */
	public void setMemento(Memento m) {
		this.memento = (CouperMemento) m;
	}

	/**
	 * Classe privee CouperMemento implementant Memento
	 * 
	 * @author Alexis LE MASLE et Fanny PRIEUR
	 *
	 */
	private class CouperMemento implements Memento {

	}

}