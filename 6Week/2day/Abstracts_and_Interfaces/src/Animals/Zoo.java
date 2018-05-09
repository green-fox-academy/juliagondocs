package Animals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Zoo  {
    private ArrayList<Animal> animals;

    public Zoo() {
        animals = new ArrayList<>();
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.animals.add(new Sparrow("papi",2));
        zoo.animals.add(new Cat("cati",4));
        zoo.animals.add(new Dog("dogi",4));
        zoo.animals.add(new Dog("Csuszi Ká",0));

        for (Animal currentanimal: zoo.animals ) {
            System.out.println(currentanimal.toString());
        }

        //zoo.animals.sort(Animal::compareTo);
        Collections.sort(zoo.animals);
        System.out.println("-------");

        for (Animal currentanimal: zoo.animals ) {
            System.out.println(currentanimal.toString());
        }

        Collections.sort(zoo.animals, new AnimalComparator());

        System.out.println("-------------------");

        for (Animal currentAnimal: zoo.animals) {
            System.out.println(currentAnimal.toString());
        }
    }


}
