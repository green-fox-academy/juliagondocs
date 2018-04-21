import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ConnectingTheDots {
    public static void mainDraw(Graphics graphics) {
        // Create a function that takes 1 parameter:
        // An array of {x, y} points
        // and connects them with green lines.
        // Connect these to get a box: {{10, 10}, {290,  10}, {290, 290}, {10, 290}}
        // Connect these: {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70},
        // {120, 100}, {85, 130}, {50, 100}}
        int xpoints[][] = new int[][]{{10, 10}, {290, 10}, {290, 290}, {10, 290}};
        int ypoints[][] = {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70}, {120, 100}, {85, 130}, {50, 100}};
        connectPoints(graphics, xpoints);
        connectPoints(graphics, ypoints);
    }

    public static void connectPoints(Graphics graphics, int[][] inputPoints) {
        graphics.setColor(Color.GREEN);
        int[] xPoints = new int[inputPoints.length];
        int[] yPoints = new int[inputPoints.length];
        for (int i = 0; i < inputPoints.length; i++) {
            xPoints[i] = inputPoints[i][0];
            yPoints[i] = inputPoints[i][1];
        }
        graphics.drawPolygon(xPoints, yPoints, inputPoints.length);
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


// create a 300x300 canvas.