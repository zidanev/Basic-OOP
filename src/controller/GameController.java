package controller;

import model.order.Order;
import model.game.Game;
import model.game.GameRequest;
import model.game.Genre;
import model.users.Developer;
import model.users.Gamer;
import model.users.User;
import storage.File_Storage;
import storage.Storage;
import java.util.ArrayList;
import java.util.UUID;


public class GameController {
    public ArrayList<Game> getListGame() {
        File_Storage file_storage = new File_Storage();
        Storage storage = file_storage.readStorageFile();
        ArrayList<Game> list_game = storage.getGameList();
        return list_game;
    }

    public void buyGame(String gameID) {
        File_Storage file_storage = new File_Storage();
        Storage storage = file_storage.readStorageFile();
        User loggedUser = (User) file_storage.getLoggedUser();
        Game game = getGameById(gameID, storage);
        double price = game.getPrice();
        Gamer user = (Gamer) new UserController().findUserByUsername(loggedUser.getUsername(), storage);
        double userBalance = user.getWallet().getBalance();
        user.getWallet().setBalance(userBalance - price);
        double developerBalance = game.getDeveloper().getWallet().getBalance();
        game.getDeveloper().getWallet().setBalance(developerBalance + price);

        int totalDownload = game.getStatistic().getTotalDownload() + 1;
        int totalActiveUser = game.getStatistic().getTotalActiveUser() + 1;
        game.getStatistic().setTotalActiveUser(totalActiveUser);
        game.getStatistic().setTotalDownload(totalDownload);

        Order order = new Order(user, game);
        storage.getOrderList().add(order);

        user.getMyGame().add(game);
        file_storage.saveLoggedUser(user);
        file_storage.saveStorage(storage);
    }

    public ArrayList<Game> getListGameFromUser() {
        File_Storage file_Storage = new File_Storage();
        Storage storage = file_Storage.readStorageFile();
        String loggedUserUsername = new File_Storage().getLoggedUser().getUsername();
        Gamer user = (Gamer) new UserController().findUserByUsername(loggedUserUsername, storage);
        return user.getMyGame();
    }

    public void addGameRequest(String gameName, double gamePrice, String genreID) {
        File_Storage file_Storage = new File_Storage();
        Storage storage = file_Storage.readStorageFile();
        String id = UUID.randomUUID().toString();
        User loggedUser = file_Storage.getLoggedUser();
        Developer developer = (Developer) new UserController().findUserByUsername(loggedUser.getUsername(), storage);
        Genre genre = getGenreByID(genreID);
        Game game = new Game(gameName, developer, gamePrice, genre);
        GameRequest gameRequest = new GameRequest(game, developer, id);
        storage.getGameRequests().add(gameRequest);
        file_Storage.saveStorage(storage);
    }

    public ArrayList<GameRequest> getGameRequestFromUser() {
        File_Storage file_Storage = new File_Storage();
        Storage storage = file_Storage.readStorageFile();
        User loggedUser = file_Storage.getLoggedUser();
        ArrayList<GameRequest> userGameRequests = new ArrayList<>();
        for (GameRequest gameRequest : storage.getGameRequests()) {
            if (gameRequest.getDeveloper().getUsername().equals(loggedUser.getUsername())) {
                userGameRequests.add(gameRequest);
            }
        }
        return userGameRequests;
    }

    public ArrayList<GameRequest> getAllPendingGameRequest() {
        File_Storage file_Storage = new File_Storage();
        Storage storage = file_Storage.readStorageFile();
        ArrayList<GameRequest> gameRequestList = new ArrayList<>();
        for (GameRequest gameRequest : storage.getGameRequests()) {
            if (gameRequest.getStatus().equals("Pending")) {
                gameRequestList.add(gameRequest);
            }
        }
        return gameRequestList;
    }

    public void changeGameRequestStatus(String id, String status) {
        File_Storage file_Storage = new File_Storage();
        Storage storage = file_Storage.readStorageFile();
        GameRequest gameRequest = getGameRequestById(id, storage);
        if (gameRequest != null) {
            gameRequest.setStatus(status);
            if (status.equals("accepted")) {
                storage.getGameList().add(gameRequest.getGame());
            }
            file_Storage.saveStorage(storage);
        } else {
            System.out.println("Game request not found");
        }
    }

    public GameRequest getGameRequestById(String id, Storage storage) {
        ArrayList<GameRequest> gameRequests = storage.getGameRequests();
        for (GameRequest gameRequest : gameRequests) {
            if (gameRequest.getId().equals(id)) {
                return gameRequest;
            }
        }
        return null;
    }

    public ArrayList<Game> getDeveloperGames() {
        ArrayList<Game> list_game = new ArrayList<Game>();
        File_Storage file_Storage = new File_Storage();
        Storage storage = file_Storage.readStorageFile();
        String devUsername = file_Storage.getLoggedUser().getUsername();
        for (Game game : storage.getGameList()) {
            if (game.getDeveloper().getUsername().equals(devUsername)) {
                list_game.add(game);
            }
        }
        return list_game;
    }

    public ArrayList<Game> getAllGame() {
        File_Storage file_Storage = new File_Storage();
        Storage storage = file_Storage.readStorageFile();
        return storage.getGameList();
    }

    public Game getGameById(String id, Storage storage) {
        Game gameFound = null;
        for (Game game : storage.getGameList()) {
            if (game.getId().equals(id)) {
                gameFound = game;
                break;
            }
        }
        return gameFound;
    }

    public void deleteUserGame(String gameID) {
        File_Storage file_Storage = new File_Storage();
        Storage storage = file_Storage.readStorageFile();
        Gamer loggedUser = (Gamer) file_Storage.getLoggedUser();
        Gamer user = (Gamer) new UserController().findUserByUsername(loggedUser.getUsername(), storage);
        for (Game game : user.getMyGame()) {
            if (game.getId().equals(gameID)) {
                user.getMyGame().remove(game);
                int totalActiveUser = game.getStatistic().getTotalActiveUser() - 1;
                game.getStatistic().setTotalActiveUser(totalActiveUser);
                file_Storage.saveStorage(storage);
                break;
            }
        }
    }

    public ArrayList<Genre> getAllGenre() {
        File_Storage file_Storage = new File_Storage();
        Storage storage = file_Storage.readStorageFile();
        return storage.getGenreList();
    }

    public Genre getGenreByID(String id) {
        File_Storage file_Storage = new File_Storage();
        Storage storage = file_Storage.readStorageFile();
        for (Genre genre : storage.getGenreList()) {
            if (genre.getId().equals(id)) {
                return genre;
            }
        }
        return null;
    }

}
