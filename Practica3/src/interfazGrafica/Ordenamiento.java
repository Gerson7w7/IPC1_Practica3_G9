package interfazGrafica;

import java.awt.Dimension;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import logica.*;
import objetos.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Ordenamiento extends JFrame {

    int nCodigo;
    int sleep;
    String tipoOrd;
    String algoritmoOrd;

    public Ordenamiento(int nCodigo, int sleep, String tipoOrd, String algoritmoOrd) {
        this.nCodigo = nCodigo;
        this.sleep = sleep;
        this.tipoOrd = tipoOrd;
        this.algoritmoOrd = algoritmoOrd;
        //Inicializando la ventana y dándole dimensiones
        OrdenamientoP ordenamientoP = new OrdenamientoP(this.nCodigo, this.sleep, this.tipoOrd, this.algoritmoOrd);
        this.setBounds(400, 50, 700, 500);
        this.setTitle("Gráfica de notas");
        this.setVisible(true);
        Thread hilo = new Thread(ordenamientoP);
        hilo.start();
        this.add(ordenamientoP);
        this.addWindowListener(ordenamientoP);
    }

}

class OrdenamientoP extends JPanel implements Runnable, WindowListener {

    int nCodigo;
    int sleep;
    String tipoOrd;
    String algoritmoOrd;
    Nota[] notasOrd = new Nota[100];

    public OrdenamientoP(int nCodigo, int sleep, String tipoOrd, String algoritmoOrd) {
        this.nCodigo = nCodigo;
        this.sleep = sleep;
        this.tipoOrd = tipoOrd;
        this.algoritmoOrd = algoritmoOrd;
        filtrar();
        
        this.setLayout(null);
    }

    public void asignacion(int sleep, String tipoOrd, String algoritmoOrd) throws InterruptedException {
        try {
            DefaultCategoryDataset datos = new DefaultCategoryDataset();
            JFreeChart grafica = nombreCurso(nCodigo, datos);

            for (Curso curso : CargaMasiva.cursos) {
                if (curso != null && curso.getCodigo() == nCodigo) {
                    for (Alumno alumno : CargaMasiva.alumnos) {
                        if (alumno != null) {
                            for (Nota nota : this.notasOrd) {
                                if (nota != null && nota.getIdAlumno() == alumno.getId() && nota.getIdCurso() == curso.getId()) {
                                    if (tipoOrd.equals("Ascendente")) {
                                        switch (sleep) {
                                            case 1200:
                                                if (algoritmoOrd.equals("BubbleSort")) {
                                                    notasOrd = ordenamiento(notasOrd);
                                                    grafica(datos, nota, grafica, alumno);
                                                    Thread.sleep(sleep);
                                                    break;
                                                } else if (algoritmoOrd.equals("QuickSort")) {

                                                }
                                                break;
                                            case 600:
                                                if (algoritmoOrd.equals("BubbleSort")) {
                                                    notasOrd = ordenamiento(notasOrd);
                                                    grafica(datos, nota, grafica, alumno);
                                                    Thread.sleep(sleep);
                                                    break;
                                                } else if (algoritmoOrd.equals("QuickSort")) {

                                                }
                                                break;
                                            case 100:
                                                if (algoritmoOrd.equals("BubbleSort")) {
                                                    notasOrd = ordenamiento(notasOrd);
                                                    grafica(datos, nota, grafica, alumno);
                                                    Thread.sleep(sleep);
                                                    break;
                                                } else if (algoritmoOrd.equals("QuickSort")) {

                                                }
                                                break;
                                            default:
                                                break;
                                        }
                                    } else if (tipoOrd.equals("Descendente")) {
                                        switch (sleep) {
                                            case 1200:
                                                if (algoritmoOrd.equals("BubbleSort")) {

                                                } else if (algoritmoOrd.equals("QuickSort")) {

                                                }
                                                break;
                                            case 600:
                                                if (algoritmoOrd.equals("BubbleSort")) {

                                                } else if (algoritmoOrd.equals("QuickSort")) {

                                                }
                                                break;
                                            case 100:
                                                if (algoritmoOrd.equals("BubbleSort")) {

                                                } else if (algoritmoOrd.equals("QuickSort")) {

                                                }
                                                break;
                                            default:
                                                break;
                                        }
                                    }

                                }
                            }
                        }
                    }
                }
            }
        } catch (NumberFormatException e) {
            String m = "No se ha ingresado ningún código :(";
            JOptionPane.showMessageDialog(this, m, "Error", 2);
        }
    }

    public final void filtrar() {
        for (Curso curso : CargaMasiva.cursos) {
            if (curso != null && curso.getCodigo() == nCodigo) {
                for (Alumno alumno : CargaMasiva.alumnos) {
                    if (alumno != null) {
                        for (Nota nota : CargaMasiva.notas) {
                            if (nota != null && nota.getIdAlumno() == alumno.getId() && nota.getIdCurso() == curso.getId()) {
                                for (int j = 0; j < notasOrd.length; j++) {
                                    if (notasOrd[j] == null) {
                                        notasOrd[j] = nota;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void grafica(DefaultCategoryDataset datos, Nota nota, JFreeChart grafica, Alumno alumno) {
        datos.setValue(nota.getNota(), "Alumno", alumno.getNombre());
        ChartPanel panelG = new ChartPanel(grafica);
        panelG.setMouseWheelEnabled(true);
        panelG.setPreferredSize(new Dimension(680, 410));
        panelG.repaint();

        this.add(panelG);
        panelG.setBounds(0, 200, 680, 380);
    }

    public Nota[] ordenamiento(Nota[] notas) {
        for (int i = 0; i < (notas.length - 1); i++) {
            for (int j = i + 1; j < notas.length; j++) {
                if (notas[i] != null) {
                    if (notas[j] != null) {
                        if (notas[i].getNota() < notas[j].getNota()) {
                            double aux = notas[i].getNota();
                            notas[i].setNota(notas[j].getNota());
                            notas[j].setNota(aux);
                        }
                    }
                }
            }
        }
        return notas;
    }

    public JFreeChart nombreCurso(int nCodigo, DefaultCategoryDataset datos) {
        JFreeChart grafica = null;
        for (Curso curso : CargaMasiva.cursos) {
            if (curso != null && curso.getCodigo() == nCodigo) {
                grafica = ChartFactory.createBarChart3D("Notas del curso " + curso.getNombre(),
                        "Estudiantes", "Nota", datos, PlotOrientation.VERTICAL, true, true, false);
                break;
            }
        }
        return grafica;
    }

    @Override
    public void run() {
        try {
            asignacion(this.sleep, this.tipoOrd, this.algoritmoOrd);
        } catch (InterruptedException ex) {
            Logger.getLogger(OrdenamientoP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
        VentanaGraficaP.ventanaGNotas.setVisible(true);
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
