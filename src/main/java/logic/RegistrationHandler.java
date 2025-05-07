package logic;

import java.util.ArrayList;
import java.util.List;
import static logic.Config.*;
import models.User;

public class RegistrationHandler {

    private List<User> users;

    public RegistrationHandler() {
        users = JsonStorage.loadFromFile(USERS_FILE_PATH, User.class);
        if (users == null) {
            users = new ArrayList<>();
        }
    }

    public boolean register(String name, String email, String password, String repeatedPassword) {
        if (isEmailTaken(email)) {
            return false;
        }
        if (verifyEmail(email) == false) {
            return false;
        }
        if (verifyPassword(password) == false) {
            return false;
        }
        if (confirmPassword(password, repeatedPassword) == false) {
            return false;
        }
        String hashedPassword = HashUtil.hashPassword(password);
        User newUser = new User(name, email, hashedPassword);
        users.add(newUser);
        JsonStorage.saveToFile(USERS_FILE_PATH, users);
        return true;
    }

    private boolean isEmailTaken(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    private boolean verifyEmail(String email) {
        if (email.isEmpty()) {
            return false;
        }
        int atIndex = email.indexOf('@');
        int dotIndex = email.lastIndexOf('.');
        if (atIndex <= 0 || atIndex >= email.length() - 1) {
            return false;
        }
        if (dotIndex <= atIndex + 1 || dotIndex >= email.length() - 1) {
            return false;
        }
        return true;
    }

    private boolean verifyPassword(String password) {
        if (password.isEmpty() || password.length() < 8) {
            return false;
        }
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSymbol = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else {
                hasSymbol = true;
            }
        }
        return hasUppercase && hasLowercase && hasDigit && hasSymbol;
    }
    
    private boolean confirmPassword(String password, String repeatedPassword) {
        if (password.equals(repeatedPassword)) {
            return true;
        }
        return false;
    }
    

}
