package command;

import ihm.*;
import receiver.Moteur;

/**
 * Concrete Command "Inserer" implementant l'interface Command
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 * 
 */
public class Ajouter implements Command {

	/**
	 * Nouvelle instance de l'interface Moteur declarant la methode inserer
	 * 
	 * @see Moteur
	 */
	private Moteur moteur;

	/**
	 * Nouvelle String a inserer
	 */
	private Ihm ihm;

	/**
	 * Constructeur de la classe Inserer
	 * 
	 * @param moteur
	 * @param str
	 */
	public Ajouter(Moteur moteur, Ihm ihm) {
		this.moteur = moteur;
		this.ihm = ihm;
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

		String str = ihm.getText();

		moteur.ajouter(str);
	}

	public void setIhm(Ihm ihm) {
		this.ihm = ihm;
	}

}
