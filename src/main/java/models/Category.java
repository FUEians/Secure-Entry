/*

Category (Model):

- Represents a group of accounts (e.g., "Social", "Business").
- Contains a list of AccountEntry objects.
- Has methods to add/remove accounts.



*/

package models;


import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<AccountEntry> accounts;

    public Category(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public Category() {
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AccountEntry> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountEntry> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(AccountEntry account) {
        accounts.add(account);
    }

    public void removeAccount(AccountEntry account) {
        accounts.remove(account);
    }
}
