
public class PantallaPresion implements Observador {
	private static Presion presion;
	
	public PantallaPresion() {
		
	}
	
	public void refrescarPantalla() {
		System.out.println("Presión (Pantalla): " + presion.getPresion() + " hPa");
	}
	
	public void manejarEvento() {
		refrescarPantalla();
	}
}