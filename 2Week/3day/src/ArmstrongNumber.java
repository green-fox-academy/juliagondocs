import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputNumber = scanner.nextLine();
        int inputNumberAsInt = Integer.parseInt(inputNumber);
        
        String[] inputStringArray = inputNumber.split("");
        int[] inputIntegerArray = new int[inputStringArray.length];
        for (int i = 0; i < inputStringArray.length; i++) {
            inputIntegerArray[i] = Integer.parseInt(inputStringArray[i]);
        }

        int armstrongNumber = 0;
        for (int i = 0; i < inputStringArray.length; i++) {
            armstrongNumber += (int) Math.pow(inputIntegerArray[i], inputIntegerArray.length);
            //System.out.println(armstrongNumber);
        }

        if (armstrongNumber == inputNumberAsInt) {
            System.out.println(" This is an Armstrong number : " + armstrongNumber + " .");
        } else {
            System.out.println("This is not az Armstrong number.");
        }
    }
}
