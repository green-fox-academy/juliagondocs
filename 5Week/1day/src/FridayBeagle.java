public class FridayBeagle extends FridayDog {
    boolean toBeCute;

    public FridayBeagle(String name, String breed, int age, boolean hasOwner, boolean toBeCute) {
        super(name, breed, age, hasOwner);
        this.toBeCute = toBeCute;
    }

    @Override
    public String toString() {
        return "FridayBeagle{" +
                "toBeCute=" + toBeCute + ' '
                + super.toString() +
                '}';
    }

    public boolean isToBeCute() {
        return toBeCute;
    }

    public void setToBeCute(boolean toBeCute) {
        this.toBeCute = toBeCute;
    }
}
