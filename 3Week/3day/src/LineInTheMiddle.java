import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LineInTheMiddle {
    public static void mainDraw(Graphics graphics){
        // draw a red horizontal line to the canvas' middle.
        // draw a green vertical line to the canvas' middle.

        // EXAMPLE 1:
        //graphics.drawLine(0, 0, 200, 50);
        //graphics.drawRect(50, 50, 100, 90);
        //graphics.fillRect(60, 60, 100, 90);
        //graphics.fillOval(120, 10, 180, 90);

        // EXAMPLE 2:
        //graphics.fillRect(200,200,200,200);
        //graphics.setColor(new Color(200,200,0,150));
        //graphics.fillRect(210,210,200,200);

        //EXAMPLE 3
        //int xpoints[] = {25, 145, 25, 145, 25};
        //int ypoints[] = {25, 25, 145, 145, 25};
        //int npoints = 5;
        //graphics.drawPolygon(xpoints, ypoints, npoints);

        // TASK:
        graphics.setColor(new Color(255,0,0));
        graphics.drawLine(0, 343/2, 320, 343/2);

        graphics.setColor(new Color(0,255,0));
        graphics.drawLine(320/2, 0, 320/2, 343);
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