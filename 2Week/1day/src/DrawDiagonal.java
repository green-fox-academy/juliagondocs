import java.util.Scanner;

public class DrawDiagonal {
    public static void main ( String [] args) {
        // Write a program that reads a number from the standard input, then draws a
        // square like this:
        //
        //
        // %%%%%
        // %%  %
        // % % %
        // %  %%
        // %%%%%
        //
        // The square should have as many lines as the number was
        Scanner scanner = new Scanner(System.in);
        int userInput1 = scanner.nextInt();
        for(int i=1;i<=userInput1;i++) {
            if (i==1 || i== userInput1) {
               for(int k=0;k<=userInput1;k++) {
                   System.out.print("%");
               }
                System.out.println("");
           } else {
               System.out.print("%");
                   for(int j = 0; j <= userInput1-2; j++) {
                       if(j==i-1){
                           System.out.print("%");
                       } else{
                           System.out.print(" ");
                       }
                   }
               System.out.print("%");
               System.out.println();
           }

        }

    }
}
