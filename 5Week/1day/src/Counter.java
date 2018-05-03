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

    public void add(int input) {
        this.count += input;
    }

    public void add() {
        this.count += 1;
    }

    public int get() {
        return count;
    }

    public void reset() {
        count = initialValue;
    }

    public static void main(String[] args) {
        Counter number = new Counter();
        System.out.println(number.get());

        Counter number1 = new Counter(50);
        System.out.println(number1.get());
    }

}
