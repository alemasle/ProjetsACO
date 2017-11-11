package Receiver;

import java.util.*;

import Memento.Memento;

/**
 * Classe {@link EnregistrerImpl} implementant l'interface {@link Enregistreur}
 * contenant une implementation des methodes abstraite de l'interface
 *
 * @author Alexis LE MASLE et Fanny PRIEUR
 */
public class EnregistrerImpl implements Enregistreur {

	private Boolean record = false;

	private List<Memento> replay = new ArrayList<Memento>();

	/**
	 * Demarre l'enregistrement
	 */
	public void demarrer() {
		setRecord(true);
	}

	/**
	 * Stoppe l'enregistrement en cours
	 */
	public void stopper() {
		setRecord(false);
	}

	/**
	 * Rejoue le dernier enregistrement
	 */
	public void rejouer() {
		for (Memento memento : replay) {
			memento.getCommand().execute();
		}
	}

	public void addMemento(Memento m) {
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
