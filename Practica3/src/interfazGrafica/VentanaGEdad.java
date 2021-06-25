package interfazGrafica;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import logica.CargaMasiva;
import objetos.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class VentanaGEdad extends JFrame {

    public VentanaGEdad() {
        //Inicializando la ventana y dándole dimensiones
        VentanaGEdadP ventanaGEdadP = new VentanaGEdadP();
        this.setBounds(400, 50, 700, 500);
        this.setTitle("Gráfica de edad");
        this.setVisible(true);
        Thread hilo = new Thread(ventanaGEdadP);
        hilo.start();
        this.add(ventanaGEdadP);
        this.addWindowListener(ventanaGEdadP);
    }
}

final class VentanaGEdadP extends JPanel implements WindowListener, Runnable {

    int n1 = 0, n2 = 0, n3 = 0, n4 = 0, n5 = 0, n6 = 0, n7 = 0, n8 = 0, n9 = 0, n10 = 0;

    public VentanaGEdadP() {
        estetica();
    }

    //Aquí irá las dimensiones y colores de los componentes
    public void estetica() {
        this.setLayout(null);
        this.setBackground(Color.YELLOW);
    }

    @Override
    public void run() {
        JFreeChart grafica = null;
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        String[] fecha;
        int edad = 0;
        grafica = ChartFactory.createBarChart3D("Edad de estudiantes",
                "Edad", "Estudiantes", datos, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel panelG = new ChartPanel(grafica);
        for (Alumno alumno : CargaMasiva.alumnos) {
            if (alumno != null) {
                fecha = alumno.getfNacimiento().split("/");
                edad = 2021 - Integer.parseInt(fecha[2]);
                if (edad >= 0 && edad <= 10) {
                    this.n1++;
                } else if (edad > 10 && edad <= 20) {
                    this.n2++;
                } else if (edad > 20 && edad <= 30) {
                    this.n3++;
                } else if (edad > 30 && edad <= 40) {
                    this.n4++;
                } else if (edad > 40 && edad <= 50) {
                    this.n5++;
                } else if (edad > 50 && edad <= 60) {
                    this.n6++;
                } else if (edad > 60 && edad <= 70) {
                    this.n7++;
                } else if (edad > 70 && edad <= 80) {
                    this.n8++;
                } else if (edad > 80 && edad <= 90) {
                    this.n9++;
                } else if (edad > 90 && edad <= 100) {
                    this.n10++;
                }

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

                panelG.setMouseWheelEnabled(true);
                panelG.setPreferredSize(new Dimension(700, 500));
                this.setLayout(new BorderLayout());
                this.add(panelG, BorderLayout.NORTH);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(VentanaGEdadP.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    //aquí implementamos los métodos de la interfaz de WindowListener
    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        //Aquí se abre la anterior ventana cuando se cierra la actual.
        VentanaPrincipalP.ventanaGrafica.setVisible(true);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}
