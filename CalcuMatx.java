import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class CalcuMatx {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> crearYMostrarGUI());
    }

    private static void crearYMostrarGUI() {
        JFrame frame = new JFrame("Multiplicador de Matrices");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JTextField fieldMatrixA = new JTextField(20);
        JTextField fieldMatrixB = new JTextField(20);

        frame.add(new JLabel("Matriz A :"));
        frame.add(fieldMatrixA);
        frame.add(new JLabel("Matriz B :"));
        frame.add(fieldMatrixB);

        JButton button = new JButton("Multiplicar Matrices");
        frame.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int[][] matrixA = parseMatrix(fieldMatrixA.getText());
                    int[][] matrixB = parseMatrix(fieldMatrixB.getText());

                    if (matrixA[0].length != matrixB.length) {
                        JOptionPane.showMessageDialog(frame, "No es posible la operación: el número de columnas de A debe ser igual al número de filas de B.", "Error de multiplicación", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    int[][] resultMatrix = multiplyMatrices(matrixA, matrixB);
                    JOptionPane.showMessageDialog(frame, "Resultado de AxB:\n" + matrixToString(resultMatrix));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese las matrices en el formato correcto.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    private static int[][] parseMatrix(String input) {
        String[] rows = input.split(";");
        int[][] matrix = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            matrix[i] = Arrays.stream(rows[i].split(",")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }

    private static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int[][] result = new int[matrixA.length][matrixB[0].length];
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                for (int k = 0; k < matrixA[0].length; k++) {
                    result[row][col] += matrixA[row][k] * matrixB[k][col];
                }
            }
        }
        return result;
    }

    private static String matrixToString(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            sb.append(Arrays.toString(row)).append("\n");
        }
        return sb.toString();
    }
}
