import java.util.ArrayList;

public class Garden {
    private ArrayList<Plant> listOfPlants;

    public Garden() {
        listOfPlants = new ArrayList<>();
    }

    public void addPlants(Plant plant) {
        listOfPlants.add(plant);
    }

    // itt kell öntözni

    public void waterGarden(double waterAmount) {
        ArrayList<Integer> numberOfThirstyPlant = new ArrayList<>();
        int needWaterCounter = 0;
        for (int i = 0; i < listOfPlants.size(); i++) {
            if (listOfPlants.get(i) instanceof Flower && ((Flower) listOfPlants.get(i)).isThirsty() ||
                    listOfPlants.get(i) instanceof Tree && ((Tree) listOfPlants.get(i)).isThirsty()) {
                numberOfThirstyPlant.add(i);
                needWaterCounter++;
            }
        }
        // divide the incoming amount of water
        double waterPerPlant = waterAmount / needWaterCounter;
        for (int i = 0; i < listOfPlants.size(); i++) {
            for (int j = 0; j < numberOfThirstyPlant.size(); j++) {
                if (i == numberOfThirstyPlant.get(j) && listOfPlants.get(i) instanceof Flower) {
                    listOfPlants.get(i).setWaterLevel(waterPerPlant * Flower.absorbingPropertie);
                } else if (i == numberOfThirstyPlant.get(j) && listOfPlants.get(i) instanceof Tree) {
                    listOfPlants.get(i).setWaterLevel(waterPerPlant * Tree.absorbingPropertie);
                }
            }
        }
        waterAmountInfo();
    }

    public void waterAmountInfo() {
        for (int i = 0; i < listOfPlants.size(); i++) {
            if (listOfPlants.get(i) instanceof Flower && ((Flower) listOfPlants.get(i)).isThirsty()) {
                System.out.println("The " + listOfPlants.get(i).getColor() + " flower needs watering.");
            } else if (listOfPlants.get(i) instanceof Tree && ((Tree) listOfPlants.get(i)).isThirsty()) {
                System.out.println("The " + listOfPlants.get(i).getColor() + " tree needs watering.");
            } else if (listOfPlants.get(i) instanceof Flower) {
                System.out.println("The " + listOfPlants.get(i).getColor() + " flower doesn't need water.");
            } else {
                System.out.println("The " + listOfPlants.get(i).getColor() + " tree doesn't need water.");
            }
        }
    }


}
