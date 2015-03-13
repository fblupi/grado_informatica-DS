import java.io.File;
import java.io.IOException;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Test {

	public static void main(String[] args) {
		//Gráfico xy
		XYSeries series = new XYSeries("XY gráfico");
		series.add(0, 4);
		series.add(1, 2);
		series.add(2, 5);
		series.add(3, 3);
		series.add(4, 4);
		series.add(5, 2);
		series.add(6, 5);
		series.add(7, 3);
		series.add(8, 4);
		series.add(9, 2);
		series.add(10, 5);
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		JFreeChart chart = ChartFactory.createXYLineChart("Gráfico XY", "Eje x", "Eje y", dataset, PlotOrientation.VERTICAL, true, true, false);
		ChartFrame frame = new ChartFrame("Mi segundo chart", chart);
		frame.pack();
		frame.setVisible(true);
	
	}

}