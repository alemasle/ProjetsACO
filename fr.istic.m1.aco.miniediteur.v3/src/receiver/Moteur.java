package receiver;

import state.Buffer;
import state.ClipBoard;
import state.Selection;

/**
 * Interface Moteur comprenant les fonctions du mini editeur.
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 *
 */
public interface Moteur {

	public void copier();

	public void couper();

	public void coller();

	public void inserer(String str);

	public void selectionner(int deb, int fin);

	public void save(String filename) throws Exception;

	public void ajouter(String str);

	public void delete();

	public void load(String filename) throws Exception;

	public void setBuffer(Buffer buffer);

	public Buffer getBuffer();

	public Selection getSelect();

	public void setSelect(Selection select);

	public ClipBoard getClip();

	public void setClip(ClipBoard clip);

	public void newLine();

	public Moteur clone();
}
