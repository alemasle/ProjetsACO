package command;

import memento.Memento;
import receiver.Enregistreur;
import receiver.Manager;
import receiver.Moteur;
import receiver.MoteurImpl;
import state.State;

/**
 * Concrete Command "Delete" implementant l'interface Command
 *
 * @since 1.1
 * @author Alexis LE MASLE et Fanny PRIEUR
 */
public class Delete implements Command {

	/**
	 * Nouvelle instance de l'interface Moteur declarant la methode delete
	 *
	 * @see Moteur
	 */
	private Moteur moteur;

	private Enregistreur enregistreur;

	private DeleteMemento memento;

	private Manager manager;

	/**
	 * Constructeur de la classe Delete
	 * 
	 * @param moteur
	 * @param enregistreur
	 * @param manager
	 */
	public Delete(Moteur moteur, Enregistreur enregistreur, Manager manager) {
		this.moteur = moteur;
		this.enregistreur = enregistreur;
		this.manager = manager;
	}

	// Operations

	/**
	 * Appel de la mise en oeuvre de la fonction "delete" dans l'implementation
	 * Moteur.
	 *
	 * @see MoteurImpl
	 */
	@Override
	public void execute() {
		DeleteMemento m = getMemento();
		moteur.delete();
		if (enregistreur.getRecord()) {
			enregistreur.addMemento(m);
			enregistreur.addCommand(this);
		}
		if (!manager.getPlay()) {
			State st = manager.getStateCourant();
			st.addMem(m);
			st.addCmd(this);
			manager.saveState();
			manager.emptyRedo();
		}
	}

	/**
	 * Cree un nouveau DeleteMemento
	 */
	@Override
	public DeleteMemento getMemento() {
		return new DeleteMemento();
	}

	/**
	 * Classe DeleteMemento implementant Memento et ne servant qu'a Delete
	 * 
	 * @author Alexis LE MASLE et Fanny PRIEUR
	 *
	 */
	private class DeleteMemento implements Memento<DeleteMemento> {

		@Override
		public DeleteMemento clone() {
			return new DeleteMemento();
		}
	}

	@Override
	public void setMemento(Memento<?> mem) {
		this.setDeleteMemento((DeleteMemento) mem);
	}

	public DeleteMemento getDeleteMemento() {
		return memento;
	}

	public void setDeleteMemento(DeleteMemento memento) {
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
	public Delete clone() {
		Delete a = new Delete(moteur.clone(), enregistreur, manager);
		return a;
	}

}
