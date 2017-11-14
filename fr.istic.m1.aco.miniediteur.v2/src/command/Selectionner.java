package command;

import ihm.Ihm;
import memento.Memento;
import receiver.Enregistreur;
import receiver.Moteur;
import receiver.MoteurImpl;

/**
 * Concrete Command "Selectionner" implementant l'interface Command
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 * 
 */
public class Selectionner implements Command {

	/**
	 * Nouvelle instance de l'interface Moteur declarant la methode selectionner
	 * 
	 * @see Moteur
	 */
	private Moteur moteur;

	private Ihm ihm;

	private Enregistreur enregistreur;

	int deb;

	int fin;

	private boolean replay = false;

	public Selectionner(Moteur moteur, Ihm ihm, Enregistreur enregistreur) {
		this.moteur = moteur;
		this.ihm = ihm;
		this.enregistreur = enregistreur;
	}

	// Operations

	/**
	 * Appel de la mise en oeuvre de la fonction "selectionner" dans
	 * l'implementation Moteur. Demande les bornes de debut et de fin a
	 * l'utilsateur. Si la commande est en mode replay alors elle utilise les
	 * dernieres bornes.
	 * 
	 * @see MoteurImpl
	 * 
	 */
	public void execute() {
		if (replay) {
			deb = ihm.getSelDeb();
			fin = ihm.getSelFin();
			if (deb > fin) {
				int tmp = fin;
				fin = deb;
				deb = tmp;
			}
			moteur.selectionner(deb, fin);
		} else {
			deb = ihm.getDebut();
			fin = ihm.getFin();
			if (deb > fin) {
				int tmp = fin;
				fin = deb;
				deb = tmp;
			}
			moteur.selectionner(deb, fin);
			if (enregistreur.getRecord()) {
				enregistreur.addMemento(getMemento());
			}
		}
	}

	public void setIhm(Ihm ihm) {
		this.ihm = ihm;
	}

	@Override
	public SelectionnerMemento getMemento() {
		return new SelectionnerMemento(new Selectionner(moteur, ihm, enregistreur));
	}

	@Override
	public void setReplay(boolean bool) {
		this.replay = bool;
	}

	private class SelectionnerMemento implements Memento<SelectionnerMemento> {

		Selectionner cmd;

		public SelectionnerMemento(Selectionner cmd) {
			this.cmd = cmd;
		}

		@Override
		public Command getCommand() {
			return cmd;
		}

	}

}
