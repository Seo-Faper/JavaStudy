package ch13.sec05;

public class GenericExample {
    public static void main(String[] args) {
        Course.registerCourse1(new Applicant<Person>(new Person()));
        Course.registerCourse1(new Applicant<Worker>(new Worker()));
        Course.registerCourse1(new Applicant<Student>(new Student()));
        System.out.println();

        Course.registerCourse2(new Applicant<Student>(new Student()));
    }
}
