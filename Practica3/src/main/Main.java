
package main;

import interfazGrafica.*;
import javax.swing.JFrame;

public class Main {
    public static VentanaPrincipal ventanaPrincipal;
    
    public static void main(String[] args) {
        ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
