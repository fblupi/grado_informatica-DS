
public class BotonCambioTemperatura implements Observador {
	private static Temperatura temperatura;
	private ObservableTemperatura observable;
	
	public BotonCambioTemperatura(ObservableTemperatura observable) {
		this.observable = observable;
	}
	
	public void refrescarPantalla() {
		System.out.println("Temperatura (Botón Cambio): " + temperatura.getTemperatura() + " ºC");
	}
	
	public void manejarEvento() {
		refrescarPantalla();
	}
	
	public void setTemperatura(int temperatura) {
		System.out.println("Actualizo");
		this.temperatura.setTemperatura(temperatura);
		observable.notificar(); // al cambiar temperatura, notifica a todos los observadores
	}
}