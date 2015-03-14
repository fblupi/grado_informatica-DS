
import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Main() {
		setTitle("Central Meteorol�gica");
		setSize(1000,600);
		
		// Creaci�n de monitores de temperatura y presio�n
		Temperatura temperatura = new Temperatura(25);
		Presion presion = new Presion(1025);
		
		// Creaci�n simuladores: Dos hebras que generan temperatura y presi�n
		Simulador simuladorTemperatura = new Simulador(
				0,				// tipo 0=temperatura
				1000,			// periodo de generaci�n de datos (ms)
				20,				// valor m�nimo generado
				30,				// valor m�ximo generado
				temperatura,	// monitor temperatura
				null			// monitor presion
		);
		Simulador simuladorPresion = new Simulador(
				1,				// tipo 1=presion
				2000,			// periodo de generaci�n de datos (ms)
				1000,			// valor m�nimo generado
				1050,			// valor m�ximo generado
				null,			// monitor 
				presion
		);
		
		// Inicio de hebras
		simuladorPresion.start();
		simuladorTemperatura.start();
		
		// Creci�n observables
		ObservableTemperatura observableTemperatura = new ObservableTemperatura();
		ObservablePresion observablePresion = new ObservablePresion();
		
		// Inclusi�n de observables en simuladores
		simuladorTemperatura.incluirObservable(observableTemperatura);
		simuladorPresion.incluirObservable(observablePresion);
		
		// Creaci�n de observadores
		BotonCambioTemperatura botonCambioTemperatura = new BotonCambioTemperatura(observableTemperatura,temperatura);
		BotonCambioPresion botonCambioPresion = new BotonCambioPresion(observablePresion,presion);
		PantallaTemperatura pantallaTemperatura = new PantallaTemperatura(temperatura);
		PantallaPresion pantallaPresion = new PantallaPresion(presion);
		GraficaTemperatura graficaTemperatura = new GraficaTemperatura(temperatura);
		GraficaPresion graficaPresion = new GraficaPresion(presion);
		
		// Creaci�n de JPanel para los observadores
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
		
		// Inclusi�n de observadores en observables
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