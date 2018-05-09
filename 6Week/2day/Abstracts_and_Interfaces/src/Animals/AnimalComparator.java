package Animals;

import java.util.Comparator;

class AnimalComparator implements Comparator<Animal> {

    @Override
    public int compare(Animal animal1, Animal animal2) {
        return animal2.getName().compareTo(animal1.getName());
    }
}
