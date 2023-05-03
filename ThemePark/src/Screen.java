import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Screen implements KeyListener {
    private JFrame gameScreen = new JFrame();
    private JTabbedPane menu = new JTabbedPane();
    private ImageIcon player = new ImageIcon("C:/Users/talia/OneDrive - Limestone DSB/ICS4U/ThemePark-GUI-CodeJam/ThemePark/src/sprite.png");
    private JLabel playerIcon = new JLabel(player);
    private Player jacob = new Player("Jacob");
    private JLabel map = new JLabel();
    private JPanel main = new JPanel();

    public Screen(){
        // player.setImage(player.getImage().getScaledInstance(200,300,0));
        // playerIcon.setIcon(player);
        main.add(jacob);
        menu.addTab("Main Menu", main);
        gameScreen.add(menu);
        gameScreen.setSize(1420,1000);
        gameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameScreen.addKeyListener(this);
        gameScreen.setVisible(true);
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        switch(e.getKeyChar()){
            case 'w':
                jacob.move(0,-1);
                break;
            case 'a':
                jacob.move(-1,0);
                break;
            case 's':
                jacob.move(0,1);
                break;
            case 'd':
                jacob.move(1,0);
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
}
