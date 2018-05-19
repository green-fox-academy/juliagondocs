import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class StreamExamples {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        int[] evens = Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .toArray();
        System.out.println(Arrays.toString(evens));

        double oddAverage = Arrays.stream(numbers)
                .filter(n -> (n & 1) == 1)
                .average()
                .getAsDouble();

        OptionalDouble oddAverage2 = Arrays.stream(numbers)
                .filter(n -> (n & 1) == 1)
                .average();

        System.out.println(oddAverage);
        System.out.println(oddAverage2);

        ArrayList<Integer> myList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        myList.stream()
                .filter(x -> x > 3)
                .forEach(System.out::println);

    }


}
