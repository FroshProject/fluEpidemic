package Element;


import static org.junit.Assert.*;
import org.junit.Test;
import Etat.*;


public class PigTest {
	Pig test;
	public PigTest(){
		test = new Pig();
	}
	@Test
	public void testGetType(){
		String expected = "P";
		String actual = test.getType();
		assertEquals(expected,actual);
	}
	@Test
	public void testToString(){
		String checkStateDead = "P☠";
		String checkStateSick = "P1";
		String checkStateHealthy = "P0";
		String checkStateRecovering = "P3";
		String checkStateContageous = "P2";
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
