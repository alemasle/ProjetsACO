package receiver;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import command.Command;
import memento.Memento;
import state.State;

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
		this.stateCourant = new State(moteur.clone());
	}

	/**
	 * defait la derniere action
	 */
	// public void defaire() {
	//
	// List<Command> lcmd = stateCourant.getLcmd();
	// List<Memento<?>> lmem = stateCourant.getLmem();
	// Command cmd = null;
	//
	// System.out.println("Moteur init: \"" +
	// moteur.getBuffer().getBuffer().toString() + "\"");
	//
	// if (lcmd.size() == 0) {
	// if (!defaireStack.isEmpty()) {
	//
	// State ns = stateCourant.clone();
	// refaireStack.push(ns);
	//
	// System.out.println("IF");
	//
	// System.out.println("stateCourant avant pop: \""
	// + stateCourant.getMoteur().getBuffer().getBuffer().toString() + "\"");
	// stateCourant = defaireStack.pop();
	//
	// lcmd = stateCourant.getLcmd();
	// lmem = stateCourant.getLmem();
	//
	// System.out.println(
	// "stateCourant buffer: \"" +
	// stateCourant.getMoteur().getBuffer().getBuffer().toString() + "\"");
	//
	// moteur.setBuffer(stateCourant.getMoteur().getBuffer().clone());
	// moteur.setSelect(stateCourant.getMoteur().getSelect().clone());
	//
	// System.out.println("Buffer moteur: \"" +
	// moteur.getBuffer().getBuffer().toString() + "\"");
	//
	// for (int i = 0; i < lcmd.size() - 1; i++) {
	// setPlay(true);
	// cmd = lcmd.get(i);
	// cmd.setMemento(lmem.get(i));
	// cmd.execute();
	// System.out.println("cmd-moteur = " +
	// cmd.getMoteur().getBuffer().getBuffer().toString());
	// setPlay(false);
	// }
	//
	// System.out.println("moteur APRES buffer: \"" +
	// moteur.getBuffer().getBuffer().toString() + "\"");
	//
	// }
	// }
	//
	// else {
	//
	// State ns = stateCourant.clone();
	// refaireStack.push(ns);
	//
	// stateCourant.getLcmd().remove(lcmd.size() - 1);
	// stateCourant.getLmem().remove(lmem.size() - 1);
	//
	// System.out.println(
	// "stateCourant buffer: \"" +
	// stateCourant.getMoteur().getBuffer().getBuffer().toString() + "\"");
	//
	// moteur.setBuffer(stateCourant.getMoteur().getBuffer().clone());
	// moteur.setSelect(stateCourant.getMoteur().getSelect().clone());
	//
	// System.out.println("moteur modified: \"" +
	// moteur.getBuffer().getBuffer().toString() + "\"");
	//
	// for (int i = 0; i < lcmd.size(); i++) {
	// setPlay(true);
	// cmd = lcmd.get(i);
	// cmd.setMemento(lmem.get(i));
	// cmd.execute();
	// System.out.println("cmd-moteur = " +
	// cmd.getMoteur().getBuffer().getBuffer().toString());
	// setPlay(false);
	// }
	//
	// System.out.println("moteur APRES buffer: \"" +
	// moteur.getBuffer().getBuffer().toString() + "\"");
	// }
	// }

	public void defaire() {

		List<Command> lcmd = stateCourant.getLcmd();
		List<Memento<?>> lmem = stateCourant.getLmem();
		Command cmd = null;

		System.out.println("Moteur init: \"" + moteur.getBuffer().getBuffer().toString() + "\"");

		if (lcmd.size() == 0) {
			if (!defaireStack.isEmpty()) {

				State ns = stateCourant.clone();
				refaireStack.push(ns);

				System.out.println("IF");

				System.out.println("stateCourant avant pop: \""
						+ stateCourant.getMoteur().getBuffer().getBuffer().toString() + "\"");
				stateCourant = defaireStack.pop();

				lcmd = stateCourant.getLcmd();
				lmem = stateCourant.getLmem();

				System.out.println(
						"stateCourant buffer: \"" + stateCourant.getMoteur().getBuffer().getBuffer().toString() + "\"");

				moteur.setBuffer(stateCourant.getMoteur().getBuffer().clone());
				moteur.setSelect(stateCourant.getMoteur().getSelect().clone());

				System.out.println("Buffer moteur: \"" + moteur.getBuffer().getBuffer().toString() + "\"");

				for (int i = 0; i < lcmd.size() - 1; i++) {
					setPlay(true);
					cmd = lcmd.get(i);
					cmd.setMemento(lmem.get(i));
					cmd.execute();
					System.out.println("cmd-moteur = " + cmd.getMoteur().getBuffer().getBuffer().toString());
					setPlay(false);
				}

				System.out.println("moteur APRES buffer: \"" + moteur.getBuffer().getBuffer().toString() + "\"");

			}
		}

		else {

			State ns = stateCourant.clone();
			refaireStack.push(ns);

			stateCourant.getLcmd().remove(lcmd.size() - 1);
			stateCourant.getLmem().remove(lmem.size() - 1);

			System.out.println(
					"stateCourant buffer: \"" + stateCourant.getMoteur().getBuffer().getBuffer().toString() + "\"");

			setPlay(true);

			moteur.defaire(stateCourant.clone());

			setPlay(false);

			System.out.println("moteur manager fin buffer: \"" + moteur.getBuffer().getBuffer().toString() + "\"");

		}
	}

	/**
	 * Refait la derniere action defaite
	 */
	public void refaire() {
		List<Command> lcmd = stateCourant.getLcmd();
		Command cmd = null;

		if (!refaireStack.isEmpty()) {
			State ns = new State(stateCourant.getMoteur().clone());
			ns.setLcmd(stateCourant.getLcmd());
			ns.setLmem(stateCourant.getLmem());
			defaireStack.push(ns);

			stateCourant = refaireStack.pop();

			State nst = new State(stateCourant.getMoteur().clone());
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
			State oldSt = stateCourant.clone();
			defaireStack.push(oldSt);

			State ns = new State(moteur.clone());
			ns.setLcmd(new ArrayList<Command>());
			ns.setLmem(new ArrayList<Memento<?>>());
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
