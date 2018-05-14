import java.util.ArrayList;

public class Sum {
    ArrayList<Integer> numbers;

    public Sum() {
        new ArrayList<>();
    }


    public int sum(ArrayList<Integer> numbers) {
        if (numbers.size() > 0) {
            int sum = 0;
            for (int i = 0; i < numbers.size(); i++) {
                sum += numbers.get(i);
            }
            return sum;
        } else {
            return 0;
        }
    }
}
