public class Main {
    public static void main(String[] args) {

        AircraftCarrier carrier = new AircraftCarrier(50, 200);
        AircraftCarrier carrier2 = new AircraftCarrier(10, 300);

        Aircraft fly1 = new F16();
        Aircraft fly2 = new F35();
        Aircraft fly3 = new F16();
        Aircraft fly4 = new F35();

        carrier.add(fly1);
        carrier.add(fly2);
        carrier2.add(fly3);
        carrier2.add(fly4);

        carrier.fill();
        carrier2.fill();
        carrier.getStatus();
        carrier2.getStatus();

        System.out.println("----------------------");
        carrier.fight(carrier2);

        carrier2.fill();
        carrier2.fight(carrier);

        carrier.getStatus();
        carrier2.getStatus();
    }
}
