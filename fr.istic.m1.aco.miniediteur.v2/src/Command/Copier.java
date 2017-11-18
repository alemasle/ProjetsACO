package command;

import memento.Memento;
import receiver.Enregistreur;
import receiver.Moteur;
import receiver.MoteurImpl;

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

	private boolean replay = false;

	public Copier(Moteur moteur, Enregistreur enregistreur) {
		this.moteur = moteur;
		this.enregistreur = enregistreur;
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
		if (enregistreur.getRecord()) {
			enregistreur.addMemento(getMemento());
		}
	}

	@Override
	public CopierMemento getMemento() {
		return new CopierMemento(new Copier(moteur, enregistreur));
	}

	@Override
	public void setReplay(boolean bool) {
		this.replay = bool;
	}

	private class CopierMemento implements Memento<CopierMemento> {

		Copier cmd;

		public CopierMemento(Copier cmd) {
			this.cmd = cmd;
		}

		@Override
		public Command getCommand() {
			return cmd;
		}

	}
}
