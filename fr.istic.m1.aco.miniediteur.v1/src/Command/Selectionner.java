package Command;

import Receiver.Moteur;

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

	/**
	 * Nouveaux entiers definissant une position de debut et une postion de fin en
	 * Integer pour la selection.
	 */
	private int deb = 0;
	private int fin = 0;

	/**
	 * Constructeur de la classe Selectionner
	 * 
	 * @param moteur
	 * @param deb
	 * @param fin
	 */
	public Selectionner(Moteur moteur, int deb, int fin) {
		this.moteur = moteur;
		if (deb > fin) {
			this.deb = fin;
			this.fin = deb;
		} else {
			this.deb = deb;
			this.fin = fin;
		}
	}

	// Operations

	/**
	 * Appel de la mise en oeuvre de la fonction "selectionner" dans
	 * l'implementation Moteur.
	 * 
	 * @see MoteurImpl
	 * 
	 */
	public void execute() {
		moteur.selectionner(deb, fin);
	}

	/**
	 * retourne la position de debut de la selection sauvegardee
	 * 
	 * @return deb
	 */
	public int getDeb() {
		return deb;
	}

	/**
	 * Met a jour la position de debut sauvegardee
	 * 
	 * @param deb
	 */
	public void setDeb(int deb) {
		this.deb = deb;
	}

	/**
	 * 
	 * @return fin la position de fin de selection sauvegardee
	 */
	public int getFin() {
		return fin;
	}

	/**
	 * Met a jour le parametre fin sauvegarde
	 * 
	 * @param fin
	 *            la nouvelle valeur
	 */
	public void setFin(int fin) {
		this.fin = fin;
	}

}
