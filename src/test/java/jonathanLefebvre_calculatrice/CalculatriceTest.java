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
	private final double ERREUR = 0.00001;

	@Before
	public void setUp() {
		calculatrice = new Calculatrice();
	}

	@Test
	public void testAddition() {
		calculatrice.addPile(2);
		calculatrice.addPile(3);
		calculatrice.calcul("+");
		assertEquals(5, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testAdditionNulle() {
		calculatrice.addPile(2);
		calculatrice.addPile(0);
		calculatrice.calcul("+");
		assertEquals(2, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testAdditionNegative() {
		calculatrice.addPile(2);
		calculatrice.addPile(-2);
		calculatrice.calcul("+");
		assertEquals(0, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testAdditionNull() {
		calculatrice.addPile(2);
		calculatrice.calcul("+");
		assertEquals(2, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testSoustraction() {
		calculatrice.addPile(7);
		calculatrice.addPile(2);
		calculatrice.calcul("-");
		assertEquals(5, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testSoustractionNulle() {
		calculatrice.addPile(7);
		calculatrice.addPile(0);
		calculatrice.calcul("-");
		assertEquals(7, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testSoustractionNegative() {
		calculatrice.addPile(3);
		calculatrice.addPile(-2);
		calculatrice.calcul("-");
		assertEquals(5, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testSoustractionNull() {
		calculatrice.addPile(3);
		calculatrice.calcul("-");
		assertEquals(3, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testMultiplication() {
		calculatrice.addPile(3);
		calculatrice.addPile(2);
		calculatrice.calcul("*");
		assertEquals(6, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testMultiplicationNulle() {
		calculatrice.addPile(0);
		calculatrice.addPile(3);
		calculatrice.calcul("*");
		assertEquals(0, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testMultiplicationNegative() {
		calculatrice.addPile(3);
		calculatrice.addPile(-2);
		calculatrice.calcul("*");
		assertEquals(-6, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testMultiplicationNull() {
		calculatrice.addPile(3);
		calculatrice.calcul("*");
		assertEquals(3, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testRacine() {
		calculatrice.addPile(9);
		calculatrice.calcul("sqrt");
		assertEquals(3, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testRacineNulle() {
		calculatrice.addPile(0);
		calculatrice.calcul("sqrt");
		assertEquals(0, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testRacineNegative() {
		calculatrice.addPile(-2);
		calculatrice.calcul("sqrt");
		assertEquals(-2, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testRacineOperande() {
		calculatrice.addPile(25);
		calculatrice.addPile(9);
		calculatrice.calcul("sqrt");
		assertEquals(3, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testCarre() {
		calculatrice.addPile(3);
		calculatrice.calcul("carré");
		assertEquals(9, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testCarreNulle() {
		calculatrice.addPile(0);
		calculatrice.calcul("carré");
		assertEquals(0, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testCarreNegative() {
		calculatrice.addPile(-3);
		calculatrice.calcul("carré");
		assertEquals(9, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testCarreOperande() {
		calculatrice.addPile(5);
		calculatrice.addPile(3);
		calculatrice.calcul("carré");
		assertEquals(9, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testSin() {
		calculatrice.addPile(Math.PI / 2);
		calculatrice.calcul("sin");
		assertEquals(1, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testSinNulle() {
		calculatrice.addPile(0);
		calculatrice.calcul("sin");
		assertEquals(0, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testSinNegative() {
		calculatrice.addPile(-2);
		calculatrice.calcul("sin");
		assertEquals(-0.90929742682, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testSinOperande() {
		calculatrice.addPile(-2);
		calculatrice.addPile(Math.PI / 2);
		calculatrice.calcul("sin");
		assertEquals(1, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testCos() {
		calculatrice.addPile(Math.PI / 3);
		calculatrice.calcul("cos");
		assertEquals(0.5, calculatrice.sommet(), ERREUR);
	}
	
	@Test
	public void testCosNulle() {
		calculatrice.addPile(0);
		calculatrice.calcul("cos");
		assertEquals(1, calculatrice.sommet(), ERREUR);
	}
	
	@Test
	public void testCosNegative() {
		calculatrice.addPile(-2);
		calculatrice.calcul("cos");
		assertEquals(-0.41614683654, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testTan() {
		calculatrice.addPile(Math.PI / 3);
		calculatrice.calcul("tan");
		assertEquals(1.73205080757, calculatrice.sommet(), ERREUR);
	}
	
	@Test
	public void testTanNulle() {
		calculatrice.addPile(0);
		calculatrice.calcul("tan");
		assertEquals(0, calculatrice.sommet(), ERREUR);
	}
	
	@Test
	public void testTanNegative() {
		calculatrice.addPile(-2);
		calculatrice.calcul("tan");
		assertEquals(2.18503986326, calculatrice.sommet(), ERREUR);
	}
	
	@Test
	public void testTanOperande() {
		calculatrice.addPile(0);
		calculatrice.addPile(Math.PI / 3);
		calculatrice.calcul("tan");
		assertEquals(1.73205080757, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testInv() {
		calculatrice.addPile(4);
		calculatrice.calcul("inv");
		assertEquals(0.25, calculatrice.sommet(), ERREUR);
	}
	
	@Test
	public void testInvNulle() {
		calculatrice.addPile(0);
		calculatrice.calcul("inv");
		assertEquals(0, calculatrice.sommet(), ERREUR);
	}
	
	@Test
	public void testInvNegative() {
		calculatrice.addPile(-2);
		calculatrice.calcul("inv");
		assertEquals(1/-2.0, calculatrice.sommet(), ERREUR);
	}
	
	@Test
	public void testInvOperande() {
		calculatrice.addPile(2);
		calculatrice.addPile(-2);
		calculatrice.calcul("inv");
		assertEquals(1/-2.0, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testOpp() {
		calculatrice.addPile(5);
		calculatrice.calcul("opp");
		assertEquals(-5, calculatrice.sommet(), ERREUR);
	}
	
	@Test
	public void testOppNulle() {
		calculatrice.addPile(0);
		calculatrice.calcul("opp");
		assertEquals(0, calculatrice.sommet(), ERREUR);
	}
	
	@Test
	public void testNegative() {
		calculatrice.addPile(-5);
		calculatrice.calcul("opp");
		assertEquals(5, calculatrice.sommet(), ERREUR);
	}
	
	@Test
	public void testOppOperande() {
		calculatrice.addPile(7);
		calculatrice.addPile(5);
		calculatrice.calcul("opp");
		assertEquals(-5, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testPuiss() {
		calculatrice.addPile(2);
		calculatrice.addPile(3);
		calculatrice.calcul("puiss");
		assertEquals(8, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testPuissNulle() {
		calculatrice.addPile(2);
		calculatrice.addPile(0);
		calculatrice.calcul("puiss");
		assertEquals(1, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testPuissUn() {
		calculatrice.addPile(2);
		calculatrice.addPile(1);
		calculatrice.calcul("puiss");
		assertEquals(2, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testPuissNegatif() {
		calculatrice.addPile(2);
		calculatrice.addPile(-2);
		calculatrice.calcul("puiss");
		assertEquals(0.25, calculatrice.sommet(), ERREUR);
	}
	
	@Test
	public void testPuissNull() {
		calculatrice.addPile(2);
		calculatrice.calcul("puiss");
		assertEquals(2, calculatrice.sommet(), ERREUR);
	}

	@Test
	public void testGamma() {
		//First interval: (0, 0.001)
		calculatrice.addPile(0.00001);
		calculatrice.calcul("!");
		assertEquals(99999.42278766684, calculatrice.sommet(), ERREUR);
	}
	
	@Test
	public void testGamma2() {
		//Second interval: [0.001, 12)
		calculatrice.addPile(3);
		calculatrice.calcul("!");
		assertEquals(2.0, calculatrice.sommet(), ERREUR);
	}
	
	@Test
	public void testGamma3() {
		//Third interval: [12, infinity)
		calculatrice.addPile(15);
		calculatrice.calcul("!");
		assertEquals(8.717829120000017E10, calculatrice.sommet(), ERREUR);
	}
	
	@Test
	public void testGammaNulle() {
		calculatrice.addPile(0);
		calculatrice.calcul("!");
		assertEquals(0, calculatrice.sommet(), ERREUR);
	}
	
	@Test
	public void testGammaNegative() {
		calculatrice.addPile(-5);
		calculatrice.calcul("!");
		assertEquals(-5, calculatrice.sommet(), ERREUR);
	}
	
	@Test
	public void testGammaOperande() {
		calculatrice.addPile(2);
		calculatrice.addPile(1.0/3);
		calculatrice.calcul("!");
		assertEquals(2.67893853, calculatrice.sommet(), ERREUR);
	}
}