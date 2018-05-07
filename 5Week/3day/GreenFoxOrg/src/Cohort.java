import java.util.ArrayList;
import java.util.List;

public class Cohort {
    private String name;
    List<Student> students;
    List<Mentor> mentors;

    public Cohort() {
    }

    public Cohort(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.mentors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addStudent(Student student){
        students.add(student);
    }
    public void addMentor(Mentor mentor){
        mentors.add(mentor);
    }
    public void info(){
        System.out.println("The " + this.name + " cohort has " + students.size() + " students and " + mentors.size() + " mentors.");
    }
}