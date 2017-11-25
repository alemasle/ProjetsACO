package command;

import etats.State;
import memento.Memento;
import receiver.Enregistreur;
import receiver.Manager;
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

	private CopierMemento memento;

	private Manager manager;

	public Copier(Moteur moteur, Enregistreur enregistreur, Manager manager) {
		this.moteur = moteur;
		this.enregistreur = enregistreur;
		this.manager = manager;
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
		CopierMemento m = getMemento();
		if (enregistreur.getRecord()) {
			enregistreur.addMemento(getMemento());
			enregistreur.addCommand(this);
		}
		State st = manager.getStateCourant();
		st.getLmem().add(m);
		st.getLcmd().add(this);
		manager.saveState();
	}

	@Override
	public CopierMemento getMemento() {
		return new CopierMemento();
	}

	private class CopierMemento implements Memento<CopierMemento> {

		@Override
		public CopierMemento clone() {
			return new CopierMemento();
		}
	}

	@Override
	public void setMemento(Memento<?> mem) {
		this.setCopierMemento((CopierMemento) mem);
	}

	public CopierMemento getCopierMemento() {
		return memento;
	}

	public void setCopierMemento(CopierMemento memento) {
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
	public Copier clone() {
		Copier a = new Copier(moteur.clone(), enregistreur, manager);
		return a;
	}
}
