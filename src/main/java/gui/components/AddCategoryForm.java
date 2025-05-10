package gui.components;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKey;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;
import static logic.Config.*;
import logic.EncryptionUtil;
import models.AccountEntry;
import models.Category;
import models.User;

public class AddCategoryForm extends JDialog {

    private AddCategoryForm addCategory = this;
    private JPanel accountsContainer;
    private int accountCount = 0;
    private final int MAX_ACCOUNTS = 4;
    private User user;

    public AddCategoryForm(JFrame parent, User user) {
        super(parent, "Add Category", true);
        this.setSize(1200, 600);
        this.setLocationRelativeTo(parent);
        this.setResizable(false);
        this.getContentPane().setBackground(JET_BLACK);
        this.user = user;

        JLabel categoryLabel = new JLabel("Category Name");
        categoryLabel.setFont(POPPINS_REGULAR_20);
        categoryLabel.setForeground(WHITE);

        TextField categoryField = new TextField(DEFAULT_TEXT_FIELD_SIZE);

        JPanel categoryPanel = new JPanel();
        categoryPanel.setLayout(new BoxLayout(categoryPanel, BoxLayout.Y_AXIS));
        categoryPanel.setOpaque(false);
        categoryPanel.setBorder(BorderFactory.createEmptyBorder(20, 25, 10, 25));

        categoryLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        categoryField.setAlignmentX(Component.LEFT_ALIGNMENT);

        categoryPanel.add(categoryLabel);
        categoryPanel.add(categoryField);

        accountsContainer = new JPanel();
        accountsContainer.setLayout(new BoxLayout(accountsContainer, BoxLayout.Y_AXIS));
        accountsContainer.setOpaque(false);

        JScrollPane scrollPane = new JScrollPane(accountsContainer) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(530, 300);
            }
        };

        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(false);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        scrollPane.getVerticalScrollBar().setBlockIncrement(100);

        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = LIGHT_GREEN;
                this.trackColor = JET_BLACK;
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }

            private JButton createZeroButton() {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0));
                button.setMinimumSize(new Dimension(0, 0));
                button.setMaximumSize(new Dimension(0, 0));
                return button;
            }

            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(LIGHT_GREEN);
                g2.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, 10, 10);
                g2.dispose();
            }
        });

        addAccountPanel();
        Button addButton = new Button(
                "+",
                ADD_ACCOUNT_BUTTON_SIZE,
                POPPINS_REGULAR_25,
                LIGHT_GREEN,
                applyLightGreenStyleButtonEffect()
        );
        addButton.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (accountCount < MAX_ACCOUNTS) {
                    addAccountPanel();
                    accountsContainer.revalidate();
                    accountsContainer.repaint();
                } else {
                    AccountLimitReachedForm accLimitReached = new AccountLimitReachedForm(parent);
                }
            }
        });

        JPanel addButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        addButtonPanel.setOpaque(false);
        addButtonPanel.add(addButton);

        Button submitButton = new Button(
                "Add Category",
                MEDIUM_BUTTON_SIZE,
                POPPINS_EXTRABOLD_20,
                LIGHT_GREEN,
                applyLightGreenStyleButtonEffect()
        );

        submitButton.addActionListener(e -> {
            String categoryName = categoryField.getText();
            if (categoryName.isEmpty()) {
                new ErrorMessageForm(parent); 
                return;
            }
            Component[] components = accountsContainer.getComponents();
            List<AccountEntry> accountList = new ArrayList<>();

            for (Component comp : components) {
                if (comp instanceof JPanel panel) {
                    Component[] fields = panel.getComponents();
                    String accountName = null;
                    String accountEmail = null;
                    String accountPassword = null;
                    for (Component field : fields) {
                        if (field instanceof TextField tf) {
                            if (tf.getText().trim().isEmpty()) {
                                new ErrorMessageForm(parent); 
                                return;
                            }
                            if (accountName == null) {
                                accountName = tf.getText().trim(); 
                            } else if (accountEmail == null) {
                                accountEmail = tf.getText().trim(); 
                            } else if (accountPassword == null) {
                                accountPassword = tf.getText().trim(); 
                            }
                        }
                    }
                    if (accountName != null && accountEmail != null && accountPassword != null) {
                        try {
                            SecretKey key = EncryptionUtil.generateAESKey();
                            String encryptedPassword = EncryptionUtil.encrypt(accountPassword, key);
                            
                        } catch (Exception ex) {
                            Logger.getLogger(AddCategoryForm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        AccountEntry account = new AccountEntry(accountName, accountEmail, accountPassword);
                        accountList.add(account);
                    }
                }
            }
            Category newCategory = new Category(categoryName);
            newCategory.setAccounts(accountList);
            addCategory.dispose();
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);
        buttonPanel.add(submitButton);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setOpaque(false);
        JPanel categoryWrapper = new JPanel(new FlowLayout(FlowLayout.LEFT));
        categoryWrapper.setOpaque(false);
        categoryWrapper.add(categoryPanel);
        contentPanel.add(categoryWrapper);
        contentPanel.add(scrollPane);
        contentPanel.add(addButtonPanel);
        contentPanel.add(buttonPanel);

        this.add(contentPanel);
        this.setVisible(true);
    }

    private void addAccountPanel() {
        JPanel accountPanel = new JPanel();
        accountPanel.setLayout(new GridLayout(3, 2, 10, 10));
        accountPanel.setOpaque(false);
        accountPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(WHITE), "Account " + (accountCount + 1), 0, 0, POPPINS_REGULAR_20, WHITE));

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(WHITE);
        nameLabel.setFont(POPPINS_REGULAR_20);

        TextField nameField = new TextField(DEFAULT_TEXT_FIELD_SIZE);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(WHITE);
        emailLabel.setFont(POPPINS_REGULAR_20);

        TextField emailField = new TextField(DEFAULT_TEXT_FIELD_SIZE);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(WHITE);
        passwordLabel.setFont(POPPINS_REGULAR_20);

        TextField passwordField = new TextField(DEFAULT_TEXT_FIELD_SIZE);

        accountPanel.add(nameLabel);
        accountPanel.add(nameField);
        accountPanel.add(emailLabel);
        accountPanel.add(emailField);
        accountPanel.add(passwordLabel);
        accountPanel.add(passwordField);

        accountsContainer.add(Box.createVerticalStrut(30));
        accountsContainer.add(accountPanel);
        accountCount++;
    }
}
