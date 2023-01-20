package model.users;

import java.io.Serializable;

public class Wallet implements Serializable {
    private double balance = 500000;

    public void setBalance(double d) {
        this.balance = d;
    }

    public double getBalance() {
        return balance;
    }
}
