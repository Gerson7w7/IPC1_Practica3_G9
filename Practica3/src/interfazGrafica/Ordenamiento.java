package interfazGrafica;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import logica.CargaMasiva;
import objetos.Alumno;
import objetos.Curso;
import objetos.Nota;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class Ordenamiento extends JPanel implements Runnable{

    JTextField codigo;
    int sleep;
    String tipoOrd;
    String algoritmoOrd;
    Nota[] notasOrd = new Nota[100];

    public Ordenamiento(JTextField codigo, int sleep, String tipoOrd, String algoritmoOrd) {
        this.sleep = sleep;
        this.tipoOrd = tipoOrd;
        this.algoritmoOrd = algoritmoOrd;
    }

    public void asignacion2(int sleep, String tipoOrd, String algoritmoOrd) throws InterruptedException {
        try {
            int nCodigo = Integer.valueOf(this.codigo.getText());
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
                                                    grafica(datos, nota, grafica, alumno, 0);
                                                    Thread.sleep(sleep);
                                                    break;
                                                } else if (algoritmoOrd.equals("QuickSort")) {

                                                }
                                                break;
                                            case 600:
                                                if (algoritmoOrd.equals("BubbleSort")) {
                                                    notasOrd = ordenamiento(notasOrd);
                                                    grafica(datos, nota, grafica, alumno, 0);
                                                    Thread.sleep(sleep);
                                                    break;
                                                } else if (algoritmoOrd.equals("QuickSort")) {

                                                }
                                                break;
                                            case 100:
                                                if (algoritmoOrd.equals("BubbleSort")) {
                                                    notasOrd = ordenamiento(notasOrd);
                                                    grafica(datos, nota, grafica, alumno, 0);
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

    public void filtrar() {
        for (Curso curso : CargaMasiva.cursos) {
            if (curso != null && curso.getCodigo() == nCodigo) {
                for (Alumno alumno : CargaMasiva.alumnos) {
                    if (alumno != null) {
                        for (Nota nota : CargaMasiva.notas) {
                            if (nota != null && nota.getIdAlumno() == alumno.getId() && nota.getIdCurso() == curso.getId()) {
                                for (int j = 0; j < notasOrd.length; j++) {
                                    if (notasOrd[j] == null) {
                                        notasOrd[j] = CargaMasiva.notas[i];
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

    public Nota[] ordenamiento(Nota[] notas) {
        for (int i = 0; i < (notas.length - 1); i++) {
            for (int j = i + 1; j < notas.length; j++) {
                if (notas[i].getNota() < notas[j].getNota()) {
                    double aux = notas[i].getNota();
                    notas[i].setNota(notas[j].getNota());
                    notas[j].setNota(aux);
                }
            }
        }
        return notas;
    }

    @Override
    public void run() {
        
    }
}
