
public class Main {
	public static void main(String[] args) throws InterruptedException {
		Simulador simulador = new Simulador(20,30,1000,1050);
		ObservableTemperatura observableTemperatura = new ObservableTemperatura();
		ObservablePresion observablePresion = new ObservablePresion();
		simulador.incluirObservable(observableTemperatura);
		simulador.incluirObservable(observablePresion);
		BotonCambioTemperatura botonCambioTemperatura = new BotonCambioTemperatura(observableTemperatura);
		PantallaTemperatura pantallaTemperatura = new PantallaTemperatura();
		PantallaPresion pantallaPresion = new PantallaPresion();
		pantallaTemperatura.setVisible(true);
		pantallaPresion.setVisible(true);
		botonCambioTemperatura.setVisible(true);
		observableTemperatura.incluirObservador(botonCambioTemperatura);
		observableTemperatura.incluirObservador(pantallaTemperatura);
		observablePresion.incluirObservador(pantallaPresion);
		simulador.start();
		Thread.sleep(5500); // a los diez segundos boton cambio cambia la temperatura
		botonCambioTemperatura.setTemperatura(27);
	}
}