import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Table {

    int size;
    private GameObject[][] tileLocationMatrix = readPlan("level" + Hero.heroLevel + ".txt");
    private GameObject[][] characterAndTileLocationMatrix = readPlan("level" + Hero.heroLevel + "_char.txt");

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
                    coordList[i][j] = hero;
                } else if (content.get(i).charAt(j) == 'b') {
                    Boss boss = new Boss();
                    coordList[i][j] = boss;
                } else if (content.get(i).charAt(j) == 's') {
                    Skeleton skeleton = new Skeleton();
                    coordList[i][j] = skeleton;
                    int[] characterCoordinates = new int[2];
                    characterCoordinates[0] = i;
                    characterCoordinates[1] = j;
                    skeletons.add(characterCoordinates);
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
            coordList[skeletons.get(chance)[0]][skeletons.get(chance)[1]].setKey();
        }
        return coordList;
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
        if (!coordinates.isEmpty()) {
            System.out.println(coordinates.get(0)[0] + " " + coordinates.get(0)[1]);
        }
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
                } else {
                    //attack battle(startCoordinates, startCoordinates[0]][startCoordinates[1] + 1);
                }
            } else if (!(characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1]] instanceof Hero)) {
                moveAgain(startCoordinates);
            }
        }
    }

    public void moveCharacterLeft(int[] startCoordinates) {
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
                } else {
                    //attack
                }
            } else if (!(characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1]] instanceof Hero)) {
                moveAgain(startCoordinates);
            }
        }
    }

    public void moveCharacterDown(int[] startCoordinates) {
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
                } else if (characterAndTileLocationMatrix[startCoordinates[0] + 1][startCoordinates[1]] instanceof Skeleton) {
                    System.out.println("Van elottem valami:  I will kill you Skeleton");
                } else if (characterAndTileLocationMatrix[startCoordinates[0] + 1][startCoordinates[1]] instanceof Boss) {
                    System.out.println("Van elottem valami: I will kill you Boss");
                }
            } else if (!(characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1]] instanceof Hero)) {
                moveAgain(startCoordinates);
            }
        }
    }

    public void moveCharacterUp(int[] startCoordinates) {
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
                } else {
                    //attack
                }
            } else if (!(characterAndTileLocationMatrix[startCoordinates[0]][startCoordinates[1]] instanceof Hero)) {
                moveAgain(startCoordinates);
            }
        }
    }

    public int getSkeletonNumberWithKey() {
        int skeletonWithKey = 0;
        for (int i = 0; i < characterAndTileLocationMatrix.length; i++) {
            for (int j = 0; j < characterAndTileLocationMatrix[0].length; j++) {
                if(characterAndTileLocationMatrix[i][j] instanceof Skeleton ) {
//                    if (characterAndTileLocationMatrix[i][j].getKey() == true ) {
//                        skeletonWithKey +=1;
//                    };
                }
            }
        }
        return skeletonWithKey;
    }
}
