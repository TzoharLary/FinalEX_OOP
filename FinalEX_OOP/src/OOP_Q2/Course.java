package OOP_Q2;

import java.util.HashMap;
import java.util.Map;

public class Course {
    static Map<Integer, Course> courses = new HashMap<Integer, Course>();
    String name;
    int id;
    CourseType type;
    Teacherable teacher;

    int maxStudents;

    private Course(String name, int id, CourseType type, Teacherable teacher, int maxStudents) {
        this.name = name;
        this.id = id;
        this.type = type;
        this.teacher = teacher;
        this.maxStudents = maxStudents;
    }

    public static Course getCourse(int id) {
        return courses.get(id);
    }
    public static Course getCourse(String name, int id, CourseType type, Teacherable teacher, int maxStudents) {
        if (courses.containsKey(id)) {
            System.out.println("OOP_Q2.Course already exists");
            return courses.get(id);
        }
        Course course = new Course(name, id, type, teacher, maxStudents);
        courses.put(id, course);
        return course;
    }

    public boolean equals(Course course) {
        return this.id == course.id;
    }

    public int hashCode() {
        return id;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public int getId() {
        return id;
    }
}
