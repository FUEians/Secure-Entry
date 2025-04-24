package gui.components;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;

public final class ToolTip {

    private ToolTip() {
        throw new UnsupportedOperationException("Utility class -> cannot be instantiated");
    }

    public static void applyDefaultStyle() {
        UIManager.put("ToolTip.font", new Font("Arial", Font.PLAIN, 12));
        UIManager.put("ToolTip.background", Color.WHITE);
        UIManager.put("ToolTip.foreground", Color.DARK_GRAY);
        UIManager.put("ToolTip.border", BorderFactory.createLineBorder(Color.GRAY));
        ToolTipManager.sharedInstance().setInitialDelay(750);
        ToolTipManager.sharedInstance().setDismissDelay(5000);
    }
}
