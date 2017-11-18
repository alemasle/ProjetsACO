package command;

import memento.Memento;
import receiver.Enregistreur;
import receiver.Moteur;
import receiver.MoteurImpl;

/**
 * Concrete Command "Couper" implementant l'interface Command
 *
 * @author Alexis LE MASLE et Fanny PRIEUR
 */
public class Couper implements Command {

	/**
	 * Nouvelle instance de l'interface Moteur declarant la methode couper
	 *
	 * @see Moteur
	 */
	private Moteur moteur;

	private Enregistreur enregistreur;

	private boolean replay = false;

	/**
	 * Constructeur de la classe Couper
	 *
	 * @param moteur
	 */
	public Couper(Moteur moteur, Enregistreur enregistreur) {
		this.moteur = moteur;
		this.enregistreur = enregistreur;
	}

	// Operations

	/**
	 * Appel de la mise en oeuvre de la fonction "couper" dans l'implementation
	 * Moteur.
	 *
	 * @see MoteurImpl
	 */
	public void execute() {
		enregistreur.setBuffer(moteur.getBuffer());
		if (enregistreur.getRecord()) {
			enregistreur.addMemento(getMemento());
		}
		moteur.couper();
	}

	@Override
	public Memento getMemento() {
		return new Memento(new Couper(moteur, enregistreur));
	}

	@Override
	public void setReplay(boolean bool) {
		this.replay = bool;
	}

	@Override
	public Moteur getMoteur() {
		return moteur;
	}

}
