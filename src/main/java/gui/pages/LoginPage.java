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

public class LoginPage extends JFrame {

    private final LoginPage loginPage = this;

    public LoginPage() {

        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle(PROJECT_NAME);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(JET_BLACK);
        this.setLocationRelativeTo(null);

        ImageIcon logoIcon = new ImageIcon(getClass().getResource(LOGO_IMAGE_ICON));
        Image scaledLogoIcon = logoIcon.getImage().getScaledInstance(24, 24, 60);
        this.setIconImage(scaledLogoIcon);

        ImageIcon image = new ImageIcon(getClass().getResource(IMAGE_3));
        Image scaledImg = image.getImage().getScaledInstance(550, 550, Image.SCALE_SMOOTH);
        JLabel Labelimage = new JLabel(new ImageIcon(scaledImg));
        JPanel LeftPanel = new JPanel();
        LeftPanel.add(Labelimage);
        LeftPanel.setBorder(BorderFactory.createEmptyBorder(80, 60, 80, 0));
        LeftPanel.setOpaque(false);
        this.add(LeftPanel, BorderLayout.WEST);

        GradientPanel RightPanel = new GradientPanel(true);
        RightPanel.setLayout(new BorderLayout());
        RightPanel.setBorder(BorderFactory.createEmptyBorder(40, 70, 40, 70));
        this.add(RightPanel, BorderLayout.EAST);

        JLabel logLabel = new JLabel("Login", SwingConstants.CENTER);
        logLabel.setFont(POPPINS_EXTRABOLD_40);
        logLabel.setForeground(WHITE);

        RightPanel.add(logLabel, BorderLayout.NORTH);
        RightPanel.setBorder(BorderFactory.createEmptyBorder(100, 0, 100, 0));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setOpaque(false);
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 60, 30, 60));
        JLabel Elabel = new JLabel("Email");
        Elabel.setFont(POPPINS_REGULAR_20);
        Elabel.setForeground(JET_BLACK);
        Elabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        TextField Efield = new TextField(DEFAULT_TEXT_FIELD_SIZE);
        Efield.setAlignmentX(Component.LEFT_ALIGNMENT);
        Efield.setMaximumSize(DEFAULT_TEXT_FIELD_SIZE);
        Efield.setMinimumSize(DEFAULT_TEXT_FIELD_SIZE);
        formPanel.add(Elabel);
        formPanel.add(Efield);

        formPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        JLabel Plabel = new JLabel("Password");
        Plabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        Plabel.setFont(POPPINS_REGULAR_20);
        Plabel.setForeground(JET_BLACK);

        PasswordField passwordField = new PasswordField(
                DEFAULT_TEXT_FIELD_SIZE,
                CLOSED_EYE,
                OPENED_EYE,
                EYE_SIZE
        );
        passwordField.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(Plabel);
        formPanel.add(passwordField);

        formPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        Button loginbtn = new Button(
            "Login",
            LARGE_BUTTON_SIZE,
            POPPINS_EXTRABOLD_30,
            JET_BLACK,
            applyDarkStyleButtonEffect(),
            new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginHandler loginHandler = new LoginHandler();
                boolean isAuthenticated = loginHandler.authenticate(Efield.getText(), passwordField.getText());
                if (isAuthenticated) {
                    JFrame frame = new JFrame();
                    frame.setTitle(PROJECT_NAME);
                    frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(false);
                    frame.setVisible(true);
                    loginPage.setVisible(false);
                }
            }
        }
        );

        loginbtn.setMinimumSize(LARGE_BUTTON_SIZE);
        loginbtn.setMaximumSize(LARGE_BUTTON_SIZE);
        loginbtn.setForeground(WHITE);
        formPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        formPanel.add(loginbtn);

        JPanel checkPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        
        Checkbox rememberMe = new Checkbox("Remember me", NOT_SELECTED_CHECK_BOX, SELECTED_CHECK_BOX);
        rememberMe.setOpaque(false);

        JButton forgotPasswordLink = new JButton("<HTML><U>Forgot password?</U></HTML>");
        forgotPasswordLink.setFont(POPPINS_REGULAR_20);
        forgotPasswordLink.setForeground(JET_BLACK);
        forgotPasswordLink.setBorderPainted(false);
        forgotPasswordLink.setContentAreaFilled(false);
        forgotPasswordLink.setOpaque(false);
        forgotPasswordLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        forgotPasswordLink.setFocusPainted(false);

        checkPanel.setOpaque(false);
        checkPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        checkPanel.add(rememberMe);
        checkPanel.add(rememberMe.getCheckboxText());
        checkPanel.add(Box.createRigidArea(new Dimension(80, 0)));
        checkPanel.add(forgotPasswordLink);

        formPanel.add(Box.createRigidArea(new Dimension(0, 18)));
        formPanel.add(checkPanel);

        JPanel registrationLinkPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        registrationLinkPanel.setOpaque(false);

        JLabel registrationLinkLabel = new JLabel("<HTML>Don't have an account?</HTML>");
        registrationLinkLabel.setForeground(WHITE);
        registrationLinkLabel.setFont(POPPINS_REGULAR_20);

        JButton registrationLink = new JButton("<HTML><U>Registration</U></HTML>");
        registrationLink.setForeground(WHITE);
        registrationLink.setFont(POPPINS_REGULAR_20);
        registrationLink.setBorderPainted(false);
        registrationLink.setContentAreaFilled(false);
        registrationLink.setOpaque(false);
        registrationLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registrationLink.setFocusPainted(false);
        registrationLink.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistrationPage();
                loginPage.setVisible(false);
            }
        });

        registrationLinkPanel.add(registrationLinkLabel);
        registrationLinkPanel.add(registrationLink);
        registrationLinkPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(registrationLinkPanel);

        RightPanel.add(formPanel);

        this.setVisible(true);
    }

}
