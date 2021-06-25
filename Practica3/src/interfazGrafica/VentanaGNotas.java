package interfazGrafica;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import logica.*;
import objetos.Alumno;
import objetos.Curso;
import objetos.Nota;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class VentanaGNotas extends JFrame {

    int nCodigo;

    public VentanaGNotas(int nCodigo) {
        this.nCodigo = nCodigo;
        //Inicializando la ventana y dándole dimensiones
        VentanaGNotasP ventanaGNotasP = new VentanaGNotasP(this.nCodigo);
        this.setBounds(250, 35, 700, 600);
        this.setTitle("Gráfica de edad");
        this.setVisible(true);
        Thread hilo = new Thread(ventanaGNotasP);
        hilo.start();
        this.add(ventanaGNotasP);
        this.addWindowListener(ventanaGNotasP);
    }
}

final class VentanaGNotasP extends JPanel implements ActionListener, WindowListener, Runnable {

    JLabel labelG = new JLabel("Gráfica por ordenamiento de notas", SwingConstants.CENTER);
    JButton ordenar = new JButton("Ordenar");
    JLabel opcOrdenar = new JLabel("Opciones de ordenamiento:");
    JComboBox tOrdenamiento, vOrdenamiento, aOrdenamiento;

    int nCodigo;

    public VentanaGNotasP(int nCodigo) {
        this.nCodigo = nCodigo;
        initComponents();
        estetica();
    }

    //Aquí irá las dimensiones y colores de los componentes
    public void estetica() {
        this.setLayout(null);
        labelG.setBounds(100, 10, 500, 35);
        labelG.setFont(new Font("Gráficas", Font.ROMAN_BASELINE, 30));
        opcOrdenar.setBounds(40, 50, 300, 35);
        ordenar.setBounds(530, 80, 100, 30);
        tOrdenamiento.setBounds(40, 80, 100, 20);
        vOrdenamiento.setBounds(160, 80, 100, 20);
        aOrdenamiento.setBounds(280, 80, 100, 20);

        this.setBackground(Color.YELLOW);
    }

    //Aquí inicializamos los componentes y los añadimos al panel
    public void initComponents() {
        this.add(labelG);
        this.add(ordenar);
        this.add(opcOrdenar);

        String[] tipoO = {"Ascendente", "Descendente"};
        tOrdenamiento = new JComboBox(tipoO);
        this.add(tOrdenamiento);

        String[] velocidadO = {"Alta", "Media", "Baja"};
        vOrdenamiento = new JComboBox(velocidadO);
        this.add(vOrdenamiento);

        String[] algoritmoO = {"BubbleSort", "QuickSort"};
        aOrdenamiento = new JComboBox(algoritmoO);
        this.add(aOrdenamiento);

        ordenar.addActionListener(this);
    }

    public void asignacion(int sleep) {
        try {
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
        
        this.add(panelG);
        panelG.setBounds(0, 150, 680, 410);
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException ex) {
            Logger.getLogger(VentanaGNotasP.class.getName()).log(Level.SEVERE, null, ex);
        }

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
        asignacion(500);
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

    @Override
    public void actionPerformed(ActionEvent e) {

        int sleep = 0;
        switch (vOrdenamiento.getSelectedIndex()) {
            case 0:
                sleep = 100;
                break;
            case 1:
                sleep = 600;
                break;
            case 2:
                sleep = 1200;
                break;
            default:
                break;
        }
        
        Ordenamiento ordenamiento = new Ordenamiento(this.nCodigo, sleep, 
                (String)tOrdenamiento.getSelectedItem(), 
                (String)aOrdenamiento.getSelectedItem());   
        VentanaGraficaP.ventanaGNotas.dispose();
        ordenamiento.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
