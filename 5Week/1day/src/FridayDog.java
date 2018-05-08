public class FridayDog  extends Object {
    // final classt nem lehet extendelni
    // filedek -> konstruktorok -> methodok
    private String name;
    private String breed;
    private int age;
    private boolean hasOwner;

    public FridayDog() {

    }
    public FridayDog(String name, String breed, int age, boolean hasOwner) {
        // ALT+insert -> konstruktor sorrendje
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.hasOwner = hasOwner;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public boolean isHasOwner() {
        return hasOwner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHasOwner(boolean hasOwner) {
        this.hasOwner = hasOwner;
    }

    @Override
    public String toString() {
        return "FridayDog{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                ", hasOwner=" + hasOwner +
                '}';
    }

    @Override
    public int hashCode() {
        return 2;
    }
}
