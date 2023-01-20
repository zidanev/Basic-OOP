package controller;

import model.users.Developer;
import model.users.Gamer;
import model.users.User;
import storage.File_Storage;
import storage.Storage;

public class UserController {

    public User login(String username, String password) {
        Storage storage = new File_Storage().readStorageFile();
        User user_found = null;
        for (User user : storage.getUserList()) {
            boolean check_username = user.getUsername().equals(username);
            boolean check_password = user.getPassword().equals(password);
            if (check_username && check_password) {
                user_found = user;
                return user_found;
            }
        }
        return user_found;
    }

    public User register(String name, String username, String password, String role) {
        Storage storage = new File_Storage().readStorageFile();

        // check if the the username already used
        boolean is_user_exist = false;
        for (User user : storage.getUserList()) {
            boolean check_username = user.getUsername().equals(username);
            if (check_username) {
                is_user_exist = true;
                break;
            }
        }
        if (is_user_exist) {
            return null;
        } else {
            User user = null;
            if(role.equals("gamer")) {
                user = new Gamer(name, username, password);
            } else if(role.equals("developer")) {
                user = new Developer(name, username, password);
            }
            this.addUser(user);
            return user;
        }
    }

    public void logout() {
        new File_Storage().deleteLoggedUser();
    }

    public void addUser(User user) {
        File_Storage file_Storage = new File_Storage();
        Storage storage = file_Storage.readStorageFile();
        storage.getUserList().add(user);
        file_Storage.saveStorage(storage);
    }

    public User findUserByUsername(String username, Storage storage) {
        User user_found = null;
        for (User user : storage.getUserList()) {
            if (username.equals(user.getUsername())) {
                user_found = user;
                break;
            }
        }
        return user_found;
    }
}
