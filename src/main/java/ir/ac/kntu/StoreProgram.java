
package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class StoreProgram extends CheckPMDTest {

    enum LogInOption {
        ADMIN, USER;
    }

    enum UserLogInOption {
        SIGN_IN, SIGN_UP;
    }

    public static void main(String[] args) {

        LogInOption logInOption;
        UserLogInOption userLogInOption = UserLogInOption.SIGN_IN;
        Store store = new Store(new Admin(), "FariborzGameStore");
        Scanner scanner = new Scanner(System.in);
        printTheLogInOption();
        logInOption = getLogInOption(scanner);

        while (true) {
            store = handleTheLogInOption(scanner, store, logInOption, userLogInOption);
            System.out.println(store);
            printTheLogInOption();
            logInOption = getLogInOption(scanner);
        }
    }

    public static LogInOption getLogInOption(Scanner scanner) {
        LogInOption[] logInOption = LogInOption.values();
        int logInInput = scanner.nextInt();
        scanner.nextLine();
        logInInput--;
        if (logInInput >= 0 && logInInput < logInOption.length) {
            return logInOption[logInInput];
        }
        return null;
    }

    public static Store handleTheLogInOption(Scanner scanner, Store store, LogInOption logInOption,
            UserLogInOption userLogInOption) {
        switch (logInOption) {
            case ADMIN:
                getAdminInfo(scanner,store);
                break;
            case USER:
                printTheUserLogInOption();
                userLogInOption = getUserLogInOption(scanner);
                switch (userLogInOption) {
                    case SIGN_IN:
                        getUser(scanner, store);
                        break;

                    case SIGN_UP:
                        addUser(scanner, store);
                        break;
                }
                break;

        }
        return store;
    }

    public static UserLogInOption getUserLogInOption(Scanner scanner) {
        UserLogInOption[] userLogInOption = UserLogInOption.values();
        int userLogInInput = scanner.nextInt();
        scanner.nextLine();
        userLogInInput--;
        if (userLogInInput >= 0 && userLogInInput < userLogInOption.length) {
            return userLogInOption[userLogInInput];
        }
        return null;
    }

    public static void getAdminInfo(Scanner scanner, Store store) {

        // printTheAdminLogInOption(scanner);
        System.out.println("Please enter your username");
        String adminUsername = scanner.nextLine();
        System.out.println("Your username is: " + adminUsername);
        System.out.println("Please enter your password");
        String adminPassword = scanner.nextLine();
        System.out.println("your password is: " + adminPassword);

        if(store.areYouTheAdmin(adminUsername,adminPassword)){
            System.out.println("You have been successfully entered!");
            System.out.println(store.getAdmin());
        }
         else {
            System.out.println("Wrong username or password!");
        }
    }

    public static void printTheLogInOption() {
        System.out.println("Welcome.please select your roll");
        System.out.println("1)Admin");
        System.out.println("2)User");
    }

    public static void printTheUserLogInOption() {
        System.out.println("Please select your choice: ");
        System.out.println("1)sign in");
        System.out.println("2)sign up");
    }

    public static void printTheAdminLogInOption(Scanner scanner) {
        System.out.println("Please enter your username");
        scanner.nextLine();
        String adminUsername = scanner.nextLine();
        System.out.println("Please enter your password");
        String adminPassword = scanner.nextLine();
    }

    public static void addUser(Scanner scanner, Store store) {
        if (store == null) {
            System.out.println("Define store first!");
        } else {
            // String username, password, email, phoneNumber;
            System.out.println("Please enter the username of user");
            String username = scanner.nextLine();

            while(store.ifUsernameIsTaken(username)){
                System.out.println("this username is taken!");
                System.out.println("please choose another username");
                username = scanner.nextLine();
            }
            System.out.println("username is: " + username);
            System.out.println("Please enter the password of user");
            String password = scanner.nextLine();
            while(!passwordIsChosenCorrectly(password)){
                System.out.println("Password must have 8 char at least and contains digit, lower and upper alphabet");
                System.out.println("please change your password");
                password = scanner.nextLine();
            }
            System.out.println("Please enter the email of user");
            String email = scanner.nextLine();
            System.out.println("Please enter the phone-number of user");
            String phoneNumber = scanner.nextLine();
            User user = new User(username, password, email, phoneNumber);
            store.addUser(user);
            System.out.println(store.getUser(username,password));
            UserMenu userMenu = new UserMenu(user);
            userMenu.getMenuOfUser(store.getUser(username,password),scanner);

            /* if (store.addUser(user)) {
                if(password.matches("(\\d[A-Z][a-z]){8,}"))
                System.out.println("User successfully added!");
                else{

                }
            } else {
                System.out.println("this username is taken!");
            */}


    }

    public static void getUser(Scanner scanner, Store store) {
        if (store == null) {
            System.out.println("Define store first!");
        } else {
            System.out.println("Please enter username");
            String username = scanner.nextLine();
            System.out.println(username);
            System.out.println("Please enter password");
            String password = scanner.nextLine();
            System.out.println(password);
            //System.out.println(store.getUserMenu(username,password));
            System.out.println(store.getUser(username,password));
            if(store.getUser(username,password) != null){
                UserMenu userMenu = new UserMenu(store.getUser(username,password));
                userMenu.getMenuOfUser(store.getUser(username,password), scanner);
            }

        }
    }

    public static boolean passwordIsChosenCorrectly(String password){
        if(password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$")){
            return true;
        }
        else return false;
    }
}