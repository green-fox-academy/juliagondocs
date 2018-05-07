public class Flower extends Plant {
    static double absorbingPropertie = 0.75;

    public Flower() {
        super();
    }

    public Flower(String color) {
        super();
        this.color = color;
    }

    public boolean isThirsty() {
        boolean isThirty = false;
        if (this.currentWaterAmount < 5) {
            isThirty = true;
        } else {
            isThirty = false;
        }
        return isThirty;
    }
}
