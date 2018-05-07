public class Student extends Person {
    String previousOrganization;
    int skippedDays;

    @Override
    public void getGoal() {
        System.out.println("Be a junior software developer.");
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.println("I am from" + this.previousOrganization + " who skipped " + this.skippedDays + "days from the course already");
    }

    public void skipDays(int numberOfDays) {
        this.skippedDays += numberOfDays;
    }

    public Student(String name, int age, String gender, String previousOrganization) {
        super(name, age, gender);
        this.skippedDays = 0;
    }

    public Student() {
        //this.name ="Jane Doe";
        //this.age = 30;
        //this.gender = "female";
        super();
        this.previousOrganization = "The School of Life";
        this.skippedDays = 0;
    }
}
