import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class CalcuVector {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> crearYMostrarGUI());
    }

    private static void crearYMostrarGUI() {
        JFrame frame = new JFrame("Calculadora de Vectores");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JTextField fieldVectorA = new JTextField(20);
        JTextField fieldVectorB = new JTextField(20);

        frame.add(new JLabel("Vector A :"));
        frame.add(fieldVectorA);
        frame.add(new JLabel("Vector B :"));
        frame.add(fieldVectorB);

        JButton button = new JButton("Calcular Suma");
        frame.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strVectorA = fieldVectorA.getText();
                String strVectorB = fieldVectorB.getText();

                if (strVectorA.isEmpty() || strVectorB.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese ambos vectores.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    int[] vectorA = Arrays.stream(strVectorA.split(",")).mapToInt(Integer::parseInt).toArray();
                    int[] vectorB = Arrays.stream(strVectorB.split(",")).mapToInt(Integer::parseInt).toArray();

                    if (vectorA.length != vectorB.length) {
                        JOptionPane.showMessageDialog(frame, "Los vectores deben tener la misma longitud.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    int[] vectorC = new int[vectorA.length];
                    for (int i = 0; i < vectorA.length; i++) {
                        vectorC[i] = vectorA[i] + vectorB[i];
                    }

                    JOptionPane.showMessageDialog(frame, "Vector C: " + Arrays.toString(vectorC));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese solo números válidos separados por comas.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.pack();
        frame.setVisible(true);
    }
}
