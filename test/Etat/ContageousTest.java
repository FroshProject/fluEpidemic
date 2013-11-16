package Etat;

import static org.junit.Assert.*;
import org.junit.Test;

public class ContageousTest {
	private Contageous test;
	public ContageousTest(){
		test = new Contageous();
	}
	
	@Test
	public void testGetTpsEtat(){
		int expected = 3;
		int actual = test.getTpsEtat();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testSetContageous(){
		boolean expected = true;
		boolean actual = test.setContagieux();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testNumEtat(){
		String expected = "2";
		String actual = test.numEtat();
		assertEquals(expected,actual);
	}
	
	
}
