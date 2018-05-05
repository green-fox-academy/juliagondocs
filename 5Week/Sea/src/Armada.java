import java.util.ArrayList;

public class Armada {
    ArrayList<Ship> armada;

    public Armada() {
        armada = new ArrayList<Ship>();
    }

    public void addShipsToArmada(Ship ship) {
        armada.add(ship);
    }

    public void war(Armada otherArmada) {
        int armadaIndex = 0;
        int otherArmadaIndex = 0;

        while (armadaIndex != this.armada.size() && otherArmadaIndex != otherArmada.armada.size()) {
            boolean whichShipWon = armada.get(armadaIndex).battle(otherArmada.armada.get(otherArmadaIndex));
            if (whichShipWon == true) {
                otherArmadaIndex++;
                System.out.println("Our ship has won, ready for the next battle.");
            } else if (whichShipWon == false) {
                armadaIndex++;
                System.out.println("Enenmy ship has won, ready for the next battle.");
            } else {
                otherArmadaIndex++;
                armadaIndex++;
                System.out.println("Both ship has drowned, next ships are coming to fight.");
            }
        }

        if (armadaIndex == armada.size() && otherArmadaIndex == otherArmada.armada.size()) {
            System.out.println("Everyone died.");
        } else if (armadaIndex == armada.size()) {
            System.out.println("We have lost the war.");
        } else {
            System.out.println("We have won the war.");
        }
    }
}
