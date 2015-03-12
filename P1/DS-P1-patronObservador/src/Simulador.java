import java.util.Random;
import java.util.ArrayList;

public class Simulador extends Thread {
	private int t1;
	private int t2;
	private int p1;
	private int p2;
	private ArrayList<Observable> observables;
	Temperatura temperatura;
	Presion presion;
	
	public Simulador (int t1, int t2, int p1, int p2) {
		this.t1 = t1;
		this.t2 = t2;
		this.p1 = p1;
		this.p2 = p2;
		observables = new ArrayList<Observable>();
	}
	
	public void incluirObservable(Observable observable) {
		observables.add(observable);
	}
	
	public void run() {
		Random t = new Random(t2);
		Random p = new Random(p2);
		int turno = 0;
		while (true){
			temperatura.setTemperatura(t.nextInt((t2-t1)+1)+t1); // número aleatorio entre t1 y t2
			if(turno%10==0) presion.setPresion(p.nextInt((p2-p1)+1)+p1);
			try {
				sleep(1000); // espera 1 segundo
			}
			catch(java.lang.InterruptedException e) {
				e.printStackTrace();
			}
			for(Observable observable : observables) {
				if(observable.getClass().equals(ObservablePresion.class)) {
					if(turno%10==0) {
						observable.notificar();
					}
				} else {
					observable.notificar();
				}
			}
			turno++;
		}
	}
}
