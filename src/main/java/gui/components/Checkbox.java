package gui.components;

import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import static logic.Config.*;

public class Checkbox extends JCheckBox {
    
    private final JLabel CheckboxText;
    
    public Checkbox(String text, String notSelectedIcon, String selectedIcon) {
        ToolTip.applyDefaultStyle();
        this.setToolTipText(text);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setIcon(new ImageIcon(getClass().getResource(notSelectedIcon)));
        this.setSelectedIcon(new ImageIcon(getClass().getResource(selectedIcon)));
        
        this.CheckboxText = new JLabel(text);
        this.CheckboxText.setFont(POPPINS_REGULAR_20);
        this.CheckboxText.setForeground(JET_BLACK);
    }
    
    public JLabel getCheckboxText() {
        return CheckboxText;
    }
}
