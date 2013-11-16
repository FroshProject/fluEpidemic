package Maladie;
import static org.junit.Assert.*;
import org.junit.Test;

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
