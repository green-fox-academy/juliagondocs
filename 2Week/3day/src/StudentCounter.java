import java.util.*;

public class StudentCounter {
    public static void main(String... args) {
        ArrayList<Map<String, Object>> map = new ArrayList<Map<String, Object>>();

        // Given this list of hashmaps...

        Map<String, Object> row0 = new HashMap<String, Object>();
        row0.put("name", "Rezso");
        row0.put("age", 9.5);
        row0.put("candies", 2);
        map.add(row0);

        Map<String, Object> row1 = new HashMap<String, Object>();
        row1.put("name", "Gerzson");
        row1.put("age", 10);
        row1.put("candies", 1);
        map.add(row1);

        Map<String, Object> row2 = new HashMap<String, Object>();
        row2.put("name", "Aurel");
        row2.put("age", 7);
        row2.put("candies", 3);
        map.add(row2);

        Map<String, Object> row3 = new HashMap<String, Object>();
        row3.put("name", "Zsombor");
        row3.put("age", 12);
        row3.put("candies", 5);
        map.add(row3);

        Map<String, Object> row4 = new HashMap<String, Object>();
        row4.put("name", "Olaf");
        row4.put("age", 12);
        row4.put("candies", 7);
        map.add(row4);

        Map<String, Object> row5 = new HashMap<String, Object>();
        row5.put("name", "Teodor");
        row5.put("age", 3);
        row5.put("candies", 2);
        map.add(row5);

        // Display the following things:
        //  - Who has got more candies than 4 candies
        //  - Sum the age of people who have lass than 5 candies
        double sumAge = 0;
        for (int i = 0; i < map.size(); i++) {
            // First Task
            Object candy = map.get(i).get("candies");
            Object age = map.get(i).get("age");
            if (candy instanceof Double) {
                double numberOfCandy = (Double) candy;
                if (numberOfCandy > 4) {
                    System.out.println(map.get(i).get("name"));
                }
            } else if (candy instanceof Integer) {
                int numberOfCandy = (Integer) candy;
                if (numberOfCandy > 4) {
                    System.out.println(map.get(i).get("name"));
                }
            }
            if (candy instanceof Double && age instanceof Integer) {
                double numberOfCandy = (Double) candy;
                int numberOfAge = (Integer) age;
                if (numberOfCandy < 5) {
                    sumAge += numberOfAge;
                }
            } else if (candy instanceof Integer && age instanceof Integer) {
                int numberOfCandy = (Integer) candy;
                int numberOfAge = (Integer) age;
                if (numberOfCandy < 5) {
                    sumAge += numberOfAge;
                }
            } else if (candy instanceof Integer && age instanceof Double) {
                int numberOfCandy = (Integer) candy;
                double numberOfAge = (Double) age;
                if (numberOfCandy < 5) {
                    sumAge += numberOfAge;
                }
            } else if (candy instanceof Double && age instanceof Double) {
                double numberOfCandy = (Double) candy;
                double numberOfAge = (Double) age;
                if (numberOfCandy < 5) {
                    sumAge += numberOfAge;
                }
            }
        } // for
        System.out.println(sumAge);
    }
}