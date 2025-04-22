package logic;

import org.mindrot.jbcrypt.BCrypt;

public final class HashUtil {

    private HashUtil() {
        throw new UnsupportedOperationException("Utility Class -> Cannot be instantiated");
    }

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean verifyPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
