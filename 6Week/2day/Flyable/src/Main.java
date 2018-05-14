public class Main {
    public static void main(String[] args) {

        Vehicle helicopter = new Helicopter("Bell 206");

        Animal bird = new Bird("Toucan");

        System.out.println(bird.name);
        ((Bird) bird).takeOff();
        ((Bird) bird).fly();
        ((Bird) bird).land();
        System.out.println("-----------------");

        System.out.println(helicopter.toString());
        System.out.println(helicopter.type);
        System.out.println(helicopter.getClass().getSimpleName());
        ((Helicopter) helicopter).takeOff();
        ((Helicopter) helicopter).fly();
        ((Helicopter) helicopter).land();
    }
}