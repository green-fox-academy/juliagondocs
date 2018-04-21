import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SquarePositioning {

    public static void mainDraw(Graphics graphics) {
        // create a square drawing function that takes 2 parameters:
        // the x and y coordinates of the square's top left corner
        // and draws a 50x50 square from that point.
        // draw 3 squares with that function.
        // avoid code duplication.
        for (int i = 0; i < 4; i++) {
            int koordX = (int) (Math.random() * 320);
            int koordY = (int) (Math.random() * 343);
            drawing(graphics, koordX, koordY);
        }
    }

    public static void drawing(Graphics graphics, int inputX, int inputY) {
        int colorRandom = (int) (Math.random() * 254);
        int sizeRandom = (int) (Math.random() * 100);
        System.out.println(colorRandom + " " + sizeRandom);
        graphics.setColor(new Color(colorRandom, 255 - colorRandom, colorRandom));
        graphics.drawRect(inputX, inputY, 50, 50);
    }

    //    Don't touch the code below
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