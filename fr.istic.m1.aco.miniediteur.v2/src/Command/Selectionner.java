package Command;

import Command.Selectionner.MementoSelectionner;
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
	 * Nouveaux entiers definissant une position de debut et une postion de fin
	 * en Integer pour la selection.
	 */
	private int deb = 0;
	private int fin = 0;

	/**
	 * Nouveau Memento
	 */
	private Memento<MementoSelectionner> memento;

	/**
	 * Constructeur de la classe Selectionner
	 * 
	 * @param moteur
	 * @param deb
	 * @param fin
	 */
	public Selectionner(Moteur moteur, int deb, int fin, Enregistreur enregistreur) {
		this.moteur = moteur;
		if (deb > fin) {
			this.deb = fin;
			this.fin = deb;
		} else {
			this.deb = deb;
			this.fin = fin;
		}
		this.memento = null;
		this.setEnregistreur(enregistreur);
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

	/**
	 * @return memento le memento courant
	 */
	public Memento<MementoSelectionner> getMemento() {
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
	 * @return le enregistreur
	 */
	public Enregistreur getEnregistreur() {
		return enregistreur;
	}

	/**
	 * @param enregistreur
	 *            le enregistreur à définir
	 */
	public void setEnregistreur(Enregistreur enregistreur) {
		this.enregistreur = enregistreur;
	}

	/**
	 * Classe privee {@link MementoSelectionner} implementant {@link Memento}
	 * 
	 * @author Alexis LE MASLE et Fanny PRIEUR
	 *
	 */
	public class MementoSelectionner implements Memento<MementoSelectionner> {

		private Command command = new Selectionner(moteur, deb, fin, enregistreur);

		/**
		 * deb et fin sont les parametres de debut et de fin de la selection a
		 * sauvegarder lors d'un enregistrement
		 */

		int debut;
		int finale;

		/**
		 * Constructeur de la classe {@link MementoSelectionner}
		 * 
		 * @param deb
		 * @param fin
		 */
		public MementoSelectionner(int debut, int finale) {
			this.debut = debut;
			this.finale = finale;
		}

		/**
		 * retourne la position de debut de la selection sauvegardee
		 * 
		 * @return deb
		 */
		public int getDeb() {
			return debut;
		}

		/**
		 * Met a jour la position de debut sauvegardee
		 * 
		 * @param deb
		 */
		public void setDeb(int deb) {
			this.debut = deb;
		}

		/**
		 * 
		 * @return fin la position de fin de selection sauvegardee
		 */
		public int getFin() {
			return finale;
		}

		/**
		 * Met a jour le parametre fin sauvegarde
		 * 
		 * @param fin
		 *            la nouvelle valeur
		 */
		public void setFin(int finale) {
			this.finale = finale;
		}

		public Command getCommand() {
			return command;
		}

	}

}
