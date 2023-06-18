package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCubo extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel lado, volumen, superficie;
    private JTextField campoLado;
    private JButton calcular;

    public VentanaCubo() {
        inicio();
        setTitle("Cubo");
        setSize(280, 210);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        lado = new JLabel();
        lado.setText("Lado (cms):");
        lado.setBounds(20, 20, 135, 23);
        campoLado = new JTextField();
        campoLado.setBounds(100, 20, 135, 23);

        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(100, 50, 135, 23);
        calcular.addActionListener(this);

        volumen = new JLabel();
        volumen.setText("Volumen (cm3):");
        volumen.setBounds(20, 80, 135, 23);

        superficie = new JLabel();
        superficie.setText("Superficie (cm2):");
        superficie.setBounds(20, 110, 135, 23);

        contenedor.add(lado);
        contenedor.add(campoLado);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    public void actionPerformed(ActionEvent event) {
        boolean error = false;
        double lado = 0;
        try {
            lado = Double.parseDouble(campoLado.getText());
            Cubo cubo = new Cubo(lado);

            volumen.setText("Volumen (cm3): " + String.format("%.2f", cubo.calcularVolumen()));
            superficie.setText("Superficie (cm2): " + String.format("%.2f", cubo.calcularSuperficie()));
        } catch (Exception e) {
            error = true;
        } finally {
            if (error) {
                JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

