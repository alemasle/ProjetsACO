package State;

import static org.junit.Assert.*;

import org.junit.Test;

public class JClipBoard {

	@Test
	public void testClipboardImpl() {
		ClipBoard pressePapier = new ClipboardImpl();
		
		pressePapier.setClip("");
		
		assertTrue((pressePapier.getClip().compareTo(""))==0);
	}

	@Test
	public void testClipboardImpl2() {
		ClipBoard pressePapier = new ClipboardImpl();
		
		pressePapier.setClip("pressePaper");
		
		assertTrue((pressePapier.getClip().compareTo("pressePaper"))==0);
	}
	
	@Test
	public void testGetClip() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetClip() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testClipboardImpl3() {
		ClipBoard pressePapier = new ClipboardImpl();
		
		pressePapier.setClip("pressePapeterie");
		
		assertFalse((pressePapier.getClip().compareTo("pressePap"))==0);
	}
	
	

}
