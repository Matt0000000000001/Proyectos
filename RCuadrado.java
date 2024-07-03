import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class RCuadrado extends JFrame {
    private JTextField baseField;
    private JTextField alturaField;
    private JTextArea resultadoArea;

    public RCuadrado() {
        setTitle("Calculadora de Refuerzo de Cuadro");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel baseLabel = new JLabel("Base (m):");
        baseField = new JTextField();
        JLabel alturaLabel = new JLabel("Altura (m):");
        alturaField = new JTextField();
        JButton calcularButton = new JButton("Calcular");
        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double base = Double.parseDouble(baseField.getText());
                    double altura = Double.parseDouble(alturaField.getText());
                    double diagonal = Math.sqrt(base * base + altura * altura);
                    double costoMetro = 2.75;
                    double costoInstalacion = 5.5;
                    double costoTotal = (diagonal * 2) * costoMetro + costoInstalacion;

                    DecimalFormat df = new DecimalFormat("#.00");
                    resultadoArea.setText("Costo Total: " + df.format(costoTotal) + " U$S");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese solo números válidos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(baseLabel);
        panel.add(baseField);
        panel.add(alturaLabel);
        panel.add(alturaField);
        panel.add(calcularButton);
        panel.add(new JLabel("Resultado:"));
        panel.add(resultadoArea);

        add(panel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RCuadrado());
    }
}

