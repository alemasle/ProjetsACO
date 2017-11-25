package state;

public class Selection {

	private int debut = 0;
	private int fin = 0;

	public Selection() {

	}

	/**
	 * @return le debut
	 */
	public int getDebut() {
		return debut;
	}

	/**
	 * @param debut
	 *            le debut à définir
	 */
	public void setDebut(int debut) {
		this.debut = debut;
	}

	/**
	 * @return le fin
	 */
	public int getFin() {
		return fin;
	}

	/**
	 * @param fin
	 *            le fin à définir
	 */
	public void setFin(int fin) {
		this.fin = fin;
	}

	public Selection clone() {
		Selection s = new Selection();
		return s;
	}

}
