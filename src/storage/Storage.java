package storage;

import java.io.Serializable;
import java.util.ArrayList;

import model.order.Order;
import model.game.Game;
import model.game.GameRequest;
import model.game.Genre;
import model.users.User;

public class Storage implements Serializable {
    private ArrayList<Game> gameList = new ArrayList<Game>();
    private ArrayList<User> userList = new ArrayList<User>();
    private ArrayList<GameRequest> gameRequests = new ArrayList<>();
    private ArrayList<Genre> genreList = new ArrayList<>();
    private ArrayList<Order> orderList = new ArrayList<>();
    private User loginUser;

    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }

    public User getLoginUser() {
        return loginUser;
    }

    public void login() {
        
    }

    public ArrayList<Game> getGameList() {
        return gameList;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setGameRequests(ArrayList<GameRequest> gameRequests) {
        this.gameRequests = gameRequests;
    }

    public ArrayList<GameRequest> getGameRequests() {
        return gameRequests;
    }

    public void setGameList(ArrayList<Game> gameList) {
        this.gameList = gameList;
    }

    public ArrayList<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(ArrayList<Genre> genreList) {
        this.genreList = genreList;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

}
