package interfazGrafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import logica.CargaMasiva;
import objetos.*;
import org.jfree.chart.*;
import org.jfree.data.general.DefaultPieDataset;

public class GraficaPie extends JFrame {

    public GraficaPie() {
        GraficaPieP graficaPieP = new GraficaPieP();
        this.setBounds(400, 170, 800, 600);
        this.setTitle("Gráfica de sexo");
        this.setVisible(true);
        this.add(graficaPieP);
        this.addWindowListener(graficaPieP);
        this.pack();
        this.repaint();
    }
}

final class GraficaPieP extends JPanel implements WindowListener {

    int nFemenino = 1, nMasculino = 1;

    public GraficaPieP() {
        estetica();
        initComponents();
    }

    public void estetica() {
        this.setLayout(null);
        this.setBackground(Color.YELLOW);
    }

    public void initComponents() {
        cantidad(CargaMasiva.alumnos);
        grafica();
    }

    public void cantidad(Alumno[] alumnos) {
        for (Alumno alumno : alumnos) {
            if (alumno != null) {
                if (alumno.getGenero().equals("F")) {
                    nFemenino++;
                } else if (alumno.getGenero().equals("M")) {
                    nMasculino++;
                }
            }
        }
    }
    
    public void grafica(){
        DefaultPieDataset datos = new DefaultPieDataset();
        datos.setValue("Masculino", nMasculino);
        datos.setValue("Femenino", nFemenino);
        JFreeChart grafica = ChartFactory.createPieChart("Géneros", datos, true, true, false);
        ChartPanel panelG = new ChartPanel(grafica);
        panelG.setMouseWheelEnabled(true);
        panelG.setPreferredSize(new Dimension(700,500));
        this.setLayout(new BorderLayout());
        this.add(panelG, BorderLayout.NORTH);
        
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
        VentanaPrincipalP.ventanaGrafica.setVisible(true);
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
