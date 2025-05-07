package gui.components;

import java.awt.BasicStroke;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import static logic.Config.*;

public class TextField extends JTextField {

    private int arc = getHeight() / 2; 
    
    public TextField(Dimension dimension) {
        this.setPreferredSize(dimension);
        this.setFont(POPPINS_REGULAR_25);
        this.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder(20, 15, 10, 25));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(CULTURED);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 18, 18);
        g2.dispose();

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(3));
        g2.setColor(JET_BLACK);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        g2.dispose();
    }

}
