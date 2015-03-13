
public class Main {
	public static void main(String[] args) throws InterruptedException {
		Simulador simuladorTemperatura = new Simulador(0,1000,20,30);
		Simulador simuladorPresion = new Simulador(1,2000,1000,1050);
		
		ObservableTemperatura observableTemperatura = new ObservableTemperatura();
		ObservablePresion observablePresion = new ObservablePresion();
		
		simuladorTemperatura.incluirObservable(observableTemperatura);
		simuladorPresion.incluirObservable(observablePresion);
		
		BotonCambioTemperatura botonCambioTemperatura = new BotonCambioTemperatura(observableTemperatura);
		PantallaTemperatura pantallaTemperatura = new PantallaTemperatura();
		PantallaPresion pantallaPresion = new PantallaPresion();
		
		pantallaTemperatura.setVisible(true);
		pantallaPresion.setVisible(true);
		botonCambioTemperatura.setVisible(true);
		
		observableTemperatura.incluirObservador(botonCambioTemperatura);
		observableTemperatura.incluirObservador(pantallaTemperatura);
		observablePresion.incluirObservador(pantallaPresion);
		
		simuladorPresion.start();
		simuladorTemperatura.start();
	}
}