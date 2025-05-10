package gui.pages;

import gui.components.AddCategoryForm;
import gui.components.Button;
import gui.components.GradientPanel;
import gui.components.TextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LinearGradientPaint;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import javax.swing.JFrame;
import static logic.Config.*;
import javax.swing.*;
import logic.JsonStorage;
import models.Category;
import models.User;

public class Dashboard extends JFrame {

    private Dashboard dashboard = this;
    private List<User> users;
    private User user;
    private List<Category> categories;

    public Dashboard(String sessionId) {
        File file = new File(USERS_FILE_PATH);
        users = JsonStorage.loadFromFile(file.getPath(), User.class);
        for (User user : users) {
            if (user.getId().equals(sessionId)) {
                this.user = user;
                this.categories = user.getCategories();
            }
        }

        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle(PROJECT_NAME);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(JET_BLACK);
        this.setLocationRelativeTo(null);

        ImageIcon logoIcon = new ImageIcon(getClass().getResource(LOGO_IMAGE_ICON));
        Image scaledLogoIcon = logoIcon.getImage().getScaledInstance(24, 24, 60);
        this.setIconImage(scaledLogoIcon);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setOpaque(false);
        this.add(mainPanel);

        GradientPanel upPanel = new GradientPanel(false) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                int width = getWidth();
                int height = getHeight();
                int arc = 50;
                java.awt.geom.Path2D path = new java.awt.geom.Path2D.Double();
                path.moveTo(0, 0);
                path.lineTo(0, height - arc);
                path.quadTo(0, height, arc, height);
                path.lineTo(width - arc, height);
                path.quadTo(width, height, width, height - arc);
                path.lineTo(width, 0);
                path.closePath();
                java.awt.geom.Point2D start = new java.awt.geom.Point2D.Float(0, 0);
                java.awt.geom.Point2D end = new java.awt.geom.Point2D.Float(0, height);
                Color firstColor = LIGHT_GREEN;
                Color secondColor = new Color(
                        (firstColor.getRed() + DARK_GREEN.getRed()) / 2,
                        (firstColor.getGreen() + DARK_GREEN.getGreen()) / 2,
                        (firstColor.getBlue() + DARK_GREEN.getBlue()) / 2
                );
                float[] fractions = {0.0f, 0.5f, 1.0f};
                Color[] colors = {firstColor, secondColor, DARK_GREEN};
                LinearGradientPaint gradient = new LinearGradientPaint(start, end, fractions, colors);
                g2d.setPaint(gradient);
                g2d.fill(path);
                g2d.dispose();
                super.paintComponent(g2d);
            }
        };
        upPanel.setLayout(new BorderLayout());
        upPanel.setMaximumSize(HEADER_SIZE);
        upPanel.setPreferredSize(HEADER_SIZE);

        JPanel paddedContainer = new JPanel(new BorderLayout());
        paddedContainer.setOpaque(false);
        paddedContainer.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 15));
        leftPanel.setOpaque(false);
        leftPanel.setPreferredSize(new Dimension(300, HEADER_SIZE.height));

        ImageIcon icon = new ImageIcon(getClass().getResource(LOGO_IMAGE));
        Image image = icon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        JLabel iconLabel = new JLabel(icon);
        iconLabel.setText("Secure Entry");
        iconLabel.setFont(LOGO_FONT_SMALL);
        iconLabel.setForeground(WHITE);
        iconLabel.setIconTextGap(15);
        iconLabel.setHorizontalTextPosition(JLabel.RIGHT);
        leftPanel.add(iconLabel);

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 15));
        centerPanel.setOpaque(false);
        TextField searchField = new TextField(SEARCH_TEXT_FIELD_SIZE, SEARCH, SEARCH_ICON_SIZE);
        centerPanel.add(searchField);

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 15));
        rightPanel.setOpaque(false);
        rightPanel.setPreferredSize(new Dimension(300, HEADER_SIZE.height));

        ImageIcon profileIcon = new ImageIcon(getClass().getResource(AVATAR_1));
        Image profileImg = profileIcon.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH);
        profileIcon = new ImageIcon(profileImg);
        JLabel profileLabel = new JLabel(profileIcon);
        profileLabel.setText(this.user.getName());
        profileLabel.setFont(POPPINS_REGULAR_30);
        profileLabel.setForeground(WHITE);
        profileLabel.setHorizontalTextPosition(JLabel.LEFT);
        rightPanel.add(profileLabel);

        paddedContainer.add(leftPanel, BorderLayout.WEST);
        paddedContainer.add(centerPanel, BorderLayout.CENTER);
        paddedContainer.add(rightPanel, BorderLayout.EAST);

        upPanel.add(paddedContainer, BorderLayout.CENTER);
        mainPanel.add(upPanel);

        if (this.categories == null || this.categories.isEmpty()) {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(IMAGE_4));
            Image scaledImg = imageIcon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImg);

            JLabel combinedLabel = new JLabel();
            combinedLabel.setIcon(imageIcon);
            combinedLabel.setText("<html><div style='text-align: center;'>"
                    + "Your dashboard is empty!!<br>No categories added yet"
                    + "</div></html>"
            );
            combinedLabel.setHorizontalTextPosition(JLabel.CENTER);
            combinedLabel.setVerticalTextPosition(JLabel.BOTTOM);
            combinedLabel.setForeground(Color.GRAY);
            combinedLabel.setFont(POPPINS_REGULAR_30);
            combinedLabel.setHorizontalAlignment(SwingConstants.CENTER);
            combinedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            mainPanel.add(Box.createVerticalGlue());
            mainPanel.add(combinedLabel);
            mainPanel.add(Box.createVerticalGlue());
        } else {
            JPanel categoriesPanel = new JPanel();
            categoriesPanel.setLayout(new BoxLayout(categoriesPanel, BoxLayout.Y_AXIS));
            categoriesPanel.setOpaque(false);
            categoriesPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30)); // Add padding

            for (Category category : categories) {
                JPanel categoryPanel = new JPanel(new BorderLayout());
                categoryPanel.setBackground(new Color(0x2C2C2C));
                categoryPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
                categoryPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
                categoryPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

                JLabel categoryLabel = new JLabel(category.getName());
                categoryLabel.setFont(POPPINS_REGULAR_30);
                categoryLabel.setForeground(Color.WHITE);

                categoryPanel.add(categoryLabel, BorderLayout.WEST);

                JButton viewButton = new JButton("View");
                viewButton.setFocusPainted(false);
                viewButton.setBackground(LIGHT_GREEN);
                viewButton.setForeground(Color.BLACK);
                viewButton.setFont(POPPINS_REGULAR_20);
                categoryPanel.add(viewButton, BorderLayout.EAST);

                categoriesPanel.add(categoryPanel);
                categoriesPanel.add(Box.createRigidArea(new Dimension(0, 15)));
            }
        }
        Button addCategoryBtn = new Button(
                "+",
                ADD_BUTTON_SIZE,
                POPPINS_REGULAR_37,
                LIGHT_GREEN,
                applyLightGreenStyleButtonEffect(),
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddCategoryForm cat = new AddCategoryForm(dashboard, user);
            }

        }
        );
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10));
        bottomPanel.setOpaque(false);
        bottomPanel.add(addCategoryBtn);
        this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }
}