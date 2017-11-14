package command;

import memento.Memento;
import receiver.Enregistreur;
import receiver.Moteur;

/**
 * 
 * Concrete Command "Demarrer" implementant l'interface Command
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 *
 */
public class Demarrer implements Command {

	/**
	 * Nouvelle instance de l'interface Enregistreur permettant l'acces aux methodes
	 * de l'enregistreur.
	 * 
	 * @see Enregistreur
	 */
	private Enregistreur enregistreur;

	private Moteur moteur;

	private boolean replay = false;

	/**
	 * Constructeur de la classe Demarrer initialisant les attributs
	 * 
	 * @param enregistreur
	 */
	public Demarrer(Moteur moteur, Enregistreur enregistreur) {
		this.enregistreur = enregistreur;
		this.moteur = moteur;
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
	public DemarrerMemento getMemento() {
		return new DemarrerMemento(new Demarrer(moteur, enregistreur));
	}

	@Override
	public void setReplay(boolean bool) {
		this.replay = bool;
	}

	private class DemarrerMemento implements Memento<DemarrerMemento> {

		Demarrer cmd;

		public DemarrerMemento(Demarrer cmd) {
			this.cmd = cmd;
		}

		@Override
		public Command getCommand() {
			return cmd;
		}

	}

}
