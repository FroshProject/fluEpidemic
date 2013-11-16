package Main;
import static org.junit.Assert.*;
import org.junit.Test;
import Element.*;
/**
 * La classe CelluleTest execute les tests JUnit des méthodes la classe Cellule
 * 
 * @author Etienne Strobbe
 * @version 1.0.0
 * 
 */
public class CelluleTest {
	Cellule test;
	
	public CelluleTest(){
		test = new Cellule(1,1,new Pig());
	}
	
	@Test
	public void testRemoveContent(){
		test.removeContent();
		Cellule actual = test.getCellule();
		Cellule expected = new Cellule(1,1,new Etre());
		assertTrue(actual.equals(expected));
	}
	
	@Test
	public void testEstValide(){
		assertFalse(test.estValide());
		test.removeContent();
		assertTrue(test.estValide());
	}

}
