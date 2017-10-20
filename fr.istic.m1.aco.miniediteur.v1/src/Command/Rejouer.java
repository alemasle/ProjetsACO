package Command;

import Memento.Memento;
import Receiver.Enregistreur;

/**
 * Concrete Command Rejouer implementant l'interface Command
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 *
 */
public class Rejouer implements Command {

	/**
	 * Nouvelle instance de l'enregistreur
	 * 
	 * @see Enregistreur
	 */
	private Enregistreur enregistreur;

	/**
	 * Nouveau Memento
	 */
	private Memento<RejouerMemento> memento;

	/**
	 * Constructeur de la classe Rejouer
	 * 
	 * @param enregistreur
	 */
	public Rejouer(Enregistreur enregistreur) {
		this.enregistreur = enregistreur;
		this.memento = null;
	}

	/**
	 * Appel a la methode rejouer de l'enregistreur.
	 */
	public void execute() {
		enregistreur.rejouer();

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
		this.memento = m;
	}

	/**
	 * Classe privee RejouerMemento implementant Memento
	 * 
	 * @author Alexis LE MASLE et Fanny PRIEUR
	 *
	 */
	private class RejouerMemento implements Memento {

	}

}
