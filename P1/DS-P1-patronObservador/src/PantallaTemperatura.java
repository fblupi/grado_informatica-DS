/**
 *  @author Francisco Javier Bol�var Lupi��ez
 */

import java.awt.*;
import javax.swing.*;

public class PantallaTemperatura extends JPanel implements Observador {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Temperatura temperatura;
	private JLabel etiqueta;
	
	public PantallaTemperatura(Temperatura temperatura) {
		this.temperatura = temperatura;
		setBorder(javax.swing.BorderFactory.createTitledBorder("Pantalla Temperatura"));
		setPreferredSize(new Dimension(300,50));
		setLayout(new BorderLayout());
		etiqueta = new JLabel("Temperatura: " + temperatura.getTemperatura() + " �C");
		add(etiqueta, BorderLayout.CENTER);
	}
	
	public void refrescarPantalla() {
		etiqueta.setText("Temperatura: " + temperatura.getTemperatura() + " �C");
	}
	
	public void manejarEvento() {
		refrescarPantalla();
	}
}