import java.util.*;

public class Candyshop {
    public static void main(String... args) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        arrayList.add("Cupcake");
        arrayList.add(2);
        arrayList.add("Brownie");
        arrayList.add(false);

        // Accidentally we added "2" and "false" to the list.
        // Your task is to change from "2" to "Croissant" and change from "false" to "Ice cream"
        // No, don't just remove the lines
        // Create a method called sweets() which takes the list as a parameter.
        sweets(arrayList);
        for (Object currentMatch : arrayList) {
            System.out.print(currentMatch + " ");
        }
        //System.out.println();
        // Expected output: "Cupcake", "Croissant", "Brownie", "Ice cream"
    }

    public static ArrayList<Object> sweets(ArrayList<Object> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) instanceof Boolean) {
                arrayList.set(i, "Ice Cream");
            } else if (arrayList.get(i) instanceof Integer) {
                arrayList.set(i, "Croissant");
            }
        }
        return arrayList;
    }
}