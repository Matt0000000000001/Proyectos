import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CostCesp extends JFrame {
    private JTextField longitudField;
    private JTextField anchoField;
    private JTextArea resultadoArea;

    public CostCesp() {
        setTitle("Calculadora de Costo de Césped");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel longitudLabel = new JLabel("Longitud (m):");
        longitudField = new JTextField();
        JLabel anchoLabel = new JLabel("Ancho (m):");
        anchoField = new JTextField();
        JButton calcularButton = new JButton("Calcular");
        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double longitud = Double.parseDouble(longitudField.getText());
                    double ancho = Double.parseDouble(anchoField.getText());
                    double area = longitud * ancho;
                    double costoTotal = area * 25;

                    DecimalFormat df = new DecimalFormat("#.00");
                    resultadoArea.setText("Costo Total: " + df.format(costoTotal) + " U$S");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese solo números válidos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(longitudLabel);
        panel.add(longitudField);
        panel.add(anchoLabel);
        panel.add(anchoField);
        panel.add(calcularButton);
        panel.add(new JLabel("Resultado:"));
        panel.add(resultadoArea);

        add(panel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CostCesp());
    }
}
