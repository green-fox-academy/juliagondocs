package Cloneable;

public class Person {
    String name;
    int age;
    String gender;

    public void introduce() {
        System.out.println("Hi, I'm " + this.name + ", a " + this.age + " year old " + this.gender + ".");
    }

    public void getGoal() {
        System.out.println("My goal is: Live for the moment!");
    }

    public Person(String name, int age, String gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }
    public Person (){
        this.name = "Jane Doe";
        this.age = 30;
        this.gender = "female";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

