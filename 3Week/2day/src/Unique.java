import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

import java.util.ArrayList;
import java.util.Arrays;

public class Unique {
    public static void main(String[] args) {
        //  Create a function that takes a list of numbers as a parameter
        //  Returns a list of numbers where every number in the list occurs only once

        //  Example
        int[] results = unique(new int[]{1, 11, 34, 11, 52, 61, 1, 34});
        for (int element : results) {
            System.out.print(element + " ");
        }
        //  should print: `[1, 11, 34, 52, 61]`
    }

    public static int[] unique(int[] numbers) {
        Arrays.sort(numbers);
        ArrayList<Integer> uniqeNumber = new ArrayList<>();
        int temp = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (i < numbers.length - 1) {
                if (numbers[i + 1] != numbers[i]) {
                    System.out.println(temp + " " + numbers[i]);
                    uniqeNumber.add(temp, numbers[i]);
                    temp += 1;
                }
            } else if (i == numbers.length - 1) {
                if (numbers[i] != numbers[i - 1]) {
                    System.out.println(temp + " " + numbers[i]);
                    uniqeNumber.add(temp, numbers[i]);
                    temp += 1;
                }
            }
        }
        //int[] uniqeNumberArray;
        //uniqeNumber.toArray();

        //int[] uniqeNumberArray = uniqeNumber.toArray(new int[uniqeNumber.size()]);

        int[] uniqeNumberArray = new int[uniqeNumber.size()];

        for (int i = 0; i < uniqeNumber.size(); i++) {
            uniqeNumberArray[i] = uniqeNumber.get(i);
        }

        return uniqeNumberArray;
    }
}