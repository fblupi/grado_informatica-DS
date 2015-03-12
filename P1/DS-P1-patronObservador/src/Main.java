

public class Main {
	public static void main(String[] args) {
		Simulador simulador = new Simulador(20,30);
		Observador observador = new Pantalla(simulador);
		simulador.incluirObservador(observador);
		simulador.start();
	}
}
