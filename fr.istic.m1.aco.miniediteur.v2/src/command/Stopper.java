package command;

import memento.Memento;
import receiver.Enregistreur;

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

	private StopperMemento memento;

	/**
	 * Constructeur de la classe Stopper
	 * 
	 * @param enregistreur
	 */
	public Stopper(Enregistreur enregistreur) {
		this.enregistreur = enregistreur;
	}

	/**
	 * Appel de la methode stopper de l'enregistreur
	 */
	public void execute() {
		enregistreur.stopper();
	}

	@Override
	public StopperMemento getMemento() {
		return new StopperMemento();
	}

	private class StopperMemento implements Memento<StopperMemento> {

	}

	@Override
	public void setMemento(Memento<?> mem) {
		this.memento = (StopperMemento) mem;
	}

}
