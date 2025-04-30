package gui.pages;

//import java.io.ObjectInputFilter.Config;
import javax.swing.JFrame ;
//import logic.Config.* ;
import static logic.Config.*;
import javax.swing.*;
import java.awt.*;
import gui.components.*;
import gui.components.Button;
import gui.components.Checkbox;
import gui.components.TextField;

public class LoginPage extends JFrame {

    
    
    public LoginPage() {
        
      this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
      this.setTitle(PROJECT_NAME);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setResizable(false);
      this.setLayout(new GridLayout(1,2));
       
        ImageIcon image = new ImageIcon(getClass().getResource(IMAGE_3));
        Image scaledImg = image.getImage().getScaledInstance(550, 550, Image.SCALE_SMOOTH);
        JLabel Labelimage = new JLabel(new ImageIcon(scaledImg));
        JPanel LeftPanel = new JPanel();
        LeftPanel.setLayout(new FlowLayout( FlowLayout.CENTER));
        LeftPanel.setBackground(JET_BLACK);
        this.add(LeftPanel);
   
        LeftPanel.add(Labelimage);
        LeftPanel.setBorder(BorderFactory.createEmptyBorder(100,0,0 , 0));

//        imgPanel.setOpaque(false);

      
      //  right panel 
      GradientPanel RightPanel = new GradientPanel(true);
      RightPanel.setLayout(new BorderLayout());
      this.add(RightPanel);    
      

//      JPanel TopPanel = new GradientPanel(true);
//      TopPanel.setLayout(new BorderLayout());
//      TopPanel.setBackground(LIGHT_GREEN);
//      TopPanel.setBorder(BorderFactory.createEmptyBorder(100,0,0 , 0));
//      TopPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
      
      JLabel logLabel = new JLabel("Login",SwingConstants.CENTER);
      logLabel.setFont(POPPINS_EXTRABOLD_40);
      logLabel.setForeground(WHITE);
//      logLabel.setHorizontalAlignment(SwingConstants.CENTER);
      logLabel.setBounds(110,100,173, 60);
      RightPanel.add(logLabel,BorderLayout.NORTH);
//      RightPanel.add(TopPanel,BorderLayout.NORTH);
      RightPanel.setBorder(BorderFactory.createEmptyBorder(100,0,0 , 0));
      
      // Email

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setOpaque(false);
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 60, 30, 60));
        JLabel Elabel = new JLabel("Email");
        Elabel.setFont(POPPINS_REGULAR_15);
        Elabel.setForeground(JET_BLACK);
        Elabel.setAlignmentX(Component.LEFT_ALIGNMENT); 
        formPanel.add(Box.createRigidArea(new Dimension(0, 15))); 
        TextField Efield = new TextField(DEFAULT_TEXT_FIELD_SIZE);
        Efield.setAlignmentX(Component.LEFT_ALIGNMENT); 
        Efield.setMaximumSize(new Dimension(1000, 50)); 
        formPanel.add(Elabel);
        formPanel.add(Efield);
        RightPanel.add(formPanel, BorderLayout.CENTER);
        
        
        //password
        
        formPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        JLabel Plabel = new JLabel("Password");
        Plabel.setAlignmentX(Component.LEFT_ALIGNMENT); 
        Plabel.setFont(POPPINS_REGULAR_15);
        Plabel.setForeground(JET_BLACK);

        JPasswordField passwordField = createRoundedPasswordField();
        passwordField.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(Plabel);
        formPanel.add(passwordField);
        
        //Button
        

         Button loginbtn = new Button( 
                "Login"  ,
                new Dimension(1000,50) , 
                POPPINS_EXTRABOLD_30,
                JET_BLACK,
               applyDarkStyleButtonEffect()
                
        );
//          loginbtn.setPreferredSize();
        loginbtn.setPreferredSize(new Dimension(1000, 50));
        loginbtn.setMaximumSize(new Dimension(1000, 50));
        loginbtn.setAlignmentX(Component.LEFT_ALIGNMENT);
        loginbtn.setForeground(WHITE);

        formPanel.add(Box.createRigidArea(new Dimension(0, 25)))
       ;
        formPanel.add(loginbtn);

        
       // Remember me
        
        Checkbox rememberMe = new Checkbox("Remember me");
        loginbtn.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        rememberMe .setOpaque(false);
formPanel.add(rememberMe);

        
       // Forget password
        JPanel optionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel forgotPassword = new JLabel("<HTML><U>Forgot password?</U></HTML>");
        forgotPassword.setFont(POPPINS_REGULAR_15);
        forgotPassword.setForeground(JET_BLACK);
        optionPanel.setOpaque(false);
//        optionPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        optionPanel.add(rememberMe);
        optionPanel.add(forgotPassword);
        formPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        formPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
       
        
        formPanel.add(optionPanel);
        RightPanel.add(formPanel);
       
        formPanel.add(forgotPassword);
     
       
//         Registration link
//        
//        JPanel regPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,5,0));
//        
//        JLabel registerLabel = new JLabel("Don't have an account? ");
//        registerLabel.setFont(POPPINS_REGULAR_15);
//        registerLabel.setForeground(JET_BLACK);
//        regPanel.add(registerLabel);
//        JLabel registerLink = new JLabel("<HTML><U>Registration</U></HTML>");
//        regPanel.add(registerLink);
//        registerLink.setFont(POPPINS_REGULAR_15);
//        registerLink.setForeground(JET_BLACK);
//        registerLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        regPanel.setOpaque(false);
//        formPanel.add(Box.createRigidArea(new Dimension(0, 15)));
//        formPanel.add(regPanel);
//   
          this.setVisible(true);
    }


  
    private JPasswordField createRoundedPasswordField() 
    {
        return new JPasswordField() 
        {
            {
                setOpaque(false);
                setBorder(null);
                setPreferredSize(new Dimension(1000, 50));
                setMaximumSize(new Dimension(1000, 50));
            }

            @Override
            protected void paintComponent(Graphics g)
            {
                Graphics2D g2 = (Graphics2D) g.create();
              g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                super.paintComponent(g2);
                g2.dispose();
            }

            @Override
            protected void paintBorder(Graphics g) 
            {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(JET_BLACK);
                g2.setStroke(new BasicStroke(1));
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
                g2.dispose();
                        
                        }
                        
      
                
                };
      }
}

