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
    private List<List<GameObject>> tileLocationMatrix = readPlan("level" + Hero.heroLevel + ".txt");
    private List<List<GameObject>> characterAndTileLocationMatrix = readPlan("level" + Hero.heroLevel + "_char.txt");
    Character attacker;
    Character defenser;
    boolean gameOver;
    boolean isLevelUp;


    public Table() {
        this.size = 72;
        Hero.setHeroLevel(Hero.getHeroLevel()+1);
    }

    public List<List<GameObject>> readPlan(String fileAccessPath) {
        List<int[]> skeletons = new ArrayList<>();

        List<String> content = new ArrayList<>();
        Path filePath = Paths.get(fileAccessPath);
        try {
            content = Files.readAllLines(filePath);
        } catch (IOException e) {
            System.out.println("Reading error");
        }

        List<List<GameObject>> coordList = new ArrayList<>();
        for (int i = 0; i < content.size(); i++) {
            List<GameObject> temp = new ArrayList<>();
            for (int j = 0; j < content.get(i).length(); j++) {
                if (content.get(i).charAt(j) == 'h') {
                    temp.add(j, new Hero());
                } else if (content.get(i).charAt(j) == 'b') {
                    temp.add(j, new Boss());
                } else if (content.get(i).charAt(j) == 's') {
                    Skeleton skeleton = new Skeleton();
                    temp.add(j, new Skeleton());
                    int[] characterCoordinates = new int[2];
                    characterCoordinates[0] = i;
                    characterCoordinates[1] = j;
                    skeletons.add(characterCoordinates);
                    System.out.println("Ennyi skeletonom van: " + skeletons.size());
                } else if (content.get(i).charAt(j) == '0') {
                    temp.add(j, new Wall());
                } else if (content.get(i).charAt(j) == '1') {
                    temp.add(j, new Floor());
                }
            }
            coordList.add(temp);
        }
        if (!skeletons.isEmpty()) {
            int chance = (int) Math.random() * skeletons.size();
            if (coordList.get(skeletons.get(chance)[0]).get(skeletons.get(chance)[1]) instanceof Skeleton) {
                coordList.get(skeletons.get(chance)[0]).get(skeletons.get(chance)[1]).setHasKey();
            }
        }
        return coordList;
    }

    public void drawTilePlan(Graphics g) {
        for (int i = 0; i < tileLocationMatrix.get(0).size(); i++) {
            for (int j = 0; j < tileLocationMatrix.get(0).size(); j++) {
                if (tileLocationMatrix.get(i).get(j) instanceof Wall || tileLocationMatrix.get(i).get(j) instanceof Floor) {
                    PositionedImage tile = new PositionedImage(tileLocationMatrix.get(i).get(j).filePath, j * size, i * size);
                    tile.draw(g);
                }
            }
        }
    }

    public void drawCharacterPlan(Graphics g) {
        for (int i = 0; i < characterAndTileLocationMatrix.get(0).size(); i++) {
            for (int j = 0; j < characterAndTileLocationMatrix.get(i).size(); j++) {
                if (characterAndTileLocationMatrix.get(i).get(j) instanceof Hero || characterAndTileLocationMatrix.get(i).get(j) instanceof Skeleton || characterAndTileLocationMatrix.get(i).get(j) instanceof Boss) {
                    PositionedImage tile = new PositionedImage(characterAndTileLocationMatrix.get(i).get(j).filePath, j * size, i * size);
                    tile.draw(g);
                }
            }
        }
    }

    public List<int[]> findCharacter(String className) {
        List<int[]> coordinates = new ArrayList<>();
        for (int i = 0; i < characterAndTileLocationMatrix.size(); i++) {
            for (int j = 0; j < characterAndTileLocationMatrix.get(i).size(); j++) {
                if (className.equals("Hero") && (characterAndTileLocationMatrix.get(i).get(j) instanceof Hero)) {
                    int[] characterCoordinates = new int[2];
                    characterCoordinates[0] = i;
                    characterCoordinates[1] = j;
                    coordinates.add(characterCoordinates);
                } else if (className.equals("Boss") && (characterAndTileLocationMatrix.get(i).get(j) instanceof Boss)) {
                    int[] characterCoordinates = new int[2];
                    characterCoordinates[0] = i;
                    characterCoordinates[1] = j;
                    coordinates.add(characterCoordinates);
                } else if (className.equals("Skeleton") && (characterAndTileLocationMatrix.get(i).get(j) instanceof Skeleton)) {
                    int[] characterCoordinates = new int[2];
                    characterCoordinates[0] = i;
                    characterCoordinates[1] = j;
                    coordinates.add(characterCoordinates);
                }
            }
        }
        return coordinates;
    }

    public void drawInfoHero(Graphics g) {
        if (!findCharacter("Hero").isEmpty()) {
            int xx = findCharacter("Hero").get(0)[0];
            int yy = findCharacter("Hero").get(0)[1];
            String info = "";
            if (xx >= 0 && yy >= 0) {
                info = (characterAndTileLocationMatrix.get(xx).get(yy) instanceof Hero ? "Hero HP: " + characterAndTileLocationMatrix.get(xx).get(yy).toString() : "semmi");
            }
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
    }

    public void drawInfoTableBoss(Graphics g) {
        if (!findCharacter("Boss").isEmpty()) {
            int xx = findCharacter("Boss").get(0)[0];
            int yy = findCharacter("Boss").get(0)[1];
            String info = "";
            if (xx > 0 && yy > 0) {
                info = (characterAndTileLocationMatrix.get(xx).get(yy) instanceof Boss ? "Boss HP: " + characterAndTileLocationMatrix.get(xx).get(yy).toString() : "semmi");
            }
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

    public void moveCharacterRight(int[] stsc) {
        setToFalseWars();
        if (stsc[1] != characterAndTileLocationMatrix.get(0).size() - 1) {
            if (!(characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1] + 1) instanceof Wall)) {
                if (!(characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1] + 1) instanceof Character)) {
                    GameObject temp = characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1]);
                    characterAndTileLocationMatrix.get(stsc[0]).set(stsc[1], characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1] + 1));
                    characterAndTileLocationMatrix.get(stsc[0]).set(stsc[1] + 1, temp);
                    if (characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1] + 1) instanceof Hero) {
                        Hero.heroStep++;
                        characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1] + 1).moveRight();
                    }
                } else if ((characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1]) instanceof Hero)) {
                    isWar = true;

                    if (characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1] + 1) instanceof Boss) {
                        isWarWithBoss = true;
                    }
                    if (characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1] + 1) instanceof Boss ||
                            characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1] + 1) instanceof Skeleton) {
                        attacker = (Character) characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1]); // hero
                        defenser = (Character) characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1] + 1); //attacker
                        isWarBetweenHeroAndOther = true;
                    }
                }
            } else if (!(characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1]) instanceof Hero)) {
                moveAgain(stsc);
            }
        }
    }

    public void moveCharacterLeft(int[] stsc) {
        setToFalseWars();
        if (stsc[1] != 0) {
            if (!(characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1] - 1) instanceof Wall)) {
                if (!(characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1] - 1) instanceof Character)) {
                    GameObject temp = characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1]);
                    characterAndTileLocationMatrix.get(stsc[0]).set(stsc[1], characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1] - 1));
                    characterAndTileLocationMatrix.get(stsc[0]).set(stsc[1] - 1, temp);
                    if (characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1] - 1) instanceof Hero) {
                        Hero.heroStep++;
                        characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1] - 1).moveLeft();
                    }
                } else if ((characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1]) instanceof Hero)) {
                    isWar = true;

                    if (characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1] - 1) instanceof Boss) {
                        isWarWithBoss = true;
                    }
                    if (characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1] - 1) instanceof Boss ||
                            characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1] - 1) instanceof Skeleton) {
                        attacker = (Character) characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1]); // hero
                        defenser = (Character) characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1] - 1); //attacker
                        isWarBetweenHeroAndOther = true;
                    }
                }
            } else if (!(characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1]) instanceof Hero)) {
                moveAgain(stsc);
            }
        }
    }

    public void moveCharacterDown(int[] stsc) {
        setToFalseWars();
        if (stsc[0] != characterAndTileLocationMatrix.get(0).size() - 1) {
            if (!(characterAndTileLocationMatrix.get(stsc[0] + 1).get(stsc[1]) instanceof Wall)) {
                if (!(characterAndTileLocationMatrix.get(stsc[0] + 1).get(stsc[1]) instanceof Character)) {
                    GameObject temp = characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1]);
                    characterAndTileLocationMatrix.get(stsc[0]).set(stsc[1], characterAndTileLocationMatrix.get(stsc[0] + 1).get(stsc[1]));
                    characterAndTileLocationMatrix.get(stsc[0] + 1).set(stsc[1], temp);
                    if (characterAndTileLocationMatrix.get(stsc[0] + 1).get(stsc[1]) instanceof Hero) {
                        Hero.heroStep++;
                        characterAndTileLocationMatrix.get(stsc[0] + 1).get(stsc[1]).moveDown();
                    }
                } else if ((characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1]) instanceof Hero)) {
                    isWar = true;

                    if (characterAndTileLocationMatrix.get(stsc[0] + 1).get(stsc[1]) instanceof Boss) {
                        isWarWithBoss = true;
                    }
                    if (characterAndTileLocationMatrix.get(stsc[0] + 1).get(stsc[1]) instanceof Boss ||
                            characterAndTileLocationMatrix.get(stsc[0] + 1).get(stsc[1]) instanceof Skeleton) {
                        attacker = (Character) characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1]); // hero
                        defenser = (Character) characterAndTileLocationMatrix.get(stsc[0] + 1).get(stsc[1]); //attacker
                        isWarBetweenHeroAndOther = true;
                    }
                }
            } else if (!(characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1]) instanceof Hero)) {
                moveAgain(stsc);
            }
        }
    }

    public void moveCharacterUp(int[] stsc) {
        setToFalseWars();
        if (stsc[0] >= 0) {
            if (!(characterAndTileLocationMatrix.get(stsc[0] - 1).get(stsc[1]) instanceof Wall)) {
                if (!(characterAndTileLocationMatrix.get(stsc[0] - 1).get(stsc[1]) instanceof Character)) {
                    GameObject temp = characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1]);
                    characterAndTileLocationMatrix.get(stsc[0]).set(stsc[1], characterAndTileLocationMatrix.get(stsc[0] - 1).get(stsc[1]));
                    characterAndTileLocationMatrix.get(stsc[0] - 1).set(stsc[1], temp);
                    if (characterAndTileLocationMatrix.get(stsc[0] - 1).get(stsc[1]) instanceof Hero) {
                        Hero.heroStep++;
                        characterAndTileLocationMatrix.get(stsc[0] - 1).get(stsc[1]).moveUp();
                    }
                } else if ((characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1]) instanceof Hero)) {
                    isWar = true;

                    if (characterAndTileLocationMatrix.get(stsc[0] - 1).get(stsc[1]) instanceof Boss) {
                        isWarWithBoss = true;
                    }
                    if (characterAndTileLocationMatrix.get(stsc[0] - 1).get(stsc[1]) instanceof Boss ||
                            characterAndTileLocationMatrix.get(stsc[0] - 1).get(stsc[1]) instanceof Skeleton) {
                        attacker = (Character) characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1]); // hero
                        defenser = (Character) characterAndTileLocationMatrix.get(stsc[0] - 1).get(stsc[1]); //attacker
                        isWarBetweenHeroAndOther = true;
                    }
                }
            } else if (!(characterAndTileLocationMatrix.get(stsc[0]).get(stsc[1]) instanceof Hero)) {
                moveAgain(stsc);
            }
        }
    }

    public void setToFalseWars() {
        isWar = false;
        isWarWithBoss = false;
        isWarBetweenHeroAndOther = false;
        attacker = null;
        defenser = null;
    }

    public void disMissDeadCharacter(int[] stsc) {
        characterAndTileLocationMatrix.get(stsc[0]).set(stsc[1], new Floor());
    }

    public boolean checkForWin() {
        // megszamoljuk h miből hány van -> ha elérjük a kettőt, akkor true lesz a kimenet
        int count = 0;
        for (int i = 0; i < characterAndTileLocationMatrix.size(); i++) {
            for (int j = 0; j < characterAndTileLocationMatrix.get(1).size(); j++) {
                if (characterAndTileLocationMatrix.get(i).get(j) instanceof Boss) {
                    if (((Boss) characterAndTileLocationMatrix.get(i).get(j)).getCurrentHP() > 0) {
                        count += 1;
                        System.out.println("van egy élő Bossom");
                    }
                }

                if (characterAndTileLocationMatrix.get(i).get(j) instanceof Skeleton) {
                    Skeleton skeleton = (Skeleton) characterAndTileLocationMatrix.get(i).get(j);
                    if (skeleton.hasKey()) {
                        if (skeleton.getCurrentHP() > 0) {
                            count += 1;
                            System.out.println("Van egy kulcsos elő skeletonom");
                        }

                    }
                }
            }
        }
        if (count == 2) {
            return false;
        } else if (count == 0) {
            return true;
        }
        return false;
    }
}
