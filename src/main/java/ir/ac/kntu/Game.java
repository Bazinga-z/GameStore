package ir.ac.kntu;

public class Game {
    private String name;
    private String description;
    private String typeOfTheGame;
    private double priceOfTheGame;
    private float rateOfTheGame;

    public Game(String name, String description, String typeOfTheGame, double priceOfTheGame, float rateOfTheGame) {
        this.name = name;
        this.description = description;
        this.typeOfTheGame = typeOfTheGame;
        this.priceOfTheGame = priceOfTheGame;
        this.rateOfTheGame = rateOfTheGame;
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

    public float getRateOfTheGame() {
        return rateOfTheGame;
    }

    public void setRateOfTheGame(float rateOfTheGame) {
        this.rateOfTheGame = rateOfTheGame;
    }


}
