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
public class Inserer implements Command {

	/**
	 * Nouvelle instance de l'interface Moteur declarant la methode inserer
	 * 
	 * @see Moteur
	 */
	private Moteur moteur;

	private Enregistreur enregistreur;

	private InsererMemento memento;

	private Manager manager;

	private Ihm ihm;

	/**
	 * Constructeur de la classe Inserer
	 * 
	 * @param moteur
	 * @param ihm
	 * @param enregistreur
	 * @param manager
	 */
	public Inserer(Moteur moteur, Ihm ihm, Enregistreur enregistreur, Manager manager) {
		this.moteur = moteur;
		this.ihm = ihm;
		this.enregistreur = enregistreur;
		this.manager = manager;
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
		String str = "";
		InsererMemento m = getMemento();
		if (enregistreur.getPlay() || manager.getPlay()) {
			str = memento.getTexte();
			moteur.inserer(str);
		} else {
			str = ihm.getText();
			moteur.inserer(str);
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

	/**
	 * Cree un nouveau InsererMemento
	 */
	@Override
	public InsererMemento getMemento() {
		return new InsererMemento();
	}

	/**
	 * Classe InsererMemento implementant Memento et ne servant qu'a Inserer
	 * 
	 * @author Alexis LE MASLE et Fanny PRIEUR
	 *
	 */
	private class InsererMemento implements Memento<InsererMemento> {

		/**
		 * Le texte a sauvegarder
		 */
		private String texte;

		public String getTexte() {
			return texte;
		}

		public void setTexte(String texte) {
			this.texte = texte;
		}

		@Override
		public InsererMemento clone() {
			InsererMemento m = new InsererMemento();
			m.setTexte(texte);
			return m;
		}

	}

	@Override
	public void setMemento(Memento<?> mem) {
		this.memento = (InsererMemento) mem;
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
	public Inserer clone() {
		Inserer a = new Inserer(moteur.clone(), ihm, enregistreur, manager);
		return a;
	}

}
