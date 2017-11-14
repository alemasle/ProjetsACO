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

	private boolean replay = false;

	/**
	 * Constructeur de la classe Selectionner
	 * 
	 * @param moteur
	 * @param deb
	 * @param fin
	 */
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
		int deb = 0;
		int fin = 0;
		if (replay) {
			deb = ihm.getSelDeb();
			fin = ihm.getSelFin();
		} else {
			deb = ihm.getDebut();
			fin = ihm.getFin();
			if (enregistreur.getRecord()) {
				enregistreur.addMemento(getMemento());
			}
		}
		if (deb > fin) {
			moteur.selectionner(fin, deb);
		} else {
			moteur.selectionner(deb, fin);
		}
	}

	public void setIhm(Ihm ihm) {
		this.ihm = ihm;
	}

	@Override
	public Memento getMemento() {
		return new Memento(new Selectionner(moteur, ihm, enregistreur));
	}

	@Override
	public void setReplay(boolean bool) {
		this.replay = bool;
	}

	@Override
	public Moteur getMoteur() {
		return moteur;
	}

}
