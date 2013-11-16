package Etat;

import static org.junit.Assert.*;
import org.junit.Test;

public class SickTest {
	private Sick test;
	
	public SickTest(){
		test = new Sick();
	}
	@Test
	public void testGetTpsEtat(){
		int expected = 0;
		int actual = test.getTpsEtat();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetContageous(){
		boolean expected = false;
		boolean actual = test.setContagieux();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testNumEtat(){
		String expected = "1";
		String actual = test.numEtat();
		assertEquals(expected,actual);
	}
	
	
}
