import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FillTheRectangles {

    public static void mainDraw(Graphics graphics) {
        // draw four different size and color rectangles.
        // avoid code duplication.
        for (int i = 0; i < 5; i++) {
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
        graphics.drawRect(inputX, inputY, sizeRandom, sizeRandom);
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