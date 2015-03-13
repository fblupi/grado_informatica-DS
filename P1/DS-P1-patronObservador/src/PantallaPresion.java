import java.awt.*;
import javax.swing.*;

public class PantallaPresion extends JFrame implements Observador {
	private static Presion presion;
	private JLabel etiqueta;
	
	public PantallaPresion() {
		setTitle("Pantalla Presion");
		setSize(300,100);
		Panel panelSuperior = new Panel();
		panelSuperior.setLayout(new BorderLayout());
		getContentPane().add(panelSuperior);
		etiqueta = new JLabel("Presion: " + presion.getPresion() + " hPa");
		panelSuperior.add(etiqueta, BorderLayout.NORTH);
	}
	
	public void refrescarPantalla() {
		etiqueta.setText("Presión: " + presion.getPresion() + " hPa");
		//System.out.println("Presión (Pantalla): " + presion.getPresion() + " hPa");
	}
	
	public void manejarEvento() {
		refrescarPantalla();
	}
}