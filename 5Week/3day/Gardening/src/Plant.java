public class Plant {
    double currentWaterAmount;
    double absorbingPropertie;
    String color;

    public Plant() {
        this.currentWaterAmount = 0;
        this.absorbingPropertie = 0;
        this.color = "unknown";
    }

    public Plant(String color) {
        this.color = color;
    }

    public double getWaterLevel() {
        return currentWaterAmount;
    }

    public void setWaterLevel(double currentWaterAmount) {
        this.currentWaterAmount = currentWaterAmount;
    }

    public String getColor() {
        return this.color;
    }

}
