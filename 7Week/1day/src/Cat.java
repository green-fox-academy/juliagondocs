public class Cat {
    public String name;
    public int age;
    public String color;
    public String breed;

    public Cat() {

    }

    public Cat(String name, int age, String color, String breed) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.breed = breed;
    }

    public static void main(String[] args) {
        Cat cirmi = new Cat("Cirmi", 3, "black", "perzsa");
        if (cirmi.age == 3) {
            System.out.println("Jeeee");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
