public class Student {

    public void learn() {
        System.out.println("im am suffering");
    }

    public void question(Teacher teacher) {
        System.out.println(" I have a question");
        teacher.answer();
    }

    public static void main(String[] args) {
        Student student = new Student();
        Teacher teacher = new Teacher();
        student.question(teacher);
    }
}
