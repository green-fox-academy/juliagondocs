import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Minesweeper  {

    public static final int MAP_WIDTH = 10;
    public static final int MAP_HEIGHT = 10;
    public static final int FIELD_SIZE = 40;
    public static final int CANVAS_HEIGHT = FIELD_SIZE * MAP_HEIGHT;
    public static final int CANVAS_WIDTH = FIELD_SIZE * MAP_WIDTH;
    public static final int BORDER_SIZE = 2;
    public static final int MINE_COUNT = 10;
    public static final int MINE = 9;

    private static Graphics canvas;
    private static Boolean[][] appearedMap;
    private static int[][] map;
    private static Color hiddenFieldColor = Color.lightGray;
    private static Color appearedFieldColor = Color.green;
    private static Color markedFieldColor = new Color(100, 100, 255);
    private static Color explosionColor = Color.red;
    private static Color fontColor = Color.darkGray;
    private static int fontSize = 12;
    private static int finalFontSize = 72;
    private static String mineSymbol = "*";
    private static boolean isGameEnd = false;
    private static int appearedFieldsCount = 0;
    private static int[] lastMoveCoordinate;
    private static String winningText = "YAY :)";
    private static String losingText = "NOOO :(";

    public static void mainDraw() {
        drawMap(appearedMap);
        if (isGameEnd) {
            if (!isWon(appearedMap)) {
                drawField(appearedMap,lastMoveCoordinate[0], lastMoveCoordinate[1], explosionColor);
                drawFieldValue(map, lastMoveCoordinate[0], lastMoveCoordinate[1]);
            }
            drawFinalScreen(isWon(appearedMap));
        }
    }

    private static void drawFinalScreen(boolean isWon) {
        drawWhiteLayer();
        drawFinalText(isWon);
    }

    private static void drawFinalText(boolean isWon) {
        canvas.setColor(fontColor);
        canvas.setFont(new Font("Arial", Font.BOLD, finalFontSize));
        String finalText = isWon ? winningText : losingText;
        canvas.drawString(finalText,
                CANVAS_WIDTH / 2 - finalText.length() * finalFontSize / 4,
                CANVAS_HEIGHT / 2 + finalFontSize / 2
        );
    }

    private static void drawWhiteLayer() {
        canvas.setColor(new Color(255, 255, 255, 127));
        canvas.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
    }

    private static void drawMap(Boolean[][] appearedMap) {
        for (int rowIndex = 0; rowIndex < appearedMap.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < appearedMap[0].length; columnIndex++) {
                Boolean fieldVisibility = appearedMap[rowIndex][columnIndex];
                Color fieldColor = fieldVisibility == null ? hiddenFieldColor :
                        (fieldVisibility ? appearedFieldColor : markedFieldColor);
                drawField(appearedMap, rowIndex, columnIndex, fieldColor);
                if (appearedMap[rowIndex][columnIndex] != null && appearedMap[rowIndex][columnIndex]) {
                    drawFieldValue(map, rowIndex, columnIndex);
                }
            }
        }
    }

    private static void drawFieldValue(int[][] map, int rowIndex, int columnIndex) {
        canvas.setColor(fontColor);
        canvas.setFont(new Font("Arial", Font.BOLD, fontSize));
        canvas.drawString(
                map[rowIndex][columnIndex] == MINE ? mineSymbol : Integer.toString(map[rowIndex][columnIndex]),
                columnIndex * FIELD_SIZE + FIELD_SIZE / 2,
                rowIndex * FIELD_SIZE + FIELD_SIZE / 2 + fontSize / 2);
    }

    private static void drawField(Boolean[][] appearedMap, int rowIndex, int columnIndex, Color fieldColor) {
        canvas.setColor(fieldColor);
        canvas.fillRoundRect(
                columnIndex * FIELD_SIZE + BORDER_SIZE,
                rowIndex * FIELD_SIZE + BORDER_SIZE,
                FIELD_SIZE - BORDER_SIZE * 2,
                FIELD_SIZE - BORDER_SIZE * 2,
                5,
                5
        );
    }

    public static void userAction(MouseEvent e) {
        if (isGameEnd) {
            return;
        }
        int x = e.getX() / FIELD_SIZE;
        int y = e.getY() / FIELD_SIZE;
        if (e.getButton() == MouseEvent.BUTTON1) {
            leftClickAction(x, y);
        } else {
            rightClickAction(x, y);
        }
    }

    private static void rightClickAction(int x, int y) {
        if (appearedMap[y][x] == null) {
            appearedMap[y][x] = false;
        } else if (!appearedMap[y][x]) {
            appearedMap[y][x] = null;
        }
    }

    private static void leftClickAction(int x, int y) {
        if (appearedMap[y][x] == null) {
            lastMoveCoordinate = new int[]{y, x};
            appearedMap = appearField(y, x, appearedMap, map);
            isGameEnd = checkGameEnd(map, y, x);
        }
    }

    private static boolean checkGameEnd(int[][] map, int rowIndex, int columnIndex) {
        return isDead(map, rowIndex, columnIndex) || isWon(appearedMap);
    }

    private static boolean isWon(Boolean[][] appearedMap) {
        return appearedFieldsCount == MAP_WIDTH * MAP_HEIGHT - MINE_COUNT;
    }

    private static boolean isDead(int[][] map, int rowIndex, int columnIndex) {
        return map[rowIndex][columnIndex] == MINE;
    }

    private static Boolean[][] appearField(int rowIndex, int columnIndex, Boolean[][] appearedMap, int[][] map) {
        appearedMap[rowIndex][columnIndex] = true;
        appearedFieldsCount++;
        if (map[rowIndex][columnIndex] == 0) {
            List<int[]> neighbourCoordinates = getNeighbourCoordinates(map, rowIndex, columnIndex);
            for (int[] coordinate : neighbourCoordinates) {
                if (appearedMap[coordinate[0]][coordinate[1]] == null) {
                    appearedMap = appearField(coordinate[0], coordinate[1], appearedMap, map);
                }
            }
        }
        return appearedMap;
    }

    public static void main(String[] args) {
        appearedMap = createAppearedMap();
        map = createMap(MAP_WIDTH, MAP_HEIGHT);
        map = setMines(map, MINE_COUNT);
        map = calculateFieldValues(map);
        setupGamePanel();
    }

    private static int[][] calculateFieldValues(int[][] map) {
        for (int rowIndex = 0; rowIndex < map.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < map[0].length; columnIndex++) {
                if (map[rowIndex][columnIndex] == MINE) {
                    continue;
                }
                java.util.List<int[]> neighbourCoordinates = getNeighbourCoordinates(map, rowIndex, columnIndex);
                int nearbyMinesCount = countNearbyMines(neighbourCoordinates, map);
                map[rowIndex][columnIndex] = nearbyMinesCount;
            }
        }
        return map;
    }

    private static int countNearbyMines(List<int[]> neighbourCoordinates, int[][] map) {
        int nearbyMinesCount = 0;
        for (int[] coordinate : neighbourCoordinates) {
            nearbyMinesCount += map[coordinate[0]][coordinate[1]] == MINE ? 1 : 0;
        }
        return nearbyMinesCount;
    }

    private static List<int[]> getNeighbourCoordinates(int[][] map, int rowIndex, int columnIndex) {
        List<int[]> neighbourCoordinates = new ArrayList<>();
        for (int rowModifier = -1; rowModifier <= 1; rowModifier++) {
            for (int columnModifier = -1; columnModifier <= 1; columnModifier++) {
                if (rowModifier == 0 && columnModifier == 0) {
                    continue;
                }
                int modifiedRowIndex = rowIndex + rowModifier;
                int modifiedColumnIndex = columnIndex + columnModifier;
                if (modifiedRowIndex >= 0 && modifiedRowIndex < MAP_HEIGHT
                        && modifiedColumnIndex >= 0 && modifiedColumnIndex < MAP_WIDTH) {
                    neighbourCoordinates.add(new int[] { modifiedRowIndex, modifiedColumnIndex });
                }
            }
        }
        return neighbourCoordinates;
    }

    private static int[][] setMines(int[][] map, int mineCount) {
        int minesSet = 0;
        while (minesSet < mineCount) {
            int randomRowIndex = (int) (Math.random() * MAP_HEIGHT);
            int randomColumnIndex = (int) (Math.random() * MAP_WIDTH);
            if (map[randomRowIndex][randomColumnIndex] != MINE) {
                map[randomRowIndex][randomColumnIndex] = MINE;
                minesSet++;
            }
        }
        return map;
    }

    private static int[][] createMap(int mapWidth, int mapHeight) {
        return new int[mapHeight][mapWidth];
    }

    private static Boolean[][] createAppearedMap() {
        return new Boolean[MAP_HEIGHT][MAP_WIDTH];
    }

    private static void setupGamePanel() {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT + 23));
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.add(new ImagePanel());
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    static class ImagePanel extends JPanel {

        public ImagePanel() {
            addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent me) {
                    userAction(me);
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            canvas = graphics;
            mainDraw();
        }
    }
}