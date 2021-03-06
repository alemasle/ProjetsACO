package ihm;

import java.util.Scanner;

import command.Ajouter;
import command.Coller;
import command.Command;
import command.CommandGeneral;
import command.Copier;
import command.Couper;
import command.Delete;
import command.Demarrer;
import command.Inserer;
import command.Load;
import command.Rejouer;
import command.Save;
import command.Selectionner;
import command.Stopper;
import state.Buffer;
import state.Selection;

/**
 * 
 * Interface Homme Machine
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 *
 */
public class Ihm {
	private Command copier;
	private Command coller;
	private Command couper;
	private Command inserer;
	private Command selectionner;
	private Buffer buffer;
	private Selection selection;
	private Scanner input;
	private CommandGeneral save;
	private Command ajouter;
	private Command delete;
	private CommandGeneral load;
	private CommandGeneral demarrer;
	private CommandGeneral stopper;
	private CommandGeneral rejouer;

	// Is Recording;
	private boolean record = false;

	public Ihm(Copier copier, Coller coller, Couper couper, Inserer inserer, Selectionner selectionner, Buffer buffer,
			Selection selection, Scanner scanner, Save save, Ajouter ajouter, Delete delete, Load load,
			Demarrer demarrer, Stopper stopper, Rejouer rejouer) {
		this.copier = copier;
		this.coller = coller;
		this.couper = couper;
		this.inserer = inserer;
		this.selectionner = selectionner;
		this.buffer = buffer;
		this.selection = selection;
		this.input = scanner;
		this.save = save;
		this.ajouter = ajouter;
		this.delete = delete;
		this.load = load;
		this.demarrer = demarrer;
		this.stopper = stopper;
		this.rejouer = rejouer;
	}

	/**
	 * 
	 * Si les marqueurs de debut et de fin de selection sont au meme endroit on
	 * affiche '>' sinon on affiche '>' + text + '<'
	 * 
	 * @return Le buffer de texte avec les marqueurs de selection
	 */
	public String printBuffer() {
		int deb = selection.getDebut();
		int fin = selection.getFin();

		if (deb != fin) {
			buffer.getBuffer().insert(deb, '>');
			buffer.getBuffer().insert(fin + 1, '<');
		}

		else {
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
		return input.nextLine();
	}

	/**
	 * 
	 * @return L'index de debut de la selection
	 */
	public int getDebut() {

		int len = buffer.getBuffer().length();
		int deb = -1;
		System.out.println("Selection from (index): ");

		while (deb == -1) {
			try {
				deb = input.nextInt();
			} catch (Exception e) {
				System.out.println("Please, enter a integer. ");
				input.nextLine();
			}
		}
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
		int fin = -1;

		System.out.println("To (index): ");

		while (fin == -1) {
			try {
				fin = input.nextInt();
			} catch (Exception e) {
				System.out.println("Please, enter a integer. ");
				input.nextLine();
			}
		}

		if (fin < 0) {
			return 0;
		}
		if (fin > len) {
			return len;
		}
		return fin;
	}

	/**
	 * 
	 * @return Le nom de fichier de sauvegarde
	 */
	public String getFile() {
		System.out.println("Enter the name of the file: ");
		String str = input.nextLine();
		str += ".txt";
		return str;
	}

	public String optionsCommand() {
		String str = "";
		if (!record) {
			str = "Options: " + "| C : Copy |" + " V : Paste |" + " X : Cut |" + " A : Add |" + " I : Insert |"
					+ " S : Select |" + " K : Save |" + " Q : Quit |" + " D : Delete |" + " L : Load |"
					+ " R : Record |" + " P : Replay |";
		} else {
			str = "Options: " + "| C : Copy |" + " V : Paste |" + " X : Cut |" + " A : Add |" + " I : Insert |"
					+ " S : Select |" + " K : Save |" + " Q : Quit |" + " D : Delete |" + " L : Load |"
					+ " R : StopRecord |" + " P : Replay |";
		}

		return str;
	}

	private void clearScreen() {
		for (int i = 0; i < 10; i++) {
			System.out.println("");
		}
	}

	public void executeCommand() {
		Boolean quit = false;

		clearScreen();
		System.out.println("_____________________________________");
		System.out.println("--------- Mini Text Editor ----------");
		System.out.println("_____________________________________");

		System.out.println("v2.1 by Alexis LE MASLE & Fanny PRIEUR");
		System.out.println("");
		System.out.println("");

		while (!quit) {

			System.out.println(printBuffer());
			System.out.println("");

			System.out.println(optionsCommand());
			System.out.println("");

			String command = input.next();

			input.nextLine();

			while (command.length() == 0) {
				command = input.nextLine();
			}

			command.toLowerCase();
			char cmd = command.charAt(0);

			switch (cmd) {
			case 'c': // Copy in the clipboard the current selection
				clearScreen();
				System.out.println(printBuffer());
				System.out.println("");
				copier.execute();
				clearScreen();
				break;

			case 'v': // Paste the current clipboard
				clearScreen();
				System.out.println(printBuffer());
				System.out.println("");
				coller.execute();
				clearScreen();
				break;

			case 'x': // Cut the selection
				clearScreen();
				System.out.println(printBuffer());
				System.out.println("");
				couper.execute();
				clearScreen();
				break;

			case 'i': // Text to insert at the current selection
				clearScreen();
				System.out.println(printBuffer());
				System.out.println("");
				inserer.execute();
				clearScreen();
				break;

			case 'a': // Text to add at the current selection
				clearScreen();
				System.out.println(printBuffer());
				System.out.println("");
				ajouter.execute();
				clearScreen();
				break;

			case 'l': // Load the content of the given filename.txt
				clearScreen();
				System.out.println(printBuffer());
				System.out.println("");
				load.execute();
				clearScreen();
				System.out.println("--- Load Done ---");
				System.out.println("");
				System.out.println("");
				break;

			case 's': // New selection
				clearScreen();
				System.out.println(printBuffer());
				System.out.println("");
				selectionner.execute();
				clearScreen();
				break;

			case 'd': // Delete the current selection
				clearScreen();
				System.out.println(printBuffer());
				System.out.println("");
				delete.execute();
				clearScreen();
				break;

			case 'q': // Quit the mini text editor
				clearScreen();
				System.out.println("Are you sure you want to quit ? All your unsaved data will be erased. (y/n)");
				String res = input.nextLine();
				res.toLowerCase();
				if (res.charAt(0) == 'y' || res.charAt(0) == 'o') {
					clearScreen();
					System.out.println("Goodbye ");
					System.out.println("> Quit");
					quit = true;
				} else {
					clearScreen();
					System.out.println("Quit canceled ");
				}
				break;

			case 'k': // Save the current buffer
				clearScreen();
				System.out.println(printBuffer());
				System.out.println("");
				save.execute();
				clearScreen();
				System.out.println("--- Save Done ---");
				System.out.println("");
				System.out.println("");
				break;

			case 'r': // Start or Stop the record
				record = !record;
				clearScreen();
				System.out.println(printBuffer());
				System.out.println("");
				if (record) {
					demarrer.execute();
				} else {
					stopper.execute();
				}
				clearScreen();
				break;

			case 'p': // Replay the record
				if (!record) {
					clearScreen();
					System.out.println(printBuffer());
					System.out.println("");
					rejouer.execute();
					clearScreen();
				} else {
					clearScreen();
					System.out.println("You can not replay while recording. ");
				}
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
