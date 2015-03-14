
import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Main() {
		setTitle("Central Meteorológica");
		setSize(1000,600);
		
		Temperatura temperatura = new Temperatura(25);
		Presion presion = new Presion(1025);
		
		// Creación simuladores: Dos hebras que generan temperatura y presión
		Simulador simuladorTemperatura = new Simulador(0,1000,20,30,temperatura,null);
		Simulador simuladorPresion = new Simulador(1,2000,1000,1050,null,presion);
		
		// Creción observables
		ObservableTemperatura observableTemperatura = new ObservableTemperatura();
		ObservablePresion observablePresion = new ObservablePresion();
		
		// Inclusión de observables en simuladores
		simuladorTemperatura.incluirObservable(observableTemperatura);
		simuladorPresion.incluirObservable(observablePresion);
		
		// Creación de observadores
		BotonCambioTemperatura botonCambioTemperatura = new BotonCambioTemperatura(observableTemperatura,temperatura);
		PantallaTemperatura pantallaTemperatura = new PantallaTemperatura(temperatura);
		PantallaPresion pantallaPresion = new PantallaPresion(presion);
		GraficaTemperatura graficaTemperatura = new GraficaTemperatura(temperatura);
		GraficaPresion graficaPresion = new GraficaPresion(presion);
		
		add(pantallaTemperatura,BorderLayout.NORTH);
		add(pantallaPresion,BorderLayout.SOUTH);
		add(botonCambioTemperatura,BorderLayout.CENTER);
		add(graficaTemperatura,BorderLayout.EAST);
		add(graficaPresion,BorderLayout.WEST);
		
		// Inclusión de observadores en observables
		observableTemperatura.incluirObservador(botonCambioTemperatura);
		observableTemperatura.incluirObservador(pantallaTemperatura);
		observableTemperatura.incluirObservador(graficaTemperatura);
		observablePresion.incluirObservador(pantallaPresion);
		observablePresion.incluirObservador(graficaPresion);
		
		// Inicio de hebras
		simuladorPresion.start();
		simuladorTemperatura.start();
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.pack();
		main.setVisible(true);
	}
}