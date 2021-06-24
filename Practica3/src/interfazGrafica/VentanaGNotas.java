package interfazGrafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class VentanaGNotas extends JFrame {

    public VentanaGNotas() {
        //Inicializando la ventana y dándole dimensiones
        VentanaGNotasP ventanaGNotasP = new VentanaGNotasP();
        this.setBounds(250, 35, 700, 600);
        this.setTitle("Gráfica de edad");
        this.setVisible(true);
        this.add(ventanaGNotasP);
        this.addWindowListener(ventanaGNotasP);
//        this.pack();
//        this.repaint();
    }

}

final class VentanaGNotasP extends JPanel implements ActionListener, WindowListener {

    JLabel labelG = new JLabel("Gráfica por ordenamiento de notas", SwingConstants.CENTER);
    JButton ordenar = new JButton("Ordenar");
    JLabel opcOrdenar = new JLabel("Opciones de ordenamiento:");
    JComboBox tOrdenamiento, vOrdenamiento, aOrdenamiento;

    public VentanaGNotasP() {
        initComponents();
        estetica();
    }

    //Aquí irá las dimensiones y colores de los componentes
    public void estetica() {
        this.setLayout(null);
        labelG.setBounds(100, 10, 500, 35);
        labelG.setFont(new Font("Gráficas", Font.ROMAN_BASELINE, 30));
        opcOrdenar.setBounds(40, 50, 300, 35);
        ordenar.setBounds(500, 80, 100, 30);
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

    }

    public void grafica() {
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        JFreeChart grafica = ChartFactory.createBarChart3D("Edad de estudiantes",
                "Edad", "Estudiantes", datos, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel panelG = new ChartPanel(grafica);
        panelG.setMouseWheelEnabled(true);
        panelG.setPreferredSize(new Dimension(700, 500));
        this.setLayout(new BorderLayout());
        this.add(panelG, BorderLayout.NORTH);
    }

}
