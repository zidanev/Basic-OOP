/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.users.User;

/**
 *
 * @author zviga
 */
public class File_Storage {
    public void createFile(String filename) {
        try {
            File file = new File(filename + ".dat");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public Storage readStorageFile() {
        try {
            FileInputStream fis = new FileInputStream("storage.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Storage storage = (Storage) ois.readObject();
            ois.close();
            return storage;
        } catch (ClassNotFoundException e) {
            System.out.println("an error occurred");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("an error occurred");
            e.printStackTrace();
        }
        return null;
    }

    public void saveStorage(Storage storage) {
        try {
            FileOutputStream fos = new FileOutputStream("storage.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(storage);
            oos.close();
        } catch (IOException e) {
            System.out.println("an error occurred");
            e.printStackTrace();
        }
    }

    public void saveLoggedUser(User user) {
        this.createFile("loggedUser");
        try {
            FileOutputStream fos = new FileOutputStream("loggedUser.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(user);
            oos.close();
        } catch (IOException e) {
            System.out.println("an error occurred");
            e.printStackTrace();
        }
    }

    public User getLoggedUser() {
        try {
            FileInputStream fis = new FileInputStream("loggedUser.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            User user = (User) ois.readObject();
            ois.close();
            return user;
        } catch (ClassNotFoundException e) {
            System.out.println("an error occurred");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("an error occurred");
            e.printStackTrace();
        }
        return null;
    }

    public void deleteLoggedUser() {
        File file = new File("loggedUser.dat");
        if (file.delete()) {
            System.out.println("File deleted");
        } else {
            System.out.println("Delete file failed");
        }
    }
}
