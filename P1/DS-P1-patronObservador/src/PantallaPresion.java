import java.awt.*;

import javax.swing.*;

public class PantallaPresion extends JPanel implements Observador {
	private static Presion presion;
	private JLabel etiqueta;
	
	public PantallaPresion() {
		setBorder(javax.swing.BorderFactory.createTitledBorder("Pantalla Presi�n"));
		setPreferredSize(new Dimension(300,50));
		setLayout(new BorderLayout());
		etiqueta = new JLabel("Presi�n: " + presion.getPresion() + " hPa");
		add(etiqueta, BorderLayout.NORTH);
	}
	
	public void refrescarPantalla() {
		etiqueta.setText("Presi�n: " + presion.getPresion() + " hPa");
		//System.out.println("Presi�n (Pantalla): " + presion.getPresion() + " hPa");
	}
	
	public void manejarEvento() {
		refrescarPantalla();
	}
}