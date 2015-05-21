package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dinero.*;

public class DineroTest {
	
    private Dinero m12CHF;
    private Dinero m14CHF;
    private Dinero m10EUR;
    private Dinero m12CHF2;
    private Dinero m12CHF3;
	
	@Before
	public void setUp () throws Exception {
		m12CHF = new Dinero(12, "CHF");
		m14CHF = new Dinero(14, "CHF");
		m10EUR = new Dinero(10, "EUR");
		m12CHF2 = new Dinero(12, "CHF");
		m12CHF3 = new Dinero(12, "CHF");
	}

	@Test
	public void testAdd () {
		// Sumarlos, aver si sale lo que tiene que salir
		IDinero sumaIgual = m12CHF.add(m14CHF);
		IDinero sumaDistintos = m10EUR.add(m14CHF);

		// Suma iguales es un Dinero
		assertTrue(sumaIgual instanceof Dinero);
		assertEquals(((Dinero) sumaIgual).cantidad(), 26);
		assertEquals(((Dinero) sumaIgual).moneda(), "CHF");
		
		// Suma distintos es una bolsa de dinero
		assertTrue(sumaDistintos instanceof BolsaDinero);
	}
	
	@Test
	public void testEqualsObject () {
		testReflexiva();
		testSimetrica();
		testTransitiva();
	}
	
	public void testReflexiva () {
		assertEquals(m12CHF, m12CHF);
		assertEquals(m10EUR, m10EUR);
	}
	
	public void testSimetrica () {
		assertEquals(m12CHF, m12CHF2);
		assertEquals(m12CHF2, m12CHF);
		assertFalse(m12CHF.equals(m10EUR));
		assertFalse(m10EUR.equals(m12CHF));
		assertFalse(m12CHF.equals(m14CHF));
		assertFalse(m14CHF.equals(m12CHF));
	}
	
	public void testTransitiva () {
		assertEquals(m12CHF, m12CHF2);
		assertEquals(m12CHF2, m12CHF3);
		assertEquals(m12CHF, m12CHF3);
	}

}