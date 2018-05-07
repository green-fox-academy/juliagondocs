public class Pirate {
    String name;
    int age;
    boolean isEvil;
    int howToxicated = 0;
    boolean isSleeping = false;
    boolean isAlive = true;
    boolean isCaptain = true;

    public Pirate(String name, int age, boolean isEvil) {
        this.name = name;
        this.age = age;
        this.isEvil = isEvil;
        this.isCaptain = false;
    }

    public Pirate(String name, int age) {
        this.name = name;
        this.age = age;
        this.isEvil = true;
        this.isCaptain = false;
    }

    public Pirate() {
        this.name = "unknown";
        this.age = 0;
        this.isSleeping = false;
        this.isAlive = true;
        this.isCaptain = false;

    }

    public void drinkSomeRum() {
        if (isAlive) {
            this.howToxicated += 1;
        } else {
            System.out.println("Dead pirate does not drink.");
        }

    }

    public void howsItGoingMate() {
        if (this.howToxicated < 4.1) {
            System.out.println("Pour me anudder!");
        } else {
            System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
            sleep();
        }
    }

    public void sleep() {
        if (this.isAlive) {
            this.isSleeping = true;
        } else {
            System.out.println("Dead pirate does not sleep.");
        }
    }

    public void die() {
        this.isAlive = false;
    }

    public void brawl(Pirate evilPirate) {
        if (this.isAlive && evilPirate.isAlive) {
            int chance = (int) (Math.random() * 3) + 1;
            System.out.println(chance);
            if (chance == 1) {
                this.die();
            }
            if (chance == 2) {
                evilPirate.die();
            }
            if (chance == 3) {
                this.sleep();
                evilPirate.sleep();
            }
        }
    }

    public void pirateInfo() {
        System.out.println("Name: " + name);
        System.out.println("Sleep: " + isSleeping);
        System.out.println("Dead: " + isAlive);
        System.out.println("Drunk level: " + howToxicated);
        System.out.println("Captain: " + isCaptain);
    }

    public void setCaptain(boolean captain) {
        this.isCaptain = captain;
    }

    public boolean isDead() {
        return isAlive;
    }

    public boolean isSleep() {
        return isSleeping;
    }

    public int getDrunkLevel() {
        return this.howToxicated;
    }
}

class Parrot {
    String color;
    boolean isAnnoying;

    public Parrot() {
    }

    public Parrot(String color, boolean annoying) {
        this.color = color;
        this.isAnnoying = annoying;
    }
}