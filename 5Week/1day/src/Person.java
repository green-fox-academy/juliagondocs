public class Person {
    String name;
    int age;
    Dog dog;  // alapérték null, van egy Dog osztályhoz tartozó kutyája, vagy persze null

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
