
import java.util.ArrayList;

public class ObservableTemperatura extends Observable {
	private ArrayList<Observador> observadores;
	
	public ObservableTemperatura() {
		observadores = new ArrayList<Observador>();
	}
	
	public void incluirObservador(Observador observador) {
		observadores.add(observador);
	}
	
	public void notificar() {
		for(Observador observador : observadores) {
			observador.manejarEvento();
		}
	}
}
