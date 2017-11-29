package state;

public class Selection {

	/**
	 * Le debut et la fin de la selection initiale a 0
	 */
	private int debut = 0;
	private int fin = 0;

	/**
	 * @return le debut
	 */
	public int getDebut() {
		return debut;
	}

	/**
	 * Si debut est inferieur a 0 on le force a 0, pareil pour fin
	 * 
	 * @param debut
	 *            le debut a definir
	 */
	public void setDebut(int debut) {
		if (debut < 0) {
			this.debut = 0;
		} else {
			this.debut = debut;
		}
	}

	/**
	 * @return la fin
	 */
	public int getFin() {
		return fin;
	}

	/**
	 * @param fin
	 *            le fin a definir
	 */
	public void setFin(int fin) {
		if (fin < 0) {
			this.fin = 0;
		} else {
			this.fin = fin;
		}
	}

}
