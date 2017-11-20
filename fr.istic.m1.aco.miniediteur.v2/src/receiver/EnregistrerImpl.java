package receiver;

import java.util.ArrayList;
import java.util.List;

import command.Command;
import memento.Memento;

/**
 * Classe {@link EnregistrerImpl} implementant l'interface {@link Enregistreur}
 * contenant une implementation des methodes abstraite de l'interface
 *
 * @since v2
 * @author Alexis LE MASLE et Fanny PRIEUR
 */
public class EnregistrerImpl implements Enregistreur {

	private Boolean record = false;

	private Boolean play = false;

	private List<Memento<?>> replay = new ArrayList<Memento<?>>();

	private List<Command> lcmd = new ArrayList<Command>();

	/**
	 * Demarre l'enregistrement
	 */
	public void demarrer() {
		setRecord(true);
		replay = new ArrayList<Memento<?>>();
		lcmd = new ArrayList<Command>();
	}

	/**
	 * Stoppe l'enregistrement en cours
	 */
	public void stopper() {
		setRecord(false);
	}

	/**
	 * Rejoue les commandes enregistrées dans le macro
	 */
	public void rejouer() {
		Command cmdCurrent = null;
		setPlay(true);

		for (int i = 0; i < lcmd.size(); i++) {
			cmdCurrent = lcmd.get(i);
			cmdCurrent.setMemento(replay.get(i));
			cmdCurrent.execute();
		}

		setPlay(false);
	}

	/**
	 * Ajout un memento dans la liste de memento
	 * 
	 * @param m
	 *            Le memento a ajouter dans la liste
	 */
	public void addMemento(Memento<?> m) {
		replay.add(m);
	}

	/**
	 * Ajout un commandes dans la liste de commandes
	 * 
	 * @param cmd
	 *            La commande a ajouter dans la liste
	 */
	public void addCommand(Command cmd) {
		lcmd.add(cmd);
	}

	/**
	 * @return le record
	 */
	public boolean getRecord() {
		return record;
	}

	/**
	 * @param record
	 *            le record Ã  definir
	 */
	public void setRecord(Boolean record) {
		this.record = record;
	}

	public boolean getPlay() {
		return play;
	}

	public void setPlay(boolean play) {
		this.play = play;
	}
}
