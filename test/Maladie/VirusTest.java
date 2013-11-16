package Maladie;

import static org.junit.Assert.*;
import org.junit.Test;

public class VirusTest {
	Virus test;
	
	public VirusTest(){
		test = new Virus();
	}
	
	@Test
	public void TestGetIncubation(){
		int expected = 0;
		int actual = test.getIncubation();
		assertEquals(expected,actual);
	}
}
