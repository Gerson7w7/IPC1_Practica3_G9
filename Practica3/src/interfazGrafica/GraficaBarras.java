package interfazGrafica;

import java.awt.Dimension;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficaBarras {

    public GraficaBarras() {

    }

    public void grafica(int n1, int n2, int n3, int n4, int n5, int n6,
            int n7, int n8, int n9, int n10) {
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        if (n1 != 0) {
            datos.setValue(n1, "0-10 años", "0-10");
        }
        if (n2 != 0) {
            datos.setValue(n2, "11-20 años", "11-20");
        }
        if (n3 != 0) {
            datos.setValue(n3, "21-30 años", "21-30");
        }
        if (n4 != 0) {
            datos.setValue(n4, "31-40 años", "31-40");
        }
        if (n5 != 0) {
            datos.setValue(n5, "41-50 años", "41-50");
        }
        if (n6 != 0) {
            datos.setValue(n6, "51-60 años", "51-60");
        }
        if (n7 != 0) {
            datos.setValue(n7, "61-70 años", "61-70");
        }
        if (n8 != 0) {
            datos.setValue(n8, "71-80 años", "71-80");
        }
        if (n9 != 0) {
            datos.setValue(n9, "81-90 años", "81-90");
        }
        if (n10 != 0) {
            datos.setValue(n10, "91-100 años", "91-100");
        }

        JFreeChart grafica = ChartFactory.createBarChart("Edad de estudiantes", 
                "Edad", "Estudiantes", datos, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel panelG = new ChartPanel(grafica);
        panelG.setMouseWheelEnabled(true);
        panelG.setPreferredSize(new Dimension(700,500));
        //this.setLayout(new BorderLayout());
        //this.add(panelG, BorderLayout.NORTH);
    }

}
