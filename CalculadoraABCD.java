import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraABCD {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> crearYMostrarGUI());
    }

    private static void crearYMostrarGUI() {
        JFrame frame = new JFrame("Calculadora ABCD");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JTextField fieldA = new JTextField(5);
        JTextField fieldB = new JTextField(5);
        JTextField fieldC = new JTextField(5);
        JTextField fieldD = new JTextField(5);

        frame.add(new JLabel("A:"));
        frame.add(fieldA);
        frame.add(new JLabel("B:"));
        frame.add(fieldB);
        frame.add(new JLabel("C:"));
        frame.add(fieldC);
        frame.add(new JLabel("D:"));
        frame.add(fieldD);

        JButton button = new JButton("Calcular");
        frame.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double A = Double.parseDouble(fieldA.getText());
                    double B = Double.parseDouble(fieldB.getText());
                    double C = Double.parseDouble(fieldC.getText());
                    double D = Double.parseDouble(fieldD.getText());

                    double sumaAB = A + B;
                    double sumaCD = C + D;

                    JOptionPane.showMessageDialog(frame, "Suma de A y B: " + sumaAB + "\nSuma de C y D: " + sumaCD);

                    if (sumaAB > 0 && sumaCD > 0) {
                        JOptionPane.showMessageDialog(frame, "Variables: A=" + A + ", B=" + B + ", C=" + C + ", D=" + D);
                    } else if (sumaAB > 0) {
                        JOptionPane.showMessageDialog(frame, "Producto: " + (A * B * C * D));
                    } else if (sumaCD > 0) {
                        JOptionPane.showMessageDialog(frame, "Suma: " + (sumaAB + sumaCD));
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese solo números válidos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.pack();
        frame.setVisible(true);
    }
}

