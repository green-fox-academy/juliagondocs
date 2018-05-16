public class Sharpie {
    String color;
    float width;
    float inkAmount = 100;

    public Sharpie(String color, float width) {
        this.inkAmount = 100;
        this.color = color;
        this.width = width;
    }

    public float use() {
        return this.inkAmount -= 10;
    }
}
