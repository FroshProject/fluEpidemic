package Etat;

import static org.junit.Assert.*;
import org.junit.Test;

public class DeadTest {
	private Dead test;
	public DeadTest(){
		test = new Dead();
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
		String expected = "☠";
		String actual = test.numEtat();
		assertEquals(expected,actual);
	}
	
	
}
