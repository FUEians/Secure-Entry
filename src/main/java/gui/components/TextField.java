package gui.components;

import java.awt.BasicStroke;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JTextField;
import static logic.Config.*;

public class TextField extends JTextField {
    
    public TextField(Dimension dimension) {
        this.setPreferredSize(dimension);
        this.setFont(POPPINS_REGULAR_25);
        this.setBackground(CULTURED);
        this.setCursor(new Cursor(Cursor.TEXT_CURSOR));
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(2));
        g2.setColor(JET_BLACK);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        g2.dispose();
    }
    
    
}
