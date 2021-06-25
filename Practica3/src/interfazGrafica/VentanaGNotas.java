package interfazGrafica;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import logica.*;

public class VentanaGNotas extends JFrame {

    public VentanaGNotas() {
        //Inicializando la ventana y dándole dimensiones
        VentanaGNotasP ventanaGNotasP = new VentanaGNotasP();
        this.setBounds(250, 35, 700, 600);
        this.setTitle("Gráfica de edad");
        this.setVisible(true);
        this.add(ventanaGNotasP);
        this.addWindowListener(ventanaGNotasP);
    }

}

final class VentanaGNotasP extends JPanel implements ActionListener, WindowListener {

    JLabel labelG = new JLabel("Gráfica por ordenamiento de notas", SwingConstants.CENTER);
    JLabel opcCodigo = new JLabel("Código del curso:");
    JButton ordenar = new JButton("Ordenar");
    JLabel opcOrdenar = new JLabel("Opciones de ordenamiento:");
    JComboBox tOrdenamiento, vOrdenamiento, aOrdenamiento;
    JTextField codigo = new JTextField("");
    OrdenamientoNotas ordenamientoNotas;
    OrdenamientoNotas ordenamientoNotas2;

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
        opcCodigo.setBounds(400, 50, 300, 35);
        ordenar.setBounds(530, 80, 100, 30);
        tOrdenamiento.setBounds(40, 80, 100, 20);
        vOrdenamiento.setBounds(160, 80, 100, 20);
        aOrdenamiento.setBounds(280, 80, 100, 20);
        codigo.setBounds(400, 80, 100, 20);

        this.setBackground(Color.YELLOW);
    }

    //Aquí inicializamos los componentes y los añadimos al panel
    public void initComponents() {
        this.add(labelG);
        this.add(ordenar);
        this.add(opcOrdenar);
        this.add(codigo);
        this.add(opcCodigo);

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
        ordenamientoNotas = new OrdenamientoNotas(codigo);
        Thread hilo1 = new Thread(ordenamientoNotas);
        hilo1.start();
        this.add(ordenamientoNotas);
        ordenamientoNotas.setBounds(0, 150, 680, 410);
        
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
        
   
    }

}
