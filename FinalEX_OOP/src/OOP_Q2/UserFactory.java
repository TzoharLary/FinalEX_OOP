package OOP_Q2;

public class UserFactory {
    public SystemUser createUser(String name, String email, String password, boolean isStudent, boolean isTA) {
        SystemUser user = null;
        if (isStudent) {
            user = new Student(name, email, password);
        } else if (isTA) {
            user = new TA(name, email, password);
        } else {
            user = new Lecturer(name, email, password);
        }
        RegistrationSystem.get().registerUser(user);
        return user;
    }
}
