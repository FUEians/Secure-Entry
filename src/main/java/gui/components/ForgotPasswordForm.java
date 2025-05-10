package gui.components;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static logic.Config.*;
import logic.PasswordManager;

public class ForgotPasswordForm extends JDialog {

    private ForgotPasswordForm form = this;
    private JFrame parent;
    public ForgotPasswordForm(JFrame parent) {
        super(parent, "Forgot Password", true);
        this.parent = parent;
        this.setSize(500, 350);
        this.setLocationRelativeTo(parent);
        this.setResizable(false);
        this.getContentPane().setBackground(JET_BLACK);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setOpaque(false);
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 60, 30, 60));
        JLabel Nlabel = new JLabel("Name");
        Nlabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        Nlabel.setFont(POPPINS_REGULAR_15);
        Nlabel.setForeground(WHITE);
        TextField Nfield = new TextField(DEFAULT_TEXT_FIELD_SIZE);
        Nfield.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(Nlabel);
        formPanel.add(Nfield);
        formPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        JLabel Elabel = new JLabel("Email");
        Elabel.setFont(POPPINS_REGULAR_15);
        Elabel.setForeground(WHITE);
        Elabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        TextField Efield = new TextField(DEFAULT_TEXT_FIELD_SIZE);
        Efield.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(Elabel);
        formPanel.add(Efield);

        Button submitButton = new Button(
                "Submit",
                SUBMIT_BUTTON_SIZE,
                POPPINS_EXTRABOLD_20,
                LIGHT_GREEN,
                applyLightGreenStyleButtonEffect()
        );

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PasswordManager pm = new PasswordManager();
                boolean isVaildUser = pm.validUser(Nfield.getText(), Efield.getText());
                if(isVaildUser) {
                    form.dispose(); 
                    ResetPasswordForm resetPassword = new ResetPasswordForm(parent, pm.getUsers(), pm.getUser());
                } else {
                    form.dispose();
                    ErrorMessageForm errorMessage = new ErrorMessageForm(parent); 
                }
                
            }
        });
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);
        buttonPanel.add(submitButton);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setOpaque(false);
        contentPanel.add(formPanel, BorderLayout.CENTER);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.add(contentPanel);
        this.setVisible(true);
    }
}
