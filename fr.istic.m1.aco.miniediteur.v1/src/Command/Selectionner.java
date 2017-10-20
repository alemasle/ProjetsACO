package Command;

import Memento.Memento;
import Receiver.Enregistreur;
import Receiver.Moteur;
import Receiver.MoteurImpl;

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

	private Enregistreur enregistreur;

	/**
	 * Nouveau Memento
	 */
	private Memento<MementoSelectionner> memento;

	/**
	 * Nouveaux entiers definissant une position de debut et une postion de fin
	 * en Integer pour la selection.
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
	public Selectionner(Moteur moteur, int deb, int fin, Enregistreur enregistreur) {
		this.moteur = moteur;
		this.deb = deb;
		this.fin = fin;
		this.memento = null;
		this.enregistreur = enregistreur;
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
	 * @return memento le memento courant
	 */
	public Memento getMemento() {
		return memento;
	}

	/**
	 * met a jour le memento courant
	 * 
	 * @param m
	 *            le nouveau memento
	 */
	public void setMemento(Memento m) {
		this.memento = m;
	}

	/**
	 * Classe privee {@link MementoSelectionner} implementant {@link Memento}
	 * 
	 * @author Alexis LE MASLE et Fanny PRIEUR
	 *
	 */
	public class MementoSelectionner implements Memento {

		/**
		 * deb et fin sont les parametres de debut et de fin de la selection a
		 * sauvegarder lors d'un enregistrement
		 */
		int deb, fin;

		/**
		 * Constructeur de la classe {@link MementoSelectionner}
		 * 
		 * @param deb
		 * @param fin
		 */
		public MementoSelectionner(int deb, int fin) {
			this.deb = deb;
			this.fin = fin;
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

}
