package ir.ac.kntu;

import java.util.Scanner;

public class AdminMenu {

    enum MenuOfAdmin {
        GAMES, USERS
    }

    enum AdminGameMenu {
        ADD_GAME, CHANGE_GAME, REMOVE_GAME, BACK
    }

    enum AdminUserMenu {
        SEE_PROFILE_OF_USER, ADD_USER, CHANGE_INFORMATION_OF_USER, REMOVE_USER, BACK
    }

    private Admin admin;

    public void handleTheAdminMenuChoice(Scanner scanner, Store store) {
        printTheAdminMenu();
        MenuOfAdmin menuOfAdmin = getAdminMenuOption(scanner);
        while (true) {

            switch (menuOfAdmin) {
                case GAMES:
                    handleGamesChoice(scanner, store);
                    break;
                case USERS:
                    handleUsersChoice(scanner, store);
                    break;
                default:
                    break;
            }
            printTheAdminMenu();
            menuOfAdmin = getAdminMenuOption(scanner);
        }
    }

    public static void printTheAdminMenu() {
        System.out.println("Admin menu Options: ");
        System.out.println("1) games");
        System.out.println("2) users");
        System.out.println("Please choose a number");
    }

    public static MenuOfAdmin getAdminMenuOption(Scanner scanner) {
        MenuOfAdmin[] menuOfAdmin = MenuOfAdmin.values();
        int adminChoice = scanner.nextInt();
        scanner.nextLine();
        adminChoice--;
        if (adminChoice >= 0 && adminChoice < menuOfAdmin.length) {
            return menuOfAdmin[adminChoice];
        }
        return null;
    }

    public static void printAdminGameMenu() {
        System.out.println("Please choose a number: ");
        System.out.println("1) Adding a new game to the store.");
        System.out.println("2) Changing the information of an existing game.");
        System.out.println("3) Removing a game from store.");
        System.out.println("4) Back");
    }

    public static AdminGameMenu getAdminGameMenu(Scanner scanner) {
        AdminGameMenu[] adminGameMenu = AdminGameMenu.values();
        int adminChoice = scanner.nextInt();
        scanner.nextLine();
        adminChoice--;
        if (adminChoice >= 0 && adminChoice < adminGameMenu.length) {
            return adminGameMenu[adminChoice];
        }
        return null;
    }

    public static void printAdminUserMenu() {
        System.out.println("Please choose a number: ");
        System.out.println("1) See profile of a user.");
        System.out.println("2) Add a new user.");
        System.out.println("3) Change information of an existing user.");
        System.out.println("4) Remove a user");
        System.out.println("5) Back");
    }

    public static AdminUserMenu getAdminUserMenu(Scanner scanner) {
        AdminUserMenu[] adminUserMenu = AdminUserMenu.values();
        int adminChoice = scanner.nextInt();
        scanner.nextLine();
        adminChoice--;
        if (adminChoice >= 0 && adminChoice < adminUserMenu.length) {
            return adminUserMenu[adminChoice];
        }
        return null;
    }

    public void handleGamesChoice(Scanner scanner, Store store) {
        printAdminGameMenu();
        AdminGameMenu adminGameMenu = getAdminGameMenu(scanner);
        while (adminGameMenu != AdminGameMenu.BACK) {

            switch (adminGameMenu) {
                case ADD_GAME:
                    addGameToAStore(scanner, store);
                    break;
                case CHANGE_GAME:
                    changeAGame(scanner, store);
                    break;
                case REMOVE_GAME:
                    removeAGameFromStore();
                    break;
                default:
                    break;
            }
            printAdminGameMenu();
            adminGameMenu = getAdminGameMenu(scanner);
        }
    }

    public void handleUsersChoice(Scanner scanner, Store store) {
        printAdminUserMenu();
        AdminUserMenu adminUserMenu = getAdminUserMenu(scanner);
        while (adminUserMenu != AdminUserMenu.BACK) {

            switch (adminUserMenu) {
                case SEE_PROFILE_OF_USER:
                    seeProfileOfUser();
                    break;
                case ADD_USER:
                    addUser();
                    break;
                case CHANGE_INFORMATION_OF_USER:
                    changeInformationOfUser();
                    break;
                case REMOVE_USER:
                    removeAUserFromStore();
                    break;
                default:
                    break;
            }
            printAdminUserMenu();
            adminUserMenu = getAdminUserMenu(scanner);
        }
    }

    private void removeAUserFromStore() {
    }

    private void changeInformationOfUser() {
    }

    private void seeProfileOfUser() {
    }

    private void addUser() {

    }

    public void addGameToAStore(Scanner scanner, Store store) {

    }

    public void changeAGame(Scanner scanner, Store store) {

    }

    public void removeAGameFromStore() {

    }

}
