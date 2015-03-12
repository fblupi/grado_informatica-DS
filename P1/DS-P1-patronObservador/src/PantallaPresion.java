
public class PantallaPresion implements Observador {
	private static Presion presion;
	
	public PantallaPresion() {
		
	}
	
	public void refrescarPantalla() {
		System.out.println("Presi�n (Pantalla): " + presion.getPresion() + " hPa");
	}
	
	public void manejarEvento() {
		refrescarPantalla();
	}
}