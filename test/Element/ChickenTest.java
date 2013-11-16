package Element;


import static org.junit.Assert.*;
import org.junit.Test;
import Etat.*;


public class ChickenTest {
	Chicken test;
	public ChickenTest(){
		test = new Chicken();
	}
	@Test
	public void testGetType(){
		String expected = "C";
		String actual = test.getType();
		assertEquals(expected,actual);
	}
	@Test
	public void testToString(){
		String checkStateDead = "C☠";
		String checkStateSick = "C1";
		String checkStateHealthy = "C0";
		String checkStateRecovering = "C3";
		String checkStateContageous = "C2";
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
