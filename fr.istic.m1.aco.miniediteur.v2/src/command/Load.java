package command;

import ihm.Ihm;
import memento.Memento;
import receiver.Moteur;
import receiver.MoteurImpl;

/**
 * Concrete Command "Load" implementant l'interface Command
 *
 * @since 1.1
 * @author Alexis LE MASLE et Fanny PRIEUR
 */
public class Load implements Command {

	/**
	 * Nouvelle instance de l'interface Moteur declarant la methode load
	 *
	 * @see Moteur
	 */
	private Moteur moteur;

	private Ihm ihm;

	private boolean replay = false;

	/**
	 * Constructeur de la classe Load
	 *
	 * @param moteur
	 */
	public Load(Moteur moteur, Ihm ihm) {
		this.moteur = moteur;
		this.ihm = ihm;
	}

	// Operations

	/**
	 * Appel de la mise en oeuvre de la fonction "load" dans l'implementation
	 * Moteur.
	 *
	 * @see MoteurImpl
	 */
	public void execute() {
		String filename = ihm.getFile();
		try {
			moteur.load(filename);
		} catch (Exception e) {
			System.out.println("Error during loading file");
		}
	}

	public void setIhm(Ihm ihm) {
		this.ihm = ihm;
	}

	@Override
	public Memento getMemento() {
		return new Memento(new Load(moteur, ihm));
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
