import java.awt.*;
import javax.swing.*;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GraficaTemperatura extends JPanel implements Observador {
	private static Temperatura temperatura;
	private int contador;
	private XYSeries series;
	private XYSeriesCollection dataset;
	
	public GraficaTemperatura() {
		setBorder(javax.swing.BorderFactory.createTitledBorder("Gráfica Temperatura"));
		contador = 0;
		series = new XYSeries("Temperatura");
		dataset = new XYSeriesCollection(series);
		JFreeChart chart = ChartFactory.createXYLineChart("Gráfica Temperatura", "", "Temperatura", dataset, PlotOrientation.VERTICAL, false, false, false);
		ChartPanel panel = new ChartPanel(chart);
		setLayout(new BorderLayout());
		add(panel);
	}
	
	public void refrescarPantalla() {
		series.add(contador,temperatura.getTemperatura());
		contador++;
	}
	
	public void manejarEvento() {
		refrescarPantalla();
	}
}