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
        users = new ArrayList<User>();
        games = new ArrayList<Game>();
    }

    public void addUser(User user){
        //if (!users.contains(user)){
            users.add(user);
            //return true;
        //}
        //return false;
    }

    public static boolean ifUsernameIsTaken(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }return false;
    }

    public User getUser(String username, String password){
        for(User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("welcome to the " + getName() + ". You are successfully signed up.");
                return user;
            }
        }
        return null;
    }

    /*public UserMenu getUserMenu (String username, String password){
        for(User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return  user.getUserMenu();
            }
        }
        return null;
    }*/

    public boolean addGame(Game game){
        if(!games.contains(game)){
            games.add(game);
            return true;
        }
        return false;
    }

    public boolean areYouTheAdmin(String username, String password){
        if(admin.getUsername().equals(username) && admin.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    public Admin getAdmin(){
        return admin;
    }

    public String getName(){
        return name;
    }

    //public Game getGame()


    @Override
    public String toString() {
        return "Name of the store is: " + name + " and the users are: " + users;
    }
}
