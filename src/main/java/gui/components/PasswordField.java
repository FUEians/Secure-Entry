package gui.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static logic.Config.*;

public class PasswordField extends JPanel {

    private final JPasswordField passwordField;
    private final JCheckBox passwordIcon;

    public PasswordField(Dimension dimension, String icon, String selectedIcon, int size) {
        this.setLayout(new BorderLayout());
        this.setOpaque(false);
        this.setPreferredSize(dimension);
        this.setMaximumSize(dimension);
        this.setMinimumSize(dimension);

        passwordField = new JPasswordField();
        passwordField.setOpaque(false);
        passwordField.setFont(POPPINS_EXTRABOLD_40);
        passwordField.setForeground(JET_BLACK);
        passwordField.setEchoChar('•');
        passwordField.setBorder(new EmptyBorder(20, 15, 10, 35));

        ImageIcon closedIcon = new ImageIcon(getClass().getResource(icon));
        ImageIcon openIcon = new ImageIcon(getClass().getResource(selectedIcon));
        Image scaledClosed = closedIcon.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH);
        Image scaledOpen = openIcon.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH);

        passwordIcon = new JCheckBox();
        passwordIcon.setIcon(new ImageIcon(scaledClosed));
        passwordIcon.setSelectedIcon(new ImageIcon(scaledOpen));
        passwordIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        passwordIcon.setOpaque(false);
        passwordIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean show = passwordIcon.isSelected();
                if (show) {
                    passwordField.setEchoChar((char) 0);
                    passwordField.setFont(POPPINS_REGULAR_25);
                } else {
                    passwordField.setEchoChar('•');
                    passwordField.setFont(POPPINS_EXTRABOLD_40);
                }
            }
        });

        JPanel iconPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        iconPanel.setOpaque(false);
        iconPanel.add(passwordIcon);

        this.add(passwordField, BorderLayout.CENTER);
        this.add(iconPanel, BorderLayout.EAST);
    }

    public JCheckBox getPasswordIcon() {
        return passwordIcon;
    }

    public String getText() {
        return new String(passwordField.getPassword());
    }

    public JPasswordField getField() {
        return passwordField;
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
