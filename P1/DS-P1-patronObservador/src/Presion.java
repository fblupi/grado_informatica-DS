import monitor.*;

public class Presion extends AbstractMonitor {
	private int presion;
	
	public Presion(int p) {
		presion = p;
	}
	
	public int getPresion() {
		enter();
		int valor = presion;
		leave();
		return valor;
	}
	
	public void setPresion(int t) {
		enter();
		presion = t;
		leave();
	}
}