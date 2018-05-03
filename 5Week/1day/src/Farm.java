import java.util.ArrayList;
import java.util.List;

public class Farm {
    static int freePlaces;
    int capacity = 3;

    List<Animal> listOfAnimals;

    public Farm() {
        this.listOfAnimals = new ArrayList<>();
    }

    public void breed() {
        if (this.listOfAnimals.size() < this.capacity) {
            int hunger = (int) Math.random() * 50;
            int thirst = (int) Math.random() * 50;
            listOfAnimals.add(new Animal(hunger, thirst));
        } else {
            System.out.println("There is no more place");
        }
    }

    public int getSize() {
        return this.listOfAnimals.size();
    }

    public void slaughter() {
        int mini = 100;
        int position = 0;
        for (int i = 0; i < listOfAnimals.size(); i++) {
            if (listOfAnimals.get(i).thirst < mini) {
                position = i;
            }
        }
        listOfAnimals.remove(position);
    }

    public static void main(String[] args) {
        Farm farm = new Farm();
        farm.breed();
        farm.breed();
        farm.breed();
        System.out.println(farm.getSize());
        farm.breed();

        farm.slaughter();
        System.out.println(farm.getSize());

    }
}
