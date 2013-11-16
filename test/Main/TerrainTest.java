package Main;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * La classe TerrainTest execute les tests JUnit des méthodes la classe Terrain
 * 
 * @author Etienne Strobbe
 * @version 1.0.0
 * 
 */
public class TerrainTest {
	
	Terrain test;
	
	public TerrainTest(){
		test = new Terrain(10);
	}
	
	@Test
	public void testClone(){
		Terrain check = new Terrain(10);
		Terrain tmp = new Terrain();
		test.clone(tmp);
		assertTrue(check.equals(tmp));
	}
}
