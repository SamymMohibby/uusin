package com.example.uusin;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Collections;
import java.util.Comparator;
public class UserStorage {
    private ArrayList<User> users = new ArrayList<>();
    private static UserStorage storage = null;

    public ArrayList<User> getUsers() {
        return users;
    }

    public static UserStorage getStorage() {
        return storage;
    }

    private UserStorage() {

    }
    public void saveUsers(Context context) {
        try {
            FileOutputStream fos = context.openFileOutput("users.data", Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadUsers(Context context) {
        try {
            FileInputStream fis = context.openFileInput("users.data");
            ObjectInputStream ois = new ObjectInputStream(fis);
            users = (ArrayList<User>) ois.readObject();
            ois.close();
            fis.close();


            Collections.sort(users, new Comparator<User>() {
                @Override
                public int compare(User u1, User u2) {
                    return u1.getLastname().compareToIgnoreCase(u2.getLastname());
                }
            });

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static UserStorage getInstance() {
        if(storage == null) {
            storage = new UserStorage();
        }
        return storage;
    }
    public void addUser(User user, Context context) {
        users.add(user);
        // Järjestä käyttäjät sukunimen mukaan aakkosjärjestyksessä
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getLastname().compareToIgnoreCase(u2.getLastname());
            }
        });

        saveUsers(context);
    }
    /*public void printFileContents(Context context) {
        try {
            FileInputStream fis = context.openFileInput("users.data");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<User> users = (ArrayList<User>) ois.readObject();
            ois.close();
            fis.close();

            for (User user : users) {
                Log.d("UserStorage", "User: " + user.getName() + ", " + user.getLastname());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /*public void showToastWithFilePath(Context context) {
        String filesDir = context.getFilesDir().getAbsolutePath();
        String filePath = filesDir + "/users.data";
        Toast.makeText(context, "Tiedosto tallennetaan: " + filePath, Toast.LENGTH_LONG).show();
    }*/

}
