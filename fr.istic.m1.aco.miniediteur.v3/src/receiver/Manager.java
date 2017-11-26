package receiver;

import state.State;

/**
 * 
 * Interface du manager Defaire/Refaire
 * 
 * @since v3
 * @author Alexis LE MASLE et Fanny PRIEUR
 *
 */
public interface Manager {

	void defaire();

	void refaire();

	void saveState();

	void setStateCourant(State s);

	State getStateCourant();

	boolean getPlay();

	void setPlay(boolean play);

	Moteur getMoteur();

	void setMoteur(Moteur moteur);

	void emptyRedo();

}
