package gui.components;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static logic.Config.CLOSED_EYE;
import static logic.Config.DEFAULT_TEXT_FIELD_SIZE;
import static logic.Config.JET_BLACK;
import static logic.Config.LIGHT_GREEN;
import static logic.Config.OPENED_EYE;
import static logic.Config.POPPINS_EXTRABOLD_20;
import static logic.Config.POPPINS_REGULAR_15;
import static logic.Config.SUBMIT_BUTTON_SIZE;
import static logic.Config.USERS_FILE_PATH;
import static logic.Config.WHITE;
import static logic.Config.applyLightGreenStyleButtonEffect;
import logic.HashUtil;
import logic.JsonStorage;
import logic.PasswordManager;
import models.User;

public class ResetPasswordForm extends JDialog  {
    private ResetPasswordForm form = this;
    private JFrame parent;
    private List<User> users;
    private User user;
    public ResetPasswordForm(JFrame parent, List<User> users ,User user) {
        super(parent, "Reset Your Password", true);
        this.parent = parent;
        this.users = users;
        this.user = user;
        this.setSize(500, 350);
        this.setLocationRelativeTo(parent);
        this.setResizable(false);
        this.getContentPane().setBackground(JET_BLACK);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setOpaque(false);
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 60, 30, 60));
        JLabel Plabel = new JLabel("Password");
        Plabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        Plabel.setFont(POPPINS_REGULAR_15);
        Plabel.setForeground(WHITE);
        PasswordField Pfield = new PasswordField(
                DEFAULT_TEXT_FIELD_SIZE,
                CLOSED_EYE,
                OPENED_EYE,
                40
        );
        Pfield.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(Plabel);
        formPanel.add(Pfield);
        formPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        JLabel PcLabel = new JLabel("Repeat your password");
        PcLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        PcLabel.setFont(POPPINS_REGULAR_15);
        PcLabel.setForeground(WHITE);
        PasswordField PcField = new PasswordField(
                DEFAULT_TEXT_FIELD_SIZE,
                CLOSED_EYE,
                OPENED_EYE,
                40
        );
        PcField.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(PcLabel);
        formPanel.add(PcField);

        Button resetButton = new Button(
                "Reset",
                SUBMIT_BUTTON_SIZE,
                POPPINS_EXTRABOLD_20,
                LIGHT_GREEN,
                applyLightGreenStyleButtonEffect()
        );

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PasswordManager pm = new PasswordManager();
                boolean isVaildPassword = pm.verifyPassword(Pfield.getText());
                boolean isConfirmed = pm.confirmPassword(Pfield.getText(), PcField.getText());
                if(isVaildPassword && isConfirmed) {
                    String hashedPassword = HashUtil.hashPassword(Pfield.getText());
                    user.setPassword(hashedPassword);
                    User newUser = user;
                    users.remove(user);
                    users.add(newUser);
                    JsonStorage.saveToFile(USERS_FILE_PATH, users);
                    form.dispose();    
                } else {
                    form.dispose();
                    ErrorMessageForm errorMessage = new ErrorMessageForm(parent); 
                }
                
            }
        });
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);
        buttonPanel.add(resetButton);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setOpaque(false);
        contentPanel.add(formPanel, BorderLayout.CENTER);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.add(contentPanel);
        this.setVisible(true);
    }
}
