import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Board extends JComponent implements KeyListener {

    int testBoxX;
    int testBoxY;
    private static final int MAP_WIDTH = 10;
    private static final int MAP_HEIGHT = 10;
    private static final int CANVAS_WIDTH = 720;
    private static final int CANVAS_HEIGHT = 720;
    private static final int SIZE_OF_TILE = 72;
    public static int[][] map;
    private static String heroDirection = "hero-down";
    List<int[]> validPositionsInThePast = new ArrayList<>();
    static Table field = new Table();

    public Board() {
        testBoxX = 0;
        testBoxY = 0;
        heroDirection = "hero-down";

        // set the size of your draw board
        setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        field.drawTilePlan(graphics);
        field.drawCharacterPlan(graphics);
        repaint();

        //super.paint(graphics);
        //drawTable(graphics);
        //drawHero(graphics);

    }

    private void drawHero(Graphics graphics) {
        PositionedImage image = new PositionedImage("img/" + heroDirection + ".png", testBoxX, testBoxY);

        System.out.println("jelenlegi helyzetem:" + (int) testBoxX / SIZE_OF_TILE + " " + (int) testBoxY / SIZE_OF_TILE);
        System.out.println("terkep: " + map[testBoxY / SIZE_OF_TILE][testBoxX / SIZE_OF_TILE]);
        image.draw(graphics);
    }

    private void drawTable(Graphics graphics) {
        for (int i = 0; i < MAP_HEIGHT; i++) {
            for (int j = 0; j < MAP_WIDTH; j++) {
                if (map[i][j] == 1) {
                    PositionedImage image = new PositionedImage("img/floor.png", j * SIZE_OF_TILE, i * SIZE_OF_TILE);
                    image.draw(graphics);
                } else {
                    PositionedImage image = new PositionedImage("img/wall.png", j * SIZE_OF_TILE, i * SIZE_OF_TILE);
                    image.draw(graphics);
                }
            }
        }
    }


    public static void main(String[] args) {
        //Table table = new Table();
        //map = table.createMap(MAP_HEIGHT, MAP_WIDTH);
        setupGamePanel();
        System.out.println(field.getSkeletonNumberWithKey());
    }


    // To be a KeyListener the class needs to have these 3 methods in it
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }


    @Override
    public void keyReleased(KeyEvent e) {
        // When the up or down keys hit, we change the position of our box
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            field.moveCharacterUp(field.findCharacter("Hero").get(0));
            System.out.print("Lépés utani kiiratas: ");
            field.findCharacter("Hero");
            field.randomMovementGenerator(field.findCharacter("Boss"));
            field.randomMovementGenerator(field.findCharacter("Skeleton"));

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            field.moveCharacterDown(field.findCharacter("Hero").get(0));
            System.out.print("Lépés utani kiiratas: ");
            field.findCharacter("Hero");
            field.randomMovementGenerator(field.findCharacter("Boss"));
            field.randomMovementGenerator(field.findCharacter("Skeleton"));

        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            field.moveCharacterLeft(field.findCharacter("Hero").get(0));
            System.out.print("Lépés utani kiiratas: ");
            field.findCharacter("Hero");
            field.randomMovementGenerator(field.findCharacter("Boss"));
            field.randomMovementGenerator(field.findCharacter("Skeleton"));

        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            field.moveCharacterRight(field.findCharacter("Hero").get(0));
            System.out.print("Lépés utani kiiratas: ");
            field.findCharacter("Hero");
            field.randomMovementGenerator(field.findCharacter("Boss"));
            field.randomMovementGenerator(field.findCharacter("Skeleton"));

        }
        repaint();
    }

    public static void setupGamePanel() {
        JFrame frame = new JFrame("RPG Game");
        Board board = new Board();
        frame.add(board);
        frame.setSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT + 23));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
        frame.addKeyListener(board);
    }


}