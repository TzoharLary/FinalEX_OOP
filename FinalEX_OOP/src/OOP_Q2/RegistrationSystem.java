package OOP_Q2;

import java.util.Set;

public class RegistrationSystem {
    private final static RegistrationSystem rs = new RegistrationSystem();

    private final static int MAX_USERS = 100;

    private final UsersDB usersDB = new UsersDB(MAX_USERS);
    private final CoursesDB coursesDB = new CoursesDB();

    private RegistrationSystem() {

    }

    public static RegistrationSystem get() {
        return rs;
    }

    public SystemUser registerUser(SystemUser user) {
        rs.usersDB.addUser(user);
        return user;
    }

    public void RegisterUserToCourse(Student user, Course course) {
        StudentObserver so = rs.coursesDB.addUserToCourse(user, course);
        if (so != null) {
            return;
        }
        rs.usersDB.addCourseToUser(user, course);
    }

    public void addCourse(Course course, Teacherable teacher) {
        rs.coursesDB.addCourse(course);
    }

    public Set<Course> getCoursesForUser(Student student) {
        return rs.usersDB.getCoursesForUser(student);
    }

    public void removeUserFromCourse(Student user, Course course) {
        rs.coursesDB.removeUserFromCourse(user, course);
    }
}


