
import java.util.Random;
import java.util.ArrayList;

public class Simulador extends Thread {
	private int min;
	private int max;
	private int tipo;
	private int periodo;
	private ArrayList<Observable> observables;
	private Temperatura temperatura;
	private Presion presion;
	
	public Simulador (int tipo, int periodo, int min, int max, Temperatura temperatura, Presion presion) {
		this.tipo = tipo;
		this.periodo = periodo;
		this.min = min;
		this.max = max;
		observables = new ArrayList<Observable>();
		switch (tipo) {
			case 0: this.temperatura = temperatura; break;
			case 1: this.presion = presion; break;
			default: break;
		}
	}
	
	public void incluirObservable(Observable observable) {
		observables.add(observable);
	}
	
	public void run() {
		Random r = new Random(max);
		while (true){
			// Crea número aleatorio
			int valor = r.nextInt((max-min)+1)+min; // número aleatorio entre min y max
			switch (tipo) {
				case 0: temperatura.setTemperatura(valor); break;
				case 1: presion.setPresion(valor); break;
				default: break;
			}
			// Espera un periodo de tiempo
			try {
				sleep(periodo);
			} catch(java.lang.InterruptedException e) {
				e.printStackTrace();
			}
			// Observables notifican observadores
			for(Observable observable : observables) {
				switch(tipo) {
				case 0: 
					if(observable.getClass().equals(ObservableTemperatura.class)) {
						observable.notificar();
					}
					break;
				case 1:  
					if(observable.getClass().equals(ObservablePresion.class)) {
						observable.notificar();
					}
					break;
				} // end switch
			} // end for
		} // end while
	}
}
