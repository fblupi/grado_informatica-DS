import java.util.Random;
import java.util.ArrayList;

public class Simulador extends Thread {
	private int t1;
	private int t2;
	private int temperatura;
	private ArrayList<Observador> observadores;
	
	public Simulador (int t1, int t2) {
		this.t1 = t1;
		this.t2 = t2;
		observadores = new ArrayList<Observador>();
	}
	
	public int getTemperatura() {
		return temperatura;
	}
	
	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}
	
	public void incluirObservador(Observador observador) {
		observadores.add(observador);
	}
	
	public void notificar() {
		for(Observador observador : observadores) {
			observador.manejarEvento();
		}
	}
	
	public void run() {
		Random r = new Random(t2);
		while (true){
			temperatura = r.nextInt((t2-t1)+1)+t1; // número aleatorio entre t1 y t2
			try {
				sleep(1000); // espera 1 segundo
			}
			catch(java.lang.InterruptedException e) {
				e.printStackTrace();
			}
			this.notificar();
		}
	}
}
