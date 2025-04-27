package gui.pages;

import javax.swing.*;
import java.awt.*;
import static logic.Config.*;

public class RegistrationPage {

    public RegistrationPage() {

        JFrame frame = new JFrame(PROJECT_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setResizable(false);

        // ========== Outer Panel ==========
        JPanel outerPanel = new JPanel(new BorderLayout());
        outerPanel.setBackground(LIGHT_GREEN);
        outerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // ========== MAIN PANEL (Left + Right) ==========
        JPanel mainPanel = new JPanel(new GridLayout(1, 2));
        mainPanel.setOpaque(false);

        // ========== LEFT PANEL ==========
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setOpaque(false);
        leftPanel.setBorder(BorderFactory.createLineBorder(JET_BLACK, 6));

        // === Register Label ===
        JLabel registerLabel = new JLabel("Register", SwingConstants.CENTER);
        registerLabel.setFont(POPPINS_EXTRABOLD_40);
        registerLabel.setForeground(WHITE);
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerLabel.setVerticalAlignment(SwingConstants.TOP);
        registerLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        leftPanel.add(registerLabel, BorderLayout.NORTH);

        // === Form Wrapper Panel (to center the form) ===
        JPanel formWrapper = new JPanel(new GridBagLayout());
        formWrapper.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(40, 40, 40, 40);

        // === Form Panel for Fields ===
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setOpaque(false);

        // === Name ===
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(POPPINS_REGULAR_15);
        nameLabel.setForeground(JET_BLACK);
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(nameLabel);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        JTextField nameText = createRoundedTextField();
        nameText.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(nameText);
        formPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // === Email ===
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(POPPINS_REGULAR_15);
        emailLabel.setForeground(JET_BLACK);
        emailLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(emailLabel);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        JTextField emailText = createRoundedTextField();
        emailText.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(emailText);
        formPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // === Password ===
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(POPPINS_REGULAR_15);
        passwordLabel.setForeground(JET_BLACK);
        passwordLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(passwordLabel);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        JPasswordField passwordField = createRoundedPasswordField();
        passwordField.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(passwordField);
        formPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // === Confirm Password ===
        JLabel confirmPasswordLabel = new JLabel("Confirm Password");
        confirmPasswordLabel.setFont(POPPINS_REGULAR_15);
        confirmPasswordLabel.setForeground(JET_BLACK);
        confirmPasswordLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(confirmPasswordLabel);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        JPasswordField confirmPasswordField = createRoundedPasswordField();
        confirmPasswordField.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(confirmPasswordField);

        // Add formPanel to formWrapper
        gbc.gridx = 0;
        gbc.gridy = 0;
        formWrapper.add(formPanel, gbc);

        leftPanel.add(formWrapper, BorderLayout.CENTER);

        // === Add Sign Up Button and Remember Me Checkbox ===
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.setOpaque(false);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 40, 40));

        JButton signUpButton = createRoundedButton("Sign Up");
        signUpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        bottomPanel.add(signUpButton);
        bottomPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JCheckBox rememberMeCheckBox = new JCheckBox("Remember me");
        rememberMeCheckBox.setFont(POPPINS_REGULAR_15);
        rememberMeCheckBox.setForeground(JET_BLACK);
        rememberMeCheckBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        rememberMeCheckBox.setOpaque(false);
        bottomPanel.add(rememberMeCheckBox);

        leftPanel.add(bottomPanel, BorderLayout.SOUTH);

        // ========== RIGHT PANEL ==========
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);

        // Add panels to the main layout
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);
        outerPanel.add(mainPanel, BorderLayout.CENTER);

        // Set and show frame
        frame.setContentPane(outerPanel);
        frame.setVisible(true);
    }

    private JTextField createRoundedTextField() {
        return new JTextField() {
            {
                setOpaque(false);
                setBorder(null);
                setPreferredSize(new Dimension(300, 40));
                setMaximumSize(new Dimension(300, 40));
            }

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                super.paintComponent(g2);
                g2.dispose();
            }

            @Override
            protected void paintBorder(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(JET_BLACK);
                g2.setStroke(new BasicStroke(1));
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
                g2.dispose();
            }
        };
    }

    private JPasswordField createRoundedPasswordField() {
        return new JPasswordField() {
            {
                setOpaque(false);
                setBorder(null);
                setPreferredSize(new Dimension(300, 40));
                setMaximumSize(new Dimension(300, 40));
            }

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                super.paintComponent(g2);
                g2.dispose();
            }

            @Override
            protected void paintBorder(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(JET_BLACK);
                g2.setStroke(new BasicStroke(1));
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
                g2.dispose();
            }
        };
    }

    private JButton createRoundedButton(String text) {
        return new JButton() {
            {
                this.setOpaque(false);
                this.setContentAreaFilled(false);
                this.setFocusPainted(false);
                this.setBorderPainted(false);
                this.setForeground(WHITE);
                this.setFont(POPPINS_REGULAR_20);
                this.setPreferredSize(new Dimension(200, 50));
                this.setMaximumSize(new Dimension(200, 50));

            }

            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(JET_BLACK);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                

            }

        };
    }
}
