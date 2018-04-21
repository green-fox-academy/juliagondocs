import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class JosephusProblem {
    public static void main(String[] args) {
        // initial variables
        int numPeople, skip, targetIndex;

        Scanner in = new Scanner(System.in);

        // get the initial number of soldiers
        System.out.print("Enter the number of soldiers: ");
        numPeople = in.nextInt();
        in.nextLine();

        // get the number of soldiers to skip
        System.out.print("Enter the number of soldiers to skip: ");
        skip = in.nextInt();
        System.out.println("Survivor:" + josephus(skip, numPeople));

    }

    public static int josephus(int skip, int numPeople) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int targetIndex;
        targetIndex = skip;
        for (int count = 1; count <= numPeople; count++) {
            list.add(count);
        }

        int survivor = 0;
        while (list.size() > 1) {
            list.remove(targetIndex);
            if (list.size() > 1) {
                targetIndex = (targetIndex + skip) % list.size();
            } else if (list.size() == 1) {
                targetIndex = (targetIndex + skip) % list.size();
                survivor = list.get(targetIndex);
            }
        }
        return survivor;
    }
}
