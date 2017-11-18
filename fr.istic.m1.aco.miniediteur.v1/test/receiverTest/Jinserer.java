package receiverTest;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

import command.Coller;
import command.Command;
import command.Copier;
import command.Couper;
import command.Inserer;
import command.Selectionner;
import receiver.Moteur;
import receiver.MoteurImpl;
import state.Buffer;
import state.ClipBoard;
import state.ClipboardImpl;
import state.Selection;
import ihm.Ihm;


/**
 * Fichier Test Inserer
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 * 
 */



public class Jinserer {

	
	@Test
	public void testGetInserer() {
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);
		//TODO
		/*Ihm ihm;
		Inserer inserer = new Inserer(moteur, ihm);
		
		String str = "InsererTest";
		inserer.setTexte(str);
		assertEquals("Contenu different à l'appel de getTexte()", inserer.getTexte(), str);*/
	}
	
	/*
	@Test
	public void testInserer1() {
		String str = new String("abcdef");
		StringBuffer stringBuffer = new StringBuffer("insere");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
	
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);

		buffer.setBuffer(stringBuffer);
	
		selection.setDebut(0);
		Command inserer = new Inserer(moteur, str);
		inserer.execute();

		assertTrue(("abcdefinsere").compareTo(buffer.getBuffer().toString()) == 0);

	}

	@Test
	public void testInserer2() {
		String str = new String("abcdef");
		StringBuffer stringBuffer = new StringBuffer("insere");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();

		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);

		Command inserer = new Inserer(moteur, str);
		inserer.execute();
		assertNotNull("La chaine n'est pas vide", str);
	}

	@Test
	public void testInserer3() {

		String str = new String("abcdef");
		StringBuffer stringBuffer = new StringBuffer("insere");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);

		buffer.setBuffer(stringBuffer);
	
		selection.setDebut(6);
		Command inserer = new Inserer(moteur, str);
		inserer.execute();

		assertTrue(("insereabcdef").compareTo(buffer.getBuffer().toString()) == 0);

	}

	@Test
	public void testInserer4() {

		String str = new String("abcdef");
		StringBuffer stringBuffer = new StringBuffer("insere");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
	
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);

		buffer.setBuffer(stringBuffer);
		
		selection.setDebut(3);
		Command inserer = new Inserer(moteur, str);
		inserer.execute();

		assertTrue(("insabcdefere").compareTo(buffer.getBuffer().toString()) == 0);

	}*/

}
