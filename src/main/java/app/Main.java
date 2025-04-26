package App;

import gui.pages.*;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Timer;

public class Main {

    private static LandingPage landingPage;
    private static SplashScreen splashScreen;

    public static void main(String[] args) {
        splashScreen = new SplashScreen();
        Action openLandingPageAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                landingPage = new LandingPage();
                splashScreen.dispose(); 
            }
        };
        Timer timer = new Timer(3000, openLandingPageAction);
        timer.setRepeats(false);
        timer.start();
    }
}
