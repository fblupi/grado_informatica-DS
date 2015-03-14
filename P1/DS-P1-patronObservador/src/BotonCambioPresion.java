
import java.awt.*;
import javax.swing.*;

public class BotonCambioPresion extends JPanel implements Observador {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Presion presion;
	private ObservablePresion observable;
	private JLabel etiqueta;
	private JTextArea texto;
	private JButton boton;
	
	public BotonCambioPresion(ObservablePresion observable, Presion presion) {
		this.observable = observable;
		this.presion = presion;
		setBorder(javax.swing.BorderFactory.createTitledBorder("Botón Cambio Presión"));
		setPreferredSize(new Dimension(300,100));
		setLayout(new BorderLayout());
		etiqueta = new JLabel("Presión: " + presion.getPresion() + " hPa");
		boton = new JButton("Actualizar");
		texto = new JTextArea(2,2);
		boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActionPerformed(evt);
            }
        });
		add(texto, BorderLayout.SOUTH);
		add(boton, BorderLayout.CENTER);
		add(etiqueta, BorderLayout.NORTH);
	}
	
	private void botonActionPerformed(java.awt.event.ActionEvent evt) {
		String s = texto.getText();
		if(esNumero(s)) {
			setPresion(Integer.parseInt(s));
		}
	}
	
	public void refrescarPantalla() {
		etiqueta.setText("Presión: " + presion.getPresion() + " hPa");
	}
	
	public void manejarEvento() {
		refrescarPantalla();
	}
	
	public void setPresion(int presion) {
		this.presion.setPresion(presion);
		observable.notificar(); // al cambiar presión notifica a todos los observadores
	}
	
	private boolean esNumero(String string) {
		if(string == null || string.isEmpty()) {
			return false;
		}
		for(int i=0; i<string.length(); i++) {
			if(!Character.isDigit(string.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}