package logic;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static logic.Config.*;
import models.User;

public class LoginHandler {

    private List<User> users;
    private String sessionId;

    public LoginHandler() {
        File file = new File(USERS_FILE_PATH);
        users = JsonStorage.loadFromFile(file.getPath(), User.class);
        if (users == null) {
            users = new ArrayList<>();
        }
    }

    public boolean authenticate(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                if (HashUtil.verifyPassword(password, user.getPassword())) {
                    this.sessionId = user.getId();
                    return true;
                }
            }
        }
        return false;
    }

    public String getSessionId() {
        return sessionId;
    }

}
