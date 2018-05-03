public class Station {
    int gasAmount = 1000;

    public void refill(Car car) {
        this.gasAmount -= car.capacity;
        car.gasAmount += car.capacity;
    }
}
