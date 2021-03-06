package interfazGrafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import logica.CargaMasiva;
import main.Main;

public class VentanaGrafica extends JFrame {

    public VentanaGrafica() {
        //Inicializando la ventana y dándole dimensiones
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
    public static VentanaGEdad ventanaGEdad; 
    public static VentanaGNotas ventanaGNotas;
    JLabel labelG = new JLabel("GRÁFICAS");
    JLabel opcCodigo = new JLabel("Código del curso:");
    JTextField codigo = new JTextField("");
    JButton bGSexo = new JButton("Gráfica por sexo");
    JButton bGEdad = new JButton("Gráfica por edad");
    JButton bGNotas = new JButton("Gráficas por ordenamiento de Notas");

    public VentanaGraficaP() {
        estetica();
        initComponents();
    }

    //Aquí irá las dimensiones y colores de los componentes
    public void estetica() {
        this.setLayout(null);
        labelG.setBounds(120, 10, 500, 35);
        labelG.setFont(new Font("Gráficas", Font.ROMAN_BASELINE, 30));
        bGSexo.setBounds(40, 120, 135, 30);
        bGEdad.setBounds(220, 120, 135, 30);
        bGNotas.setBounds(70, 170, 250, 30);
        opcCodigo.setBounds(30, 50, 300, 35);
        codigo.setBounds(30, 80, 100, 20);
        this.setBackground(Color.YELLOW);
    }

    //Aquí inicializamos los componentes y los añadimos al panel
    public void initComponents() {
        this.add(labelG);
        this.add(bGSexo);
        this.add(bGEdad);
        this.add(bGNotas);
        this.add(codigo);
        this.add(opcCodigo);
        bGSexo.addActionListener(this);
        bGEdad.addActionListener(this);
        bGNotas.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int nCodigo = Integer.valueOf(this.codigo.getText());
      
        //Si se han cargado los archivos correctamente se podrá graficar
        //de lo contrario saldrá un cuadro de diálogo mostrando un error.
        if (CargaMasiva.alumnos != null && CargaMasiva.cursos != null && CargaMasiva.notas != null) {
            if (e.getSource() == bGSexo) {
                graficaPie = new GraficaPie(nCodigo);
                VentanaPrincipalP.ventanaGrafica.dispose();
                graficaPie.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            } else if (e.getSource() == bGEdad) {
                ventanaGEdad = new VentanaGEdad(nCodigo);
                VentanaPrincipalP.ventanaGrafica.dispose();
                ventanaGEdad.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            } else {
                ventanaGNotas = new VentanaGNotas(nCodigo);
                VentanaPrincipalP.ventanaGrafica.dispose();
                ventanaGNotas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        } else {
            String m = "No se han cargado los archivos :(";
            JOptionPane.showMessageDialog(graficaPie, m, "Error", 2);
        }
    }

     //aquí implementamos los métodos de la interfaz de WindowListener
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
