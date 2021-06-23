package interfazGrafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import logica.*;
import main.*;

public class VentanaCM extends JFrame {

    public VentanaCM() {
        VentanaCMP ventanaCMP = new VentanaCMP();
        this.setBounds(400, 170, 520, 275);
        this.setTitle("Carga de datos");
        this.setVisible(true);
        this.add(ventanaCMP);
        this.addWindowListener(ventanaCMP);
    }
}

final class VentanaCMP extends JPanel implements ActionListener, WindowListener {

    JLabel labelCM = new JLabel("CARGA DE DATOS");
    JLabel labelCMInfo = new JLabel("Ingrese la ruta de la carpeta donde se encuentran sus archivos:");
    JButton bCargarDatos = new JButton("Cargar datos");
    JTextField ruta = new JTextField("");
    JLabel labelError = new JLabel("No se ha encontrado la ruta de los archivos :(");
    JLabel labelExito = new JLabel("Los archivos han sido cargados! :D");
    CargaMasiva cargaMasiva = new CargaMasiva();

    public VentanaCMP() {
        estetica();
        initComponents();
    }

    public void estetica() {
        this.setLayout(null);
        labelCM.setBounds(120, 10, 500, 35);
        labelCM.setFont(new Font("Carga de datos", Font.ROMAN_BASELINE, 30));
        labelCMInfo.setBounds(20, 50, 500, 50);
        bCargarDatos.setBounds(220, 175, 150, 30);
        ruta.setBounds(20, 100, 300, 20);
        this.setBackground(Color.LIGHT_GRAY);
        labelError.setBounds(100, 125, 300, 30);
        labelExito.setBounds(100, 125, 200, 30);

    }

    public void initComponents() {
        this.add(labelCM);
        this.add(labelCMInfo);
        this.add(bCargarDatos);
        this.add(ruta);
        this.add(labelError);
        this.add(labelExito);
        labelError.setVisible(false);
        labelExito.setVisible(false);
        bCargarDatos.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

            String datos = cargaMasiva.cargaDatos(ruta.getText() + "alumnos.csv");
            cargaMasiva.cargaAlumnos(datos);

            datos = cargaMasiva.cargaDatos(ruta.getText() + "cursos.csv");
            cargaMasiva.cargaCursos(datos);

            datos = cargaMasiva.cargaDatos(ruta.getText() + "asignaciones.csv");
            cargaMasiva.cargaNotas(datos);

            if (CargaMasiva.archivoB == true) {
                labelError.setVisible(false);
                labelExito.setVisible(true);
            } else {
                labelExito.setVisible(false);
                labelError.setVisible(true);
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
        Main.ventanaPrincipal.setVisible(true);
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
