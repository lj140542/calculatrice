package jonathanLefebvre_calculatrice;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.runner.Version;

public class CalculatriceTest {

	protected Calculatrice calculatrice;

	@Before
	public void setUp() {
		calculatrice = new Calculatrice();
	}

	// Les opérandes étant toutes des doubles, et le nombre de celles-ci étant
	// vérifié avant l'appel de chacune des méthodes de calculs, Les paramètres
	// ne peuvent êtres null ou en dehors de l'ensemble sur lequel le calcul se
	// réalise
	@Test
	public void testAddition() {
		assertEquals(5, calculatrice.addition(3, 2), 0.00001);
	}

	@Test
	public void testSoustraction() {
		assertEquals(5, calculatrice.soustraction(7, 2), 0.00001);
	}
	
	@Test
	public void testSoustractionNegative() {
		assertEquals(5, calculatrice.soustraction(3, -2), 0.00001);
	}

	@Test
	public void testMultiplication() {
		assertEquals(6, calculatrice.multiplication(3, 2), 0.00001);
	}
	
	@Test
	public void testMultiplicationNulle() {
		assertEquals(0, calculatrice.multiplication(3, 0), 0.00001);
	}
	
	@Test
	public void testMultiplicationNegative() {
		assertEquals(-9, calculatrice.multiplication(3, -3), 0.00001);
	}

	@Test
	public void testDivision() {
		assertEquals(3, calculatrice.division(6, 2), 0.00001);
	}

	@Test
	public void testRacine() {
		assertEquals(5, calculatrice.racine(25), 0.00001);
	}

	@Test
	public void testCarre() {
		assertEquals(25, calculatrice.carre(5), 0.00001);
	}

	@Test
	public void testSin() {
		assertEquals(1, calculatrice.sin(Math.PI / 2), 0.00001);
	}

	@Test
	public void testCos() {
		assertEquals(0.5, calculatrice.cos(Math.PI / 3), 0.00001);
	}

	@Test
	public void testTan() {
		assertEquals(1.73205080757, calculatrice.tan(Math.PI / 3), 0.00001);
	}

	@Test
	public void testInv() {
		assertEquals(0.25, calculatrice.inv(4), 0.00001);
	}

	@Test
	public void testOpp() {
		assertEquals(-5, calculatrice.opp(5), 0.00001);
	}

	@Test
	public void testPuiss() {
		assertEquals(8, calculatrice.puiss(2, 3), 0.00001);
	}

	@Test
	public void testPuissNull() {
		assertEquals(1, calculatrice.puiss(2, 0), 0.00001);
	}

	@Test
	public void testPuissUn() {
		assertEquals(2, calculatrice.puiss(2, 1), 0.00001);
	}

	@Test
	public void testPuissNegatif() {
		assertEquals(0.25, calculatrice.puiss(2, -2), 0.00001);
	}

	@Test
	public void testGamma() {
		assertEquals(2.67893853, calculatrice.gamma(1.0 / 3), 0.00001);
	}
}