package Receiver;

import State.*;

/**
 * Class MoteurImpl comprennant la mise en oeuvre des chacunes des fonctions
 *
 * @author Alexis LE MASLE et Fanny PRIEUR
 */
public class MoteurImpl implements Moteur {

	private Buffer buffer;

	private ClipBoard clip;

	private Selection select;

	public MoteurImpl(ClipBoard clip, Selection select, Buffer buffer) {
		this.clip = clip;
		this.select = select;
		this.buffer = buffer;

	}

	// Operations

	/**
	 * Selectionne une partie du texte ayant comme debut le caracters a la
	 * position debut et selectionnant tous les caracteres jusqu'a la position
	 * fin. Si debut > fin alors on inverse les positions.
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
		// TODO
	}

	/**
	 * Met dans le press-papier la selection courante et efface la selection du
	 * texte.
	 */
	public void couper() {
		clip.setClip(buffer.getBuffer().substring(select.getDebut(),select.getFin()));
		buffer.getBuffer().delete(select.getDebut(),select.getFin());
	}

	/**
	 * Colle le contenu du press-papier a la position actuelle en decalant le
	 * texte existant apres la position courante.
	 */
	public void coller() {
		buffer.getBuffer().insert(select.getDebut(), clip.getClip());
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
