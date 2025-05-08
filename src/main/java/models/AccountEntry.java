// Represents an account with fields like email and password.
package models;
public class AccountEntry {
    private String email;
    private String password; 

    public AccountEntry(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public AccountEntry() {
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
