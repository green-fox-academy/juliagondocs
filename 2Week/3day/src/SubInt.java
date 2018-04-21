import java.util.*;

public class SubInt {
    public static void main(String[] args) {
        //  Create a function that takes a number and a list of numbers as a parameter
        //  Returns the indices of the numbers in the list where the first number is part of
        //  Returns an empty list if the number is not part any of the numbers in the list

        //  Example:
        System.out.println(subIntM(1, new int[]{1, 11, 34, 52, 61}));
        //  should print: `[0, 1, 4]`
        System.out.println(subIntM(9, new int[]{1, 11, 34, 52, 61}));
        //  should print: '[]'
    }

    public static ArrayList<Integer> subIntM(int a, int[] inputList) {
        ArrayList<Integer> result = new ArrayList<>();
        String[] inputListString = new String[inputList.length];
        int j = 0;
        for (int element : inputList) {
            inputListString[j] = String.valueOf(element);
            j++;
        }

        String inputNumberString = String.valueOf(a);
        int index = 0;
        for (String i : inputListString) {
            if (i.contains(inputNumberString)) {
                result.add(index);
                index++;
            } else {
                index++;
            }
        }

        return result;
    }
}