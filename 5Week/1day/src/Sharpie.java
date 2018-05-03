public class Sharpie {
    String color;
    float width;
    float inkAmount = 100;

    public Sharpie(String color, float width) {
        this.inkAmount = 100;
        this.color = color;
        this.width = width;
    }

    public void use() {
        this.inkAmount -= 10;
    }

    public static void main(String[] args) {
        Sharpie littleSharpie = new Sharpie("brown", 23000);
        System.out.println(littleSharpie.inkAmount);
        littleSharpie.use();
        System.out.println(littleSharpie.inkAmount);
    }
}
