import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Table {

    int size;
    boolean isWar = false;
    boolean isWarBetweenHeroAndOther;
    boolean isWarWithBoss = false;
    private GameObject[][] tileLocationMatrix = readPlan("level" + Hero.heroLevel + ".txt");
    private GameObject[][] characterAndTileLocationMatrix = readPlan("level" + Hero.heroLevel + "_char.txt");
    Character attacker;
    Character defenser;


    public Table() {
        this.size = 72;
    }

    public GameObject[][] readPlan(String fileAccessPath) {
        List<int[]> skeletons = new ArrayList<>();
        List<String> content = new ArrayList<>();
        Path filePath = Paths.get(fileAccessPath);
        try {
            content = Files.readAllLines(filePath);
        } catch (IOException e) {
            System.out.println("Reading error");
        }
        GameObject[][] coordList = new GameObject[content.size()][content.get(0).length()];
        for (int i = 0; i < content.size(); i++) {
            for (int j = 0; j < content.get(i).length(); j++) {
                if (content.get(i).charAt(j) == 'h') {
                    Hero hero = new Hero();
                    System.out.println(hero.getCurrentHP());
                    coordList[i][j] = hero;
                } else if (content.get(i).charAt(j) == 'b') {
                    Boss boss = new Boss();
                    System.out.println(boss.getCurrentHP());
                    coordList[i][j] = boss;
                } else if (content.get(i).charAt(j) == 's') {
                    Skeleton skeleton = new Skeleton();
                    coordList[i][j] = skeleton;
                    int[] characterCoordinates = new int[2];
                    characterCoordinates[0] = i;
                    characterCoordinates[1] = j;
                    skeletons.add(characterCoordinates);
                    System.out.println("Ennyi skeletonom van: " + skeletons.size());
                } else if (content.get(i).charAt(j) == '0') {
                    Wall wall = new Wall();
                    coordList[i][j] = wall;
                } else if (content.get(i).charAt(j) == '1') {
                    Floor floor = new Floor();
                    coordList[i][j] = floor;
                }
            }
        }
        if (!skeletons.isEmpty()) {
            int chance = (int) Math.random() * skeletons.size();
            ((Skeleton) coordList[skeletons.get(chance)[0]][skeletons.get(chance)[1]]).setHasKey();
        }
        return coordList;
    }

    public int numberOfAliveCharacters() {
        // Hany elo babum van eletben
        int countAliveCharacters = 0;
        for (int i = 0; i < characterAndTileLocationMatrix.length; i++) {
            for (int j = 0; j < characterAndTileLocationMatrix[i].length; j++) {
                if (characterAndTileLocationMatrix[i][j] instanceof Character) {
                    if (((Character) characterAndTileLocationMatrix[i][j]).isAlive()) {
                        countAliveCharacters += 1;
                    }
                }
            }
        }
        return countAliveCharacters;
    }

    public void drawTilePlan(Graphics g) {
        for (int i = 0; i < tileLocationMatrix.length; i++) {
            for (int j = 0; j < tileLocationMatrix[i].length; j++) {
                if (tileLocationMatrix[i][j] instanceof Wall || tileLocationMatrix[i][j] instanceof Floor) {
                    PositionedImage tile = new PositionedImage(tileLocationMatrix[i][j].filePath, j * size, i * size);
                    tile.draw(g);
                }
            }
        }
    }

    public void drawInfoTableBoss(Graphics g) {
        int xx = findCharacter("Boss").get(0)[0];
        int yy = findCharacter("Boss").get(0)[1];
        String info = (characterAndTileLocationMatrix[xx][yy] instanceof Boss ? "Boss HP: " + characterAndTileLocationMatrix[xx][yy].toString() : "semmi");
        Color textColor = Color.WHITE;
        Color bgColor = Color.BLACK;
        int x = 100;
        int y = 40;

        FontMetrics fm = g.getFontMetrics();
        Rectangle2D rect = fm.getStringBounds(info, g);

        g.setColor(bgColor);
        g.fillRect(x, y - fm.getAscent(), (int) rect.getWidth(), (int) rect.getHeight());

        g.setColor(textColor);
        g.drawString(info, x, y);
    }

    public void drawInfoHero(Graphics g) {
        int xx = findCharacter("Hero").get(0)[0];
        int yy = findCharacter("Hero").get(0)[1];
        String info = (characterAndTileLocationMatrix[xx][yy] instanceof Hero ? "Hero HP: " + characterAndTileLocationMatrix[xx][yy].toString() : "semmi");
        Color textColor = Color.WHITE;
        Color bgColor = Color.BLACK;
        int x = 100;
        int y = 20;

        FontMetrics fm = g.getFontMetrics();
        Rectangle2D rect = fm.getStringBounds(info, g);

        g.setColor(bgColor);
        g.fillRect(x, y - fm.getAscent(), (int) rect.getWidth(), (int) rect.getHeight());

        g.setColor(textColor);
        g.drawString(info, x, y);
    }

    public void drawCharacterPlan(Graphics g) {
        for (int i = 0; i < characterAndTileLocationMatrix.length; i++) {
            for (int j = 0; j < characterAndTileLocationMatrix[i].length; j++) {
                if (characterAndTileLocationMatrix[i][j] instanceof Hero || characterAndTileLocationMatrix[i][j] instanceof Skeleton || characterAndTileLocationMatrix[i][j] instanceof Boss) {
                    PositionedImage tile = new PositionedImage(characterAndTileLocationMatrix[i][j].filePath, j * size, i * size);
                    tile.draw(g);
                }
            }
        }
    }

    public List<int[]> findCharacter(String className) {
        List<int[]> coordinates = new ArrayList<>();
        for (int i = 0; i < characterAndTileLocationMatrix.length; i++) {
            for (int j = 0; j < characterAndTileLocationMatrix[i].length; j++) {
                if (className.equals("Hero") && (characterAndTileLocationMatrix[i][j] instanceof Hero)) {
                    int[] characterCoordinates = new int[2];
                    characterCoordinates[0] = i;
                    characterCoordinates[1] = j;
                    coordinates.add(characterCoordinates);
                } else if (className.equals("Boss") && (characterAndTileLocationMatrix[i][j] instanceof Boss)) {
                    int[] characterCoordinates = new int[2];
                    characterCoordinates[0] = i;
                    characterCoordinates[1] = j;
                    coordinates.add(characterCoordinates);
                } else if (className.equals("Skeleton") && (characterAndTileLocationMatrix[i][j] instanceof Skeleton)) {
                    int[] characterCoordinates = new int[2];
                    characterCoordinates[0] = i;
                    characterCoordinates[1] = j;
                    coordinates.add(characterCoordinates);
                }
            }
        }
        //if (!coordinates.isEmpty()) {
        //    System.out.println(coordinates.get(0)[0] + " " + coordinates.get(0)[1]);
        //}
        return coordinates;
    }

    public void randomMovementGenerator(List<int[]> startCoordinates) {
        if (Hero.heroStep % 2 == 0) {
            for (int i = 0; i < startCoordinates.size(); i++) {
                int direction = (int) (Math.random() * 100);
                if (direction < 25) {
                    moveCharacterRight(startCoordinates.get(i));
                } else if (direction >= 25 && direction < 50) {
                    moveCharacterLeft(startCoordinates.get(i));
                } else if (direction >= 50 && direction < 75) {
                    moveCharacterDown(startCoordinates.get(i));
                } else {
                    moveCharacterUp(startCoordinates.get(i));
                }
            }
        }
    }

    public void moveAgain(int[] startCoordinates) {
        List<int[]> coordinates = new ArrayList<>();
        coordinates.add(startCoordinates);
        randomMovementGenerator(coordinates);
    }

    public void moveCharacterRight(int[] startCoordinates) {
        setToFalseWars();
        if (startCoordinates[1] != characterAndTileLocationMatrix[0].length - 1) {
            if (!(characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1] + 1] instanceof Wall)) {
                if (!(characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1] + 1] instanceof Character)) {
                    GameObject temp = characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1]];
                    characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1]] =
                            tileLocationMatrix[startCoordinates[0]][startCoordinates[1]];
                    characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1] + 1] = temp;
                    if (characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1] + 1] instanceof Hero) {
                        Hero.heroStep++;
                        characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1] + 1].moveRight();
                    }
                } else if ((characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1]] instanceof Hero)) {
                    isWar = true;

                    if (characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1] + 1] instanceof Boss) {
                        isWarWithBoss = true;
                    }
                    if (characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1] + 1] instanceof Boss ||
                            characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1] + 1] instanceof Skeleton) {
                        attacker = (Character) characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1]]; // hero
                        defenser = (Character) characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1] + 1]; //attacker
                        isWarBetweenHeroAndOther = true;
                    }
                }
            } else if (!(characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1]] instanceof Hero)) {
                moveAgain(startCoordinates);
            }
        }
    }

    public void moveCharacterLeft(int[] startCoordinates) {
        setToFalseWars();
        if (startCoordinates[1] != 0) {
            if (!(characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1] - 1] instanceof Wall)) {
                if (!(characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1] - 1] instanceof Character)) {
                    GameObject temp = characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1]];
                    characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1]] =
                            tileLocationMatrix[startCoordinates[0]][startCoordinates[1]];
                    characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1] - 1] = temp;
                    if (characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1] - 1] instanceof Hero) {
                        Hero.heroStep++;
                        characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1] - 1].moveLeft();
                    }
                } else if ((characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1]] instanceof Hero)) {
                    isWar = true;
                    if (characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1] - 1] instanceof Boss) {
                        isWarWithBoss = true;
                    }
                    if (characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1] - 1] instanceof Boss ||
                            characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1] - 1] instanceof Skeleton) {
                        attacker = (Character) characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1]];
                        defenser = (Character) characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1] - 1];
                        isWarBetweenHeroAndOther = true;
                    }
                }
            } else if (!(characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1]] instanceof Hero)) {
                moveAgain(startCoordinates);
            }
        }
    }

    public void moveCharacterDown(int[] startCoordinates) {
        setToFalseWars();
        if (startCoordinates[0] != characterAndTileLocationMatrix.length - 1) {
            if (!(characterAndTileLocationMatrix[startCoordinates[0] + 1][startCoordinates[1]] instanceof Wall)) {
                if (!(characterAndTileLocationMatrix[startCoordinates[0] + 1][startCoordinates[1]] instanceof Character)) {
                    GameObject temp = characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1]];
                    characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1]] =
                            tileLocationMatrix[startCoordinates[0]][startCoordinates[1]];
                    characterAndTileLocationMatrix[startCoordinates[0] + 1][startCoordinates[1]] = temp;
                    if (characterAndTileLocationMatrix[startCoordinates[0] + 1][startCoordinates[1]] instanceof Hero) {
                        Hero.heroStep++;
                        characterAndTileLocationMatrix[startCoordinates[0] + 1][startCoordinates[1]].moveDown();
                    }
                } else if ((characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1]] instanceof Hero)) {
                    isWar = true;
                    if (characterAndTileLocationMatrix[startCoordinates[0] + 1][startCoordinates[1]] instanceof Boss) {
                        isWarWithBoss = true;
                    }
                    if (characterAndTileLocationMatrix[startCoordinates[0] + 1][startCoordinates[1]] instanceof Boss ||
                            characterAndTileLocationMatrix[startCoordinates[0] + 1][startCoordinates[1]] instanceof Skeleton) {
                        attacker = (Character) characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1]];
                        defenser = (Character) characterAndTileLocationMatrix[startCoordinates[0] + 1][startCoordinates[1]];
                        isWarBetweenHeroAndOther = true;
                    }
                }
            } else if (!(characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1]] instanceof Hero)) {
                moveAgain(startCoordinates);
            }
        }
    }

    public void moveCharacterUp(int[] startCoordinates) {
        setToFalseWars();
        if (startCoordinates[0] != 0) {
            if (!(characterAndTileLocationMatrix[startCoordinates[0] - 1][startCoordinates[1]] instanceof Wall)) {
                if (!(characterAndTileLocationMatrix[startCoordinates[0] - 1][startCoordinates[1]] instanceof Character)) {
                    GameObject temp = characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1]];
                    characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1]] =
                            tileLocationMatrix[startCoordinates[0]][startCoordinates[1]];
                    characterAndTileLocationMatrix[startCoordinates[0] - 1][startCoordinates[1]] = temp;
                    if (characterAndTileLocationMatrix[startCoordinates[0] - 1][startCoordinates[1]] instanceof Hero) {
                        Hero.heroStep++;
                        characterAndTileLocationMatrix[startCoordinates[0] - 1][startCoordinates[1]].moveUp();
                    }
                } else if ((characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1]] instanceof Hero)) {
                    isWar = true;
                    if (characterAndTileLocationMatrix[startCoordinates[0] - 1][startCoordinates[1]] instanceof Boss) {
                        isWarWithBoss = true;
                    }
                    if (characterAndTileLocationMatrix[startCoordinates[0] - 1][startCoordinates[1]] instanceof Boss ||
                            characterAndTileLocationMatrix[startCoordinates[0] - 1][startCoordinates[1]] instanceof Skeleton) {
                        attacker = (Character) characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1]];
                        defenser = (Character) characterAndTileLocationMatrix[startCoordinates[0] - 1][startCoordinates[1]];
                        isWarBetweenHeroAndOther = true;
                    }
                }
            } else if (!(characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1]] instanceof Hero)) {
                moveAgain(startCoordinates);
            }
        }
    }

    public void setToFalseWars() {
        isWar = false;
        isWarWithBoss = false;
        isWarBetweenHeroAndOther = false;
        attacker = null;
        defenser= null;
    }

    public void dissmissCharachterFromBoard() {

    }
}
