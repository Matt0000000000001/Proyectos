import javax.swing.*;
import java.awt.*;

public class AreaCalculator extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    public AreaCalculator() {
        setTitle("Área del Rectángulo Verde");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);

        Graphics g = panel.getGraphics();
        g.setColor(Color.GREEN);
        g.fillRect(50, 50, 100, 60); 

        int base = 100;
        int altura = 60;
        int area = base * altura;

        JOptionPane.showMessageDialog(null, "El área del rectángulo verde es: " + area + " unidades cuadradas");

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AreaCalculator().setVisible(true));
    }
}