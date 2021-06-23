package interfazGrafica;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

public class VentanaGEdad extends JFrame {

    public VentanaGEdad() {
        //Inicializando la ventana y dándole dimensiones
        VentanaGEdadP ventanaGEdadP = new VentanaGEdadP();
        this.setBounds(400, 170, 800, 600);
        this.setTitle("Gráfica de edad");
        this.setVisible(true);
        this.add(ventanaGEdadP);
        this.addWindowListener(ventanaGEdadP);
        this.pack();
        this.repaint();
    }
}

final class VentanaGEdadP extends JPanel implements WindowListener {
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

}
