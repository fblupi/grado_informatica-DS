import java.awt.*;
import javax.swing.*;

public class PantallaTemperatura extends JFrame implements Observador {
	private static Temperatura temperatura;
	private JLabel etiqueta;
	
	public PantallaTemperatura() {
		setTitle("Pantalla Temperatura");
		setSize(300,100);
		Panel panelSuperior = new Panel();
		panelSuperior.setLayout(new BorderLayout());
		getContentPane().add(panelSuperior);
		etiqueta = new JLabel("Temperatura: " + temperatura.getTemperatura() + " ºC");
		panelSuperior.add(etiqueta, BorderLayout.NORTH);
	}
	
	public void refrescarPantalla() {
		etiqueta.setText("Temperatura: " + temperatura.getTemperatura() + " ºC");
		//System.out.println("Temperatura (Pantalla): " + temperatura.getTemperatura() + " ºC");
	}
	
	public void manejarEvento() {
		refrescarPantalla();
	}
}