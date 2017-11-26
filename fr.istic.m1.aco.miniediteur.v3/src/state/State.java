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

	private List<Command> lcmd = new ArrayList<Command>();

	private List<Memento<?>> lmem = new ArrayList<Memento<?>>();

	public State(Moteur moteur) {
		this.moteur = moteur;
	}

	public Moteur getMoteur() {
		return moteur;
	}

	public void addCmd(Command c) {
		lcmd.add(c);
	}

	public void addMem(Memento<?> m) {
		lmem.add(m);
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
