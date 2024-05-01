package OOP_Q2;

public class SystemUser {

    private String name;
    final private String email;

    public SystemUser(String name, String email, String password) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }
    public boolean equals(SystemUser user) {
        return this.email.equals(user.email);
    }

    public int hashCode() {
        return email.hashCode();
    }
}
