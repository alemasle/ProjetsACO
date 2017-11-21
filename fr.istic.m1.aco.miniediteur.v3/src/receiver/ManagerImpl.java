package receiver;

import java.util.Stack;

import etats.State;

/**
 * 
 * Classe ManagerImpl implementant Manager
 * 
 * @since v3
 * @author Alexis LE MASLE et Fanny PRIEUR
 *
 */
public class ManagerImpl implements Manager {

	private Stack<State> defaire = new Stack<State>();
	private Stack<State> refaire = new Stack<State>();

}
