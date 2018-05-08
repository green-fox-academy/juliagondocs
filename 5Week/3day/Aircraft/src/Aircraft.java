public class Aircraft {
    int maxAmo;
    int baseDamage;
    int currentAmo;
    String type;
    int damage;
    boolean fillPriority;

    public Aircraft() {
        this.currentAmo = 0;
    }

    public String getType(Aircraft aircraft) {
        return this.type;
    }

    public int fight() {
        int damage = this.currentAmo * this.baseDamage;
        this.currentAmo = 0;
        return damage;
    }

    public int refill(int getAmoAmount) {
        int remainingAmo = 0;
        if (this.maxAmo - this.currentAmo >= getAmoAmount) {
            this.currentAmo += getAmoAmount;
            remainingAmo = 0;
        } else {
            remainingAmo = getAmoAmount - (this.maxAmo - this.currentAmo);
            this.currentAmo = this.maxAmo;
        }
        return remainingAmo;
    }

    public int getCurrentAmo() {
        return this.currentAmo;
    }

    public void getStatus() {
        System.out.println("Type " + this.type + ", Ammo: " + this.currentAmo +
                ", Base Damage:" + this.baseDamage + ", All Damage:" + this.damage);
    }

    public boolean getPriority() {
        return (this.type == "F35");
    }

    public int getAmmoToFill() {
        //return this.ammoLevel;
        int ammoToFill = 0;
        if (this.type == "F35") {
            ammoToFill = 12 - this.currentAmo;
        } else {
            ammoToFill = 8 - this.currentAmo;
        }
        return ammoToFill;
    }
}
