package Element;
import static org.junit.Assert.*;
import org.junit.Test;
import Etat.*;
import Maladie.*;
/**
 * La classe EtreTest execute les tests JUnit des méthodes la classe Etre
 * 
 * @author Etienne Strobbe
 * @version 1.0.0
 * 
 */

public class EtreTest {
	private Etre test;
	
	public EtreTest(){
		test = new Etre();
	}
	
	@Test
	public void testgetStateDay(){
		int expected = 1;
		int actual = test.getStateDay();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testIncStateDay(){
		int before = test.getStateDay();
		test.incStateDay();
		int after = test.getStateDay();
		assertEquals(after-before,1);
	}
	
	@Test
	public void testResetStateDay(){
		int expected = 1;
		test.resetStateDay();
		int actual = test.getStateDay();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testSetState(){
		Etat tmp = new Healthy();
		test.setState(tmp);
		assertEquals(tmp,test.getState());
		tmp = new Sick();
		test.setState(tmp);
		assertEquals(tmp,test.getState());
		tmp = new Dead();
		test.setState(tmp);
		assertEquals(tmp,test.getState());
		tmp = new Recovering();
		test.setState(tmp);
		assertEquals(tmp,test.getState());
		tmp = new Contageous();
		test.setState(tmp);
		assertEquals(tmp,test.getState());
	}
	
	@Test
	public void testGetState(){
		Etat tmp = new Healthy();
		Etat expected = tmp;
		test.setState(tmp);
		Etat actual = test.getState();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testSetContagieux(){
		test.setState(new Contageous());
		assertTrue(test.setContagieux());
		test.setState(new Sick());
		assertFalse(test.setContagieux());
		test.setState(new Dead());
		assertFalse(test.setContagieux());
		test.setState(new Healthy());
		assertFalse(test.setContagieux());
		test.setState(new Recovering());
		assertFalse(test.setContagieux());		
	}
	
	@Test
	public void testSetSick(){
		Virus vTmp = new H1N1();
		int expectedDay = test.getStateDay()+1;
		Etat expectedState = new Contageous();
		test.setVirus(vTmp);
		test.setSick(test,1);
		assertEquals(expectedDay-test.getStateDay(),0);
		test.setSick(test,1);
		assertEquals(expectedDay-test.getStateDay(),-1);
		test.setSick(test,1);
		assertEquals(expectedState.getClass(),test.getState().getClass());
		test.setSick(test,0);
		assertEquals(1,test.getStateDay());		
	}
	
	@Test
	public void testSetRecovering(){
		test.setState(new Recovering());
		int expectedDay = test.getStateDay()+3;
		Etat expectedState = new Healthy();
		for(int i=0;i<3;i++){
			test.setRecovering(test);
		}
		assertEquals(expectedDay-test.getStateDay(),0);
		test.setRecovering(test);
		assertEquals(expectedState.getClass(),test.getState().getClass());
	}
	
	@Test
	public void testSetContageous(){
		test.setState(new Contageous());
		Etat checkDead = new Dead();
		Etat checkRecovering = new Recovering();
		Etre case1 = test; // case 1 is going to recover
		Etre case2 = test; // case 2 is going to die
		for(int i=0;i<3;i++){
			test.setContageous(case1,1);
			test.setContageous(case2,0);
		}
		assertEquals(checkDead.getClass(),case2.getState().getClass());
		assertEquals(checkRecovering.getClass(),case1.getState().getClass());
	}
}
