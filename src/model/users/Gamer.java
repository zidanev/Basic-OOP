package model.users;

import java.util.ArrayList;

import model.game.Game;

public class Gamer extends User {
    private Wallet wallet = new Wallet();
    private ArrayList<Game> myGame = new ArrayList<Game>();

    public Gamer(String name, String username, String password) {
        super(name, username, password);
        super.setRole("gamer");
    }

    public ArrayList<Game> getMyGame() {
        return myGame;
    }

    public void buyGame(Game game) {
        double gamePrice = game.getPrice();
        if (this.wallet.getBalance() >= gamePrice) {
            this.myGame.add(game);
        }
    }

    public Wallet getWallet() {
        return this.wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

}