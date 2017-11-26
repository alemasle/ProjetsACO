package command;

import memento.Memento;
import receiver.Enregistreur;
import receiver.Manager;
import receiver.Moteur;
import receiver.MoteurImpl;
import state.State;

/**
 * Concrete Command "NewLine" implementant l'interface Command
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 * 
 */
public class NewLine implements Command {

	/**
	 * Nouvelle instance de l'interface Moteur declarant la methode newLine
	 * 
	 * @see Moteur
	 */
	private Moteur moteur;

	private Enregistreur enregistreur;

	private NewLineMemento memento;

	private Manager manager;

	public NewLine(Moteur moteur, Enregistreur enregistreur, Manager manager) {
		this.moteur = moteur;
		this.enregistreur = enregistreur;
		this.manager = manager;
	}
	// Operations

	/**
	 * Appel de la mise en oeuvre de la fonction "newLine" dans l'implementation
	 * Moteur.
	 * 
	 * @see MoteurImpl
	 * 
	 */
	public void execute() {
		moteur.newLine();
		NewLineMemento m = getMemento();
		if (enregistreur.getRecord()) {
			enregistreur.addMemento(m);
			enregistreur.addCommand(this);
		}
		if (!manager.getPlay()) {
			State st = manager.getStateCourant();
			st.addMem(m);
			st.addCmd(this);
			manager.saveState();
		}
	}

	@Override
	public NewLineMemento getMemento() {
		return new NewLineMemento();
	}

	private class NewLineMemento implements Memento<NewLineMemento> {

		@Override
		public NewLineMemento clone() {
			return new NewLineMemento();
		}
	}

	@Override
	public void setMemento(Memento<?> mem) {
		this.setNewLineMemento((NewLineMemento) mem);
	}

	public NewLineMemento getNewLineMemento() {
		return memento;
	}

	public void setNewLineMemento(NewLineMemento memento) {
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
	public NewLine clone() {
		NewLine a = new NewLine(moteur.clone(), enregistreur, manager);
		return a;
	}
}
