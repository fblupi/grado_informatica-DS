import java.awt.*;
import javax.swing.*;

public class BotonCambioTemperatura extends JFrame implements Observador {
	private static Temperatura temperatura;
	private ObservableTemperatura observable;
	
	private JLabel etiqueta;
	private JTextArea campo;
	private JButton boton;
	
	public BotonCambioTemperatura(ObservableTemperatura observable) {
		this.observable = observable;
		setTitle("Boton Temperatura");
		setSize(300,300);
		Panel panelSuperior = new Panel();
		panelSuperior.setLayout(new BorderLayout());
		getContentPane().add(panelSuperior);
		etiqueta = new JLabel("Temperatura: " + temperatura.getTemperatura() + " ºC");
		boton = new JButton("Actualizar");
		campo = new JTextArea(10, 10);
		boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActionPerformed(evt);
            }
        });
		panelSuperior.add(campo, BorderLayout.SOUTH);
		panelSuperior.add(boton, BorderLayout.EAST);
		panelSuperior.add(etiqueta, BorderLayout.NORTH);
	}
	
	private void botonActionPerformed(java.awt.event.ActionEvent evt) {
		String s = campo.getText();
		if(isNumber(s)) {
			setTemperatura(Integer.parseInt(s));
		}
	}
	
	public void refrescarPantalla() {
		etiqueta.setText("Temperatura: " + temperatura.getTemperatura() + " ºC");
		//System.out.println("Temperatura (Botón Cambio): " + temperatura.getTemperatura() + " ºC");
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