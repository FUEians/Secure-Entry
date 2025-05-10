package gui.pages;

import javax.swing.JFrame;
import static logic.Config.*;
import javax.swing.*;
import java.awt.*;
import gui.components.*;
import gui.components.Button;
import gui.components.Checkbox;
import gui.components.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logic.LoginHandler;

public class ProfilePage extends JFrame {

    public ProfilePage() {

        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle(PROJECT_NAME);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(JET_BLACK);
        this.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(JET_BLACK);
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
                super.paintComponent(g);
            }
        };

        upPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 0));
        upPanel.setMaximumSize(HEADER_SIZE);
        upPanel.setPreferredSize(HEADER_SIZE);
        mainPanel.add(upPanel);

        JPanel iconPanel = new JPanel();
        iconPanel.setOpaque(false);
        iconPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        upPanel.add(iconPanel);

        ImageIcon icon = new ImageIcon(getClass().getResource(LOGO_IMAGE));
        Image image = icon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        JLabel iconLabel = new JLabel(icon);
        iconLabel.setText("Secure Entry");
        iconLabel.setFont(LOGO_FONT_SMALL);
        iconLabel.setForeground(WHITE);
        iconLabel.setIconTextGap(15);
        iconPanel.add(iconLabel);

        TextField searchField = new TextField(SEARCH_TEXT_FIELD_SIZE, SEARCH, SEARCH_ICON_SIZE);
        upPanel.add(searchField);

        JPanel rightPanel = new JPanel();
        rightPanel.setOpaque(false);
        ImageIcon profileIcon = new ImageIcon(getClass().getResource(AVATAR_2));
        Image profileImg = profileIcon.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH);

        profileIcon = new ImageIcon(profileImg);
        JLabel profileLabel = new JLabel(profileIcon);
        profileLabel.setText("Mariam");
        profileLabel.setFont(POPPINS_REGULAR_30);
        profileLabel.setForeground(WHITE);
        profileLabel.setHorizontalTextPosition(JLabel.LEFT);

        rightPanel.add(profileLabel);
        upPanel.add(rightPanel);


 mainPanel.add(Box.createVerticalGlue());
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        containerPanel.setOpaque(false);
        mainPanel.add(containerPanel);
        containerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        containerPanel.setPreferredSize(new Dimension(400, 500));
        containerPanel.setMaximumSize(new Dimension(400, 500));
        containerPanel.setMinimumSize(new Dimension(400, 500));

        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel profileTitleLabel = new JLabel("Profile");
        profileTitleLabel.setFont(new Font("Poppins", Font.BOLD, 20));
        profileTitleLabel.setForeground(Color.WHITE);
        titlePanel.add(profileTitleLabel);
        containerPanel.add(titlePanel);

         JPanel profileContentPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(0, 0, 0, 30));
                g2.fillRoundRect(5, 5, getWidth() - 10, getHeight() - 10, 40, 40);
                g2.setColor(new Color(40, 40, 40));
                g2.fillRoundRect(0, 0, getWidth() - 10, getHeight() - 10, 40, 40);
                g2.dispose();
            }
        };
        profileContentPanel.setOpaque(false);
        profileContentPanel.setLayout(new BoxLayout(profileContentPanel, BoxLayout.Y_AXIS));
        profileContentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        containerPanel.add(profileContentPanel);

        JPanel profileHeaderPanel = new JPanel();
        profileHeaderPanel.setLayout(new BoxLayout(profileHeaderPanel, BoxLayout.Y_AXIS));
        profileHeaderPanel.setOpaque(false);
        profileContentPanel.add(profileHeaderPanel);
        profileHeaderPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        ImageIcon iconName = new ImageIcon(getClass().getResource(AVATAR_4));
        Image imageName = iconName.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon avatarIcon = new ImageIcon(imageName);
        JLabel avatarLabel = new JLabel(avatarIcon);
        avatarLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel changePicLabel = new JLabel("Change your profile picture");
        changePicLabel.setFont(POPPINS_REGULAR_20);
        changePicLabel.setForeground(WHITE);
        changePicLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        profileHeaderPanel.add(avatarLabel);
        profileHeaderPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        profileHeaderPanel.add(changePicLabel);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setOpaque(false);
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        formPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        profileContentPanel.add(formPanel);

        JLabel Nlabel = new JLabel("Name");
        Nlabel.setFont(POPPINS_REGULAR_15);
        Nlabel.setForeground(CULTURED);
        Nlabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        TextField Nfield = new TextField(ACCOUNT_TEXT_FIELD_SIZE);
        Nfield.setAlignmentX(Component.LEFT_ALIGNMENT);
        Nfield.setMaximumSize(ACCOUNT_TEXT_FIELD_SIZE);
        Nfield.setMinimumSize(ACCOUNT_TEXT_FIELD_SIZE);
        Nfield.setBackground(Color.GRAY);
        formPanel.add(Nlabel);
        formPanel.add(Nfield);

        JLabel Elabel = new JLabel("Email");
        Elabel.setFont(POPPINS_REGULAR_15);
        Elabel.setForeground(CULTURED);
        Elabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        TextField Efield = new TextField(ACCOUNT_TEXT_FIELD_SIZE);
        Efield.setAlignmentX(Component.LEFT_ALIGNMENT);
        Efield.setMaximumSize(ACCOUNT_TEXT_FIELD_SIZE);
        Efield.setMinimumSize(ACCOUNT_TEXT_FIELD_SIZE);
        formPanel.add(Elabel);
        formPanel.add(Efield);

        JLabel Plabel = new JLabel("Password");
        Plabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        Plabel.setFont(POPPINS_REGULAR_15);
        Plabel.setForeground(CULTURED);

        PasswordField passwordField = new PasswordField(
                ACCOUNT_TEXT_FIELD_SIZE,
                CLOSED_EYE,
                OPENED_EYE,
                EYE_SIZE
        );
        passwordField.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(Plabel);
        formPanel.add(passwordField);

        formPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);
        Button Savebtn = new Button(
                "Save",
                new Dimension(113, 45),
                POPPINS_EXTRABOLD_30,
                LIGHT_GREEN,
                applyDarkStyleButtonEffect()
        );
        Savebtn.setContentAreaFilled(false);
        Savebtn.setOpaque(false);
        Savebtn.setMinimumSize(SMALL_BUTTON_SIZE);
        Savebtn.setMaximumSize(SMALL_BUTTON_SIZE);
        Savebtn.setForeground(WHITE);
        Savebtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        buttonPanel.add(Savebtn);
        formPanel.add(buttonPanel);

        mainPanel.add(containerPanel);
        mainPanel.add(Box.createVerticalGlue());   

        this.setVisible(true);
    }

}
