package ir.ac.kntu;

import java.util.ArrayList;

public class Store {

    private ArrayList<Game> games;

    private Admin admin;

    private static ArrayList<User> users;

    private String name;

    public Store(Admin admin, String name) {
        this.name = name;
        this.admin = admin;
        users = new ArrayList<>();
        games = Game.testGames();
    }

    public void addUser(User user) {
        // if (!users.contains(user)){
        users.add(user);
        System.out.println("welcome to the " + getName() + ". You are successfully signed up.");
        // return true;
        // }
        // return false;
    }

    public static boolean ifUsernameIsTaken(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public User getUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public boolean addGame(Game game) {
        if (!games.contains(game)) {
            games.add(game);
            return true;
        }
        return false;
    }

    public boolean areYouTheAdmin(String username, String password) {
        if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public Admin getAdmin() {
        return admin;
    }

    public String getName() {
        return name;
    }

    // public Game getGame()

    public ArrayList<Game> getGames() {
        return games;
    }

    public Store aCopyOfStore(Store store) {
        Store copyStore = new Store(new Admin(), "FariborzGameStore");
        ;
        for (User user : store.getUsers()) {
            copyStore.addUser(user);
        }
        return copyStore;
    }

    @Override
    public String toString() {
        return "Name of the store is: " + name + " and the users are: " + users;
    }
}
