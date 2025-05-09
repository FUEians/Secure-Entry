package gui.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static logic.Config.*;

public class TextField extends JPanel {

    private final JTextField textField;
    private JCheckBox optionCheckBox = null;
    
    public TextField(Dimension dimension) {
        this.setLayout(new BorderLayout());
        this.setOpaque(false);
        this.setPreferredSize(dimension);
        this.setMaximumSize(dimension);
        this.setMinimumSize(dimension);

        textField = new JTextField();
        textField.setOpaque(false);
        textField.setFont(POPPINS_REGULAR_25);
        textField.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        textField.setForeground(JET_BLACK);
        textField.setBorder(new EmptyBorder(20, 15, 10, 25));

        this.add(textField);
    }

    public TextField(Dimension dimension, String icon, int size) {
        this.setLayout(new BorderLayout());
        this.setOpaque(false);
        this.setPreferredSize(dimension);
        this.setMaximumSize(dimension);
        this.setMinimumSize(dimension);

        textField = new JTextField();
        textField.setOpaque(false);
        textField.setFont(POPPINS_REGULAR_25);
        textField.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        textField.setForeground(JET_BLACK);
        textField.setBorder(new EmptyBorder(20, 15, 10, 25));

        ImageIcon uncheckedIcon = new ImageIcon(getClass().getResource(icon));
        ImageIcon checkedIcon = new ImageIcon(getClass().getResource(icon));
        Image scaledUnchecked = uncheckedIcon.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH);
        Image scaledChecked = checkedIcon.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH);

        optionCheckBox = new JCheckBox();
        optionCheckBox.setIcon(new ImageIcon(scaledUnchecked));
        optionCheckBox.setSelectedIcon(new ImageIcon(scaledChecked));
        optionCheckBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        optionCheckBox.setOpaque(false);

        JPanel iconPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        iconPanel.setOpaque(false);
        iconPanel.add(optionCheckBox);

        this.add(textField, BorderLayout.CENTER);
        this.add(iconPanel, BorderLayout.EAST);
    }

    public JCheckBox getOptionCheckBox() {
        return optionCheckBox;
    }

    public JTextField getField() {
        return textField;
    }

    public String getText() {
        return textField.getText();
    }

    public void setText(String text) {
        textField.setText(text);
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

    public void setHorizontalAlignment(int LEFT) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
