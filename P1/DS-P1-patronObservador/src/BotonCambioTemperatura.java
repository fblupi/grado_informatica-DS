
import java.awt.*;
import javax.swing.*;

public class BotonCambioTemperatura extends JPanel implements Observador {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Temperatura temperatura;
	private ObservableTemperatura observable;
	private JLabel etiqueta;
	private JTextArea campo;
	private JButton boton;
	
	public BotonCambioTemperatura(ObservableTemperatura observable, Temperatura temperatura) {
		this.observable = observable;
		this.temperatura = temperatura;
		setBorder(javax.swing.BorderFactory.createTitledBorder("Botón Cambio Temperatura"));
		setPreferredSize(new Dimension(300,100));
		setLayout(new BorderLayout());
		etiqueta = new JLabel("Temperatura: " + temperatura.getTemperatura() + " ºC");
		boton = new JButton("Actualizar");
		campo = new JTextArea(2,2);
		boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActionPerformed(evt);
            }
        });
		add(campo, BorderLayout.SOUTH);
		add(boton, BorderLayout.CENTER);
		add(etiqueta, BorderLayout.NORTH);
	}
	
	private void botonActionPerformed(java.awt.event.ActionEvent evt) {
		String s = campo.getText();
		if(isNumber(s)) {
			setTemperatura(Integer.parseInt(s));
		}
	}
	
	public void refrescarPantalla() {
		etiqueta.setText("Temperatura: " + temperatura.getTemperatura() + " ºC");
	}
	
	public void manejarEvento() {
		refrescarPantalla();
	}
	
	public void setTemperatura(int temperatura) {
		this.temperatura.setTemperatura(temperatura);
		observable.notificar(); // al cambiar temperatura, notifica a todos los observadores
	}
	
	private boolean isNumber(String string) {
		if(string == null || string.isEmpty()) {
			return false;
		}
		for(int i=0; i< string.length(); i++) {
			if(!Character.isDigit(string.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}