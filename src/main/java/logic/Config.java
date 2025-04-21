package logic;

import java.awt.*;

public final class Config {

    public static final int FRAME_WIDTH = 1280;
    public static final int FRAME_HEIGHT = 800;

    public static final Color JET_BLACK = new Color(0x222222); 
    public static final Color WHITE = new Color(0xFFFFFF);
    public static final Color LIGHT_GREEN = new Color(0x1DCD9F);
    public static final Color DARK_GREEN = new Color(0x169976);
    public static final Color CULTURED = new Color(0xF5F5F5);
    
    public static final Font MAIN_FONT = new Font("Poppins", Font.PLAIN, 16);
    public static final Font LOGO_FONT = new Font("Protest Guerrilla", Font.BOLD, 24);
    
    private Config() {
        throw new UnsupportedOperationException("Utility class -> cannot be instantiated");
    }

}
