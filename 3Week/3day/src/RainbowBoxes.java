import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RainbowBoxes {
    public static void mainDraw(Graphics graphics) {
        // Create a square drawing function that takes 2 parameters:
        // The square size, and the fill color,
        // and draws a square of that size and color to the center of the canvas.
        // Create a loop that fills the canvas with rainbow colored squares.
        int[] colorRandom = new int[3];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 3; j++) {
                colorRandom[j] = (int) (Math.random() * 255);
            }
            int size = (int) (Math.random() * 200);
            drawing(graphics, size, colorRandom);
        }

    }

    public static void drawing(Graphics graphics, int size, int[] color) {
        graphics.setColor(new Color(color[0], color[1], color[2]));
        graphics.fillRect((320 / 2) - (size / 2), (343 / 2) - (size / 2), size, size);
    }

    // Don't touch the code below
    static int WIDTH = 320;
    static int HEIGHT = 343;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setSize(new Dimension(WIDTH, HEIGHT));
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.add(new ImagePanel());
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            mainDraw(graphics);
        }
    }
}