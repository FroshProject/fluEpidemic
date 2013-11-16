package Maladie;
import static org.junit.Assert.*;
import org.junit.Test;

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
