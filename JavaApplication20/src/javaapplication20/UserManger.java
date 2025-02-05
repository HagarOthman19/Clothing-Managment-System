/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication20;
import java.util.ArrayList;
import java.util.List;

class UserManager {
    private List<User> users;

    public UserManager() {
        users = new ArrayList<>();
    }

    public boolean signup(String username, String password, String role) {
        for (User  user : users) {
            if (user.getUsername().equals(username)) {
                return false; // Username already exists
            }
        }
        users.add(new User(username, password, role));
        return true; // Signup successful
    }

    public User login(String username, String password) {
        for (User  user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user; // Login successful
            }
        }
        return null; // Login failed
    }
}