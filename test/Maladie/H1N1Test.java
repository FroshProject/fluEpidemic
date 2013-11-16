package Maladie;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * La classe H1N1Test execute les tests JUnit des méthodes la classe H1N1
 * 
 * @author Etienne Strobbe
 * @version 1.0.0
 * 
 */
public class H1N1Test {
	
	private H1N1 test;
	public H1N1Test(){
		test = new H1N1();
	}
	
	@Test
	public void testGetIncubation(){
		int expected = 3;
		int actual = test.getIncubation();
		assertEquals(expected,actual);
	}

}
