package test;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import dinero.*;

public class BolsaDineroTest {
	
	private Dinero f12CHF;
    private Dinero f14CHF;
    private Dinero f7USD;
    private Dinero f21USD;
    private BolsaDinero fMB1;
    private BolsaDinero fMB2;
    private BolsaDinero fMB3;
    private BolsaDinero fMB4;
    
	@Before
	public void setUp () throws Exception {
		f12CHF = new Dinero(12, "CHF");
		f14CHF = new Dinero(14, "CHF");
		f7USD = new Dinero(7, "USD");
		f21USD = new Dinero(21, "USD");
		
		Dinero[] fArray1 = { f12CHF, f14CHF, f21USD };
		Dinero[] fArray2 = { f12CHF, f14CHF };
		
		fMB1 = new BolsaDinero(f12CHF, f14CHF);
		fMB2 = new BolsaDinero(fArray1);
		fMB3 = new BolsaDinero(fArray2);
		fMB4 = new BolsaDinero(fArray2);
	}
	
	@Test
	public void testBolsaEquals () {
		testReflexiva();
		testSimetrica();
		testTransitiva();
	}

	@Test
	public void testAdd () {
		assertFalse(fMB1.BolsaEquals(fMB2.vector())); // Bolsas distintas
		BolsaDinero sumado = (BolsaDinero) fMB1.add(f21USD); // A la bolsa 1 se le añade 21USD y pasa a ser igual que la 2
		assertTrue(sumado.BolsaEquals(fMB2.vector())); // Bolsas iguales
	}
	
	public void testReflexiva () {
		assertTrue(fMB1.BolsaEquals(fMB1.vector()));
		assertTrue(fMB2.BolsaEquals(fMB2.vector()));
		assertTrue(fMB3.BolsaEquals(fMB3.vector()));
	}

	public void testSimetrica () {
		assertTrue(fMB1.BolsaEquals(fMB3.vector()));
		assertTrue(fMB3.BolsaEquals(fMB1.vector()));
		assertFalse(fMB1.BolsaEquals(fMB2.vector()));
		assertFalse(fMB2.BolsaEquals(fMB1.vector()));
	}
	
	public void testTransitiva () {
		assertTrue(fMB1.BolsaEquals(fMB3.vector()));
		assertTrue(fMB3.BolsaEquals(fMB4.vector()));
		assertTrue(fMB1.BolsaEquals(fMB4.vector()));
	}
}
