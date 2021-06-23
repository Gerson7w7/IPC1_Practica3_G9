package interfazGrafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import logica.CargaMasiva;
import main.Main;

public class VentanaGrafica extends JFrame {

    public VentanaGrafica() {
        VentanaGraficaP ventanaGraficaP = new VentanaGraficaP();
        this.setBounds(400, 170, 430, 275);
        this.setTitle("Menú de gráficas");
        this.setVisible(true);
        this.add(ventanaGraficaP);
        this.addWindowListener(ventanaGraficaP);
    }
}

final class VentanaGraficaP extends JPanel implements ActionListener, WindowListener {

    public static GraficaPie graficaPie;
    JLabel labelG = new JLabel("GRÁFICAS");
    JButton bGSexo = new JButton("Gráfica por sexo");
    JButton bGEdad = new JButton("Gráfica por edad");
    JButton bGNotas = new JButton("Gráficas por ordenamiento de Notas");

    public VentanaGraficaP() {
        estetica();
        initComponents();
    }

    public void estetica() {
        this.setLayout(null);
        labelG.setBounds(120, 10, 500, 35);
        labelG.setFont(new Font("Gráficas", Font.ROMAN_BASELINE, 30));
        bGSexo.setBounds(40, 70, 135, 30);
        bGEdad.setBounds(220, 70, 135, 30);
        bGNotas.setBounds(70, 150, 250, 30);
        this.setBackground(Color.YELLOW);
    }

    public void initComponents() {
        this.add(labelG);
        this.add(bGSexo);
        this.add(bGEdad);
        this.add(bGNotas);
        bGSexo.addActionListener(this);
        bGEdad.addActionListener(this);
        bGNotas.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (CargaMasiva.alumnos != null && CargaMasiva.cursos != null && CargaMasiva.notas != null) {
            if (e.getSource() == bGSexo) {
                graficaPie = new GraficaPie();
                VentanaPrincipalP.ventanaGrafica.dispose();
                graficaPie.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            } else if (e.getSource() == bGEdad) {

            } else {

            }
        } else {
            String m = "No se han cargado los archivos :(";
            JOptionPane.showMessageDialog(graficaPie, m, "Error", 2);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Main.ventanaPrincipal.setVisible(true);
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
