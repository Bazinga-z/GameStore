package ir.ac.kntu;

import java.util.Scanner;

public class Utility {

    public static void printTheUserMenu() {
        System.out.println("User menu Options: ");
        System.out.println("1) friends");
        System.out.println("2) library");
        System.out.println("3) store");
        System.out.println("4) profile");
        System.out.println("5) back");
        System.out.println("Please choose a number");
    }

    public static void printTheFriendsOptions() {
        System.out.println("What is your choice?");
        System.out.println("1) See your friends");
        System.out.println("2) Search among your friends by their name");
        System.out.println("3) Find a new friend");
        System.out.println("4) See those who requested to be your friend");
        System.out.println("5) Back");
    }

    public static void printTheLibraryOptions() {
        System.out.println("What is your choice?");
        System.out.println("1) Add comment about a game you bought");
        System.out.println("2) Give rate to the games you bought");
        System.out.println("3) back");
    }

    public static UserMenu.Options getUserMenuOption(Scanner scanner) {
        UserMenu.Options[] options = UserMenu.Options.values();
        int userChoice = scanner.nextInt();
        scanner.nextLine();
        userChoice--;
        if (userChoice >= 0 && userChoice < options.length) {
            return options[userChoice];
        }
        return null;
    }

    public static UserMenu.WhatUserWantToChange getWhatUserWantToChange(Scanner scanner) {
        UserMenu.WhatUserWantToChange[] whatUserWantToChanges = UserMenu.WhatUserWantToChange.values();
        int userChoice = scanner.nextInt();
        scanner.nextLine();
        userChoice--;
        if (userChoice >= 0 && userChoice < whatUserWantToChanges.length) {
            return whatUserWantToChanges[userChoice];
        }
        return null;
    }

    public static UserMenu.OptionsWhenUserChooseStore getOptionsWhenUserChooseStore(Scanner scanner) {
        UserMenu.OptionsWhenUserChooseStore[] optionsWhenUserChooseStores = UserMenu.OptionsWhenUserChooseStore
                .values();
        int userChoice = scanner.nextInt();
        scanner.nextLine();
        userChoice--;
        if (userChoice >= 0 && userChoice < optionsWhenUserChooseStores.length) {
            return optionsWhenUserChooseStores[userChoice];
        }
        return null;
    }

    public static UserMenu.OptionsWhenUserChooseLibrary getOptionsWhenUserChooseLibrary(Scanner scanner) {
        UserMenu.OptionsWhenUserChooseLibrary[] optionsWhenUserChooseLibrary = UserMenu.OptionsWhenUserChooseLibrary
                .values();
        int userChoice = scanner.nextInt();
        scanner.nextLine();
        userChoice--;
        if (userChoice >= 0 && userChoice < optionsWhenUserChooseLibrary.length) {
            return optionsWhenUserChooseLibrary[userChoice];
        }
        return null;
    }

    public static UserMenu.OptionsWhenUserChooseFriends getOptionsWhenUserChooseFriends(Scanner scanner) {
        UserMenu.OptionsWhenUserChooseFriends[] optionsWhenUserChooseFriends = UserMenu.OptionsWhenUserChooseFriends
                .values();
        int userChoice = scanner.nextInt();
        scanner.nextLine();
        userChoice--;
        if (userChoice >= 0 && userChoice < optionsWhenUserChooseFriends.length) {
            return optionsWhenUserChooseFriends[userChoice];
        }
        return null;
    }

    public static UserMenu.OptionsWhenWeHaveRequests getOptionsWhenWeHaveRequests(Scanner scanner) {
        UserMenu.OptionsWhenWeHaveRequests[] optionsWhenWeHaveRequests = UserMenu.OptionsWhenWeHaveRequests.values();
        int userChoice = scanner.nextInt();
        scanner.nextLine();
        userChoice--;
        if (userChoice >= 0 && userChoice < optionsWhenWeHaveRequests.length) {
            return optionsWhenWeHaveRequests[userChoice];
        }
        return null;
    }
}
