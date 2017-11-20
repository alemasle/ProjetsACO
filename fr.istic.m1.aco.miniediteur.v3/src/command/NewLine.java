package command;

import memento.Memento;
import receiver.Enregistreur;
import receiver.Moteur;
import receiver.MoteurImpl;

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

	public NewLine(Moteur moteur, Enregistreur enregistreur) {
		this.moteur = moteur;
		this.enregistreur = enregistreur;
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
		if (enregistreur.getRecord()) {
			enregistreur.addMemento(getMemento());
			enregistreur.addCommand(this);
		}
	}

	@Override
	public NewLineMemento getMemento() {
		return new NewLineMemento();
	}

	private class NewLineMemento implements Memento<NewLineMemento> {

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
}