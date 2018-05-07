public class Tree extends Plant {
    static double absorbingPropertie = 0.4;

    public Tree() {
        super();
    }

    public Tree(String color) {
        super();
        this.color = color;
    }

    public boolean isThirsty() {
        boolean isThirty = false;
        if (this.currentWaterAmount < 10) {
            isThirty = true;
        } else {
            isThirty = false;
        }
        return isThirty;
    }
}
