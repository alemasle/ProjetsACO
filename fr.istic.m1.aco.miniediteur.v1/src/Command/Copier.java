package Command;

import Memento.Memento;
import Receiver.Enregistreur;
import Receiver.Moteur;

/**
 * Concrete Command "Copier" implementant l'interface Command
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 * 
 */
public class Copier implements Command {

	/**
	 * Nouvelle instance de l'interface Moteur declarant la methode copier
	 * 
	 * @see Moteur
	 */
	private Moteur moteur;

	private Enregistreur enregistreur;

	/**
	 * Nouveau Memento
	 */
	private Memento<CopierMemento> memento;

	public Copier(Moteur moteur, Enregistreur enregistreur) {
		this.moteur = moteur;
		this.memento = null;
		this.setEnregistreur(enregistreur);
	}
	// Operations

	/**
	 * Appel de la mise en oeuvre de la fonction "copier" dans l'implementation
	 * Moteur.
	 * 
	 * @see MoteurImpl
	 * 
	 */
	public void execute() {
		moteur.copier();
	}

	/**
	 * Classe privee CopierMemento implementant Memento
	 * 
	 * @author Alexis LE MASLE et Fanny PRIEUR
	 *
	 */
	public class CopierMemento implements Memento<CopierMemento> {

		private Command command = new Copier(moteur, enregistreur);

		public Command getCommand() {
			return command;
		}

	}

	/**
	 * @return memento le memento courant
	 */
	public Memento<CopierMemento> getMemento() {
		return memento;
	}

	/**
	 * Met a jour le memento courant
	 */
	public void setMemento(Memento m) {
		this.memento = m;
	}

	/**
	 * @return le enregistreur
	 */
	public Enregistreur getEnregistreur() {
		return enregistreur;
	}

	/**
	 * @param enregistreur
	 *            le enregistreur à définir
	 */
	public void setEnregistreur(Enregistreur enregistreur) {
		this.enregistreur = enregistreur;
	}

}
