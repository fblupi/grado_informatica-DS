
import java.awt.*;
import javax.swing.*;

public class PantallaPresion extends JPanel implements Observador {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Presion presion;
	private JLabel etiqueta;
	
	public PantallaPresion(Presion presion) {
		this.presion = presion;
		setBorder(javax.swing.BorderFactory.createTitledBorder("Pantalla Presi�n"));
		setPreferredSize(new Dimension(300,50));
		setLayout(new BorderLayout());
		etiqueta = new JLabel("Presi�n: " + presion.getPresion() + " hPa");
		add(etiqueta, BorderLayout.NORTH);
	}
	
	public void refrescarPantalla() {
		etiqueta.setText("Presi�n: " + presion.getPresion() + " hPa");
	}
	
	public void manejarEvento() {
		refrescarPantalla();
	}
}