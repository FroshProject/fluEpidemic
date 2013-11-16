package Etat;

import static org.junit.Assert.*;
import org.junit.Test;

public class RecoveringTest {
	private Recovering test;
	
	public RecoveringTest(){
		test = new Recovering();
	}
	
	
	
	@Test
	public void testGetTpsEtat(){
		int expected = 4;
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
		String expected = "3";
		String actual = test.numEtat();
		assertEquals(expected,actual);
	}
	
	
}
