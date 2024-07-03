import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuLib extends JFrame {
    private JTextField paginasField;
    private JTextArea resultadoArea;

    public SuLib() {
        setTitle("Calculadora de Superficie de Libro");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel paginasLabel = new JLabel("Número de páginas:");
        paginasField = new JTextField();
        JButton calcularButton = new JButton("Calcular");
        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int paginas = Integer.parseInt(paginasField.getText());
                    int areaHoja = 609;
                    int superficieTotal = areaHoja * paginas;

                    resultadoArea.setText("Superficie total: " + superficieTotal + " cm^2");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese solo números válidos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(paginasLabel);
        panel.add(paginasField);
        panel.add(calcularButton);
        panel.add(new JLabel("Resultado:"));
        panel.add(resultadoArea);

        add(panel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SuLib());
    }
}
