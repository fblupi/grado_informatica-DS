import monitor.*;

public class Temperatura extends AbstractMonitor {
	private int temperatura;
	
	public Temperatura(int t) {
		temperatura = t;
	}
	
	public int getTemperatura() {
		enter();
		int valor = temperatura;
		leave();
		return valor;
	}
	
	public void setTemperatura(int t) {
		enter();
		temperatura = t;
		leave();
	}
}


/*
public class Temperatura {
	private static int temperatura;
	
	public Temperatura(int t) {
		temperatura = t;
	}
	
	public static int getTemperatura() {
		return temperatura;
	}
	
	public static void setTemperatura(int t) {
		temperatura = t;
	}
}
*/