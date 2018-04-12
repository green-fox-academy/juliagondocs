import java.util.Scanner;

public class ParamtericAverage {
    public static void main (String [] args) {
        // Write a program that asks for a number.
        // It would ask this many times to enter an integer,
        // if all the integers are entered, it should print the sum and average of these
        // integers like:
        //
        // Sum: 22, Average: 4.4
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int a=0;
        int sum=0;
        while (a<length) {
            int userinput = scanner.nextInt();
            a+=1;
            sum=sum+userinput;
        }
        System.out.println("Sum: "+sum+" , Average: " + sum/(float)length);
    }
}
