package state;

/**
 * Classe Buffer representant le contenu du mini editeur a afficher et modifier
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 *
 */
public class Buffer {

	/**
	 * Le buffer initial.
	 */
	private StringBuffer buffer = new StringBuffer("");

	public StringBuffer getBuffer() {
		return buffer;
	}

	public void setBuffer(StringBuffer buffer) {
		this.buffer = buffer;
	}

}
