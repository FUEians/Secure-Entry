package logic;

import java.awt.*;
import java.io.InputStream;

public final class Config {

    public static final int FRAME_WIDTH = 1280;
    public static final int FRAME_HEIGHT = 800;

    public static final Color JET_BLACK = new Color(0x222222);
    public static final Color WHITE = new Color(0xFFFFFF);
    public static final Color LIGHT_GREEN = new Color(0x1DCD9F);
    public static final Color DARK_GREEN = new Color(0x169976);
    public static final Color CULTURED = new Color(0xF5F5F5);

    // Protest Guerrilla Fonts
    public static final Font LOGO_FONT_LARGE = loadFont("/fonts/Protest_Guerrilla/ProtestGuerrilla-Regular.ttf", 70f);
    public static final Font LOGO_FONT_SMALL = loadFont("/fonts/Protest_Guerrilla/ProtestGuerrilla-Regular.ttf", 30f);

    // Poppins ExtraBold Fonts
    public static final Font POPPINS_EXTRABOLD_30 = loadFont("/fonts/Poppins/Poppins-ExtraBold.ttf", 30f);
    public static final Font POPPINS_EXTRABOLD_40 = loadFont("/fonts/Poppins/Poppins-ExtraBold.ttf", 40f);

    // Poppins Regular Fonts
    public static final Font POPPINS_REGULAR_15 = loadFont("/fonts/Poppins/Poppins-Regular.ttf", 15f);
    public static final Font POPPINS_REGULAR_20 = loadFont("/fonts/Poppins/Poppins-Regular.ttf", 20f);
    public static final Font POPPINS_REGULAR_30 = loadFont("/fonts/Poppins/Poppins-Regular.ttf", 30f);
    public static final Font POPPINS_REGULAR_37 = loadFont("/fonts/Poppins/Poppins-Regular.ttf", 37f);

    private Config() {
        throw new UnsupportedOperationException("Utility class -> cannot be instantiated");
    }

    private static Font loadFont(String path, float size) {
        try (InputStream is = Config.class.getResourceAsStream(path)) {
            Font font = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(size);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
            return font;
        } catch (Exception e) {
            System.err.println("Could not load font: " + path);
            return new Font("SansSerif", Font.PLAIN, (int) size);
        }
    }
}
