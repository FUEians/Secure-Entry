package gui.components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import static logic.Config.*;

public class AccountLimitReachedForm extends JDialog {
    public AccountLimitReachedForm(JFrame parent) {
        super(parent, "Limit Reached", true);
        this.setSize(400, 200);
        this.setLocationRelativeTo(parent);
        this.setResizable(false);
        this.getContentPane().setBackground(JET_BLACK);

        JLabel messageLabel = new JLabel("<html>Maximum of 4 accounts reached!</html>");
        messageLabel.setForeground(WHITE);
        messageLabel.setFont(POPPINS_REGULAR_15);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setVerticalAlignment(SwingConstants.CENTER);

        Button okButton = new Button(
                "OK",
                new Dimension(100, 40),
                POPPINS_EXTRABOLD_20,
                LIGHT_GREEN,
                applyLightGreenStyleButtonEffect()
        );

        okButton.addActionListener(e -> dispose());

        JPanel messagePanel = new JPanel(new BorderLayout());
        messagePanel.setOpaque(false);
        messagePanel.add(messageLabel, BorderLayout.CENTER);
        messagePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);
        buttonPanel.add(okButton);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setOpaque(false);
        contentPanel.add(messagePanel);
        contentPanel.add(buttonPanel);

        this.add(contentPanel);
        this.setVisible(true);
    }
}
