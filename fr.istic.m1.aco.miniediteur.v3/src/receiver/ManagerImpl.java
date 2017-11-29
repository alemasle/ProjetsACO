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
	 * Revient a l'etat precedent la derniere commande si il y'en a un.
	 */
	public void defaire() {

		List<Command> lcmd = stateCourant.getLcmd();
		List<Memento<?>> lmem = stateCourant.getLmem();

		if (lcmd.size() == 0) {
			if (!defaireStack.isEmpty()) {

				refaireStack.push(stateCourant.clone());

				stateCourant = defaireStack.pop();

				setPlay(true);
				moteur.recreer(stateCourant.clone());
				setPlay(false);

			}
		} else {

			refaireStack.push(stateCourant.clone());

			stateCourant.getLcmd().remove(lcmd.size() - 1);
			stateCourant.getLmem().remove(lmem.size() - 1);

			setPlay(true);
			moteur.recreer(stateCourant.clone());
			setPlay(false);
		}
	}

	/**
	 * Refait la derniere action defaite si il y'en a une.
	 */
	public void refaire() {
		if (!refaireStack.isEmpty()) {
			if (stateCourant.getLcmd().size() == 4) {
				defaireStack.push(stateCourant.clone());
			}

			stateCourant = refaireStack.pop();

			setPlay(true);
			moteur.recreer(stateCourant);
			setPlay(false);
		}
	}

	/**
	 * Sauvegarde l'etat courant dans la pile Defaire si il y'a 5 commandes
	 * enregistree.
	 * 
	 * 
	 * Supprime l'etat le plus ancien si il y'a plus de 30 etats enregistres
	 */
	public void saveState() {
		List<Command> lcmd = stateCourant.getLcmd();
		if (lcmd.size() == 5) {
			State oldSt = stateCourant.clone();
			oldSt.getLcmd().remove(oldSt.getLcmd().size() - 1);
			oldSt.getLmem().remove(oldSt.getLmem().size() - 1);

			defaireStack.push(oldSt);

			State ns = new State(moteur.clone());
			ns.setLcmd(new ArrayList<Command>());
			ns.setLmem(new ArrayList<Memento<?>>());
			stateCourant = ns;

			if (defaireStack.size() > 30) {
				Stack<State> tmp = new Stack<State>();
				while (defaireStack.size() > 1) {
					tmp.push(defaireStack.pop());
				}
				while (!tmp.isEmpty()) {
					defaireStack.push(tmp.pop());
				}
			}
			System.out.println("Save State.");
		}
	}

	/**
	 * Vide la pile "refaire" si on execute une nouvelle commande
	 */
	public void emptyRedo() {
		if (!refaireStack.isEmpty()) {
			refaireStack = new Stack<State>();
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
