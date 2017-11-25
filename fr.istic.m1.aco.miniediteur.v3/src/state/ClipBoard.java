package state;

/**
 * Interface presse-papier
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 */
public interface ClipBoard {

	public String getClip();

	public void setClip(String clip);

	public ClipBoard clone();

}
