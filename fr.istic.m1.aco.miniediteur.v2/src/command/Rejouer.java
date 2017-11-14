package command;

import memento.Memento;
import receiver.Enregistreur;
import receiver.Moteur;

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

	private Moteur moteur;

	private boolean replay = false;

	/**
	 * Constructeur de la classe Rejouer
	 * 
	 * @param enregistreur
	 */
	public Rejouer(Moteur moteur, Enregistreur enregistreur) {
		this.enregistreur = enregistreur;
		this.moteur = moteur;
	}

	/**
	 * Appel a la methode rejouer de l'enregistreur.
	 */
	public void execute() {
		enregistreur.rejouer();

	}

	@Override
	public RejouerMemento getMemento() {
		return new RejouerMemento(new Rejouer(moteur, enregistreur));
	}

	@Override
	public void setReplay(boolean bool) {
		this.replay = bool;
	}

	private class RejouerMemento implements Memento<RejouerMemento> {

		Rejouer cmd;

		public RejouerMemento(Rejouer cmd) {
			this.cmd = cmd;
		}

		@Override
		public Command getCommand() {
			return cmd;
		}

	}

}
