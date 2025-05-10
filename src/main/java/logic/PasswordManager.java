/*
PasswordManager (Logic):
-Handles everything related to passwords 
(encryption, decryption, storage, and operations on password data).
-Manages a list of Category objects.
-Handles saving/loading all password-related data 
(accounts, categories) using JsonStorage (to a file like categories.json).
-Uses EncryptionUtil for encrypting/decrypting passwords.
 */
package logic;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import models.Category;
import models.AccountEntry;
import javax.crypto.SecretKey;
import static logic.Config.USERS_FILE_PATH;
import logic.EncryptionUtil;
import models.User;

public class PasswordManager {

    private List<Category> categories;
    private List<User> users;
    private User user;

    public PasswordManager() {

        File file = new File(USERS_FILE_PATH);
        categories = JsonStorage.loadFromFile("Category", Category.class);
        users = JsonStorage.loadFromFile(file.getPath(), User.class);
        if (categories == null) {
            categories = new ArrayList<>();
        }
        if (users == null) {
            users = new ArrayList<>();
        }
    }

    public void addCategory(Category category) {
        categories.add(category);
        saveCategories();

    }

    public void removeCategory(Category category) {
        categories.remove(category);
        saveCategories();

    }

    public void addAccountToCategory(String categoryName, AccountEntry account, SecretKey key)
            throws Exception {

        for (Category c : categories) {
            if (c.getName().equals(categoryName)) {
                String encrypted = EncryptionUtil.encrypt(account.getPassword(), key);
                account.setPassword(encrypted);
                c.addAccount(account);
                saveCategories();
                return;
            }
        }
    }

    public void removeAccountFromCategory(String categoryName, AccountEntry account) {
        for (Category c : categories) {
            if (c.getName().equals(categoryName)) {
                c.removeAccount(account);
                saveCategories();
                return;
            }
        }
    }

    public String decryptPassword(String encryptedPassword, SecretKey key) throws Exception {
        return EncryptionUtil.decrypt(encryptedPassword, key);
    }

    private void saveCategories() {
        JsonStorage.saveToFile("categories.json", categories);
    }

    public List<Category> getCategories() {
        return categories;
    }

    public boolean validUser(String name, String email) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                if (user.getEmail().equals(email)) {
                    this.user = user;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verifyPassword(String password) {
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

    public boolean confirmPassword(String password, String repeatedPassword) {
        if (password.equals(repeatedPassword)) {
            return true;
        }
        return false;
    }

    public User getUser() {
        return user;
    }

    public List<User> getUsers() {
        return users;
    }
    
}
