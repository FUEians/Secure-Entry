package App;

import gui.pages.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Main {

    private static LandingPage landingPage;
    private static SplashScreen splashScreen;

    public static void main(String[] args) {
        splashScreen = new SplashScreen();
        ActionListener openLandingPageAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                landingPage = new LandingPage();
                splashScreen.dispose();
            }
        };
        Timer timer = new Timer(3000, openLandingPageAction);
        timer.setRepeats(false);
        timer.start();
//            Dashboard dashboard = new Dashboard("42795bae-97ab-42c6-af9a-27e961b8ba5c");
    }
}
