package receiver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import command.Command;
import memento.Memento;
import state.Buffer;
import state.ClipBoard;
import state.Selection;
import state.State;

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
	 * Selectionne une partie du texte ayant comme debut le caractere a la position
	 * debut et selectionnant tous les caracteres jusqu'a la position fin. Si debut
	 * est superieur a fin alors on inverse les positions.
	 *
	 * @param debut
	 *            la position initiale
	 * @param fin
	 *            la fin de la selection
	 */
	@Override
	public void selectionner(int debut, int fin) {
		int deb = debut;
		int fi = fin;

		int len = buffer.getBuffer().length();

		if (deb > len) {
			deb = len;
		}

		if (fi > len) {
			fi = len;
		}

		if (deb < 0) {
			deb = 0;
		}

		if (fi < 0) {
			fi = 0;
		}

		select.setDebut(deb);
		select.setFin(fi);
	}

	/**
	 * Permet de copier la selection.
	 */
	@Override
	public void copier() {
		int deb = select.getDebut();
		int fin = select.getFin();
		if (deb != fin) {
			clip.setClip(buffer.getBuffer().substring(deb, fin));
		}
	}

	/**
	 * Insere une chaine de caracteres a la position courante.
	 *
	 * @param str
	 *            La chaine de caractere a inserer
	 */
	@Override
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
	@Override
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
	@Override
	public void delete() {
		if (buffer.getBuffer().length() > 0) {
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
	}

	/**
	 * Met dans le press-papier la selection courante et efface la selection du
	 * texte.
	 */
	@Override
	public void couper() {
		int deb = select.getDebut();
		int fin = select.getFin();
		if (deb != fin) {
			clip.setClip(buffer.getBuffer().substring(deb, fin));
			removeSelect();
		}
	}

	/**
	 * Colle le contenu du press-papier a la position actuelle en decalant le texte
	 * existant apres la position courante.
	 */
	@Override
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
	@Override
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
	@Override
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
				res.deleteCharAt(res.length() - 1);
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
	@Override
	public Selection getSelect() {
		return select;
	}

	/**
	 * @param select
	 *            le select a† definir
	 */
	@Override
	public void setSelect(Selection select) {
		this.select = select;
	}

	/**
	 * @return le clip
	 */
	@Override
	public ClipBoard getClip() {
		return clip;
	}

	/**
	 * @param clip
	 *            le clip √† d√©finir
	 */
	@Override
	public void setClip(ClipBoard clip) {
		this.clip = clip;
	}

	/**
	 * @return le buffer
	 */
	@Override
	public Buffer getBuffer() {
		return buffer;
	}

	/**
	 * @param buffer
	 *            le buffer a† definir
	 */
	@Override
	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}

	/**
	 * 
	 * Permet de faire un saut a la ligne.
	 * 
	 * @since v3
	 */
	@Override
	public void newLine() {
		removeSelect();
		int pos = select.getDebut();
		buffer.getBuffer().insert(pos, "\n");
		selectionner(pos + 1, pos + 1);
	}

	/**
	 * 
	 * Permet de recreer l'etat donne en parametre, utilisee pour defaire ou refaire
	 * une commande et retourner a un etat precedent
	 * 
	 * @param stM
	 */
	@Override
	public void recreer(State stM) {

		String buf = stM.getMoteur().getBuffer().getBuffer().toString();

		StringBuffer res = new StringBuffer(buf);

		buffer.setBuffer(res);
		select.setDebut(stM.getMoteur().getSelect().getDebut());
		select.setFin(stM.getMoteur().getSelect().getFin());

		List<Command> lcmd = stM.getLcmd();
		List<Memento<?>> lmem = stM.getLmem();
		Command cmd = null;

		for (int i = 0; i < lcmd.size(); i++) {
			cmd = lcmd.get(i);
			cmd.setMemento(lmem.get(i));
			cmd.setMoteur(this);
			cmd.execute();
		}

	}

	/**
	 * Permet de cloner le moteur actuel
	 * 
	 * @since v3
	 */
	@Override
	public Moteur clone() {
		Moteur mot = new MoteurImpl(buffer.clone(), clip.clone(), select.clone());
		return mot;
	}

}
