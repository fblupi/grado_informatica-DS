import java.awt.*;

import javax.swing.*;

public class PantallaPresion extends JPanel implements Observador {
	private static Presion presion;
	private JLabel etiqueta;
	
	public PantallaPresion() {
		setBorder(javax.swing.BorderFactory.createTitledBorder("Pantalla Presión"));
		setPreferredSize(new Dimension(300,50));
		setLayout(new BorderLayout());
		etiqueta = new JLabel("Presión: " + presion.getPresion() + " hPa");
		add(etiqueta, BorderLayout.NORTH);
	}
	
	public void refrescarPantalla() {
		etiqueta.setText("Presión: " + presion.getPresion() + " hPa");
		//System.out.println("Presión (Pantalla): " + presion.getPresion() + " hPa");
	}
	
	public void manejarEvento() {
		refrescarPantalla();
	}
}