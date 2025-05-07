package gui.pages;

import gui.components.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static logic.Config.*;
import logic.RegistrationHandler;

public class RegistrationPage extends JFrame {

    private final RegistrationPage registrationPage = this;

    public RegistrationPage() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(PROJECT_NAME);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        ImageIcon logoIcon = new ImageIcon(getClass().getResource(LOGO_IMAGE_ICON));
        Image scaledLogoIcon = logoIcon.getImage().getScaledInstance(24, 24, 60);
        this.setIconImage(scaledLogoIcon);

        GradientPanel registrationPanel = new GradientPanel(true);
        registrationPanel.setLayout(new BorderLayout());
        registrationPanel.setBorder(BorderFactory.createEmptyBorder(40, 70, 40, 70));

        JLabel registrationLabel = new JLabel("Register");
        registrationLabel.setFont(POPPINS_EXTRABOLD_40);
        registrationLabel.setForeground(WHITE);
        registrationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registrationPanel.add(registrationLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setOpaque(false);

        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
        namePanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(POPPINS_REGULAR_20);
        nameLabel.setForeground(JET_BLACK);
        TextField nameTextField = new TextField(DEFAULT_TEXT_FIELD_SIZE);
        nameTextField.setMaximumSize(DEFAULT_TEXT_FIELD_SIZE);
        nameTextField.setMinimumSize(DEFAULT_TEXT_FIELD_SIZE);
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        nameTextField.setAlignmentX(Component.LEFT_ALIGNMENT);

        namePanel.add(nameLabel);
        namePanel.add(nameTextField);
        namePanel.add(Box.createRigidArea(new Dimension(0, 30)));
        namePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        namePanel.setOpaque(false);

        JPanel emailPanel = new JPanel();
        emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.Y_AXIS));

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(POPPINS_REGULAR_20);
        emailLabel.setForeground(JET_BLACK);
        TextField emailTextField = new TextField(DEFAULT_TEXT_FIELD_SIZE);
        emailTextField.setMaximumSize(DEFAULT_TEXT_FIELD_SIZE);
        emailTextField.setMinimumSize(DEFAULT_TEXT_FIELD_SIZE);
        emailLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        emailTextField.setAlignmentX(Component.LEFT_ALIGNMENT);

        emailPanel.add(emailLabel);
        emailPanel.add(emailTextField);
        emailPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        emailPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        emailPanel.setOpaque(false);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.Y_AXIS));

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(POPPINS_REGULAR_20);
        passwordLabel.setForeground(JET_BLACK);
        PasswordField passwordTextField = new PasswordField(
            DEFAULT_TEXT_FIELD_SIZE,
            CLOSED_EYE,
            OPENED_EYE,
            40
        );
        passwordLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        passwordTextField.setAlignmentX(Component.LEFT_ALIGNMENT);

        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordTextField);
        passwordPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        passwordPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        passwordPanel.setOpaque(false);

        JPanel passwordConfirmationPanel = new JPanel();
        passwordConfirmationPanel.setLayout(new BoxLayout(passwordConfirmationPanel, BoxLayout.Y_AXIS));
        passwordConfirmationPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel passwordConfirmationLabel = new JLabel("Repeat your password");
        passwordConfirmationLabel.setFont(POPPINS_REGULAR_20);
        passwordConfirmationLabel.setForeground(JET_BLACK);
        PasswordField passwordConfirmationTextField = new PasswordField(
            DEFAULT_TEXT_FIELD_SIZE,
            CLOSED_EYE,
            OPENED_EYE,
            EYE_SIZE
        );
        passwordConfirmationLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        passwordConfirmationTextField.setAlignmentX(Component.LEFT_ALIGNMENT);

        passwordConfirmationPanel.add(passwordConfirmationLabel);
        passwordConfirmationPanel.add(passwordConfirmationTextField);
        passwordConfirmationPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        passwordConfirmationPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        passwordConfirmationPanel.setOpaque(false);

        Button signupBtn = new Button(
            "Sign Up",
            LARGE_BUTTON_SIZE,
            POPPINS_EXTRABOLD_30,
            JET_BLACK,
            applyDarkStyleButtonEffect(),
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    RegistrationHandler registrationHandler = new RegistrationHandler();
                    boolean isRegistered = registrationHandler.register(
                        nameTextField.getText(), 
                        emailTextField.getText(), 
                        passwordTextField.getText(), 
                        passwordConfirmationTextField.getText()
                    );
                    if (isRegistered) {
                        new LoginPage();
                        registrationPage.setVisible(false);
                    }
                }
        });
        signupBtn.setMaximumSize(LARGE_BUTTON_SIZE);
        signupBtn.setMinimumSize(LARGE_BUTTON_SIZE);

        JPanel loginLinkPanel = new JPanel();
        loginLinkPanel.setLayout(new BoxLayout(loginLinkPanel, BoxLayout.Y_AXIS));
        loginLinkPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel wrapperPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        wrapperPanel.setOpaque(false);

        JLabel loginLinkLabel = new JLabel("<HTML>Already have an account?</HTML>");
        loginLinkLabel.setForeground(WHITE);
        loginLinkLabel.setFont(POPPINS_REGULAR_20);

        JButton loginLink = new JButton("<HTML><U>Login</U></HTML>");
        loginLink.setForeground(WHITE);
        loginLink.setFont(POPPINS_REGULAR_20);
        loginLink.setBorderPainted(false);
        loginLink.setContentAreaFilled(false);
        loginLink.setOpaque(false);
        loginLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginLink.setFocusPainted(false);
        loginLink.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginPage();
                registrationPage.setVisible(false);
            }
        });

        wrapperPanel.add(loginLinkLabel);
        wrapperPanel.add(loginLink);

        loginLinkPanel.add(wrapperPanel);
        loginLinkPanel.setOpaque(false);

        formPanel.add(namePanel);
        formPanel.add(emailPanel);
        formPanel.add(passwordPanel);
        formPanel.add(passwordConfirmationPanel);
        formPanel.add(signupBtn);
        formPanel.add(loginLinkPanel);
        registrationPanel.add(formPanel, BorderLayout.CENTER);

        JPanel imagePanel = new JPanel();
        ImageIcon image = new ImageIcon(getClass().getResource(IMAGE_2));
        Image scaledImage = image.getImage().getScaledInstance(550, 550, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        imagePanel.add(imageLabel);
        imagePanel.setBorder(BorderFactory.createEmptyBorder(80, 0, 80, 40));
        imagePanel.setOpaque(false);

        this.add(registrationPanel, BorderLayout.WEST);
        this.add(imagePanel, BorderLayout.EAST);
        this.getContentPane().setBackground(JET_BLACK);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
