import java.util.ArrayList;

public class AircraftCarrier {
    ArrayList<Aircraft> aircraftList;
    int initialAmo;
    int health;
    int fightDamage;

    public AircraftCarrier() {
        aircraftList = new ArrayList<>();
    }

    public AircraftCarrier(int initialAmo, int health) {
        this.aircraftList = new ArrayList<>();
        this.initialAmo = initialAmo;
        this.health = health;
        this.fightDamage = 0;
    }

    public void add(Aircraft aircraft) {
        this.aircraftList.add(aircraft);
    }

    public void fill() {
        int airCraftsAmo = 0;
        for (int i = 0; i < this.aircraftList.size(); i++) {
            airCraftsAmo += aircraftList.get(i).getAmmoToFill();
        }

        if (initialAmo == 0) {

            System.out.println("There is no enough amo!");

        } else if (airCraftsAmo <= initialAmo) {

            for (int i = 0; i < aircraftList.size(); i++) {
                this.initialAmo = aircraftList.get(i).refill(this.initialAmo);
            }

        } else {
            for (int i = 0; i < aircraftList.size(); i++) {

                if (initialAmo > 0 && aircraftList.get(i).getPriority()) {
                    this.initialAmo = aircraftList.get(i).refill(initialAmo);
                }
            }

            if (initialAmo > 0) {
                for (int i = 0; i < aircraftList.size(); i++) {
                    this.initialAmo = aircraftList.get(i).refill(initialAmo);
                }
            } else {
                System.out.println("There is no ammo left in the storage");
            }

        }
    }

    public int fight(AircraftCarrier enemy) {
        for (int i = 0; i < aircraftList.size(); i++) {
            int fightDamage = aircraftList.get(i).fight();
            enemy.health -= fightDamage;
            enemy.fightDamage += fightDamage;

            if (enemy.health <= 0) {
                enemy.health = 0;
                System.out.println("It's dead Jim :(");
            }
        }
        return fightDamage;
    }

    public void getStatus() {
        System.out.println("HP: " + this.health + ", Aircraft count:" + this.aircraftList.size() +
                ", Ammo Storage:" + this.initialAmo + ", Total damage:" + fightDamage);
        for (int i = 0; i < aircraftList.size(); i++) {
            aircraftList.get(i).getStatus();
        }
    }


}
