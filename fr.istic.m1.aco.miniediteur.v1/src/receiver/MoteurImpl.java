package receiver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import state.Buffer;
import state.ClipBoard;
import state.Selection;

/**
 * Class MoteurImpl comprennant la mise en oeuvre des chacunes des fonctions
 *
 * @author Alexis LE MASLE et Fanny PRIEUR
 */
public class MoteurImpl implements Moteur {

	/**
	 * Buffer contenant le texte a afficher
	 */
	private Buffer buffer;

	/**
	 * Le presse-papier permettant de sauvegarder.
	 */
	private ClipBoard clip;

	/**
	 * La selection d'un morceau du buffer
	 */
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
		int deb = select.getDebut();
		int fin = select.getFin();
		if (deb != fin) {
			clip.setClip(buffer.getBuffer().substring(deb, fin));
		}
	}

	/**
	 * Insere une chaine de caracteres a la position courante en ecransant le texte
	 * situe a la suite.
	 *
	 * @param str
	 *            La chaine de caractere a inserer
	 */
	public void inserer(String str) {
		int deb = select.getDebut();

		removeSelect();

		buffer.getBuffer().replace(deb, deb + str.length(), str);
		select.setDebut(deb + str.length());
		select.setFin(deb + str.length());
	}

	/**
	 * Add the str String at the current position.
	 *
	 * @param str
	 *            The String to add
	 */
	public void ajouter(String str) {
		int deb = select.getDebut();

		removeSelect();

		buffer.getBuffer().insert(deb, str);
		select.setDebut(deb + str.length());
		select.setFin(deb + str.length());
	}

	/**
	 * Remove the current selection or the previous character if there is no
	 * selection currently
	 */
	public void delete() {
		int deb = select.getDebut();
		int fin = select.getFin();

		if (deb == fin && deb > 0) {
			buffer.getBuffer().delete(deb - 1, deb);
			select.setDebut(deb - 1);
			select.setFin(deb - 1);
		} else {
			removeSelect();
		}
	}

	/**
	 * Met dans le press-papier la selection courante et efface la selection du
	 * texte.
	 */
	public void couper() {
		clip.setClip(buffer.getBuffer().substring(select.getDebut(), select.getFin()));
		removeSelect();
	}

	/**
	 * Colle le contenu du presse-papier a la position actuelle en decalant le texte
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
	 * Write the actual buffer in filename which is "filename.txt"
	 * 
	 * @since 1.1
	 */
	public void save(String filename) throws Exception {
		try {
			File file = new File(filename);
			FileWriter fw = new FileWriter(file);
			fw.write("");
			fw.write(buffer.getBuffer().toString());
			fw.close();
		} catch (Exception e) {
			throw new Exception("Error during file saving. ");
		}
	}

	/**
	 * Load the content of the file which is "filename.txt" in the buffer
	 * 
	 * @since 1.1
	 */
	public void load(String filename) throws Exception {
		try {
			File file = new File(filename);
			FileReader fr = null;
			String buf = "";

			if (file.isFile()) {
				fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String line = br.readLine();

				while (line != null) {
					buf += line + "\n";
					line = br.readLine();
				}

				StringBuffer res = new StringBuffer(buf);
				res.deleteCharAt(res.length() - 1);// Delete the last \n in the
													// string
				buffer.setBuffer(res);
				select.setDebut(res.length());
				select.setFin(res.length());
				br.close();
				fr.close();
			} else {
				System.out.println("The file " + filename + ".txt" + " does not exist");
			}
		} catch (Exception e) {
			throw new Exception("Error during file loading. ");
		}

	}

	/**
	 * Supprime l'interieur de la selection actuelle
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
	 *            le select a  definir
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
	 *            le clip a definir
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
	 *            le buffer a definir
	 */
	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}

}
