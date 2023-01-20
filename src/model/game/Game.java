package model.game;

import java.io.Serializable;
import java.util.UUID;

import model.users.Developer;

public class Game implements Serializable {
    private String gameName;
    private Developer developer;
    private double price;
    private final String id;
    private Statistic statistic = new Statistic();
    private Genre genre;

    public Game(String gameName, Developer developer, double price, Genre genre) {
        this.gameName = gameName;
        this.developer = developer;
        this.id = UUID.randomUUID().toString();
        this.price = price;
        this.genre = genre;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getGameName() {
        return gameName;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public String getId() {
        return id;
    }

    public void setStatistic(Statistic statistic) {
        this.statistic = statistic;
    }

    public Statistic getStatistic() {
        return statistic;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

}
