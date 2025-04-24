package gui.components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import logic.Config;

public class Button extends JButton {

    public Button(String text, Dimension dimensions, Font font, Color backgroundColor, MouseAdapter mouseAdapter) {
        ToolTip.applyDefaultStyle();
        this.setText(text);
        this.setToolTipText(text);
        this.setPreferredSize(dimensions);
        this.setForeground(Config.WHITE);
        this.setFont(font);
        this.setBackground(backgroundColor);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setOpaque(false);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setFocusPainted(false);
        this.addMouseListener(mouseAdapter);
    }
    
        public Button(String text, Dimension dimensions, Font font, Color backgroundColor, MouseAdapter mouseAdapter, ActionListener action) {
        ToolTip.applyDefaultStyle();
        this.setText(text);
        this.setToolTipText(text);
        this.setPreferredSize(dimensions);
        this.setForeground(Config.WHITE);
        this.setFont(font);
        this.setBackground(backgroundColor);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setOpaque(false);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setFocusPainted(false);
        this.addMouseListener(mouseAdapter);
        this.addActionListener(action);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int shadowOffset = 4; 
        int arc = 20;
        g2.setColor(new Color(0, 0, 0, 20));  
        g2.fillRoundRect(shadowOffset, shadowOffset, getWidth() - shadowOffset, getHeight() - shadowOffset, arc, arc);
        g2.setColor(getBackground()); 
        g2.fillRoundRect(0, 0, getWidth(), getHeight() - shadowOffset, arc, arc);
        g2.dispose();
        super.paintComponent(g); 
    }

}
