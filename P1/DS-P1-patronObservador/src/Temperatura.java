import monitor.*;

public class Temperatura extends AbstractMonitor {
	private int temperatura;
	
	public Temperatura(int temperatura) {
		this.temperatura = temperatura;
	}
	
	public int getTemperatura() {
		enter();
		int valor = temperatura;
		leave();
		return valor;
	}
	
	public void setTemperatura(int temperatura) {
		enter();
		this.temperatura = temperatura;
		leave();
	}
}