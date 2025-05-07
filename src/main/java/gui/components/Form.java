package gui.components;

import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JFrame;
import static logic.Config.*;

public class Form extends JDialog {
    
    public Form(JFrame frame ,String title, Dimension dimension) {
        super(frame, title, true);
        this.setSize(dimension);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(JET_BLACK);
        
        
        
        this.setVisible(true);
        
    }
}
