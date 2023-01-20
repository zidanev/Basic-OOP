package model.order;

import java.io.Serializable;
import java.time.LocalDate;

import model.game.Game;
import model.users.User;

public class Order implements Serializable {
    private User buyer;
    private Game game;
    private LocalDate date;

    public Order(User user, Game game) {
        this.buyer = user;
        this.game = game;
        this.date = LocalDate.now();
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public User getBuyer() {
        return buyer;
    }

    public LocalDate getDate() {
        return date;
    }

    public Game getGame() {
        return game;
    }

}
