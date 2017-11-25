package command;

import etats.State;
import memento.Memento;
import receiver.Enregistreur;
import receiver.Manager;
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

	private CollerMemento memento;

	private Manager manager;

	/**
	 * Constructeur de la classe Copier
	 * 
	 * @param moteur
	 * @param enregistreur
	 * @param state
	 */
	public Coller(Moteur moteur, Enregistreur enregistreur, Manager manager) {
		this.moteur = moteur;
		this.enregistreur = enregistreur;
		this.manager = manager;
	}

	/**
	 * Appel de la mise en oeuvre de la fonction "coller" dans l'implementation
	 * Moteur.
	 *
	 * @see MoteurImpl
	 */
	public void execute() {
		moteur.coller();
		CollerMemento m = getMemento();
		if (enregistreur.getRecord()) {
			enregistreur.addMemento(m);
			enregistreur.addCommand(this);
		}
		State st = manager.getStateCourant();
		st.getLmem().add(m);
		st.getLcmd().add(this);
		manager.saveState();
	}

	@Override
	public CollerMemento getMemento() {
		return new CollerMemento();
	}

	private class CollerMemento implements Memento<CollerMemento> {

		@Override
		public CollerMemento clone() {
			return new CollerMemento();
		}

	}

	@Override
	public void setMemento(Memento<?> mem) {
		this.setColerMemento((CollerMemento) mem);
	}

	public CollerMemento getCollerMemento() {
		return memento;
	}

	public void setColerMemento(CollerMemento memento) {
		this.memento = memento;
	}

	@Override
	public void setMoteur(Moteur moteur) {
		this.moteur = moteur;
	}

	@Override
	public Moteur getMoteur() {
		return moteur;
	}

	@Override
	public Coller clone() {
		Coller a = new Coller(moteur.clone(), enregistreur, manager);
		return a;
	}

}
