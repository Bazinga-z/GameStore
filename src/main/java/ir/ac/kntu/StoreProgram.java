
package ir.ac.kntu;

import java.util.Scanner;

public class StoreProgram {

    enum LogInOption {
        ADMIN, USER
    }

    enum UserLogInOption {
        SIGN_IN, SIGN_UP, BACK
    }

    enum AdminLogInOption {
        SIGN_IN, BACK
    }

    public static void main(String[] args) {

        LogInOption logInOption;
        UserLogInOption userLogInOption = UserLogInOption.SIGN_IN;
        AdminLogInOption adminLogInOption = AdminLogInOption.SIGN_IN;
        Store store = new Store(new Admin(), "FariborzGameStore");
        Scanner scanner = new Scanner(System.in);
        printTheLogInOption();
        logInOption = getLogInOption(scanner);

        while (true) {
            store = handleTheLogInOption(scanner, store, logInOption, userLogInOption, adminLogInOption);
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
            UserLogInOption userLogInOption, AdminLogInOption adminLogInOption) {
        switch (logInOption) {
            case ADMIN:
                handleTheAdminLogInProcess(scanner, adminLogInOption, store, logInOption, userLogInOption);
                break;
            case USER:
                handleTheUserLogInProcess(scanner, adminLogInOption, store, logInOption, userLogInOption);
                break;
            default:
                break;
        }
        return store;
    }

    private static AdminLogInOption getAdminLogInOption(Scanner scanner) {
        AdminLogInOption[] adminLogInOptions = AdminLogInOption.values();
        int adminLogInInput = scanner.nextInt();
        scanner.nextLine();
        adminLogInInput--;
        if (adminLogInInput >= 0 && adminLogInInput < adminLogInOptions.length) {
            return adminLogInOptions[adminLogInInput];
        }
        return null;
    }

    private static void printTheAdminLogInOption() {
        System.out.println("Please select your choice: ");
        System.out.println("1)sign in");
        System.out.println("2)back");
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
        System.out.println("Please enter your username");
        String adminUsername = scanner.nextLine();
        System.out.println("Your username is: " + adminUsername);
        System.out.println("Please enter your password");
        String adminPassword = scanner.nextLine();
        System.out.println("your password is: " + adminPassword);

        if (store.areYouTheAdmin(adminUsername, adminPassword)) {
            System.out.println("You have been successfully entered!");
            AdminMenu adminMenu = new AdminMenu();
            adminMenu.handleTheAdminMenuChoice(scanner,store);
        } else {
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
        System.out.println("3)back");
    }

    public static void printTheAdminLogInformation(Scanner scanner) {
        System.out.println("Please enter your username");
        scanner.nextLine();
        String adminUsername = scanner.nextLine();
        System.out.println("Please enter your password");
        String adminPassword = scanner.nextLine();
    }

    public static void handleTheAdminLogInProcess(Scanner scanner, AdminLogInOption adminLogInOption, Store store,
            LogInOption logInOption, UserLogInOption userLogInOption) {
        printTheAdminLogInOption();
        adminLogInOption = getAdminLogInOption(scanner);
        switch (adminLogInOption) {
            case SIGN_IN:
                getAdminInfo(scanner, store);
                break;
            case BACK:
                printTheLogInOption();
                logInOption = getLogInOption(scanner);
                handleTheLogInOption(scanner, store, logInOption, userLogInOption, adminLogInOption);
                break;
            default:
                break;
        }
    }

    public static void handleTheUserLogInProcess(Scanner scanner, AdminLogInOption adminLogInOption, Store store,
            LogInOption logInOption, UserLogInOption userLogInOption) {
        printTheUserLogInOption();
        userLogInOption = getUserLogInOption(scanner);
        switch (userLogInOption) {
            case SIGN_IN:
                getUser(scanner, store);
                break;

            case SIGN_UP:
                addUser(scanner, store);
                break;

            case BACK:
                printTheLogInOption();
                logInOption = getLogInOption(scanner);
                handleTheLogInOption(scanner, store, logInOption, userLogInOption, adminLogInOption);
            default:
                break;
        }
    }

    public static void addUser(Scanner scanner, Store store) {
        if (store == null) {
            System.out.println("Define store first!");
        } else {
            System.out.println("Please enter the username of user");
            String username = scanner.nextLine();

            while (store.ifUsernameIsTaken(username)) {
                System.out.println("this username is taken!");
                System.out.println("please choose another username");
                username = scanner.nextLine();
            }
            System.out.println("username is: " + username);
            System.out.println("Please enter the password of user");
            String password = scanner.nextLine();
            while (!passwordIsChosenCorrectly(password)) {
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
            UserMenu userMenu = new UserMenu(user);
            userMenu.getMenuOfUser(scanner, store, store.getGames());
        }
    }

    public static void getUser(Scanner scanner, Store store) {
        if (store == null) {
            System.out.println("Define store first!");
        } else {
            System.out.println("Please enter username");
            String username = scanner.nextLine();
            System.out.println("Please enter password");
            String password = scanner.nextLine();

            if (store.getUser(username, password) != null) {
                UserMenu userMenu = new UserMenu(store.getUser(username, password));
                userMenu.getMenuOfUser(scanner, store, store.getGames());
            } else {
                System.out.println("A user with this username and password not found.");
                handleTheUserLogInProcess(scanner, AdminLogInOption.SIGN_IN, store, LogInOption.USER,
                        UserLogInOption.SIGN_IN);
            }
        }
    }

    public static boolean passwordIsChosenCorrectly(String password) {
        if (password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$")) {
            return true;
        } else {
            return false;
        }
    }
}