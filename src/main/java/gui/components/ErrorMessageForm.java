package gui.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import static logic.Config.*;

public class ErrorMessageForm extends JDialog {

    private ErrorMessageForm errorMessage = this;

    public ErrorMessageForm(JFrame parent) {
        super(parent, "Input Error", true);
        this.setSize(300, 250);
        this.setLocationRelativeTo(parent);
        this.setResizable(false);
        this.getContentPane().setBackground(JET_BLACK);

        ImageIcon rawIcon = new ImageIcon(getClass().getResource(ERROR_ICON));
        Image scaledImage = rawIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon errorIcon = new ImageIcon(scaledImage);

        JLabel combinedLabel = new JLabel(                            
                "<html><div style='text-align: center;'>"
              + "Something went wrong,<br>please check your inputs!"
              + "</div></html>", 
                errorIcon, 
                JLabel.CENTER
        );
        combinedLabel.setVerticalTextPosition(SwingConstants.BOTTOM);  
        combinedLabel.setHorizontalTextPosition(SwingConstants.CENTER); 
        combinedLabel.setForeground(Color.RED);
        combinedLabel.setFont(POPPINS_REGULAR_15);
        combinedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        combinedLabel.setVerticalAlignment(SwingConstants.CENTER);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setOpaque(false);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        contentPanel.add(combinedLabel, BorderLayout.CENTER);

        Button okButton = new Button(
                "OK",
                OK_BUTTON_SIZE,
                POPPINS_EXTRABOLD_20,
                LIGHT_GREEN,
                applyLightGreenStyleButtonEffect()
        );
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorMessage.dispose();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);
        buttonPanel.add(okButton);

        contentPanel.add(buttonPanel, BorderLayout.SOUTH);
        this.add(contentPanel);
        this.setVisible(true);
    }
}
