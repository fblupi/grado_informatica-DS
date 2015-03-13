import java.awt.*;
import javax.swing.*;

public class PantallaTemperatura extends JPanel implements Observador {
	private static Temperatura temperatura;
	private JLabel etiqueta;
	
	public PantallaTemperatura() {
		setBorder(javax.swing.BorderFactory.createTitledBorder("Pantalla Temperatura"));
		setPreferredSize(new Dimension(300,50));
		setLayout(new BorderLayout());
		etiqueta = new JLabel("Temperatura: " + temperatura.getTemperatura() + " �C");
		add(etiqueta, BorderLayout.NORTH);
	}
	
	public void refrescarPantalla() {
		etiqueta.setText("Temperatura: " + temperatura.getTemperatura() + " �C");
		//System.out.println("Temperatura (Pantalla): " + temperatura.getTemperatura() + " �C");
	}
	
	public void manejarEvento() {
		refrescarPantalla();
	}
}