package main;

import model.game.Game;
import model.game.Genre;
import model.users.Admin;
import model.users.Developer;
import model.users.Gamer;
import model.users.User;
import view.user.LoginForm;
import storage.File_Storage;
import storage.Storage;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
         User user = new Gamer("user", "user", "user");
         User admin = new Admin("admin", "admin", "admin");
         User developer = new Developer("developer", "developer", "developer");
         
         Genre genre1 = new Genre("Action");
         Genre genre2 = new Genre("Role-Playing");
         Genre genre3 = new Genre("Strategy");
         Genre genre4 = new Genre("Adventure");
         Genre genre5 = new Genre("Simulation");
         Genre genre6 = new Genre("Sport & Racing");
         
         Storage storage = new Storage();
         
         storage.getUserList().add(user);
         storage.getUserList().add(admin);
         storage.getUserList().add(developer);
         
         storage.getGenreList().add(genre1);
         storage.getGenreList().add(genre2);
         storage.getGenreList().add(genre3);
         storage.getGenreList().add(genre4);
         storage.getGenreList().add(genre5);
         storage.getGenreList().add(genre6);
         
         File_Storage file_Storage = new File_Storage();
         file_Storage.createFile("storage");
         file_Storage.saveStorage(storage);
         new LoginForm().setVisible(true);
    }

}