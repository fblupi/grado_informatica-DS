
import java.awt.*;
import javax.swing.*;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GraficaTemperatura extends JPanel implements Observador {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Temperatura temperatura;
	private int contador; // se usará para los valores del eje X de la gráfica
	private XYSeries series;
	private XYSeriesCollection dataset;
	private JFreeChart chart;
	private ChartPanel chartPanel;
	
	public GraficaTemperatura(Temperatura temperatura) {
		this.temperatura = temperatura;
		contador = 0;
		setBorder(javax.swing.BorderFactory.createTitledBorder("Gráfica Temperatura"));
		setLayout(new BorderLayout());
		series = new XYSeries("Temperatura");
		dataset = new XYSeriesCollection(series);
		chart = ChartFactory.createXYLineChart(
				"Gráfica Temperatura",		// título 
				"Tiempo", 					// etiqueta eje X
				"Temperatura (ºC)",			// etiqueta eje Y
				dataset, 					// datos
				PlotOrientation.VERTICAL, 	// orientación
				false, 						// leyenda
				false, 						// tooltips
				false						// urls
		);
		chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(300,200));
		add(chartPanel);
	}
	
	public void refrescarPantalla() {
		series.add(contador,temperatura.getTemperatura());
		contador++;
	}
	
	public void manejarEvento() {
		refrescarPantalla();
	}
}