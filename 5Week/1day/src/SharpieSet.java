import java.util.ArrayList;
import java.util.List;

public class SharpieSet {
    List<Sharpie> sharpies;

    public SharpieSet() {
        this.sharpies = new ArrayList<>();
    }

    public void add(Sharpie sharpie) {
        sharpies.add(sharpie);
    }

    public Sharpie get(int index) {
        return sharpies.get(index);
    }

    public int countUsable() {
        int counter = 0;
        for (int i = 0; i < sharpies.size(); i++) {
            if (sharpies.get(i).inkAmount > 0) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        SharpieSet set = new SharpieSet();
        set.add(new Sharpie("red", 20));
        set.add(new Sharpie("blue", 20));
        set.add(new Sharpie("green", 20));
        System.out.println(set.countUsable());
        for (int i = 0; i < 10; i++) {
            set.get(2).use();
        }
        System.out.println(set.countUsable());

    }

}
