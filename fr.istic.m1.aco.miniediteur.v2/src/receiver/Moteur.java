package receiver;

import state.Buffer;

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
}
