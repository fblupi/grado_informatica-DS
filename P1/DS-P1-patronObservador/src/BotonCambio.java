
public class BotonCambio implements Observador {
	private Simulador simulador;
	private static int temperatura;
	
	public BotonCambio(Simulador simulador) {
		this.simulador = simulador;
	}
	
	public static void refrescarPantalla() {
		System.out.println("Temperatura: " + temperatura + " ºC");
	}
	
	public void manejarEvento() {
		temperatura = simulador.getTemperatura();
		refrescarPantalla();
	}
	
	public void setTemperatura(int temperatura) {
		simulador.setTemperatura(temperatura);
	}
}
