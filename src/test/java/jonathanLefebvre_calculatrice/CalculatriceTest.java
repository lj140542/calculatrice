package jonathanLefebvre_calculatrice;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatriceTest {

	protected Calculatrice calculatrice;

	@Before
	public void setUp() {
		calculatrice = new Calculatrice();
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testAddition() {
		assertEquals(5, calculatrice.addition(3, 2));
	}

	@Test
	public void testSoustraction() {
		assertEquals(5, calculatrice.soustraction(7, 2));
	}

	@Test
	public void testMultiplication() {
		assertEquals(6, calculatrice.multiplication(3, 2));
	}

	@Test
	public void testDivision() {
		assertEquals(3, calculatrice.division(6, 2));
	}
	
	@Test
	public void testConstructeurString() {
		//doit print 7
		calculatrice = new Calculatrice("3 4 + 9 * 7");
	}
}