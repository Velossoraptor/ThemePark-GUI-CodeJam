import javax.swing.*;
import java.awt.*;


public class Screen {
    private JFrame gameScreen = new JFrame();
    private JTabbedPane menu = new JTabbedPane();
    private ImageIcon player = new ImageIcon("C:/Users/talia/OneDrive - Limestone DSB/ICS4U/ThemePark-GUI-CodeJam/ThemePark/src/sprite.png");
    private JLabel playerIcon = new JLabel(player);
    private JLabel map = new JLabel();
    private JPanel main = new JPanel();

    public Screen(){
        player.setImage(player.getImage().getScaledInstance(200,300,0));
        playerIcon.setIcon(player);
        main.add(playerIcon);
        menu.addTab("Main Menu", main);
        gameScreen.add(menu);
        gameScreen.setSize(1420,1000);
        gameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameScreen.setVisible(true);
        
    }
}
