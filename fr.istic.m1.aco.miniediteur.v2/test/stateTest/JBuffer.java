package stateTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import state.Buffer;

/**
 * Fichier Test Buffer
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 * 
 */

public class JBuffer {

	@Test
	public void testBuffer() {
		StringBuffer stringBuffer = new StringBuffer("");
		Buffer buffer = new Buffer();

		buffer.setBuffer(stringBuffer);

		assertTrue((buffer.getBuffer().toString().compareTo("") == 0));
	}

	@Test
	public void testBuffer2() {
		StringBuffer stringBuffer = new StringBuffer("ninjaLennon");
		Buffer buffer = new Buffer();

		buffer.setBuffer(stringBuffer);

		assertFalse((buffer.toString().compareTo("ninja")) == 0);

	}

	@Test
	public void testBuffer3() {
		StringBuffer stringBuffer = new StringBuffer("123 456      BobLennon    5485ret :!::: erer )()-_./__ ninja");
		Buffer buffer = new Buffer();

		buffer.setBuffer(stringBuffer);

		assertFalse((buffer.getBuffer().toString()
				.compareTo("123 456      abcd    5485ret :!::: erer )()-_./__ ninja")) == 0);
	}

}
