package OOP_Q2;

import java.util.Set;

public class Student extends SystemUser {
    public Student(String name, String email, String password) {
        super(name, email, password);
    }



    static Student getUSer(String name, String email, String password) {
        return (Student) new UserFactory().createUser(name, email, password, true, false);
    }

    public void registerCourse(Course course) {
        RegistrationSystem.get().RegisterUserToCourse(this, course);
    }

    public Set<Course> getClasses() {
        return RegistrationSystem.get().getCoursesForUser(this);
    }
}
