import java.util.ArrayList;

public class Ship {
    ArrayList<Pirate> listOfPirates;
    // initialise random number of pirates on the ship
    int numberOfPirates = (int) (1 + (Math.random() * 10));
    int indexOfTheCaptain = (int) ((Math.random() * (numberOfPirates)));

    public Ship() {
        listOfPirates = new ArrayList<Pirate>();
    }

    public void fillShip() {
        if (this.listOfPirates.isEmpty()) {
            for (int i = 0; i < numberOfPirates; i++) {
                if (i == indexOfTheCaptain) {
                    listOfPirates.add(new Pirate());
                    listOfPirates.get(i).setCaptain(true);
                    listOfPirates.get(i).drinkSomeRum();
                } else {
                    this.listOfPirates.add(new Pirate());
                }
            }
        }
    }

    public void getInfo() {
        System.out.println("The captain has consumed " + listOfPirates.get(indexOfTheCaptain).getDrunkLevel() + " rum and he's " +
                (listOfPirates.get(indexOfTheCaptain).isDead() ? "dead." : "alive and " + (listOfPirates.get(indexOfTheCaptain).isSleep() ? "sleeping." : "awake.")));
        System.out.println("The ship has " + numberOfAlivePirates() + " pirates alive.");
        System.out.println(indexOfTheCaptain);
    }

    public int numberOfAlivePirates() {
        int numberOfAlive = 0;
        for (int i = 0; i < this.listOfPirates.size(); i++) {
            if (!listOfPirates.get(i).isCaptain) {
                if (listOfPirates.get(i).isAlive) {
                    numberOfAlive += 1;
                }
            }
        }
        return numberOfAlive;
    }

    public int calculateShipScore() {
        return numberOfAlivePirates() - listOfPirates.get(indexOfTheCaptain).getDrunkLevel();
    }

    public boolean battle(Ship otherShip) {
        boolean whoWin = false;
        if (this.calculateShipScore() > otherShip.calculateShipScore()) {
            otherShip.killRandomNumberOfPirates();
            this.makeDrinkRandomNumberOfPirates();
            whoWin = true;
        } else if (this.calculateShipScore() < otherShip.calculateShipScore()) {
            this.killRandomNumberOfPirates();
            otherShip.makeDrinkRandomNumberOfPirates();
            whoWin = false;
        } else {
            this.killRandomNumberOfPirates();
            otherShip.killRandomNumberOfPirates();
        }
        return whoWin;
    }

    public void killRandomNumberOfPirates() {
        for (int i = 0; i < numberOfPirates; i++) {
            int chance = (int) Math.random();
            if (chance > 0.5) {
                listOfPirates.get(i).die();
            }
        }
    }

    public void makeDrinkRandomNumberOfPirates() {
        for (int i = 0; i < numberOfPirates; i++) {
            int chance = (int) Math.random();
            if (chance > 0.5) {
                listOfPirates.get(i).drinkSomeRum();
            }
        }
    }

}
