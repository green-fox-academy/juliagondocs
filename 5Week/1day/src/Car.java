public class Car {
    int gasAmount;
    int capacity;

    public Car() {
        this.capacity = 100;
        this.gasAmount = 0;
    }

    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car.gasAmount);
        Station station = new Station();
        station.refill(car);
        System.out.println("Car's fuel: " + car.gasAmount);
        System.out.println("Station's fuel: " + station.gasAmount);
    }
}
