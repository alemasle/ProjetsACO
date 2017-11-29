package command;

import ihm.Ihm;
import receiver.Moteur;
import receiver.MoteurImpl;

/**
 * Concrete Command "Ajouter" implementant l'interface Command
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 * 
 */
public class Ajouter implements Command {

	/**
	 * Nouvelle instance de l'interface Moteur declarant la methode ajouter
	 * 
	 * @see Moteur
	 */
	private Moteur moteur;

	/**
	 * L'ihm permettant de connaitre la string a ajouter
	 */
	private Ihm ihm;

	/**
	 * Constructeur de la classe Ajouter
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
	 * Appel de la mise en oeuvre de la fonction "ajouter" dans l'implementation
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
