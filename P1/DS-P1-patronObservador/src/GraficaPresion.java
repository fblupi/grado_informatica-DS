
import java.awt.*;

import javax.swing.*;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GraficaPresion extends JPanel implements Observador {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Presion presion;
	private int contador;
	private XYSeries series;
	private XYSeriesCollection dataset;
	private JFreeChart chart;
	private ChartPanel chartPanel;
	
	public GraficaPresion(Presion presion) {
		contador = 0;
		this.presion = presion;
		setBorder(javax.swing.BorderFactory.createTitledBorder("Gráfica Presión"));
		setLayout(new BorderLayout());
		series = new XYSeries("Presión");
		dataset = new XYSeriesCollection(series);
		chart = ChartFactory.createXYLineChart(
				"Gráfica Presión",			// título 
				"Tiempo", 					// etiqueta eje X
				"Presión (hPa)",			// etiqueta eje Y
				dataset, 					// datos
				PlotOrientation.VERTICAL, 	// orientación
				false, 						// leyenda
				false, 						// tooltips
				false						// urls
		);
		chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(400,200));
		add(chartPanel);
	}
	
	public void refrescarPantalla() {
		series.add(contador,presion.getPresion());
		contador++;
	}
	
	public void manejarEvento() {
		refrescarPantalla();
	}
}