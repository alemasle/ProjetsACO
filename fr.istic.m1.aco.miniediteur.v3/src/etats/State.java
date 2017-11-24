package etats;

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
		this.setMoteur(moteur);
	}

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

}
