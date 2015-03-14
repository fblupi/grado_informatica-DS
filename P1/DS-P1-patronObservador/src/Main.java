
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
		
		// Creación de monitores de temperatura y presioón
		Temperatura temperatura = new Temperatura(25);
		Presion presion = new Presion(1025);
		
		// Creación simuladores: Dos hebras que generan temperatura y presión
		Simulador simuladorTemperatura = new Simulador(
				0,				// tipo 0=temperatura
				1000,			// periodo de generación de datos (ms)
				20,				// valor mínimo generado
				30,				// valor máximo generado
				temperatura,	// monitor temperatura
				null			// monitor presion
		);
		Simulador simuladorPresion = new Simulador(
				1,				// tipo 1=presion
				2000,			// periodo de generación de datos (ms)
				1000,			// valor mínimo generado
				1050,			// valor máximo generado
				null,			// monitor 
				presion
		);
		
		// Inicio de hebras
		simuladorPresion.start();
		simuladorTemperatura.start();
		
		// Creción observables
		ObservableTemperatura observableTemperatura = new ObservableTemperatura();
		ObservablePresion observablePresion = new ObservablePresion();
		
		// Inclusión de observables en simuladores
		simuladorTemperatura.incluirObservable(observableTemperatura);
		simuladorPresion.incluirObservable(observablePresion);
		
		// Creación de observadores
		BotonCambioTemperatura botonCambioTemperatura = new BotonCambioTemperatura(observableTemperatura,temperatura);
		BotonCambioPresion botonCambioPresion = new BotonCambioPresion(observablePresion,presion);
		PantallaTemperatura pantallaTemperatura = new PantallaTemperatura(temperatura);
		PantallaPresion pantallaPresion = new PantallaPresion(presion);
		GraficaTemperatura graficaTemperatura = new GraficaTemperatura(temperatura);
		GraficaPresion graficaPresion = new GraficaPresion(presion);
		
		// Creación de JPanel para los observadores
		JPanel panelNorte = new JPanel();
		JPanel panelSur = new JPanel();
		add(panelNorte,BorderLayout.NORTH);
		add(panelSur,BorderLayout.SOUTH);
		add(graficaTemperatura,BorderLayout.WEST);
		add(graficaPresion,BorderLayout.EAST);
		panelNorte.add(pantallaTemperatura,BorderLayout.EAST);
		panelNorte.add(pantallaPresion,BorderLayout.WEST);
		panelSur.add(botonCambioTemperatura,BorderLayout.EAST);
		panelSur.add(botonCambioPresion,BorderLayout.WEST);
		
		// Inclusión de observadores en observables
		observableTemperatura.incluirObservador(botonCambioTemperatura);
		observableTemperatura.incluirObservador(pantallaTemperatura);
		observableTemperatura.incluirObservador(graficaTemperatura);
		observablePresion.incluirObservador(botonCambioPresion);
		observablePresion.incluirObservador(pantallaPresion);
		observablePresion.incluirObservador(graficaPresion);
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.pack();
		main.setVisible(true);
	}
}