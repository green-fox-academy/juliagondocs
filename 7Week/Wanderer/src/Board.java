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
        drawTable(graphics);
        drawHero(graphics);

    }

    private void drawHero(Graphics graphics) {
        validPositionsInThePast.add(new int[]{testBoxY / SIZE_OF_TILE, testBoxX / SIZE_OF_TILE});
        for (int[] current : validPositionsInThePast) {
            System.out.println(current[0] + " " + current[1]);
        }

        PositionedImage image;

        if (map[testBoxY / SIZE_OF_TILE][testBoxX / SIZE_OF_TILE] == 0) { // nyil utani ertekem
            int pasPostX = validPositionsInThePast.get(validPositionsInThePast.size() - 1)[1] * SIZE_OF_TILE;
            int pasPostY = validPositionsInThePast.get(validPositionsInThePast.size() - 1)[0] * SIZE_OF_TILE;
            image = new PositionedImage("img/" + heroDirection + ".png", pasPostX, pasPostY);
            //refresh the testbox values, based on the differences between x and pasX or y and pasY
            if (testBoxY > pasPostY) {
                testBoxY -= 72;
            }
            if (testBoxY < pasPostY) {
                testBoxY += 72;
            }
            if (testBoxX > pasPostX) {
                testBoxX -= 72;
            }
            if (testBoxX < pasPostX) {
                testBoxX += 72;
            }

            validPositionsInThePast.remove(validPositionsInThePast.size()-1); // az utolso nem valid indexet, azt tavolitsuk el
        } else {
            image = new PositionedImage("img/" + heroDirection + ".png", testBoxX, testBoxY);
        }

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

    public GameObject[][] indexBoard() {
        GameObject[][] coordList = new GameObject[MAP_WIDTH][MAP_HEIGHT];
        for (int i = 0; i < MAP_WIDTH; i++) {
            for (int j = 0; j < MAP_HEIGHT; j++) {
                if (map[j][i] == 0) {
                    Wall wall = new Wall();
                    coordList[j][i] = wall;
                } else if (map[j][i] == 1){
                    Floor floor = new Floor();
                    coordList [j][i] = floor;
                }
            }
        }
        return coordList;
    }

    public static void main(String[] args) {
        map = createMap(MAP_HEIGHT, MAP_WIDTH);
        setupGamePanel();
    }


    // To be a KeyListener the class needs to have these 3 methods in it
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    // But actually we can use just this one for our goals here
    @Override
    public void keyReleased(KeyEvent e) {
        // When the up or down keys hit, we change the position of our box
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            testBoxY -= SIZE_OF_TILE;
            heroDirection = "hero-up";
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            testBoxY += SIZE_OF_TILE;
            heroDirection = "hero-down";
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            testBoxX -= SIZE_OF_TILE;
            heroDirection = "hero-left";
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            testBoxX += SIZE_OF_TILE;
            heroDirection = "hero-right";
        }
        // and redraw to have a new picture with the new coordinates
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

    private static int[][] createMap(int mapWidth, int mapHeight) {
        int[][] map = new int[mapHeight][mapWidth];
        Path path = Paths.get("level0.txt");
        List<String> lines = null;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("No such file or directory");
        }

        for (int i = 0; i < mapHeight; i++) {
            String array[] = lines.get(i).split(" ");
            for (int j = 0; j < mapWidth; j++) {
                map[i][j] = Integer.valueOf(array[j]);
            }
        }
        return map;
    }
}