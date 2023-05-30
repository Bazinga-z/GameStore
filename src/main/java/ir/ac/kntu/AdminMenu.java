package ir.ac.kntu;

import java.util.Scanner;

public class AdminMenu extends CheckStyleTest {

    enum MenuOfAdmin{
        GAMES, USERS;
    }

    private Admin admin;

    public void handleTheAdminMenuChoice(MenuOfAdmin menuOfAdmin) {

        while (true) {

            switch (menuOfAdmin) {
                case GAMES:
                    handleGamesChoice();
                    break;
                case USERS:
                    handleUsersChoice();
                    break;

                //printTheUserMenu();
                //userMenu = getUserMenuOption(scanner);

            }
        }
    }

    public static void printTheAdminMenu(){
        System.out.println("Admin menu Options: ");
        System.out.println("1) games");
        System.out.println("2) users");
        System.out.println("Please choose a number");
    }

    public static MenuOfAdmin getAdminMenuOption(Scanner scanner){
        MenuOfAdmin[] menuOfAdmin = MenuOfAdmin.values();
        int adminChoice = scanner.nextInt();
        scanner.nextLine();
        adminChoice--;
        if(adminChoice >= 0 && adminChoice < menuOfAdmin.length){
            return menuOfAdmin[adminChoice];
        }
        return null;
    }

    public static void handleGamesChoice(){

    }

    public static void handleUsersChoice(){

    }

}


