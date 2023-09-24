package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class User {
    private Wallet wallet;

    private ArrayList<Game> library;

    private ArrayList<User> friends;

    private String username;

    private String password;

    private String email;

    private String phoneNumber;

    private ArrayList<User> requests;

    public User(Wallet wallet, ArrayList<Game> library, ArrayList<User> friends, String username, String password,
            String email, String phoneNumber) {
        this.wallet = wallet;
        this.library = library;
        this.friends = friends;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User(String username, String email, String phoneNumber) {
        this.username = username;
        this.library = new ArrayList<>();
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.requests = new ArrayList<>();
    }

    public User(String username, String password, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.wallet = new Wallet(0);
        this.library = new ArrayList<>();
        this.friends = new ArrayList<>();
        this.requests = new ArrayList<>();
    }

    public User(String username, String password, UserMenu userMenu) {
        this.username = username;
        this.password = password;
        this.username = username;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public ArrayList<Game> getLibrary() {
        return library;
    }

    public void setLibrary() {
        this.library = new ArrayList<>();
    }

    public void addGameToTheLibrary(Game game) {
        this.library.add(game);
    }

    public ArrayList<User> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<User> friends) {
        this.friends = friends;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(Scanner scanner) {
        System.out.println("Please enter your new username: ");
        String username = scanner.next();
        while (Store.ifUsernameIsTaken(username)) {
            System.out.println("this username is taken!");
            System.out.println("please choose another username");
            username = scanner.nextLine();
        }
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(Scanner scanner) {
        System.out.println("please enter your new password: ");
        String password = scanner.next();
        while (!StoreProgram.passwordIsChosenCorrectly(password)) {
            System.out.println("Password must have 8 char at least and contains digit, lower and upper alphabet");
            System.out.println("please change your password");
            password = scanner.nextLine();
        }
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(Scanner scanner) {
        System.out.println("Please enter your new Email: ");
        String email = scanner.next();
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Scanner scanner) {
        System.out.println("Please enter your new Phone-Number: ");
        String phoneNumber = scanner.next();
        this.phoneNumber = phoneNumber;
    }

    public void setWallet(Scanner scanner) {
        System.out.println("How much do you want to charge your wallet?");
        double deposit = scanner.nextDouble();
        this.wallet.deposit(deposit);
    }

    public void addFriend(User userWeWantToFollow) {
        friends.add(userWeWantToFollow);
    }

    public static ArrayList<User> testFriends() {
        ArrayList<User> testFriends = new ArrayList<>();
        testFriends.add(new User("Mahdi", "gmail.com", "0912"));
        testFriends.add(new User("Fatemeh", "fatemeh.com", "02222"));
        testFriends.add(new User("sara", "sara.com", "09090909"));
        testFriends.add(new User("Malihe", "lplp.com", "01212121"));
        return testFriends;
    }

    public ArrayList<User> getRequests() {
        return requests;
    }

    public void addRequests(User theFollower) {
        requests.add(theFollower);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        // return wallet == user.wallet && Objects.equals(library, user.library) &&
        // Objects.equals(friends, user.friends) && Objects.equals(username,
        // user.username) && Objects.equals(password, user.password) &&
        // Objects.equals(email, user.email) && Objects.equals(phoneNumber,
        // user.phoneNumber);
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "Username of the user is " + username + " and the password of the user is: " + password;
    }
}
