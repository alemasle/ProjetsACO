package command;

import memento.Memento;
import receiver.Enregistreur;
import receiver.Moteur;
import receiver.MoteurImpl;

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

	private boolean replay = false;

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
		this.enregistreur = enregistreur;
	}

	/**
	 * Appel de la mise en oeuvre de la fonction "coller" dans l'implementation
	 * Moteur.
	 *
	 * @see MoteurImpl
	 */
	public void execute() {
		moteur.coller();
		if (enregistreur.getRecord()) {
			enregistreur.addMemento(getMemento());
		}
	}

	@Override
	public CollerMemento getMemento() {
		return new CollerMemento(new Coller(moteur, enregistreur));
	}

	@Override
	public void setReplay(boolean bool) {
		this.replay = bool;
	}

	private class CollerMemento implements Memento<CollerMemento> {

		Coller cmd;

		public CollerMemento(Coller cmd) {
			this.cmd = cmd;
		}

		@Override
		public Command getCommand() {
			return cmd;
		}

	}

}
