/**
 * Landing Page
 *
 * This is the initial screen that appears when the app is launched for the first time
 * after installation. It provides options such as Login, Register, and a brief
 * description of the application’s purpose and features.
 *
 * Note: This page is only shown once - on the first launch - and is skipped in
 * subsequent sessions.
 */
package gui.pages;

import gui.components.Button;
import gui.components.GradientPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import static logic.Config.*;

public class LandingPage extends JFrame {
    private LandingPage landingPage = this;
    
    public LandingPage() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(PROJECT_NAME);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        ImageIcon logoIcon = new ImageIcon(getClass().getResource(LOGO_IMAGE_ICON));
        Image scaledLogoIcon = logoIcon.getImage().getScaledInstance(24, 24, 60);
        this.setIconImage(scaledLogoIcon);

        GradientPanel welcomePanel = new GradientPanel(true);
        welcomePanel.setLayout(new BorderLayout());
        welcomePanel.setOpaque(false);

        JLabel welcomeLabel = new JLabel("Welcome to " + PROJECT_NAME);
        welcomeLabel.setFont(POPPINS_EXTRABOLD_40);
        welcomeLabel.setForeground(WHITE);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomePanel.add(welcomeLabel, BorderLayout.NORTH);

        JLabel text = new JLabel(
                "<html>"
                + "<p style='text-align: justify; width:425px;'>"
                + "The password management "
                + "system that is designed to "
                + "make users securely store, "
                + "organize, and retrieve  his or her "
                + "credentials with a user "
                + "friendly interface."
                + "</p>"
                + "</html>"
        );
        text.setFont(POPPINS_REGULAR_37);
        text.setForeground(WHITE);
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.CENTER);
        welcomePanel.add(text, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 40));
        buttonPanel.setOpaque(false);

        Button loginBtn = new Button(
                "Login",
                MEDIUM_BUTTON_SIZE,
                POPPINS_EXTRABOLD_30,
                JET_BLACK,
                applyDarkStyleButtonEffect()
        );
        
        Button signupBtn = new Button(
                "Sign Up",
                MEDIUM_BUTTON_SIZE,
                POPPINS_EXTRABOLD_30,
                JET_BLACK,
                applyDarkStyleButtonEffect(),
                new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new RegistrationPage();
                    landingPage.setVisible(false);
                }
            }
        );

        buttonPanel.add(loginBtn);
        buttonPanel.add(signupBtn);

        welcomePanel.add(buttonPanel, BorderLayout.SOUTH);
        welcomePanel.setBorder(BorderFactory.createEmptyBorder(100, 30, 100, 30));

        ImageIcon img = new ImageIcon(getClass().getResource(IMAGE_1));
        Image scaledImg = img.getImage().getScaledInstance(550, 550, Image.SCALE_SMOOTH);
        JLabel imgLabel = new JLabel(new ImageIcon(scaledImg));
        JPanel imgPanel = new JPanel(new BorderLayout());
        imgPanel.setOpaque(false);
        imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imgLabel.setVerticalAlignment(SwingConstants.CENTER);
        imgPanel.add(imgLabel, BorderLayout.CENTER);
        imgPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 40));

        this.setResizable(false);
        this.add(imgPanel, BorderLayout.EAST);
        this.add(welcomePanel, BorderLayout.WEST);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(JET_BLACK);
        this.setVisible(true);

    }

}
