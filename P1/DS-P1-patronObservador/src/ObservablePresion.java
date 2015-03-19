/**
 *  @author Francisco Javier Bolívar Lupiáñez
 */

import java.util.ArrayList;

public class ObservablePresion extends Observable {	
	private ArrayList<Observador> observadores;
	
	public ObservablePresion() {
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
