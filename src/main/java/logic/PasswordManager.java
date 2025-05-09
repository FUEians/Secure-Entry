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

import java.util.ArrayList;
import java.util.List;
import models.Category;
import models.AccountEntry;
import javax.crypto.SecretKey;
import logic.EncryptionUtil;

public class PasswordManager {

    private List< Category> categories;

    public PasswordManager() {
        categories = JsonStorage.loadFromFile("Category", Category.class);
        if (categories == null) {
            categories = new ArrayList<>();
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

}
