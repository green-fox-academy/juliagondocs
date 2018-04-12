public class SecondInADay {
    public static void main(String[] args) {
        int currentHours = 14;
        int currentMinutes = 34;
        int currentSeconds = 42;

        // Write a program that prints the remaining seconds (as an integer) from a
        // day if the current time is represented by the variables
        // out: seconds -> sum
        int secondInMinutes =60;
        int secondInHours = 60*60;


        int remainingSecond = (currentSeconds) + (currentMinutes * secondInMinutes) + (currentHours * secondInHours);
        System.out.println(remainingSecond + " seconds");
    }
}