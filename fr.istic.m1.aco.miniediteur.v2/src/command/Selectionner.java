package command;

import ihm.Ihm;
import memento.Memento;
import receiver.Enregistreur;
import receiver.Moteur;
import receiver.MoteurImpl;

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

	private Ihm ihm;

	private Enregistreur enregistreur;

	int deb;

	int fin;

	private SelectionnerMemento memento;

	/**
	 * Constructeur de la classe Selectionner
	 * 
	 * @param moteur
	 * @param ihm
	 * @param enregistreur
	 */
	public Selectionner(Moteur moteur, Ihm ihm, Enregistreur enregistreur) {
		this.moteur = moteur;
		this.ihm = ihm;
		this.enregistreur = enregistreur;
	}

	// Operations

	/**
	 * Appel de la mise en oeuvre de la fonction "selectionner" dans
	 * l'implementation Moteur. Demande les bornes de debut et de fin a
	 * l'utilsateur. Si la commande est en mode replay alors elle utilise les
	 * dernieres bornes. Inverse les bornes si debut est plus grand que fin.
	 * 
	 * @see MoteurImpl
	 * 
	 */
	@Override
	public void execute() {
		if (enregistreur.getPlay()) {
			deb = memento.getDeb();
			fin = memento.getFin();
			if (deb > fin) {
				int tmp = fin;
				fin = deb;
				deb = tmp;
			}
			moteur.selectionner(deb, fin);
		} else {
			deb = ihm.getDebut();
			fin = ihm.getFin();
			if (deb > fin) {
				int tmp = fin;
				fin = deb;
				deb = tmp;
			}
			moteur.selectionner(deb, fin);
			if (enregistreur.getRecord()) {
				SelectionnerMemento m = getMemento();
				m.setDeb(deb);
				m.setFin(fin);
				enregistreur.addMemento(m);
				enregistreur.addCommand(this);
			}
		}
	}

	public void setIhm(Ihm ihm) {
		this.ihm = ihm;
	}

	/**
	 * Cree un nouveau SelectionnerMemento
	 */
	@Override
	public SelectionnerMemento getMemento() {
		return new SelectionnerMemento();
	}

	/**
	 * Classe SelectionnerMemento implementant Memento et ne servant que
	 * Selectionner
	 * 
	 * @author Alexis LE MASLE et Fanny PRIEUR
	 *
	 */
	public class SelectionnerMemento implements Memento<SelectionnerMemento> {

		/**
		 * Les attributs de debut et de fin a sauvegarder lorsqu'on enregistre
		 */
		int deb;
		int fin;

		public int getDeb() {
			return deb;
		}

		public void setDeb(int deb) {
			this.deb = deb;
		}

		public int getFin() {
			return fin;
		}

		public void setFin(int fin) {
			this.fin = fin;
		}

	}

	@Override
	public void setMemento(Memento<?> mem) {
		this.memento = (SelectionnerMemento) mem;
	}

}
