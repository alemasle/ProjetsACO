package receiver;

import java.util.ArrayList;
import java.util.List;

import command.Command;
import memento.Memento;

/**
 * Classe {@link EnregistrerImpl} implementant l'interface {@link Enregistreur}
 * contenant une implementation des methodes abstraite de l'interface
 *
 * @author Alexis LE MASLE et Fanny PRIEUR
 */
public class EnregistrerImpl implements Enregistreur {

	private Boolean record = false;

	private List<Memento<?>> replay = new ArrayList<Memento<?>>();

	/**
	 * Demarre l'enregistrement
	 */
	public void demarrer() {
		setRecord(true);
		replay = new ArrayList<Memento<?>>();
	}

	/**
	 * Stoppe l'enregistrement en cours
	 */
	public void stopper() {
		setRecord(false);
	}

	/**
	 * Rejoue le dernier enregistrement en mettant a jour le buffer
	 */
	public void rejouer() {
		System.out.println("Size of the list of Memento: " + replay.size());
		for (Memento<?> memento : replay) {
			Command cmd = memento.getCommand();
			cmd.setReplay(true);
			cmd.execute();
			cmd.setReplay(false);
		}
	}

	public void addMemento(Memento<?> m) {
		replay.add(m);
	}

	/**
	 * @return le record
	 */
	public boolean getRecord() {
		return record;
	}

	/**
	 * @param record
	 *            le record à definir
	 */
	public void setRecord(Boolean record) {
		this.record = record;
	}
}
