public class Sponsor extends Person {
    String company;
    int hiredStudents;

    public Sponsor() {
        super();
        this.company = "Google";
        this.hiredStudents = 0;
    }


    public void introduce() {
        System.out.println("I am " + this.getName() + " a " + this.getAge() + " year old " + this.getGender()
                + " who represents " + this.company + " and hired " + this.hiredStudents + " students so far.");
    }

    public void hire() {
        this.hiredStudents += 1;
    }

    @Override
    public void getGoal() {
        System.out.println("Hire brilliant junior software developers.");
    }

    public Sponsor(String name, int age, String gender, String company) {
        super(name, age, gender);
        this.company = company;
    }
}