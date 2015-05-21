package dinero;
import java.util.Vector;

public class BolsaDinero implements IDinero {
	
    private Vector fDineros = new Vector();

    void aniadirDinero (Dinero m) {
    	boolean encontrado = false;
    	for (Object dinero: fDineros) {
            if (((Dinero) dinero).moneda().equals(m.moneda())) {
            	encontrado = true;
            	((Dinero) dinero).add(m);
            }
        }
        if (!encontrado) {
        	fDineros.add(m);
        }
	}
    
	public BolsaDinero (Dinero d1, Dinero d2) {
		aniadirDinero(d1);
		aniadirDinero(d2);
	}
	
	public BolsaDinero (Dinero bolsa[]) {
		for (Dinero d: bolsa) {
			aniadirDinero(d);
		}
	}
	
	public IDinero add (IDinero d) {
		if (d instanceof Dinero) {
			aniadirDinero((Dinero) d);
		} 
		return this;
	}
	
	public Vector vector () {
		return fDineros;
	}
	
	public boolean BolsaEquals(Object objeto) {
		if (objeto instanceof Vector) {
			return this.fDineros.equals(objeto);
		} else {
			return false;
		}
	}
}