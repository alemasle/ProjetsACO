package Receiver;

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

}
