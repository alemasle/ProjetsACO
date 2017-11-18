package receiverTest;

import static org.junit.Assert.*;

import org.junit.Test;

<<<<<<< HEAD

import command.Command;
<<<<<<< HEAD
import command.Delete;
import command.Delete.CouperMemento;
=======
import command.Couper;

>>>>>>> 7906bc76829d657573f667474571022ba5e4a7e8
import receiver.Moteur;
import receiver.MoteurImpl;
=======
import command.*;
import receiver.*;
>>>>>>> 8cecf6f0c04c1e5a92401c55f666f28a0c140a02
import state.Buffer;
import state.*;

/**
 * Fichier Test Couper
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 * 
 */

public class Jcouper {

	/**
	 * 
	 * 
	 *
	 */

	// TODO
	@Test
	public void testCouper() {
<<<<<<< HEAD
		StringBuffer stringBuffer= new StringBuffer("couper");
    	Buffer buffer = new Buffer();
    	Selection selection = new Selection();
    	ClipBoard pressePapier= new ClipboardImpl();
    
    	Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);
    	
    	buffer.setBuffer(stringBuffer);
    
    	selection.setDebut(3);
    	selection.setFin(3);
<<<<<<< HEAD
    	Command couper = new Delete(moteur, enregistreur);
=======
    	Command couper = new Couper(moteur);
>>>>>>> 7906bc76829d657573f667474571022ba5e4a7e8
    	couper.execute();
    	
    	assertTrue(("").compareTo(pressePapier.getClip())==0);
        assertTrue(("couper").compareTo(buffer.getBuffer().toString())==0);
=======
		StringBuffer stringBuffer = new StringBuffer("couper");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();

		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);

		buffer.setBuffer(stringBuffer);

		selection.setDebut(3);
		selection.setFin(3);
		Command couper = new Couper(moteur);
		couper.execute();

		assertTrue(("").compareTo(pressePapier.getClip()) == 0);
		assertTrue(("couper").compareTo(buffer.getBuffer().toString()) == 0);
>>>>>>> 8cecf6f0c04c1e5a92401c55f666f28a0c140a02
	}

	/**
	 * test le stringBuffer apr�s s�lection des caract�res de 0 � 6 soit
	 * "couper" test en assertTrue que "couper" est bien dans le presse papier
	 * et est supprim� du buffer
	 *
	 */
	@Test
	public void testCouper2() {
<<<<<<< HEAD
		StringBuffer stringBuffer= new StringBuffer("couper");
    	Buffer buffer = new Buffer();
    	Selection selection = new Selection();
    	ClipBoard pressePapier= new ClipboardImpl();
    	
    	Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);
    	
    	buffer.setBuffer(stringBuffer);
    	
    	selection.setDebut(0);
    	selection.setFin(6);
<<<<<<< HEAD
    	Command couper = new Delete(moteur, enregistreur);
=======
    	Command couper = new Couper(moteur);
>>>>>>> 7906bc76829d657573f667474571022ba5e4a7e8
    	couper.execute();
    	
    	assertTrue(("couper").compareTo(pressePapier.getClip())==0);
        assertTrue(("").compareTo(buffer.getBuffer().toString())==0);
		
	}
	
<<<<<<< HEAD
	@Test
	public void testSetMemento() {
		//pas d'action
	}
=======
		StringBuffer stringBuffer = new StringBuffer("couper");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();

		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);

		buffer.setBuffer(stringBuffer);

		selection.setDebut(0);
		selection.setFin(6);
		Command couper = new Couper(moteur);
		couper.execute();

		assertTrue(("couper").compareTo(pressePapier.getClip()) == 0);
		assertTrue(("").compareTo(buffer.getBuffer().toString()) == 0);
>>>>>>> 8cecf6f0c04c1e5a92401c55f666f28a0c140a02

	}
<<<<<<< HEAD
	
=======
>>>>>>> 7906bc76829d657573f667474571022ba5e4a7e8
	
=======

>>>>>>> 8cecf6f0c04c1e5a92401c55f666f28a0c140a02
	/**
	 * test le stringBuffer apr�s s�lection des caract�res de 2 � 5 soit "upe"
	 * que l'on coupe du pressepapier et il reste donc les caract�res "cor" dans
	 * le buffer
	 *
	 */
	@Test
	public void testCouper3() {
<<<<<<< HEAD
		StringBuffer stringBuffer= new StringBuffer("couper");
    	Buffer buffer = new Buffer();
    	Selection selection = new Selection();
    	ClipBoard pressePapier= new ClipboardImpl();
    	
    	Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);
    	
    	buffer.setBuffer(stringBuffer);
    
    	selection.setDebut(2);
    	selection.setFin(5);
<<<<<<< HEAD
    	Command couper = new Delete(moteur, enregistreur);
=======
    	Command couper = new Couper(moteur);
>>>>>>> 7906bc76829d657573f667474571022ba5e4a7e8
    	couper.execute();
    	
    	assertTrue(("upe").compareTo(pressePapier.getClip())==0);
        assertTrue(("cor").compareTo(buffer.getBuffer().toString())==0);
		
=======
		StringBuffer stringBuffer = new StringBuffer("couper");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();

		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);

		buffer.setBuffer(stringBuffer);

		selection.setDebut(2);
		selection.setFin(5);
		Command couper = new Couper(moteur);
		couper.execute();

		assertTrue(("upe").compareTo(pressePapier.getClip()) == 0);
		assertTrue(("cor").compareTo(buffer.getBuffer().toString()) == 0);

>>>>>>> 8cecf6f0c04c1e5a92401c55f666f28a0c140a02
	}
}
