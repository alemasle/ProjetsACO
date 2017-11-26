package command;

import ihm.Ihm;
import memento.Memento;
import receiver.Enregistreur;
import receiver.Manager;
import receiver.Moteur;
import receiver.MoteurImpl;
import state.State;

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

	private Enregistreur enregistreur;

	private AjouterMemento memento;

	private Manager manager;

	/**
	 * Constructeur de la classe Inserer
	 * 
	 * @param moteur
	 * @param str
	 */
	public Ajouter(Moteur moteur, Ihm ihm, Enregistreur enregistreur, Manager manager) {
		this.moteur = moteur;
		this.ihm = ihm;
		this.enregistreur = enregistreur;
		this.manager = manager;
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
		String str = "";
		AjouterMemento m = getMemento();
		if (enregistreur.getPlay() || manager.getPlay()) {
			str = memento.getTexte();
			moteur.ajouter(str);
		} else {
			str = ihm.getText();
			moteur.ajouter(str);
			if (enregistreur.getRecord()) {
				m.setTexte(str);
				enregistreur.addMemento(m);
				enregistreur.addCommand(this);
			}
		}
		if (!manager.getPlay()) {
			State st = manager.getStateCourant();
			m.setTexte(str);
			st.addMem(m);
			st.addCmd(this);
			manager.saveState();
			manager.emptyRedo();
		}
	}

	public void setIhm(Ihm ihm) {
		this.ihm = ihm;
	}

	@Override
	public AjouterMemento getMemento() {
		return new AjouterMemento();
	}

	private class AjouterMemento implements Memento<AjouterMemento> {

		private String texte;

		public String getTexte() {
			return texte;
		}

		public void setTexte(String texte) {
			this.texte = texte;
		}

		@Override
		public AjouterMemento clone() {
			AjouterMemento m = new AjouterMemento();
			m.setTexte(texte);
			return m;
		}

	}

	@Override
	public void setMemento(Memento<?> mem) {
		this.memento = (AjouterMemento) mem;
	}

	@Override
	public void setMoteur(Moteur moteur) {
		this.moteur = moteur;
	}

	@Override
	public Moteur getMoteur() {
		return moteur;
	}

	@Override
	public Ajouter clone() {
		Ajouter a = new Ajouter(moteur.clone(), ihm, enregistreur, manager);
		return a;
	}

}
