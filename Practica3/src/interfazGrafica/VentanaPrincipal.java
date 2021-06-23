package interfazGrafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import main.*;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        this.setBounds(400, 170, 520, 275);
        this.setTitle("Administración de alumnos");
        this.setVisible(true);
        this.add(new VentanaPrincipalP());
    }
}

final class VentanaPrincipalP extends JPanel implements ActionListener {

    public static VentanaCM ventanaCM;
    public static VentanaGrafica ventanaGrafica;
    JLabel bienvenida = new JLabel("¿Qué desea relizar?");
    JButton bCargarDatos = new JButton("Cargar datos");
    JButton bGraficas = new JButton("Realizar gráficas");

    public VentanaPrincipalP() {
        estetica();
        initComponents();
    }

    public void estetica() {
        this.setLayout(null);
        bienvenida.setBounds(120, 10, 500, 35);
        bCargarDatos.setBounds(50, 100, 150, 30);
        bGraficas.setBounds(300, 100, 150, 30);
        this.setBackground(Color.ORANGE);
        bienvenida.setFont(new Font("bienvenida", Font.ROMAN_BASELINE, 30));
    }

    public void initComponents() {
        this.add(bienvenida);
        this.add(bCargarDatos);
        this.add(bGraficas);
        bCargarDatos.addActionListener(this);
        bGraficas.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bCargarDatos){
            ventanaCM = new VentanaCM();
            Main.ventanaPrincipal.dispose();
            ventanaCM.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }else{
            ventanaGrafica = new VentanaGrafica();
            Main.ventanaPrincipal.dispose();
            ventanaGrafica.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }

    
}
