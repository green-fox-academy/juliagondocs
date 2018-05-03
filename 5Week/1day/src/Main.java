public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog(); // osztályban lévő szabály alapján létrehoztunk egy kutya példányt
        dog1.breed = "swiss sheperd";
        dog1.color = "white";
        dog1.name = "Furkesz";
        dog1.age = 2;
        // új kutyat letrehozunk
        Dog dog2 = new Dog();
        dog2.breed = "nemet juhasz";
        dog2.color = "brown";
        dog2.name = "Trincsi";
        dog2.age = 2;
        // negyedik kutya
        Dog dog4 = new Dog("mix", "black", "Manó", 1);
        // ötödik
        Dog dog5 = new Dog("mix", "brown"); // ennek Morzsi lesz a neve

        // ----------------------------------------------------------------
        // Feltöltöttük a menhelyet
        Shelter shelter = new Shelter();
        shelter.dogs.add(dog1); // Shelter osztályban lévő dogs listához adjunk hozzá elemeket
        shelter.dogs.add(dog2); // hozzáadogatom
        shelter.dogs.add(dog4); // hozzáadogatom a shelter dogs filed-jéhez a dog példányokat
        shelter.dogs.add(dog5);
        System.out.println(shelter.dogs.get(0).name);
        System.out.println(shelter.dogs.get(1).color);
        System.out.println(shelter.dogs.get(2).name);
        System.out.println(shelter.dogs.get(3).breed);
        //-----------------------------------------------------------------
        // Kell egy ember, aki örökbe tudja fogadni
        Person jozsi = new Person("Józsi", 50);

        jozsi.dog = shelter.dogs.get(0); // a menhelyen lévő kutyák listájából az egyes
        System.out.println(jozsi.dog.name + ": ő Józsi kutyája"); // ez józsi kutyájának a neve
        shelter.adopt(jozsi, 0);
        dog2.vau();
        System.out.println(dog2);
    }
}
