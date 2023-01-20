package model.users;

import model.game.Genre;
import storage.Storage;

public class Admin extends User {
    public Admin(String name, String username, String password) {
        super(name, username, password);
        super.setRole("admin");
    }

}
