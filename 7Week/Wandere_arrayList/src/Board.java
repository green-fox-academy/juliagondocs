import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLOutput;


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
    Table field = new Table();
    private static int finalFontSize = 42;
    private static int fontSize = 12;
    private static String winningText = "YAY :)";
    private static String losingText = "NOOO :(";
    private static Graphics canvas;

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
        System.out.println("kulcsos skeleton: " + field.skeletonsWithKey());
        field.drawTilePlan(graphics);
        field.drawCharacterPlan(graphics);
        setFont(new Font("Arial", Font.BOLD, fontSize));
        field.drawInfoHero(graphics);
        if (field.isWarWithBoss) {
            field.drawInfoTableBoss(graphics);
        }
        if (field.gameOver == true) {
           drawGameOver(graphics);
        }

        if(field.isLevelUp){
            Table field = new Table();
            System.out.println("You Win!! Level up");
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
                if (field.defenser.getCurrentHP() <= 0) {
                    System.out.println(field.defenser.getClass());
                    // dismiss defenser from the boar
                    if (field.defenser instanceof Skeleton) {
                        field.disMissDeadCharacter(field.findCharacter("Skeleton").get(0));
                    }
                    if (field.defenser instanceof Boss) {
                        field.disMissDeadCharacter(field.findCharacter("Boss").get(0));
                    }
                    Hero.heroLevel++;

                }
                if (field.attacker.getCurrentHP() <= 0) {
                    // dismiss hero from the board
                    System.out.println("Hero halott");
                    field.disMissDeadCharacter(field.findCharacter("Hero").get(0));
                    field.gameOver = true;
                }
            }
            field.checkForWin();
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

    public void drawGameOver(Graphics graphics) {
        graphics.setColor(new Color(255, 255, 255, 127));
       graphics.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);

        graphics.setColor(Color.darkGray);
        graphics.setFont(new Font("Arial", Font.BOLD, finalFontSize));

        String finalText =  losingText;
        graphics.drawString(finalText,
                CANVAS_WIDTH / 2 - finalText.length() * finalFontSize / 4,
                CANVAS_HEIGHT / 2 + finalFontSize / 2
        );
    }

}