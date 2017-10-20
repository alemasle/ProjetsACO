package Receiver;

import State.*;

/**
 * Class MoteurImpl comprennant la mise en oeuvre des chacunes des fonctions
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 * 
 */
public class MoteurImpl implements Moteur {

	Buffer buffer = new Buffer();

	ClipBoard clip = new ClipboardImpl();

	Selection select = new Selection();
	
	public MoteurImpl() {

	}

	// Operations

	/**
	 * Selectionne une partie du texte ayant comme debut le caracters a la
	 * position debut et selectionnant tous les caracteres jusqu'a la position
	 * fin.
	 * 
	 * @param debut
	 *            la position initiale
	 * @param fin
	 *            la fin de la selection
	 */
	public void selectionner(int debut, int fin) {
		// TODO
	}

	/**
	 * Permet de copier la selection.
	 */
	public void copier() {
		// TODO
	}

	/**
	 * Insere une chaine de caracteres a la position courante.
	 * 
	 * @param str
	 *            La chaine de caractere a inserer
	 * 
	 */
	public void inserer(String str) {
		// TODO
	}

	/**
	 * Met dans le press-papier la selection courante et efface la selection du
	 * texte.
	 */
	public void couper() {
		// TODO
	}

	/**
	 * Colle le contenu du press-papier a la position actuelle en decalant le
	 * texte existant apres la position courante.
	 */
	public void coller() {
		// TODO
	}

}
