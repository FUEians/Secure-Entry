
package gui.pages;

import javax.swing.JFrame;
import static logic.Config.*;
import javax.swing.*;
import java.awt.*;



public class Dashboard extends JFrame{
    
    public Dashboard(){
    
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle(PROJECT_NAME);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(JET_BLACK);
        this.setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel ();
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        mainPanel.setBackground(JET_BLACK);
        this.add(mainPanel);
        
        JPanel upPanel = new JPanel(new BorderLayout());
        upPanel.setBackground(LIGHT_GREEN);
       
        upPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 112));
        upPanel.setPreferredSize(new Dimension(1280, 112));
        mainPanel.add(upPanel);
       
        JPanel iconPanel = new JPanel (new FlowLayout( FlowLayout.LEFT));
        iconPanel.setOpaque(false);
        iconPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 0));
        upPanel.add(iconPanel,BorderLayout.WEST);
        
        ImageIcon icon = new ImageIcon(getClass().getResource(LOGO_IMAGE));
        Image image = icon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        JLabel iconLabel = new JLabel(icon);
        iconLabel.setText("Secure Entry");
        iconLabel.setFont(LOGO_FONT_SMALL);
        iconLabel.setForeground(WHITE);
        iconLabel.setIconTextGap(15);
        iconPanel.add(iconLabel);
   


        JTextField searchField = new JTextField(30);
        searchField.setPreferredSize(new Dimension(500, 56));
        searchField.setHorizontalAlignment(JTextField.LEFT);
        searchField.setBorder(BorderFactory.createEmptyBorder(10, 15, 200, 15)); 
        searchField.setBounds(300, 10, 360, 56);
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,0,30));
        centerPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 112));
        centerPanel.setOpaque(false); 
        centerPanel.add(searchField);
        upPanel.add(centerPanel, BorderLayout.CENTER);
        
        
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.setOpaque(false);
        rightPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 112));
        JLabel nameLabel = new JLabel("Mariam");
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        nameLabel.setForeground(Color.WHITE);
        ImageIcon profileIcon = new ImageIcon(getClass().getResource(AVATAR_1));
        Image profileImg = profileIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        profileIcon = new ImageIcon(profileImg);
        JLabel profileLabel = new JLabel(profileIcon);
        rightPanel.add(nameLabel);
        rightPanel.add(profileLabel);
        upPanel.add(rightPanel, BorderLayout.EAST);

         
       
      
        JPanel P1 = new JPanel();
        P1.setBackground(JET_BLACK); 
        P1.setLayout(new BoxLayout(P1, BoxLayout.Y_AXIS));
        P1.setPreferredSize(new Dimension(534, 478));
        P1.setMaximumSize(new Dimension(534, 478));
        P1.setAlignmentX(Component.CENTER_ALIGNMENT);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource(IMAGE_4));
        Image scaledImg = imageIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH); 
        imageIcon = new ImageIcon(scaledImg);
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
     
        JLabel textLabel = new JLabel("<html><div style='text-align: center;'>Your dashboard is empty!!<br>No categories added yet</div></html>");
        textLabel.setForeground(Color.LIGHT_GRAY);
        textLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
     
        P1.add(imageLabel);
        P1.add(Box.createRigidArea(new Dimension(0, 20)));  
        P1.add(textLabel);
        mainPanel.add(Box.createVerticalGlue()); 
        mainPanel.add(P1);
        mainPanel.add(Box.createVerticalGlue());
        
        
        
        this.setVisible(true);
    
        
        
    }
}
    
