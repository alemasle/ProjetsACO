package Command;

import Memento.Memento;
import Receiver.Enregistreur;
import Receiver.Moteur;
import Receiver.MoteurImpl;

/**
 * Concrete Command "Inserer" implementant l'interface Command
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 * 
 */
public class Inserer implements Command {

	/**
	 * Nouvelle instance de l'interface Moteur declarant la methode inserer
	 * 
	 * @see Moteur
	 */
	private Moteur moteur;

	private Enregistreur enregistreur;

	/**
	 * Nouveau memento
	 */
	private Memento<MementoInserer> memento;

	/**
	 * Nouvelle String a inserer
	 */
	private String str;

	/**
	 * Constructeur de la classe Inserer
	 * 
	 * @param moteur
	 * @param str
	 */
	public Inserer(Moteur moteur, String str, Enregistreur enregistreur) {
		this.moteur = moteur;
		this.str = str;
		this.memento = null;
		this.enregistreur = enregistreur;
	}

	// Operations

	/**
	 * Appel de la mise en oeuvre de la fonction "inserer" dans l'implementation
	 * Moteur.
	 * 
	 * @see MoteurImpl
	 * 
	 */
	public void execute() {
		moteur.inserer(str);
	}

	/**
	 * @return memento le memento courant
	 */
	public Memento getMemento() {
		return memento;
	}

	/**
	 * Met a jour le memento courant
	 * 
	 * @param m
	 *            le nouveau memento
	 */
	public void setMemento(Memento m) {
		this.memento = m;
	}

	/**
	 * Classe privee MementoInserer implementant Memento
	 * 
	 * @author Alexis LE MASLE et Fanny PRIEUR
	 *
	 */
	public class MementoInserer implements Memento {

		/**
		 * Le contenu du memento courant
		 */
		String texte;

		/**
		 * Constructeur de la classe MementoInserer
		 * 
		 * @param texte
		 */
		public MementoInserer(String texte) {
			this.texte = texte;
		}

		/**
		 * 
		 * @return texte le contenu du memento
		 */
		public String getTexte() {
			return texte;
		}

		/**
		 * met a jour le contenu du Memento
		 * 
		 * @param texte
		 */
		public void setTexte(String texte) {
			this.texte = texte;
		}

	}

}
