
public class Pantalla implements Observador {
	private Simulador simulador;
	private static int temperatura;
	
	public Pantalla(Simulador simulador) {
		this.simulador = simulador;
	}
	
	public static void refrescarPantalla() {
		System.out.println("Temperatura: " + temperatura + " �C");
	}
	
	public void manejarEvento() {
		temperatura = simulador.getTemperatura();
		refrescarPantalla();
	}
}
