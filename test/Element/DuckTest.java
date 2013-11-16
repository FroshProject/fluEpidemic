package Element;


import static org.junit.Assert.*;
import org.junit.Test;
import Etat.*;


public class DuckTest {
	Duck test;
	public DuckTest(){
		test = new Duck();
	}
	@Test
	public void testGetType(){
		String expected = "D";
		String actual = test.getType();
		assertEquals(expected,actual);
	}
	@Test
	public void testToString(){
		String checkStateDead = "D☠";
		String checkStateSick = "D1";
		String checkStateHealthy = "D0";
		String checkStateRecovering = "D3";
		String checkStateContageous = "D2";
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
