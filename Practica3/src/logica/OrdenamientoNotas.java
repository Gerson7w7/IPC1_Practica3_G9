package logica;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import objetos.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class OrdenamientoNotas extends JPanel implements Runnable {

    JTextField codigo;   

    //para la primera gráfica (gráfica sin ordenamiento)
    public OrdenamientoNotas(JTextField codigo) {
        this.codigo = codigo;
    }

    public void asignacion(int sleep) {
        try {
            int nCodigo = Integer.valueOf(this.codigo.getText());
            DefaultCategoryDataset datos = new DefaultCategoryDataset();
            JFreeChart grafica = nombreCurso(nCodigo, datos);

            for (Curso curso : CargaMasiva.cursos) {
                if (curso != null && curso.getCodigo() == nCodigo) {
                    for (Alumno alumno : CargaMasiva.alumnos) {
                        if (alumno != null) {
                            for (Nota nota : CargaMasiva.notas) {
                                if (nota != null && nota.getIdAlumno() == alumno.getId() && nota.getIdCurso() == curso.getId()) {
                                    grafica(datos, nota, grafica, alumno, sleep);
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

    public void grafica(DefaultCategoryDataset datos, Nota nota, JFreeChart grafica, Alumno alumno, int sleep) {
        datos.setValue(nota.getNota(), "Alumno", alumno.getNombre());
        ChartPanel panelG = new ChartPanel(grafica);
        panelG.setMouseWheelEnabled(true);
        panelG.setPreferredSize(new Dimension(680, 410));
        this.setLayout(new BorderLayout());
        this.add(panelG, BorderLayout.NORTH);
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException ex) {
            Logger.getLogger(OrdenamientoNotas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public JFreeChart nombreCurso(int nCodigo, DefaultCategoryDataset datos) {
        JFreeChart grafica = null;
        for (Curso curso : CargaMasiva.cursos) {
            if (curso.getCodigo() == nCodigo) {
                grafica = ChartFactory.createBarChart3D("Notas del curso " + curso.getNombre(),
                        "Estudiantes", "Nota", datos, PlotOrientation.VERTICAL, true, true, false);
                break;
            }
        }
        return grafica;
    }


    @Override
    public void run() {
            asignacion(500);
    }
}
