package Command;

import Memento.Memento;
import Receiver.Enregistreur;

/**
 * 
 * Concrete Command "Demarrer" implementant l'interface Command
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 *
 */
public class Demarrer implements Command {

	/**
	 * Nouvelle instance de l'interface Enregistreur permettant l'acces aux
	 * methodes de l'enregistreur.
	 * 
	 * @see Enregistreur
	 */
	private Enregistreur enregistreur;

	/**
	 * Instance de la classe privee DemarrerMemento
	 */
	private Memento<DemarrerMemento> mem;

	/**
	 * Constructeur de la classe Demarrer initialisant les attributs
	 * 
	 * @param enregistreur
	 */
	public Demarrer(Enregistreur enregistreur) {
		this.enregistreur = enregistreur;
		this.mem = null;
	}

	/**
	 * Classe privee implementant l'interface Memento
	 * 
	 * 
	 * @author Alexis LE MASLE et Fanny PRIEUR
	 *
	 */
	private class DemarrerMemento implements Memento {

	}

	/**
	 * Methode execute appelant la methode demarrer() de l'enregistreur
	 */
	public void execute() {
		enregistreur.demarrer();
	}

	/**
	 * @return mem le memento courant
	 */
	public Memento getMemento() {
		return mem;
	}

	/**
	 * @param m
	 *            le nouveau Memento
	 */
	public void setMemento(Memento m) {
		this.mem = m;

	}

}
