import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


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
    static Table field = new Table();
    private static int finalFontSize = 12;

    public Board() {
        testBoxX = 0;
        testBoxY = 0;

        // set the size of your draw board
        setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        field.drawTilePlan(graphics);
        setFont(new Font("Arial", Font.BOLD, finalFontSize));
        field.drawCharacterPlan(graphics);
        field.drawInfoHero(graphics);
        if (field.isWarWithBoss) {
            field.drawInfoTableBoss(graphics);
        }
        repaint();
    }


    public static void main(String[] args) {
        setupGamePanel();
    }


    // To be a KeyListener the class needs to have these 3 methods in it
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("space");
            if (field.isWarBetweenHeroAndOther) {
                field.attacker.strike(field.defenser);
                if(field.defenser.isAlive() == false ) {
                    // dismiss defenser from the boar

                    // aztan ellenorizze le h mindenki meghalt akinek kell és szintet kell lépnij
                }
                if(field.attacker.isAlive() == false ) {
                    // dismiss hero from the board
                    field.findCharacter("Hero");

                }
            }
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        // When the up or down keys hit, we change the position of our box
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            field.moveCharacterUp(field.findCharacter("Hero").get(0));
            field.findCharacter("Hero");
            field.randomMovementGenerator(field.findCharacter("Boss"));
            field.randomMovementGenerator(field.findCharacter("Skeleton"));

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            field.moveCharacterDown(field.findCharacter("Hero").get(0));
            field.findCharacter("Hero");
            field.randomMovementGenerator(field.findCharacter("Boss"));
            field.randomMovementGenerator(field.findCharacter("Skeleton"));

        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            field.moveCharacterLeft(field.findCharacter("Hero").get(0));
            field.findCharacter("Hero");
            field.randomMovementGenerator(field.findCharacter("Boss"));
            field.randomMovementGenerator(field.findCharacter("Skeleton"));

        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            field.moveCharacterRight(field.findCharacter("Hero").get(0));
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