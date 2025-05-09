package logic;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import javax.swing.JButton;

public final class Config {
    
    public static final String PROJECT_NAME = "Secure Entry";
    public static final int FRAME_WIDTH = 1280;
    public static final int FRAME_HEIGHT = 800;

    public static final Color JET_BLACK = new Color(0x222222);
    public static final Color WHITE = new Color(0xFFFFFF);
    public static final Color LIGHT_GREEN = new Color(0x1DCD9F);
    public static final Color DARK_GREEN = new Color(0x169976);
    public static final Color CULTURED = new Color(0xF5F5F5);

    public static final Dimension SMALL_BUTTON_SIZE = new Dimension(150, 50);
    public static final Dimension MEDIUM_BUTTON_SIZE = new Dimension(200, 60);
    public static final Dimension LARGE_BUTTON_SIZE = new Dimension(460, 60);
    
    public static final Dimension DEFAULT_TEXT_FIELD_SIZE = new Dimension(460, 60);
    public static final Dimension SEARCH_TEXT_FIELD_SIZE = new Dimension(360, 56);
    public static final Dimension ACCOUNT_TEXT_FIELD_SIZE = new Dimension(370, 45);
    
    public static final Dimension HEADER_SIZE = new Dimension(1280, 112);
    
    public static final String AVATAR_1 = "/images/Avatar-1.png";
    public static final String AVATAR_2 = "/images/Avatar-2.png";
    public static final String AVATAR_3 = "/images/Avatar-3.png";
    public static final String AVATAR_4 = "/images/Avatar-4.png";
    public static final String AVATAR_5 = "/images/Avatar-5.png";
    public static final String AVATAR_6 = "/images/Avatar-6.png";

    public static final String IMAGE_1 = "/images/Image-1.png";
    public static final String IMAGE_2 = "/images/Image-2.png";
    public static final String IMAGE_3 = "/images/Image-3.png";
    public static final String IMAGE_4 = "/images/Image-4.png";
    public static final String IMAGE_5 = "/images/Image-5.png";
    
    public static final String NOT_SELECTED_CHECK_BOX = "/images/Check-box-not-selected.png";
    public static final String SELECTED_CHECK_BOX = "/images/Check-box-selected.png";
    
    public static final String OPENED_EYE = "/images/Eye.png";
    public static final String CLOSED_EYE = "/images/Eye-off.png";
    public static final int EYE_SIZE = 40;
    
    public static final String SEARCH = "/images/Search.png";
    public static final int SEARCH_ICON_SIZE = 40;
    
    public static final String LOGO_IMAGE = "/images/Logo.png";
    public static final String LOGO_IMAGE_ICON = "/images/Logo-icon.png";
    public static final String LOGO_ICON = "/images/Logo.ico";

    public static final Font LOGO_FONT_LARGE = loadFont("/fonts/Protest_Guerrilla/ProtestGuerrilla-Regular.ttf", 70f);
    public static final Font LOGO_FONT_SMALL = loadFont("/fonts/Protest_Guerrilla/ProtestGuerrilla-Regular.ttf", 30f);

    public static final Font POPPINS_EXTRABOLD_30 = loadFont("/fonts/Poppins/Poppins-ExtraBold.ttf", 30f);
    public static final Font POPPINS_EXTRABOLD_40 = loadFont("/fonts/Poppins/Poppins-ExtraBold.ttf", 40f);

    public static final Font POPPINS_REGULAR_15 = loadFont("/fonts/Poppins/Poppins-Regular.ttf", 15f);
    public static final Font POPPINS_REGULAR_20 = loadFont("/fonts/Poppins/Poppins-Regular.ttf", 20f);
    public static final Font POPPINS_REGULAR_25 = loadFont("/fonts/Poppins/Poppins-Regular.ttf", 25f); // for default text field
    public static final Font POPPINS_REGULAR_30 = loadFont("/fonts/Poppins/Poppins-Regular.ttf", 30f);
    public static final Font POPPINS_REGULAR_37 = loadFont("/fonts/Poppins/Poppins-Regular.ttf", 37f);
    
    public static final String USERS_FILE_PATH = "users.json";

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

    public static MouseAdapter applyDarkStyleButtonEffect() {
        return new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ((JButton) e.getSource()).setBackground(new Color(0x2D2D2D));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ((JButton) e.getSource()).setBackground(JET_BLACK);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                ((JButton) e.getSource()).setFocusable(false);
                ((JButton) e.getSource()).setBackground(new Color(0x1A1A1A));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                ((JButton) e.getSource()).setBackground(JET_BLACK);
            }
        };
    }
}
