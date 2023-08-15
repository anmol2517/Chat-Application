package ChatServer;

import javax.swing.*;
import java.awt.*;

public class Splash {

    public static void main(String[] args) {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - 480) / 2;
        int y = (screen.height - 500) / 2;
        JWindow win = new JWindow();
        SplashPanel s = new SplashPanel();
        win.setContentPane(s);
        win.setBounds(x, y, 480, 500);
        win.setVisible(true);


        try {
            for (int i = 1; i <= 100; i++) {
                Thread.sleep(50);
                s.abc(i);

            }
        } catch (Exception e) {
        }
        win.setVisible(false);
        JFrame f = new JFrame("Server");
        f.setContentPane(new ChatJPanel2());
        f.setBounds(10, 10, 600, 450);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


