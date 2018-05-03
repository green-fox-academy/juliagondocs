public class Dog {
    // properties, attributes, filed, mezo
    // classban definiált : globális változó, mindenhol a classban definiálva van
    // változók hatásköre {}
    //
    static int idCounter = 0; // kutya osztályra vonatkozó tulajdonság -> osztályra vonatkozó érték
    static int legs = 4; // az összes kutyára igaz változó
    static final boolean isMammals = true; // ezt soha többé nem lehet felülírni --> konstansok

    String breed;
    String color;
    int age;
    String name;
    int id = 0;
    boolean hasOwner;

    // több konstruktort is létre tudok hozni -> a bekérendő adatok száma és típusa különbözik
    // a konstruktornak nincs visszatérési értéke
    // default konstruktor: nincs paramétere
    // automatikusan létrejön az osztályból
    // Alt+Insert --> konstruktor könnyű beszúrása
    public Dog(String breed, String color, String name, int age) { // legspecifikusabb konstruktor
        this.breed = breed;
        this.color = color; // ha nincs nevütközés nem feltétlenül kell a this -> hívhatnám a bejövő colort c-nek, ekkor color=c
        this.name = name;
        this.age = age;
        this.id = ++idCounter;
    }

    // default konstruktor
    public Dog() {
        //this.name = "Morzsi";
        // tudok konstruktorban konstruktort hívni
        this("unknown", "unknown", "unkown", 0);
        this.id = ++idCounter;
    }

    public Dog(String breed, String color) {
        this(breed, color, "Morzsi", 0); // ez az elso sorban kell h történjen
        this.color = color;
        this.breed = breed;
        this.name = "Morzsi"; // de name="Morzsi" val is működik
        this.id = ++idCounter;
    }

    public void vau() {
        System.out.println("vau vau vauuuuu   " + this.name);
    }

    // felülírtuk az equals-t
    @Override
    public boolean equals(Object otherDog) {
        return this.name.equals(((Dog) otherDog).name)
                && this.color.equals(((Dog) otherDog).color)
                && this.breed.equals(((Dog) otherDog).breed);
    }

    @Override
    public String toString() {
        return "Dog | id=" + this.id + " | " + this.name;
    }
}
