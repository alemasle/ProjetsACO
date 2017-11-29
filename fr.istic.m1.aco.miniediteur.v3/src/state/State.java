package state;

import java.util.ArrayList;
import java.util.List;

import command.Command;
import memento.Memento;
import receiver.Moteur;

/**
 * 
 * Class State, representation d'une sauvegarde d'etat
 * 
 * @since v3
 * @author Alexis LE MASLE et Fanny PRIEUR
 *
 */
public class State {

	private Moteur moteur;

	/**
	 * Liste de commandes a sauvegarder a partir de l'etat courant
	 */
	private List<Command> lcmd = new ArrayList<Command>();

	/**
	 * Liste de mementos associes aux commandes.
	 */
	private List<Memento<?>> lmem = new ArrayList<Memento<?>>();

	public State(Moteur moteur) {
		this.moteur = moteur;
	}

	/**
	 * Permet d'ajouter une commande dans la liste des commandes de State
	 * 
	 * @param c
	 */
	public void addCmd(Command c) {
		lcmd.add(c);
	}

	/**
	 * Permet d'ajouter une commande dans la liste des commandes de State.
	 * 
	 * @param m
	 */
	public void addMem(Memento<?> m) {
		lmem.add(m);
	}

	///////// GETTER/SETTER attributs /////////

	public Moteur getMoteur() {
		return moteur;
	}

	public void setMoteur(Moteur moteur) {
		this.moteur = moteur;
	}

	public List<Command> getLcmd() {
		return lcmd;
	}

	public void setLcmd(List<Command> lcmd) {
		this.lcmd = lcmd;
	}

	public List<Memento<?>> getLmem() {
		return lmem;
	}

	public void setLmem(List<Memento<?>> lmem) {
		this.lmem = lmem;
	}

	@Override
	public State clone() {

		List<Command> clcmd = new ArrayList<>();
		List<Memento<?>> clmem = new ArrayList<>();

		for (int i = 0; i < lcmd.size(); i++) {
			clcmd.add(lcmd.get(i).clone());
			clmem.add(lmem.get(i).clone());
		}

		State s = new State(moteur.clone());
		s.setLcmd(clcmd);
		s.setLmem(clmem);
		return s;
	}

}
