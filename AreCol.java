import javax.swing.*;
import java.awt.*;

public class AreCol extends JFrame {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 200;

    public AreCol() {
        setTitle("Área Coloreada en Verde");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un panel con fondo blanco
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.GREEN);
                g.fillRect(50, 50, 30, 20); // Coordenadas (50, 50), base 30, altura 20
            }
        };
        panel.setBackground(Color.WHITE);
        add(panel);

        // Calcular el área del rectángulo verde
        int base = 30;
        int altura = 20;
        int area = base * altura;

        // Mostrar el área en una ventana emergente
        JOptionPane.showMessageDialog(null, "El área coloreada en verde es: " + area + " cm^2");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AreCol().setVisible(true));
    }
}
