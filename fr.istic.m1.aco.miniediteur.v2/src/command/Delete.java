package command;

import memento.Memento;
import receiver.Enregistreur;
import receiver.Moteur;
import receiver.MoteurImpl;

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

	/**
	 * Constructeur de la classe Delete
	 *
	 * @param moteur
	 */
	public Delete(Moteur moteur, Enregistreur enregistreur) {
		this.moteur = moteur;
		this.enregistreur = enregistreur;
	}

	// Operations

	/**
	 * Appel de la mise en oeuvre de la fonction "delete" dans l'implementation
	 * Moteur.
	 *
	 * @see MoteurImpl
	 */
	public void execute() {
		moteur.delete();
		if (enregistreur.getRecord()) {
			enregistreur.addMemento(getMemento());
			enregistreur.addCommand(this);
		}
	}

	@Override
	public DeleteMemento getMemento() {
		return new DeleteMemento();
	}

	public class DeleteMemento implements Memento<DeleteMemento> {

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

}
