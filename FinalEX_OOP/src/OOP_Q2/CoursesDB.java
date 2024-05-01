package OOP_Q2;

import java.util.*;

public class CoursesDB {
    Set<Course> courses = new HashSet<Course>();
    Map<Course, Set<Student>> courseToStudent = new HashMap<>();
    Map<Course, Stack<StudentObserver>> courseToObserver = new HashMap<>();
    public void addCourse(Course course) {
        if (courses.contains(course)) {
            return;
        }
        courses.add(course);
        courseToStudent.put(course, new HashSet<Student>());
        courseToObserver.put(course, new Stack<StudentObserver>());
    }

    public StudentObserver addUserToCourse(Student user, Course course) {
        if (courseToStudent.get(course).size() < course.getMaxStudents()) {
            courseToStudent.get(course).add((Student) user);
            return null;
        }
        else {
            StudentObserver so = new StudentObserver( user, course);
            courseToObserver.get(course).push(so);
            return so;
        }
    }

    public void removeUserFromCourse(Student user, Course course) {
        courseToStudent.get(course).remove(user);
        if (courseToStudent.get(course).size() < course.getMaxStudents()) {
            if (!courseToObserver.get(course).isEmpty()) {
                StudentObserver so = courseToObserver.get(course).pop();
                so.update();
            }
        }

    }
}
