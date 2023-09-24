package ir.ac.kntu;

import java.util.Objects;

public class Admin {
    private static String username;

    private static String password;

    public Admin() {
        username = "Maryam";
        password = "1234";
    }

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    @Override
    public int hashCode() {

        return Objects.hash(username) + Objects.hash(password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        Admin admin = (Admin) o;
        return username.equals(admin.username) && password.equals(admin.password);
    }

    @Override
    public String toString() {
        return "Admin{username: " + username + " password: " + password + "}";
    }
}
