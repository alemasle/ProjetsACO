package ihm;

import java.util.Scanner;

import command.*;
import state.*;

public class Ihm {
	private Command copier;
	private Command coller;
	private Command couper;
	private Command inserer;
	private Command selectionner;
	private Buffer buffer;
	private Selection selection;
	private Scanner input;

	public Ihm(Copier copier, Coller coller, Couper couper, Inserer inserer, Selectionner selectionner, Buffer buffer,
			Selection selection, Scanner scanner) {
		this.copier = copier;
		this.coller = coller;
		this.couper = couper;
		this.inserer = inserer;
		this.selectionner = selectionner;
		this.buffer = buffer;
		this.selection = selection;
		this.input = scanner;
	}

	/**
	 * 
	 * @return Le buffer de texte avec les marqueurs de selection
	 */
	public String printBuffer() {
		int deb = selection.getDebut();
		int fin = selection.getFin();

		if (deb != fin) {
			buffer.getBuffer().insert(deb, '>');
			buffer.getBuffer().insert(fin + 1, '<');
		} else {
			buffer.getBuffer().insert(deb, '|');
		}

		String str = buffer.getBuffer().toString();
		cleanBuffer();
		return str;
	}

	/**
	 * Supprime les marqueurs de selection dans le buffer afin de ne pas les
	 * dedoubler lors d'une nouvelle selection
	 */
	private void cleanBuffer() {
		int deb = selection.getDebut();
		int fin = selection.getFin();

		if (deb != fin) {
			buffer.getBuffer().deleteCharAt(deb);
			buffer.getBuffer().deleteCharAt(fin);
		} else {
			buffer.getBuffer().deleteCharAt(deb);
		}
	}

	/**
	 * 
	 * @return Le texte a inserer de l'utilisateur
	 */
	public String getText() {
		System.out.println("> Inserer: ");
		return input.nextLine();
	}

	/**
	 * 
	 * @return L'index de debut de la selection
	 */
	public int getDebut() {

		int len = buffer.getBuffer().length();

		System.out.println("Selection from (index): ");
		int deb = input.nextInt();

		if (deb < 0) {
			return 0;
		}
		if (deb > len) {
			return len;
		}
		return deb;
	}

	/**
	 * 
	 * @return L'index de fin de la selection
	 */
	public int getFin() {

		int len = buffer.getBuffer().length();

		System.out.println("To (index): ");
		int fin = input.nextInt();

		if (fin < 0) {
			return 0;
		}
		if (fin > len) {
			return len;
		}
		return fin;
	}

	public String optionsCommand() {
		return "Options: " + "| C : Copy |" + " V : Paste |" + " X : Cut |" + " I : Insert |" + " S : Select |"
				+ " Q : Quit |";
	}

	private void clearScreen() {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}

	public void executeCommand() {
		Boolean quit = false;

		while (!quit) {

			clearScreen();

			System.out.println(printBuffer());
			System.out.println("");

			// System.out.println("What do you want to do? ");
			System.out.println(optionsCommand());
			System.out.println("");

			String command = input.next();

			input.nextLine();

			if (command.length() == 0) {
				System.out.println("Please enter a non null option ");
				executeCommand();
			}

			while (command.length() == 0) {
				command = input.nextLine();
			}

			command.toLowerCase();
			char cmd = command.charAt(0);

			switch (cmd) {
			case 'c':
				copier.execute();
				break;
			case 'v':
				coller.execute();
				break;
			case 'x':
				couper.execute();
				break;
			case 'i':
				inserer.execute();
				break;
			case 's':
				selectionner.execute();
				break;
			case 'q':
				clearScreen();
				System.out.println("Goodbye ");
				System.out.println("> Quit");
				quit = true;
				break;
			default:
				clearScreen();
				System.out.println("Unknown Command: " + cmd);
				System.out.println("");
				break;
			}
		}
	}
}
