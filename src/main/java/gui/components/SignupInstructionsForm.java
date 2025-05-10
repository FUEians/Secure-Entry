package gui.components;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import static logic.Config.*;

public class SignupInstructionsForm extends JDialog {

    private SignupInstructionsForm form = this;
    public SignupInstructionsForm(JFrame parent) {
        super(parent, "Signup Instructions", true);
        this.setSize(500, 550);
        this.setLocationRelativeTo(parent);
        this.setResizable(false);
        this.getContentPane().setBackground(JET_BLACK);

        JLabel instructions = new JLabel();
        instructions.setFont(POPPINS_REGULAR_15);
        instructions.setForeground(WHITE);
        instructions.setOpaque(false);
        instructions.setVerticalAlignment(SwingConstants.TOP);

        instructions.setText("<html>"
                + "<h2>Signup Instructions</h2>"
                + "<ul>"
                + "<li><b>Name:</b><ul>"
                + "<li>Must be your first name only</li>"
                + "<li>No numbers, symbols, or whitespace</li>"
                + "<li>Maximum 10 characters</li>"
                + "</ul></li><br>"
                + "<li><b>Email:</b><ul>"
                + "<li>Must contain '@' and '.' symbols</li>"
                + "</ul></li><br>"
                + "<li><b>Password:</b><ul>"
                + "<li>At least 1 uppercase letter (A–Z)</li>"
                + "<li>At least 1 lowercase letter (a–z)</li>"
                + "<li>At least 1 digit (0–9)</li>"
                + "<li>At least 1 special character (!@#$%^&*)</li>"
                + "<li>Minimum length: 8 characters</li>"
                + "</ul></li>"
                + "</ul></html>"
        );

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setOpaque(false);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        contentPanel.add(instructions, BorderLayout.CENTER);

        Button okButton = new Button(
                "OK",
                OK_BUTTON_SIZE,
                POPPINS_EXTRABOLD_20,
                LIGHT_GREEN,
                applyLightGreenStyleButtonEffect()
        );

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);
        buttonPanel.add(okButton);

        contentPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(contentPanel);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                form.dispose();
            }
        });      
        this.setVisible(true);
    }
}
