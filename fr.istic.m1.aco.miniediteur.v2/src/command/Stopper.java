package command;

import memento.Memento;
import receiver.Enregistreur;
import receiver.Moteur;

/**
 * Concrete Command "Stopper" implementant Command
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 *
 */
public class Stopper implements Command {

	/**
	 * Nouvelle Instance d'enregistreur declarant la methode stopper
	 * 
	 * @see Enregistreur
	 */
	private Enregistreur enregistreur;

	private Moteur moteur;

	private boolean replay = false;

	/**
	 * Constructeur de la classe Stopper
	 * 
	 * @param enregistreur
	 */
	public Stopper(Moteur moteur, Enregistreur enregistreur) {
		this.enregistreur = enregistreur;
		this.moteur = moteur;
	}

	/**
	 * Appel de la methode stopper de l'enregistreur
	 */
	public void execute() {
		enregistreur.stopper();
	}

	@Override
	public StopperMemento getMemento() {
		return new StopperMemento(new Stopper(moteur, enregistreur));
	}

	@Override
	public void setReplay(boolean bool) {
		this.replay = bool;
	}

	private class StopperMemento implements Memento<StopperMemento> {

		Stopper cmd;

		public StopperMemento(Stopper cmd) {
			this.cmd = cmd;
		}

		@Override
		public Command getCommand() {
			return cmd;
		}

	}

}
