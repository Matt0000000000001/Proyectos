import javax.swing.*;
import java.awt.*;

public class CostoCesped extends JFrame {
    private JTextArea resultadoArea;

    public CostoCesped() {
        setTitle("Calculadora de Costo de Césped");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 10, 10));

        // Calcular el costo total
        int area = 625;
        double costoMetro = 25;
        double costoTotal = area * costoMetro;

        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        resultadoArea.setText("Costo Total: " + costoTotal + " U$S");

        panel.add(new JLabel("Resultado:"));
        panel.add(resultadoArea);

        add(panel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CostoCesped());
    }
}

