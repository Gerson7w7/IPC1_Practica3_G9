package interfazGrafica;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import logica.CargaMasiva;
import objetos.*;
import org.jfree.chart.*;
import org.jfree.data.general.DefaultPieDataset;

public class GraficaPie extends JFrame {

    int nCodigo;

    public GraficaPie(int nCodigo) {
        this.nCodigo = nCodigo;
        //Inicializando la ventana y dándole dimensiones
        GraficaPieP graficaPieP = new GraficaPieP(this.nCodigo);
        this.setBounds(400, 50, 700, 500);
        this.setTitle("Gráfica de sexo");
        this.setVisible(true);
        Thread hilo = new Thread(graficaPieP);
        hilo.start();
        this.addWindowListener(graficaPieP);
        this.add(graficaPieP);

    }

}

class GraficaPieP extends JPanel implements WindowListener, Runnable {

    int nFemenino = 0, nMasculino = 0;
    int nCodigo;

    public GraficaPieP(int nCodigo) {
        this.nCodigo = nCodigo;
    }

    //Método para saber la cantidad de mujeres y hombres de alumnos 
    @Override
    public void run() {
        JFreeChart grafica = null;
        DefaultPieDataset datos = new DefaultPieDataset();
        grafica = ChartFactory.createPieChart("Géneros", datos, true, true, false);
        ChartPanel panelG = new ChartPanel(grafica);
        for (Curso curso : CargaMasiva.cursos) {
            if (curso != null && curso.getCodigo() == nCodigo) {
                for (Alumno alumno : CargaMasiva.alumnos) {
                    if (alumno != null) {
                        for (Nota nota : CargaMasiva.notas) {
                            if (nota != null && nota.getIdAlumno() == alumno.getId() && nota.getIdCurso() == curso.getId()) {
                                if (alumno.getGenero().equals("F")) {
                                    nFemenino++;
                                } else if (alumno.getGenero().equals("M")) {
                                    nMasculino++;
                                }
                                datos.setValue("Masculino", nMasculino);
                                datos.setValue("Femenino", nFemenino);
                                panelG.setMouseWheelEnabled(true);
                                panelG.setPreferredSize(new Dimension(700, 500));
                                this.setLayout(new BorderLayout());
                                this.add(panelG, BorderLayout.NORTH);
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(GraficaPieP.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }
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
    }

    @Override
    public void windowClosed(WindowEvent e) {
        //Aquí se abre la anterior ventana cuando se cierra la actual.
        VentanaPrincipalP.ventanaGrafica.setVisible(true);
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
