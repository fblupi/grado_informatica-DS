/**
 *  @author Francisco Javier Bolívar Lupiáñez
 */

public class Presion {
	private int presion;
	
	public Presion(int presion) {
		this.presion = presion;
	}
	
	public synchronized int getPresion() {
		return presion;
	}
	
	public synchronized void setPresion(int presion) {
		this.presion = presion;
	}
}