
public class PantallaTemperatura implements Observador {
	private static Temperatura temperatura;
	
	public PantallaTemperatura() {
		
	}
	
	public void refrescarPantalla() {
		System.out.println("Temperatura (Pantalla): " + temperatura.getTemperatura() + " ºC");
	}
	
	public void manejarEvento() {
		refrescarPantalla();
	}
}