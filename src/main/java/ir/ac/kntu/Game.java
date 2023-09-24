package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Game {
    private String name;

    private String description;

    private String typeOfTheGame;

    private double priceOfTheGame;

    private double rateOfTheGame;

    private Integer numberOfRates;

    private ArrayList<String> community;

    public Game(String name, String description, String typeOfTheGame, double priceOfTheGame) {
        this.name = name;
        this.description = description;
        this.typeOfTheGame = typeOfTheGame;
        this.priceOfTheGame = priceOfTheGame;
        this.rateOfTheGame = 0;
        this.community = new ArrayList<>();
        this.numberOfRates = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeOfTheGame() {
        return typeOfTheGame;
    }

    public void setTypeOfTheGame(String typeOfTheGame) {
        this.typeOfTheGame = typeOfTheGame;
    }

    public double getPriceOfTheGame() {
        return priceOfTheGame;
    }

    public void setPriceOfTheGame(double priceOfTheGame) {
        this.priceOfTheGame = priceOfTheGame;
    }

    public double getRateOfTheGame() {
        return rateOfTheGame;
    }

    public Integer getNumberOfRates() {
        return numberOfRates;
    }

    public void setNumberOfRates(Integer numberOfRates) {
        this.numberOfRates = numberOfRates;
    }

    public void setRateOfTheGame(double rateOfTheGame) {
        if (getRateOfTheGame() == 0) {
            this.rateOfTheGame = rateOfTheGame;
            setNumberOfRates(1);
        } else {
            double sumOfTheRates = getRateOfTheGame() * getNumberOfRates();
            double newSum = sumOfTheRates + rateOfTheGame;
            Integer newNumberOfRate = getNumberOfRates() + 1;
            setNumberOfRates(numberOfRates);
            double averageRate = newSum / newNumberOfRate;
            this.rateOfTheGame = averageRate;
        }
    }

    public ArrayList<String> getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community.add(community);
    }

    public static ArrayList<Game> testGames() {
        ArrayList<Game> games = new ArrayList<>();
        games.add(new Game("Winnie the Pooh",
                "Winnie the Pooh The Video Game is based on the movie of the same name. Following the same story as the movie, Winnie the Pooh is an interactive story book focused on delivering action-driven storytelling and incorporating educational content for children.",
                "Adventure", 5000));
        games.add(new Game("STAR WARS",
                "Live your STAR WARS™ dreams as you fight with your favorite dark and light side heroes across iconic locations to become master of the galaxy.",
                "Action-Adventure", 7000));
        games.add(new Game("Cupcake Shop",
                "Cupcake Shop is the best restaurant management game to play on. Make the best Cupcake shops in the world! make your customers satisfied by make cupcake they want. But you need a really good memory to remember the order and serve the cupcake. Each corrected cupcake gets points and makes things harder and faster.",
                "Cooking", 4000));
        games.add(new Game("Sims",
                "The Sims 4 is the ultimate life simulation game—create unique characters, build dream homes, and let chaos unfold.",
                "Strategic life simulation", 8000));
        games.add(new Game("The Last Of Us",
                "Players use weapons such as pistols, rifles, and crafted explosives as well as melee attacks with chokeholds, bats, and metal pipes to defend themselves from the infected and other human survivors.",
                "Action-Adventure", 10000));
        return games;
    }

    public void addUserCommentAboutTheGame(Scanner scanner) {
        System.out.println("Do you want to add a comment about this game?");
        System.out.println("1) Yes");
        System.out.println("2) No");
        int userChoice = scanner.nextInt();
        if (userChoice == 1) {
            System.out.println("Write your comment.");
            scanner.nextLine();
            String userCommentAboutTheGame = scanner.nextLine();
            this.setCommunity(userCommentAboutTheGame);
            System.out.println("Your opinion has been registered.");
        }
    }

    public void updateRateOfTheGame(Scanner scanner) {
        System.out.println("Enter a number between 0 and 5");
        float userRateForTheGame = scanner.nextFloat();
        this.setRateOfTheGame(userRateForTheGame);
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + "\n" +
                ", description= " + description + "\n" +
                ", typeOfTheGame= " + typeOfTheGame + "\n" +
                ", priceOfTheGame= " + priceOfTheGame + "\n" +
                ", rateOfTheGame= " + rateOfTheGame + "\n" +
                '}';
    }
}
