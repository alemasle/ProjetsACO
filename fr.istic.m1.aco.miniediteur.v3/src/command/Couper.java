package command;

import etats.State;
import memento.Memento;
import receiver.Enregistreur;
import receiver.Manager;
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

	private CouperMemento memento;

	private Manager manager;

	/**
	 * Constructeur de la classe Couper
	 *
	 * @param moteur
	 */
	public Couper(Moteur moteur, Enregistreur enregistreur, Manager manager) {
		this.moteur = moteur;
		this.enregistreur = enregistreur;
		this.manager = manager;
	}

	// Operations

	/**
	 * Appel de la mise en oeuvre de la fonction "couper" dans l'implementation
	 * Moteur.
	 *
	 * @see MoteurImpl
	 */
	public void execute() {
		CouperMemento m = getMemento();
		moteur.couper();
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
	public CouperMemento getMemento() {
		return new CouperMemento();
	}

	private class CouperMemento implements Memento<CouperMemento> {

	}

	@Override
	public void setMemento(Memento<?> mem) {
		this.setCouperMemento((CouperMemento) mem);
	}

	public CouperMemento getCouperMemento() {
		return memento;
	}

	public void setCouperMemento(CouperMemento memento) {
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

}
