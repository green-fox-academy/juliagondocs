import java.util.ArrayList;
import java.util.List;

public class Shelter {
    String name;
    List<Dog> dogs;

    public Shelter() {
        dogs = new ArrayList<>();
    } // konstruktornál inicializáljuk a listát a kutyákkal

    public void adopt(Person person, int index) {
        person.dog = dogs.get(index);
        dogs.get(index).hasOwner = true; // az ebben az osztályban lévő kutya objektumok listája: dogs
        // mivel a kutya osztálynak van hasOwner attribútuma, ezért azt átállítom
        dogs.remove(index);
    }

}
