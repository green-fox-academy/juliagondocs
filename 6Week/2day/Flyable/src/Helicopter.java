public class Helicopter extends Vehicle implements Flyable {
    public Helicopter(String type) {
        this.numberOfWheels = 2;
        this.color = "white";
        this.type = type;
    }

    @Override
    public void land() {
        System.out.println("on a landing pad on the roof");
    }

    @Override
    public void fly() {
        System.out.println("with rotors");
    }

    @Override
    public void takeOff() {
        System.out.println("soring 90°vertically and then flies away");

    }

    @Override
    public String toString() {
        return "Helicopter{ of type " + type + ", " +
                "number Of Wheels:" + numberOfWheels +
                ", colour:'" + color + '\'' +
                '}';
    }
}
