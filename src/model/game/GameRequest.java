package model.game;

import java.time.LocalDate;

import model.users.Developer;
import java.io.Serializable;

public class GameRequest implements Serializable {
    private Game game;
    private Developer developer;
    private LocalDate date;
    private final String id;
    private String status = "Pending";

    public GameRequest(Game game, Developer developer, String id) {
        this.game = game;
        this.developer = developer;
        this.date = LocalDate.now();
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public Game getGame() {
        return game;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
