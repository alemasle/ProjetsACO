package state;

/**
 * Classe ClipboardImpl qui implements l'interface Clipboard
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 */
public class ClipboardImpl implements ClipBoard {

	/**
	 * String contenant le texte qui a ete copie
	 */
	private String clip = "";
	
	public ClipboardImpl() {
			
	}

	/**
	 * Permet de rendre le contenu du presse-papier
	 * 
	 * @return clip le contenu du presse-papier
	 */
	public String getClip() {
		return clip;
	}

	/**
	 * Permet de mettre a jour le contenu du presse-papier
	 * 
	 * @param clip
	 *            le nouveau contenu a mettre dans le presse-papier.
	 */
	public void setClip(String clip) {
		this.clip = clip;
	}

}
