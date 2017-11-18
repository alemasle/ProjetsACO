package command;

import ihm.Ihm;
import memento.Memento;
import receiver.Enregistreur;
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

	private Enregistreur enregistreur;

	/**
	 * Nouvelle String a inserer
	 */
	private Ihm ihm;

	private boolean replay = false;

	/**
	 * Constructeur de la classe Inserer
	 * 
	 * @param moteur
	 * @param str
	 */
	public Inserer(Moteur moteur, Ihm ihm, Enregistreur enregistreur) {
		this.moteur = moteur;
		this.ihm = ihm;
		this.enregistreur = enregistreur;
	}

	/**
	 * Appel de la mise en oeuvre de la fonction "inserer" dans l'implementation
	 * Moteur.
	 * 
	 * @see MoteurImpl
	 * 
	 */
	public void execute() {
		String str = "";
		if (replay) {
			str = ihm.getLastInput();
			moteur.inserer(str);
		} else {
			str = ihm.getText();
			moteur.inserer(str);
			if (enregistreur.getRecord()) {
				enregistreur.addMemento(getMemento());
			}
		}
	}

	public void setIhm(Ihm ihm) {
		this.ihm = ihm;
	}

	@Override
	public InsererMemento getMemento() {
		return new InsererMemento(new Inserer(moteur, ihm, enregistreur));
	}

	@Override
	public void setReplay(boolean bool) {
		this.replay = bool;
	}

	private class InsererMemento implements Memento<InsererMemento> {

		Inserer cmd;

		public InsererMemento(Inserer cmd) {
			this.cmd = cmd;
		}

		@Override
		public Command getCommand() {
			return cmd;
		}

	}

}
