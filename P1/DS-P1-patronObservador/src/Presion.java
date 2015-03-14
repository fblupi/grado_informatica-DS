import monitor.*;

public class Presion extends AbstractMonitor {
	private int presion;
	
	public Presion(int presion) {
		this.presion = presion;
	}
	
	public int getPresion() {
		enter();
		int valor = presion;
		leave();
		return valor;
	}
	
	public void setPresion(int presion) {
		enter();
		this.presion = presion;
		leave();
	}
}