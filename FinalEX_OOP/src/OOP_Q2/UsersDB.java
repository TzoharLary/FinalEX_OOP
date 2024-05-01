package OOP_Q2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class UsersDB {
    int maxUsers;
    int usersCount = 0;

    Set<SystemUser> users = new HashSet<SystemUser>();
    Map<SystemUser, Set<Course>> userToCourse = new HashMap<SystemUser, Set<Course>>();

    public UsersDB(int maxUsers) {
        this.maxUsers = maxUsers;
    }

    public void addUser(SystemUser user) {
        if (usersCount < maxUsers) {
            usersCount++;
        }
        else {
            System.out.println("Max users reached");
            return;
        }
        users.add(user);
        userToCourse.put(user, new HashSet<Course>());
    }

    public void addCourseToUser(SystemUser user, Course course) {
        userToCourse.get(user).add(course);
    }

    public Set<Course> getCoursesForUser(SystemUser user) {
        return userToCourse.get(user);
    }
}
