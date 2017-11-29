package state;

/**
 * Classe Buffer reprentant le contenu du mini editeur a afficher et modifier
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 *
 */
public class Buffer {

	/**
	 * Initialisation du buffer de base
	 */
	private StringBuffer buffer = new StringBuffer("");

	public StringBuffer getBuffer() {
		return buffer;
	}

	public void setBuffer(StringBuffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public Buffer clone() {
		Buffer b = new Buffer();
		b.setBuffer(new StringBuffer(buffer.toString()));
		return b;
	}
}
