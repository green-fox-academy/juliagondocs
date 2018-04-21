public class Cuboid {
    public static void main(String[] args) {
        // Write a program that stores 3 sides of a cuboid as variables (doubles)
        // The program should write the surface area and volume of the cuboid like:
        //
        // Surface Area: 600
        // Volume: 1000
        double a = 10.1;
        double b = 20.4;
        double c = 33.3;

        double surface = 2*(a*b + b*c + a*c);
        double volume = a * b * c;
        System.out.println("Surface:"+surface);
        System.out.println("Volume:"+volume);


        }

    }
}
