package ir.ac.kntu;

public class Wallet extends AdminMenu {
    private double balance;

    public Wallet(double balance) {
        this.balance = balance;
    }

    public Double withdraw(double amount) {
        if (amount <= this.getBalance()) {
            this.balance = this.balance - amount;
            return (this.balance);
        } else {
            return null;
        }
    }

    public Double deposit(double amount) {
        this.balance = this.balance + amount;
        return (this.balance);
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {

        return "You have " + getBalance() + "000 toman in your wallet";
    }
}
