package receiver;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import command.Command;
import etats.State;
import memento.Memento;

/**
 * 
 * Classe ManagerImpl implementant Manager
 * 
 * @since v3
 * @author Alexis LE MASLE et Fanny PRIEUR
 *
 */
public class ManagerImpl implements Manager {

	private Stack<State> defaireStack = new Stack<State>();
	private Stack<State> refaireStack = new Stack<State>();

	private State stateCourant;

	private Moteur moteur;

	private boolean play = false;

	public ManagerImpl(Moteur moteur) {
		this.moteur = moteur;
		this.stateCourant = new State(moteur);
	}

	/**
	 * defait la derniere action
	 */
	public void defaire() {
		List<Command> lcmd = new ArrayList<Command>();
		Command cmd = null;

		State ns = new State(stateCourant.getMoteur());
		ns.setLcmd(stateCourant.getLcmd());
		ns.setLmem(stateCourant.getLmem());
		refaireStack.push(ns);
		lcmd = ns.getLcmd();

		if (lcmd.size() == 0) {
			System.out.println("IF");
			if (!defaireStack.isEmpty()) {
				stateCourant = defaireStack.pop();
				State nst = new State(stateCourant.getMoteur());
				nst.setLcmd(stateCourant.getLcmd());
				nst.setLmem(stateCourant.getLmem());
				lcmd = nst.getLcmd();
				moteur = nst.getMoteur();
				System.out.println("lcmd size IF: " + lcmd.size());
				for (int i = 0; i < lcmd.size(); i++) {
					setPlay(true);
					cmd = lcmd.get(i);
					cmd.setMemento(nst.getLmem().get(i));
					cmd.execute();
					setPlay(false);
				}
			}
		} else {
			// stateCourant.getLcmd().remove(stateCourant.getLcmd().size() - 1);
			// stateCourant.getLmem().remove(stateCourant.getLmem().size() - 1);
			System.out.println("ELSE");
			State nst = new State(stateCourant.getMoteur());
			System.out.println("Buffer state current " + nst.getMoteur().getBuffer().getBuffer().toString());

			nst.setLcmd(stateCourant.getLcmd());
			nst.setLmem(stateCourant.getLmem());
			lcmd = nst.getLcmd();
			moteur = nst.getMoteur();
			System.out.println("lcmd size ELSE: " + lcmd.size() + " elements");

			for (int i = 0; i < lcmd.size() - 1; i++) {
				setPlay(true);
				cmd = lcmd.get(i);
				cmd.setMemento(nst.getLmem().get(i));
				cmd.execute();
				setPlay(false);
			}
		}
	}

	/**
	 * Refait la derniere action defaite
	 */
	public void refaire() {
		List<Command> lcmd = stateCourant.getLcmd();
		Command cmd = null;

		if (!refaireStack.isEmpty()) {
			State ns = new State(stateCourant.getMoteur());
			ns.setLcmd(stateCourant.getLcmd());
			ns.setLmem(stateCourant.getLmem());
			defaireStack.push(ns);

			stateCourant = refaireStack.pop();

			State nst = new State(stateCourant.getMoteur());
			nst.setLcmd(stateCourant.getLcmd());
			nst.setLmem(stateCourant.getLmem());
			lcmd = nst.getLcmd();
			moteur = nst.getMoteur();

			for (int i = 0; i < lcmd.size(); i++) {
				setPlay(true);
				cmd = lcmd.get(i);
				cmd.setMoteur(moteur);
				cmd.setMemento(nst.getLmem().get(i));
				cmd.execute();
				setPlay(false);
			}
		}
	}

	/**
	 * Sauvegarde l'etat courant dans la pile Defaire si il y'a 5 commandes
	 * enregistree
	 */
	public void saveState() {
		List<Command> lcmd = stateCourant.getLcmd();
		if (lcmd.size() == 5) {
			State oldSt = new State(stateCourant.getMoteur());
			oldSt.setLcmd(stateCourant.getLcmd());
			oldSt.setLmem(stateCourant.getLmem());
			defaireStack.push(oldSt);

			State ns = new State(stateCourant.getMoteur());
			ns.setLcmd(new ArrayList<Command>());
			ns.setLmem(new ArrayList<Memento<?>>());
			ns.setMoteur(moteur);
			stateCourant = ns;
			System.out.println("Save state");
		}
	}

	///////////////// Getter/Setter attributs /////////////////////

	public Moteur getMoteur() {
		return moteur;
	}

	public void setMoteur(Moteur moteur) {
		this.moteur = moteur;
	}

	public boolean getPlay() {
		return play;
	}

	public void setPlay(boolean play) {
		this.play = play;
	}

	public State getStateCourant() {
		return stateCourant;
	}

	public void setStateCourant(State s) {
		this.stateCourant = s;
	}

	public Stack<State> getRefaireStack() {
		return refaireStack;
	}

	public void setRefaireStack(Stack<State> refaireStack) {
		this.refaireStack = refaireStack;
	}

	public Stack<State> getDefaireStack() {
		return defaireStack;
	}

	public void setDefaireStack(Stack<State> defaireStack) {
		this.defaireStack = defaireStack;
	}

}
