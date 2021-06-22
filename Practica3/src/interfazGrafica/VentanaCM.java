

package interfazGrafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class VentanaCM extends JFrame{
    public VentanaCM(){
        this.setBounds(400, 170, 520, 275);
        this.setTitle("Carga de datos");
        this.setVisible(true);
        this.add(new VentanaCMP());
    }
}

final class VentanaCMP extends JPanel implements ActionListener {
    JLabel labelCM = new JLabel("CARGA DE DATOS");
    JButton bCargarDatos = new JButton("Cargar datos");
    
    public VentanaCMP() {
        estetica();
        this.add(labelCM);
        this.add(bCargarDatos);
    }
    
    public void estetica(){
        this.setLayout(null);
        labelCM.setBounds(120, 10, 500, 35);
        bCargarDatos.setBounds(50, 100, 150, 30);
        this.setBackground(Color.ORANGE);
        labelCM.setFont(new Font("Carga de datos",Font.ROMAN_BASELINE, 30));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}

