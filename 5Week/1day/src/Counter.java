public class Counter {
    int count;
    int initialValue;

    public Counter() {
        this.count = 0;
        this.initialValue = 0;
    }

    public Counter(int counter) {
        this.count = counter;
        this.initialValue = count;
    }

    public int add(int input) {
        this.count += input;
        return this.count;
    }

    public void add() {
        this.count += 1;
    }

    public int getV() {
        return count;
    }

    public void reset() {
        count = initialValue;
    }

    public static void main(String[] args) {
        Counter number = new Counter();
        System.out.println(number.getV());
        System.out.println(number.add(10));

        Counter number1 = new Counter(50);
        System.out.println(number1.getV());
        System.out.println(number1.add(10));
    }

}
