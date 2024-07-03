import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MultiMatri {

    private static int[][] multiplyMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        int r1 = firstMatrix.length, c1 = firstMatrix[0].length;
        int r2 = secondMatrix.length, c2 = secondMatrix[0].length;

        if (c1 != r2) {
            throw new IllegalArgumentException("Las matrices no se pueden multiplicar");
        }

        int[][] result = new int[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    result[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Multiplicación de Matrices");
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
                        int[][] resultMatrix = multiplyMatrices(matrixA, matrixB);

                        JOptionPane.showMessageDialog(frame, "Resultado:\n" + matrixToString(resultMatrix));
                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Por favor, ingrese las matrices en el formato correcto.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            frame.pack();
            frame.setVisible(true);
        });
    }

    private static int[][] parseMatrix(String text) {
        String[] rows = text.split(";");
        int[][] matrix = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            matrix[i] = Arrays.stream(rows[i].split(",")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }

    private static String matrixToString(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            for (int value : row) {
                sb.append(value).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

