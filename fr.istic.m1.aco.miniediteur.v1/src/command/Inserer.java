package command;

import ihm.Ihm;
import receiver.Moteur;
import receiver.MoteurImpl;

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

	/**
	 * L'ihm permettant d'obtenir la string a inserer
	 */
	private Ihm ihm;

	/**
	 * Nouvelle String a inserer
	 */
	private String str;

	/**
	 * Constructeur de la classe Inserer
	 * 
	 * @param moteur
	 * @param ihm
	 */
	public Inserer(Moteur moteur, Ihm ihm) {
		this.moteur = moteur;
		this.ihm = ihm;
		this.str = "";
	}

	// Operations

	/**
	 * Setter
	 * 
	 * @param chaine
	 *            est le texte � sauvegarder
	 */
	public void setTexte(String chaine) {
		this.str = chaine;
	}

	/**
	 * Getter
	 * 
	 * @return met la chaine str dans la commande
	 */
	public String getTexte() {
		return this.str;
	}

	/**
	 * Appel de la mise en oeuvre de la fonction "inserer" dans l'implementation
	 * Moteur.
	 * 
	 * @see MoteurImpl
	 * 
	 */
	@Override
	public void execute() {

		String str = ihm.getText();

		moteur.inserer(str);
	}

	public void setIhm(Ihm ihm) {
		this.ihm = ihm;
	}

}
