
public class BotonCambio implements Observador {
	private Simulador simulador;
	private int temperatura;
	
	public BotonCambio(Simulador simulador) {
		this.simulador = simulador;
	}
	
	public void refrescarPantalla() {
		System.out.println("Temperatura: " + temperatura + " ºC");
	}
	
	public void manejarEvento() {
		temperatura = simulador.getTemperatura();
		refrescarPantalla();
	}
	
	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
		simulador.setTemperatura(temperatura);
		refrescarPantalla();
	}
}
