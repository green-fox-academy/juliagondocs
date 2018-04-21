import java.util.*;

public class Matchmaking {
    public static void main(String... args) {
        ArrayList<String> girls = new ArrayList<String>(Arrays.asList("Eve", "Ashley", "Bözsi", "Kat", "Jane"));
        ArrayList<String> boys = new ArrayList<String>(Arrays.asList("Joe", "Fred", "Béla", "Todd", "Neef", "Jeff"));

        // Write a method that joins the two lists by matching one girl with one boy into a new list
        // Expected output: "Eve", "Joe", "Ashley", "Fred"...

        makingMatches(girls, boys);
        //System.out.println(makingMatches(girls, boys));
    }

    public static void makingMatches(ArrayList lanyok, ArrayList fiuk) {
        String[] matched = new String[lanyok.size() * 2];
        for (int i = 0; i < lanyok.size(); i++) { // girls contains less elements
            matched[i * 2] = (String) lanyok.get(i);
            matched[i * 2 + 1] = (String) fiuk.get(i);
        }
        for (Object currentMatch : matched) {
            System.out.print(currentMatch + " ");
        }
    }
}