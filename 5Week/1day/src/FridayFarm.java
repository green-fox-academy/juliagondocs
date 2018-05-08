import java.util.ArrayList;
import java.util.List;

public class FridayFarm {
    private List<FridayDog> dogs;

    public FridayFarm() {
        this.dogs = new ArrayList<>();
        this.dogs.add(new FridayDog("Csöpi", "Nemet juhasz", 5,true));
        this.dogs.add(new FridayBeagle("Turbo", "Nemet juhasz", 5,true,true));
    }

    public ArrayList<String> dogsDetails() {
        List<String> details = new ArrayList<>();
        for (FridayDog actualDog : dogs) {
            details.add(actualDog.toString());
        }
        return (ArrayList<String>) details;
    }

    public ArrayList<String> beaglesDetails () {
        ArrayList<String> details = new ArrayList<>();
        for (FridayDog actualDog : dogs ) {
            if ( actualDog instanceof FridayBeagle ) {
                details.add(actualDog.toString());
            }
        }
        return details;
    }

    public static void main(String[] args) {
        FridayFarm farm = new FridayFarm();
        farm.dogsDetails()
                .forEach(System.out::println);

    }
}
