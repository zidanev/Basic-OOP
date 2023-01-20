package model.users;

import java.util.ArrayList;

import model.game.GameRequest;

public class Developer extends User {
    private Wallet wallet;

    public Developer(String name, String username, String password) {
        super(name, username, password);
        this.wallet = new Wallet();
        super.setRole("developer");
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

}
