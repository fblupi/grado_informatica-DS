import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {	
	public Main() {
		setTitle("Central Meteorológica");
		setSize(1000,600);
		
		Simulador simuladorTemperatura = new Simulador(0,1000,20,30);
		Simulador simuladorPresion = new Simulador(1,2000,1000,1050);
		
		ObservableTemperatura observableTemperatura = new ObservableTemperatura();
		ObservablePresion observablePresion = new ObservablePresion();
		
		simuladorTemperatura.incluirObservable(observableTemperatura);
		simuladorPresion.incluirObservable(observablePresion);
		
		BotonCambioTemperatura botonCambioTemperatura = new BotonCambioTemperatura(observableTemperatura);
		PantallaTemperatura pantallaTemperatura = new PantallaTemperatura();
		PantallaPresion pantallaPresion = new PantallaPresion();
		GraficaTemperatura graficaTemperatura = new GraficaTemperatura();
		
		add(pantallaTemperatura,BorderLayout.NORTH);
		add(pantallaPresion,BorderLayout.SOUTH);
		add(botonCambioTemperatura,BorderLayout.CENTER);
		add(graficaTemperatura,BorderLayout.EAST);
		
		observableTemperatura.incluirObservador(botonCambioTemperatura);
		observableTemperatura.incluirObservador(pantallaTemperatura);
		observableTemperatura.incluirObservador(graficaTemperatura);
		observablePresion.incluirObservador(pantallaPresion);
		
		simuladorPresion.start();
		simuladorTemperatura.start();
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.pack();
		main.setVisible(true);
	}
}