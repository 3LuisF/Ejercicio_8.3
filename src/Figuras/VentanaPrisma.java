package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrisma extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel base, altura, profundidad, volumen, superficie;
    private JTextField campoBase, campoAltura, campoProfundidad;
    private JButton calcular;

    public VentanaPrisma() {
        inicio();
        setTitle("Prisma");
        setSize(280, 250);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        base = new JLabel();
        base.setText("Base (cms):");
        base.setBounds(20, 20, 135, 23);
        campoBase = new JTextField();
        campoBase.setBounds(100, 20, 135, 23);

        altura = new JLabel();
        altura.setText("Altura (cms):");
        altura.setBounds(20, 50, 135, 23);
        campoAltura = new JTextField();
        campoAltura.setBounds(100, 50, 135, 23);

        profundidad = new JLabel();
        profundidad.setText("Profundidad (cms):");
        profundidad.setBounds(20, 80, 135, 23);
        campoProfundidad = new JTextField();
        campoProfundidad.setBounds(130, 80, 105, 23);

        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(100, 110, 135, 23);
        calcular.addActionListener(this);

        volumen = new JLabel();
        volumen.setText("Volumen (cm3):");
        volumen.setBounds(20, 140, 135, 23);

        superficie = new JLabel();
        superficie.setText("Superficie (cm2):");
        superficie.setBounds(20, 170, 135, 23);

        contenedor.add(base);
        contenedor.add(campoBase);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(profundidad);
        contenedor.add(campoProfundidad);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    public void actionPerformed(ActionEvent event) {
        boolean error = false;
        double base = 0;
        double altura = 0;
        double profundidad = 0;
        try {
            base = Double.parseDouble(campoBase.getText());
            altura = Double.parseDouble(campoAltura.getText());
            profundidad = Double.parseDouble(campoProfundidad.getText());
            Prisma prisma = new Prisma(base, altura, profundidad);

            volumen.setText("Volumen (cm3): " + String.format("%.2f", prisma.calcularVolumen()));
            superficie.setText("Superficie (cm2): " + String.format("%.2f", prisma.calcularSuperficie()));
        } catch (Exception e) {
            error = true;
        } finally {
            if (error) {
                JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
