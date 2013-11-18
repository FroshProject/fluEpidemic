package Etat;
/**
 * La classe SickTest execute les tests JUnit des méthodes la classe Sick
 * 
 * @author Etienne Strobbe
 * @version 1.0.0
 * 
 */
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
