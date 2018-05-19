import java.util.*;

import static java.util.stream.Collectors.toMap;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex1 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14));
        // Write a Stream Expression to get the even numbers from the following array
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        // Write a Stream Expression to get the average value of the odd numbers from the following array:
        System.out.println(numbers.stream()
                .filter(n -> n % 2 == 1)
                .mapToInt(n -> n)
                .average());

        //Write a Stream Expression to get the squared value of the positive numbers from the following array:
        numbers.stream()
                .filter(n -> n > 0)
                .map(n -> n * n)
                .forEach(System.out::println);


        ArrayList<Integer> numbers1 = new ArrayList<>(Arrays.asList(3, 9, 2, 8, 6, 5));
        // Write a Stream Expression to find which number squared value is more then 20 from the following array:
        numbers1.stream()
                .filter(n -> n * n > 20)
                .forEach(System.out::println);

        // Write a Stream Expression to find the uppercase characters in a string!
        System.out.println("aLMa".chars()
                .filter((c) -> Character.isUpperCase(c))
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString());

        // Write a Stream Expression to find the strings which starts with A and ends with I in the following array:
        ArrayList<String> cities = new ArrayList<>(Arrays.asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH", "NEW DELHI", "AMSTERDAM", "ABU DHABI", "PARIS"));
        cities.stream()
                .filter(s -> s.startsWith("A") && s.endsWith("I"))
                .forEach(System.out::println);


        // Write a Stream Expression to find the frequency of characters in a given string!
        String s = "Ez egy tok atlagos mondat, amiben megszamolom az \' a \' betűt ";
        Map<Character, Integer> frequency = s.chars().boxed()
                .collect(toMap(
                        k -> Character.valueOf((char) k.intValue()),
                        v -> 1,
                        Integer::sum));
        System.out.println(frequency);

        //Write a Stream Expression to find the frequency of numbers in the following array:
        ArrayList<Integer> numbers2 = new ArrayList<>(Arrays.asList(5, 9, 1, 2, 3, 7, 5, 6, 7, 3, 7, 6, 8, 5, 4, 9, 6, 2));
        System.out.println(numbers2.stream()
                .collect(toMap(
                        k -> k,
                        v -> 1,
                        Integer::sum)));

        Map<Integer, Long> frequencies = numbers2.stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        System.out.println(frequencies);

        // Write a Stream Expression to convert a char array to a string!
        char[] charArray = {'a', 'l', 'm', 'a'};
        String text = new String(charArray).chars()
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
        System.out.println(text);

        // Create a Fox class with 3 properties(name, type, color)
        // Fill a list with at least 5 foxes, it's up to you how you name/create them!
        // Write a Stream Expression to find the foxes with green color!
        // Write a Stream Expression to find the foxes with green color and pallida type!
        List<Fox> foxes = Arrays.asList(
                new Fox("Samu", "brown", "pallida"),
                new Fox(),
                new Fox("Suta", "green", "pale"),
                new Fox("Vaksi", "green", "pallida"),
                new Fox("Lili", "green", "pallida"));
        List<Fox> greenFoxes = foxes.stream()
                .filter(f -> f.getColor() == "green")
                .collect(Collectors.toList());

        greenFoxes.stream()
                .map(f -> f.getName())
                .forEach(System.out::println);


        List<Fox> greenFoxesPallida = foxes.stream()
                .filter(f -> f.getColor() == "green")
                .filter(f -> f.getType() == "pallida")
                .collect(Collectors.toList());

        greenFoxesPallida.stream()
                .map(f -> f.getName())
                .forEach(System.out::println);
    }
}
