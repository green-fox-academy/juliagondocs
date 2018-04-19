import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        //  Create a function that takes a list of numbers as parameter
        //  Returns a list where the elements are sorted in ascending numerical order
        //  Make a second boolean parameter, if it's `True` sort that list descending

        //  Example:
        int[] sorted = bubble(new int[]{34, 12, 24, 9, 5});
        for (int element : sorted) {
            System.out.print(element + " ");
        }
        System.out.println();
        //  should print [5, 9, 12, 24, 34]
        sorted = advancedBubble(new int[]{34, 12, 24, 9, 5}, false);
        for (int element : sorted) {
            System.out.print(element + " ");
        }
        //  should print [34, 24, 12, 9, 5]
    }

    public static int[] bubble(int[] inputList) {
        int temp = 0;
        for (int i = 0; i < inputList.length; i++) {
            for (int j = 1; j < (inputList.length - i); j++) {
                if (inputList[j - 1] > inputList[j]) {
                    //swap elements
                    temp = inputList[j - 1];
                    inputList[j - 1] = inputList[j];
                    inputList[j] = temp;
                }
            }
        }
        return inputList;
    }

    public static int[] advancedBubble(int[] inputList, boolean sortingType) {
        int temp = 0;
        if (sortingType) {
            bubble(inputList);
        } else {
            for (int i = 0; i < inputList.length; i++) {
                for (int j = 1; j < (inputList.length - i); j++) {
                    if (inputList[j - 1] < inputList[j]) {
                        //swap elements
                        temp = inputList[j - 1];
                        inputList[j - 1] = inputList[j];
                        inputList[j] = temp;
                    }
                }
            }
        }
        return inputList;
    }
}
