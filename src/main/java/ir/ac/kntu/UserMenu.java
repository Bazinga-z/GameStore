package ir.ac.kntu;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Scanner;

    public class UserMenu{

        enum Options{
            FRIENDS, LIBRARY, STORE, PROFILE;
        }

        enum WhatUserWantToChange{
            USERNAME, PASSWORD, EMAIL, PHONE_NUMBER, WALLET;
        }

        private User user;

        public UserMenu(User user){
            this.user = user;
        }

        public void handleTheUserMenuChoice(Options option ,Scanner scanner) {

            while (true) {

                switch (option) {
                    case PROFILE:
                        handleProfileChoice(scanner);
                        break;
                    case STORE:
                        handleStoreChoice(scanner);
                        break;
                    case FRIENDS:
                        handleFriendsChoice(scanner);
                        break;
                    case LIBRARY:
                        handleLibraryChoice(scanner);
                        break;
                }
                printTheUserMenu();

                option = getUserMenuOption(scanner);



            }

        }

    public static void printTheUserMenu(){
        System.out.println("User menu Options: ");
        System.out.println("1) friends");
        System.out.println("2) library");
        System.out.println("3) store");
        System.out.println("4) profile");
        System.out.println("Please choose a number");
    }

    public static Options getUserMenuOption(Scanner scanner){
        Options[] options = Options.values();
        int userChoice = scanner.nextInt();
        scanner.nextLine();
        userChoice--;
        if(userChoice >= 0 && userChoice < options.length){
            return options[userChoice];
        }
        return null;
    }

    public static WhatUserWantToChange getWhatUserWantToChange(Scanner scanner){
        WhatUserWantToChange[] whatUserWantToChanges = WhatUserWantToChange.values();
        int userChoice = scanner.nextInt();
        scanner.nextLine();
        userChoice--;
        if(userChoice >= 0 && userChoice < whatUserWantToChanges.length){
            return whatUserWantToChanges[userChoice];
        }
        return null;
    }

    public void handleProfileChoice(Scanner scanner){

        System.out.println("Choose the one you want to change: ");
        System.out.println("1) Username: " + user.getUsername());
        System.out.println("2) Password: " + user.getPassword());
        System.out.println("3) Email: " + user.getEmail());
        System.out.println("4) Phone Number: " + user.getPhoneNumber());
        System.out.println("5) Wallet: " + user.getWallet());
        handleWhatUserWantToChange(scanner);

    }

    public static void handleStoreChoice(Scanner scanner){
        System.out.println("You chose Store");
    }

    public static void handleFriendsChoice(Scanner scanner){
        System.out.println("You chose Friends");
    }

    public static void handleLibraryChoice(Scanner scanner){
        System.out.println("You chose Library");
    }

    public void handleWhatUserWantToChange(Scanner scanner){

            WhatUserWantToChange whatUserWantToChange = getWhatUserWantToChange(scanner);

            switch (whatUserWantToChange){

                case USERNAME :
                    user.setUsername(scanner);
                    break;

                case PASSWORD:
                    user.setPassword(scanner);
                    break;

                case EMAIL:
                    user.setEmail(scanner);
                    break;

                case PHONE_NUMBER:
                    user.setPhoneNumber(scanner);
                    break;

                case WALLET:
                    user.setWallet(scanner);
                    break;

            }
    }

    public void getMenuOfUser(User user, Scanner scanner) {
        printTheUserMenu();
        Options option = getUserMenuOption(scanner);
        handleTheUserMenuChoice(option,scanner);
    }



}
