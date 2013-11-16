package Element;
/**
 * La classe HommeTest execute les tests JUnit des méthodes la classe Homme
 * 
 * @author Etienne Strobbe
 * @version 1.0.0
 * 
 */

import static org.junit.Assert.*;
import org.junit.Test;
import Etat.*;


public class HommeTest {
	Homme test;
	public HommeTest(){
		test = new Homme();
	}
	@Test
	public void testGetType(){
		String expected = "H";
		String actual = test.getType();
		assertEquals(expected,actual);
	}
	@Test
	public void testToString(){
		String checkStateDead = "H☠";
		String checkStateSick = "H1";
		String checkStateHealthy = "H0";
		String checkStateRecovering = "H3";
		String checkStateContageous = "H2";
		test.setState(new Dead());
		assertEquals(checkStateDead,test.toString());
		test.setState(new Sick());
		assertEquals(checkStateSick,test.toString());
		test.setState(new Healthy());
		assertEquals(checkStateHealthy,test.toString());
		test.setState(new Recovering());
		assertEquals(checkStateRecovering,test.toString());
		test.setState(new Contageous());
		assertEquals(checkStateContageous,test.toString());
		
		
	}

}
