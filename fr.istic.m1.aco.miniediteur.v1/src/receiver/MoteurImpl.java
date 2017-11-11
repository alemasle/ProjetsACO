package receiver;

import state.*;

/**
 * Class MoteurImpl comprennant la mise en oeuvre des chacunes des fonctions
 *
 * @author Alexis LE MASLE et Fanny PRIEUR
 */
public class MoteurImpl implements Moteur {

	private Buffer buffer;

	private ClipBoard clip;

	private Selection select;

	public MoteurImpl(Buffer buffer, ClipBoard clip, Selection select) {
		this.clip = clip;
		this.select = select;
		this.buffer = buffer;
	}

	// Operations

	/**
	 * Selectionne une partie du texte ayant comme debut le caracters a la position
	 * debut et selectionnant tous les caracteres jusqu'a la position fin. Si debut
	 * > fin alors on inverse les positions.
	 *
	 * @param debut
	 *            la position initiale
	 * @param fin
	 *            la fin de la selection
	 */
	public void selectionner(int debut, int fin) {
		select.setDebut(debut);
		select.setFin(fin);
	}

	/**
	 * Permet de copier la selection.
	 */
	public void copier() {
		clip.setClip(buffer.getBuffer().substring(select.getDebut(), select.getFin()));
	}

	/**
	 * Insere une chaine de caracteres a la position courante.
	 *
	 * @param str
	 *            La chaine de caractere a inserer
	 */
	public void inserer(String str) {
		int deb = select.getDebut();
		int fin = select.getFin();

		removeSelect();

		buffer.getBuffer().replace(deb, deb + str.length(), str);
		select.setDebut(deb + str.length());
		select.setFin(fin + str.length());
	}

	/**
	 * Met dans le press-papier la selection courante et efface la selection du
	 * texte.
	 */
	public void couper() {
		int deb = select.getDebut();
		int fin = select.getFin();
		clip.setClip(buffer.getBuffer().substring(deb, fin));
		removeSelect();
	}

	/**
	 * Colle le contenu du press-papier a la position actuelle en decalant le texte
	 * existant apres la position courante.
	 */
	public void coller() {
		int deb = select.getDebut();
		String paste = clip.getClip();

		removeSelect();
		if (paste != null) {
			buffer.getBuffer().insert(deb, paste);

			select.setDebut(deb + paste.length());
			select.setFin(deb + paste.length());
		}
	}

	/**
	 * Supprimer l'interieur de la selection actuelle
	 */
	private void removeSelect() {
		int deb = select.getDebut();
		int fin = select.getFin();
		if (deb != fin) {
			buffer.getBuffer().delete(deb, fin);
			select.setDebut(deb);
			select.setFin(deb);
		}
	}

	/**
	 * @return le select
	 */
	public Selection getSelect() {
		return select;
	}

	/**
	 * @param select
	 *            le select à définir
	 */
	public void setSelect(Selection select) {
		this.select = select;
	}

	/**
	 * @return le clip
	 */
	public ClipBoard getClip() {
		return clip;
	}

	/**
	 * @param clip
	 *            le clip à définir
	 */
	public void setClip(ClipBoard clip) {
		this.clip = clip;
	}

	/**
	 * @return le buffer
	 */
	public Buffer getBuffer() {
		return buffer;
	}

	/**
	 * @param buffer
	 *            le buffer à définir
	 */
	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}

}
