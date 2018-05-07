public class Main {
    public static void main(String[] args) {
        Flower yellow = new Flower("yellow");
        Flower blue = new Flower("blue");
        Tree purple = new Tree("purple");
        Tree orange = new Tree("orange");

        Garden myGarden = new Garden();

        myGarden.addPlants(yellow);
        myGarden.addPlants(blue);
        myGarden.addPlants(purple);
        myGarden.addPlants(orange);

        myGarden.waterAmountInfo();
        System.out.println("");

        myGarden.waterGarden(40);
        System.out.println("");

        myGarden.waterGarden(70);
        System.out.println("");
    }
}