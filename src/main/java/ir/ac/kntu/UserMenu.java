package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserMenu {

    enum Options {
        FRIENDS, LIBRARY, STORE, PROFILE, BACK
    }

    enum WhatUserWantToChange {
        USERNAME, PASSWORD, EMAIL, PHONE_NUMBER, WALLET, BACK
    }

    enum OptionsWhenUserChooseStore {
        BUY_A_GAME, SEARCHING_THE_GAMES_BY_NAME, FILTER_THE_GAMES_BY_PRICE, BACK
    }

    enum OptionsWhenUserChooseLibrary {
        ADD_COMMENT, GIVE_RATE_TO_A_GAME, BACK
    }

    enum OptionsWhenUserChooseFriends {
        SHOW_FRIENDS, SEARCH_FRIENDS_BY_NAME, FIND_A_NEW_FRIEND, SHOW_REQUESTS, BACK
    }

    enum OptionsWhenWeHaveRequests {
        ACCEPT, REJECT, BACK
    }

    private User user;

    public UserMenu(User user) {
        this.user = user;
    }

    public void handleTheUserMenuChoice(Options option, Scanner scanner, StoreProgram.AdminLogInOption adminLogInOption,
            Store store, StoreProgram.LogInOption logInOption, StoreProgram.UserLogInOption userLogInOption,
            ArrayList<Game> games) {
        while (option != Options.BACK) {

            switch (option) {
                case PROFILE:
                    handleProfileChoice(scanner, store, games);
                    break;
                case STORE:
                    handleStoreChoice(scanner, store, games);
                    break;
                case FRIENDS:
                    handleFriendsChoice(scanner, store);
                    break;
                case LIBRARY:
                    handleLibraryChoice(scanner, store, user);
                    break;
                default:
                    break;
            }
            Utility.printTheUserMenu();
            option = Utility.getUserMenuOption(scanner);
        }
        handleBackChoice(scanner, adminLogInOption, store, logInOption, userLogInOption);
    }

    private void handleBackChoice(Scanner scanner, StoreProgram.AdminLogInOption adminLogInOption, Store store,
            StoreProgram.LogInOption logInOption, StoreProgram.UserLogInOption userLogInOption) {
        StoreProgram.handleTheUserLogInProcess(scanner, adminLogInOption, store, logInOption, userLogInOption);
    }

    public void handleProfileChoice(Scanner scanner, Store store, ArrayList<Game> games) {

        System.out.println("Choose the one you want to change: ");
        System.out.println("1) Username: " + user.getUsername());
        System.out.println("2) Password: " + user.getPassword());
        System.out.println("3) Email: " + user.getEmail());
        System.out.println("4) Phone Number: " + user.getPhoneNumber());
        System.out.println("5) Wallet: " + user.getWallet());
        System.out.println("6) Back");
        handleWhatUserWantToChange(scanner, store, games);
    }

    public void handleStoreChoice(Scanner scanner, Store store, ArrayList<Game> games) {
        System.out.println("Please select a number: ");
        System.out.println("1) Buying a game");
        System.out.println("2) Searching a game by its name");
        System.out.println("3) Filtering the games based on their price");
        System.out.println("4) back");
        handleTheOptionsWhenUserChooseStore(scanner, store, games);
    }

    public void handleTheOptionsWhenUserChooseStore(Scanner scanner, Store store, ArrayList<Game> games) {
        OptionsWhenUserChooseStore optionsWhenUserChooseStore = Utility.getOptionsWhenUserChooseStore(scanner);

        while (optionsWhenUserChooseStore != OptionsWhenUserChooseStore.BACK) {

            switch (optionsWhenUserChooseStore) {
                case BUY_A_GAME:
                    Game game = showTheGamesAndChooseOne(games, scanner, store);
                    handleBuyingTheGame(scanner, game);
                    break;
                case FILTER_THE_GAMES_BY_PRICE:
                    handleSearchingTheGameByPrice(scanner, games, store);
                    break;
                case SEARCHING_THE_GAMES_BY_NAME:
                    handleSearchingTheGamesByName(store, scanner);
                    break;
                default:
                    break;
            }
            handleStoreChoice(scanner, store, games);
        }
        whenUserChooseBackInStoreOption(scanner, store, games);
    }

    private void whenUserChooseBackInStoreOption(Scanner scanner, Store store, ArrayList<Game> games) {
        Utility.printTheUserMenu();
        Options option = Utility.getUserMenuOption(scanner);
        handleTheUserMenuChoice(option, scanner, StoreProgram.AdminLogInOption.SIGN_IN, store,
                StoreProgram.LogInOption.USER, StoreProgram.UserLogInOption.SIGN_IN, games);
    }

    private Game chooseTheGameUserWantToBuy(Scanner scanner, ArrayList<Game> games) {
        System.out.println("Enter the number of the game you want: ");
        int numberOfTheChosenGame = scanner.nextInt();
        return games.get(numberOfTheChosenGame);
    }

    private void withdrawTheMoneyAndAddTheGameToUserLibrary(Game game) {
        double moneyAfterBuyingTheGame = user.getWallet().getBalance() - game.getPriceOfTheGame();
        user.getWallet().setBalance(moneyAfterBuyingTheGame);
        user.addGameToTheLibrary(game);
        System.out.println("The game successfully added to your library.");
    }

    private boolean userWantsToBuyTheGame(Scanner scanner) {
        System.out.println("Do you want to buy the game?");
        System.out.println("1) Yes");
        System.out.println("2) No");
        int userChoice = scanner.nextInt();
        if (userChoice == 1) {
            return true;
        } else {
            return false;
        }
    }

    private boolean userHasEnoughMoneyToBuyTheGame(Game game) {
        if (user.getWallet().getBalance() >= game.getPriceOfTheGame()) {
            return true;
        } else {
            return false;
        }
    }

    public User showTheUsersAndChooseOne(ArrayList<User> users, Scanner scanner, Store store) {
        for (int i = 0; i < users.size(); i++) {
            System.out.println(i + ") " + users.get(i).getUsername());
        }
        int numberOfTheFriendUserChoose = scanner.nextInt();
        return users.get(numberOfTheFriendUserChoose);
    }

    public void showTheGames(ArrayList<Game> games) {
        for (int i = 0; i < games.size(); i++) {
            System.out.println(i + ") " + games.get(i).getName());
        }
    }

    public void handleFriendsChoice(Scanner scanner, Store store) {
        Utility.printTheFriendsOptions();
        OptionsWhenUserChooseFriends optionsWhenUserChooseFriends = Utility.getOptionsWhenUserChooseFriends(scanner);
        while (optionsWhenUserChooseFriends != OptionsWhenUserChooseFriends.BACK) {

            switch (optionsWhenUserChooseFriends) {
                case SHOW_FRIENDS:
                    handleShowingTheFriends(scanner, store);
                    break;
                case SEARCH_FRIENDS_BY_NAME:
                    handleSearchingFriendsByTheirName(scanner, store);
                    break;
                case FIND_A_NEW_FRIEND:
                    handleFindingANewFriend(scanner, store);
                    break;
                case SHOW_REQUESTS:
                    handleShowingTheRequests(scanner, store);
                    break;
                default:
                    break;
            }
            Utility.printTheFriendsOptions();
            optionsWhenUserChooseFriends = Utility.getOptionsWhenUserChooseFriends(scanner);
        }
        // handleWhenUserChooseBackInFriendsOption();
    }

    private void handleShowingTheFriends(Scanner scanner, Store store) {
        if (user.getFriends().size() <= 0) {
            System.out.println("You don't have any friend yet.");
        } else {
            User friend = showTheUsersAndChooseOne(user.getFriends(), scanner, store);
            showTheGamesOfTheFriend(friend);
        }
    }

    public void showTheGamesOfTheFriend(User friend) {
        if (friend.getLibrary().size() <= 0) {
            System.out.println("Your friend doesn't have any game yet.");
        } else {
            System.out.println("These are the games your friend has: ");
            System.out.println(friend.getLibrary());
        }
    }

    private void handleSearchingFriendsByTheirName(Scanner scanner, Store store) {
        System.out.println("Enter the username of the friend you are looking for");
        String nameOfTheSearchedFriend = scanner.nextLine();
        ArrayList<User> friendsThatWeAreLookingFor = findThePossibleFriends(store, nameOfTheSearchedFriend);
        handleTheResultOfSearchingFriendsByTheirName(scanner, store, friendsThatWeAreLookingFor);
    }

    private ArrayList<User> findThePossibleFriends(Store store, String nameOfTheSearchedFriend) {
        ArrayList<User> friendsThatWeAreLookingFor = new ArrayList<>();
        for (User friend : user.getFriends()) {
            if (friend.getUsername().matches("^" + Pattern.quote(nameOfTheSearchedFriend) + ".*")) {
                friendsThatWeAreLookingFor.add(friend);
            }
        }
        return friendsThatWeAreLookingFor;
    }

    public ArrayList<User> findThePossibleUsers(String nameOfTheSearchedFriend, ArrayList<User> users) {
        ArrayList<User> usersThatWeAreLookingFor = new ArrayList<>();
        for (User user : users) {
            if (user.getUsername().matches("^" + Pattern.quote(nameOfTheSearchedFriend) + ".*")) {
                usersThatWeAreLookingFor.add(user);
            }
        }
        return usersThatWeAreLookingFor;
    }

    private void handleTheResultOfSearchingFriendsByTheirName(Scanner scanner, Store store,
            ArrayList<User> friendsThatWeAreLookingFor) {
        if (atLeastOneFriendMatchedOurDesire(friendsThatWeAreLookingFor)) {
            System.out.println("Choose a number to see your friends profile: ");
            User friend = showTheUsersAndChooseOne(friendsThatWeAreLookingFor, scanner, store);
            showTheGamesOfTheFriend(friend);
        } else {
            System.out.println("No friend with this username found!");
        }
    }

    private boolean atLeastOneFriendMatchedOurDesire(ArrayList<User> friends) {
        if (friends.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    // sending request
    private void handleFindingANewFriend(Scanner scanner, Store store) {
        ArrayList<User> usersTheirNameStartsWithTheString = getUsersTheirNameStartsWithDesiredString(scanner, store);
        ArrayList<User> usersTheirNameStartsWithTheStringExceptCurrentUser;
        usersTheirNameStartsWithTheString.remove(user);
        usersTheirNameStartsWithTheStringExceptCurrentUser = usersTheirNameStartsWithTheString;
        if (usersTheirNameStartsWithTheStringExceptCurrentUser.size() > 0) {
            System.out.println("These are the possible results: ");
            System.out.println("Enter number of the user you want to follow: ");
            sendRequest(usersTheirNameStartsWithTheStringExceptCurrentUser, scanner, store);
        } else {
            System.out.println("No such user found.");
        }
    }

    private void sendRequest(ArrayList<User> usersWeWantToFollow, Scanner scanner, Store store) {
        User userWeWantToFollow = showTheUsersAndChooseOne(usersWeWantToFollow, scanner, store);
        if (user.getFriends().contains(userWeWantToFollow)) {
            System.out.println("You have already followed this user");
        } else {
            userWeWantToFollow.addRequests(user);
            System.out.println(userWeWantToFollow.getUsername() + " has successfully received your request.");
        }
    }

    public ArrayList<User> getUsersTheirNameStartsWithDesiredString(Scanner scanner, Store store) {
        System.out.println("Please enter the username of the friend you are looking for");
        String usernameOfTheFriend = scanner.next();
        return findThePossibleUsers(usernameOfTheFriend, store.getUsers());
    }

    // receiving requests
    private void handleShowingTheRequests(Scanner scanner, Store store) {
        if (user.getRequests().size() <= 0) {
            System.out.println("You don't have any request.");
        } else {
            User userWeWantToFollowBackOrReject = showRequestsAndReturnTheChosenUser(scanner, store);
            OptionsWhenWeHaveRequests userChoice = Utility.getOptionsWhenWeHaveRequests(scanner);
            while (userChoice != OptionsWhenWeHaveRequests.BACK) {

                switch (userChoice) {
                    case ACCEPT:
                        acceptTheUserAndFollowBack(userWeWantToFollowBackOrReject);
                        break;
                    case REJECT:
                        rejectTheUser(userWeWantToFollowBackOrReject);
                        break;
                    default:
                        break;
                }
                handleShowingTheRequests(scanner, store);
                break;
            }
        }
    }

    public User showRequestsAndReturnTheChosenUser(Scanner scanner, Store store) {
        System.out.println("These users want to follow you: ");
        System.out.println("Enter number of the user you want to follow or reject: ");
        User userWeWantToFollowBackOrReject = showTheUsersAndChooseOne(user.getRequests(), scanner, store);
        System.out.println("What is your choice? Please choose a number: ");
        System.out.println("1) Accept and follow back.");
        System.out.println("2) Reject");
        System.out.println("3) Back");
        return userWeWantToFollowBackOrReject;
    }

    public void acceptTheUserAndFollowBack(User userWeWantToFollowBackOrReject) {
        user.addFriend(userWeWantToFollowBackOrReject);
        userWeWantToFollowBackOrReject.addFriend(user);
        System.out.println(userWeWantToFollowBackOrReject.getUsername() + " successfully added to your friends list.");
        user.getRequests().remove(userWeWantToFollowBackOrReject);
    }

    public void rejectTheUser(User userWeWantToFollowBackOrReject) {
        System.out.println(userWeWantToFollowBackOrReject.getUsername() + " successfully removed from your requests.");
        user.getRequests().remove(userWeWantToFollowBackOrReject);
    }

    public void handleLibraryChoice(Scanner scanner, Store store, User user) {
        Utility.printTheLibraryOptions();
        OptionsWhenUserChooseLibrary optionWhenUserChooseLibrary = Utility.getOptionsWhenUserChooseLibrary(scanner);
        while (optionWhenUserChooseLibrary != OptionsWhenUserChooseLibrary.BACK) {

            switch (optionWhenUserChooseLibrary) {
                case ADD_COMMENT:
                    handleAddingCommentsForTheGames(scanner, store);
                    break;
                case GIVE_RATE_TO_A_GAME:
                    handleGivingRateToAGame(scanner, store);
                    break;
                default:
                    break;
            }
            Utility.printTheLibraryOptions();
            optionWhenUserChooseLibrary = Utility.getOptionsWhenUserChooseLibrary(scanner);
        }
    }

    public void handleAddingCommentsForTheGames(Scanner scanner, Store store) {
        if (user.getLibrary().size() <= 0) {
            System.out.println("You haven't bought any game yet.");
        } else {
            System.out.println("These are the games in your library.");
            System.out.println("you can see the community for each game.");
            Game game = showTheGamesAndChooseOne(user.getLibrary(), scanner, store);
            if (game.getCommunity().size() <= 0) {
                System.out.println("There is no comment about this game.");
            } else {
                System.out.println("Comments about this game are as follows: ");
                System.out.println(game.getCommunity());
            }
            game.addUserCommentAboutTheGame(scanner);
        }
    }

    public Game showTheGamesAndChooseOne(ArrayList<Game> games, Scanner scanner, Store store) {
        System.out.println("Please choose a number: ");
        for (int i = 0; i < games.size(); i++) {
            System.out.println(i + ") " + games.get(i).getName());
        }
        int numberOfTheGameUserChose = scanner.nextInt();
        System.out.println(games.get(numberOfTheGameUserChose));
        return games.get(numberOfTheGameUserChose);
    }

    public void handleGivingRateToAGame(Scanner scanner, Store store) {
        if (user.getLibrary().size() <= 0) {
            System.out.println("You haven't bought any game yet.");
        } else {
            System.out.println("These are the games in your library.");
            Game game = showTheGamesAndChooseOne(user.getLibrary(), scanner, store);
            game.updateRateOfTheGame(scanner);
        }
    }

    public void handleBuyingTheGame(Scanner scanner, Game game) {
        if (!user.getLibrary().contains(game)) {
            if (userWantsToBuyTheGame(scanner)) {
                if (userHasEnoughMoneyToBuyTheGame(game)) {
                    withdrawTheMoneyAndAddTheGameToUserLibrary(game);
                } else {
                    System.out.println("Your money to buy this game is not enough");
                }
            }
        }
    }

    public void handleTheResultOfSearchingTheGames(Scanner scanner, Store store,
            ArrayList<Game> gamesThatWeAreLookingFor) {
        if (atLeastOneGameMatchedOurDesire(gamesThatWeAreLookingFor)) {
            Game game = showTheGamesAndChooseOne(gamesThatWeAreLookingFor, scanner, store);
            handleBuyingTheGame(scanner, game);
        } else {
            System.out.println("No game found!");
        }
    }

    private void handleSearchingTheGameByPrice(Scanner scanner, ArrayList<Game> games, Store store) {
        System.out.println("How much do you wish to spend on a game at least?");
        double minPrice = scanner.nextDouble();
        System.out.println("How much do you wish to spend on a game at most?");
        double maxPrice = scanner.nextDouble();
        ArrayList<Game> filteredGames = new ArrayList<>();
        for (Game game : games) {
            if (game.getPriceOfTheGame() > minPrice & game.getPriceOfTheGame() < maxPrice) {
                filteredGames.add(game);
            }
        }
        handleTheResultOfSearchingTheGames(scanner, store, filteredGames);
    }

    private void handleSearchingTheGamesByName(Store store, Scanner scanner) {
        System.out.println("Enter the name of the game you are looking for");
        String nameOfTheSearchedGame = scanner.nextLine();
        ArrayList<Game> gamesThatWeAreLookingFor = findThePossibleGames(store, nameOfTheSearchedGame);
        handleTheResultOfSearchingTheGames(scanner, store, gamesThatWeAreLookingFor);

    }

    private boolean atLeastOneGameMatchedOurDesire(ArrayList<Game> games) {
        if (games.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    private ArrayList<Game> findThePossibleGames(Store store, String nameOfTheSearchedGame) {
        ArrayList<Game> gamesThatWeAreLookingFor = new ArrayList<>();
        for (Game game : store.getGames()) {
            if (game.getName().matches("^" + Pattern.quote(nameOfTheSearchedGame) + ".*")) {
                gamesThatWeAreLookingFor.add(game);
            }
        }
        return gamesThatWeAreLookingFor;
    }

    public void handleWhatUserWantToChange(Scanner scanner, Store store, ArrayList<Game> games) {

        WhatUserWantToChange whatUserWantToChange = Utility.getWhatUserWantToChange(scanner);

        switch (whatUserWantToChange) {

            case USERNAME:
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

            case BACK:
                getMenuOfUser(scanner, store, games);
            default:
                break;
        }
    }

    public void getMenuOfUser(Scanner scanner, Store store, ArrayList<Game> games) {
        Utility.printTheUserMenu();
        Options option = Utility.getUserMenuOption(scanner);
        handleTheUserMenuChoice(option, scanner, StoreProgram.AdminLogInOption.SIGN_IN, store,
                StoreProgram.LogInOption.USER, StoreProgram.UserLogInOption.SIGN_IN, games);
    }
}
