/**
 * Splash Screen
 *
 * This is the very first screen displayed when the application is launched.
 * It typically shows the app logo or branding for a few seconds while resources load.
 */
package gui.pages;

import gui.components.GradientPanel;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static logic.Config.*;

public class SplashScreen extends JFrame {

    public SplashScreen() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(PROJECT_NAME);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        ImageIcon logoIcon = new ImageIcon(getClass().getResource(LOGO_IMAGE_ICON));
        Image scaledLogoIcon = logoIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        this.setIconImage(scaledLogoIcon);

        JPanel panel = new JPanel();
        ImageIcon logoImg = new ImageIcon(getClass().getResource(LOGO_IMAGE));
        Image scaledLogoImg = logoImg.getImage().getScaledInstance(360, 360, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaledLogoImg));
        logoLabel.setText(PROJECT_NAME);
        logoLabel.setFont(LOGO_FONT_LARGE);
        logoLabel.setForeground(WHITE);
        logoLabel.setHorizontalTextPosition(JLabel.CENTER);
        logoLabel.setVerticalTextPosition(JLabel.BOTTOM);
        panel.add(logoLabel);
        panel.setOpaque(false);
        GradientPanel background = new GradientPanel(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        background.setLayout(new GridBagLayout());
        background.add(panel, gbc);

        this.setLayout(new BorderLayout());
        this.add(background, BorderLayout.CENTER);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
