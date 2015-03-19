/**
 *  @author Francisco Javier Bolívar Lupiáñez
 */

public class Temperatura {
	private int temperatura;
	
	public Temperatura(int temperatura) {
		this.temperatura = temperatura;
	}
	
	public synchronized int getTemperatura() {
		return temperatura;
	}
	
	public synchronized void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}
}