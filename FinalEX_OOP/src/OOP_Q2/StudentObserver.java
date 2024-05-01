package OOP_Q2;

public class StudentObserver {
    Course course;
    Student student;

    public StudentObserver(Student student, Course course) {
        this.course = course;
        this.student = student;
    }

    public void update() {
        System.out.println("There is place in course " + course.getId());
    }
}

