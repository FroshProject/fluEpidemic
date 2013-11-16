package Maladie;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * La classe H5N1Test execute les tests JUnit des méthodes la classe H5N1
 * 
 * @author Etienne Strobbe
 * @version 1.0.0
 * 
 */
public class H5N1Test {
	
	private H5N1 test;
	public H5N1Test(){
		test = new H5N1();
	}
	
	@Test
	public void testGetIncubation(){
		int expected = 4;
		int actual = test.getIncubation();
		assertEquals(expected,actual);
	}

}
