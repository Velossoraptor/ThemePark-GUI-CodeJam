import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Screen implements KeyListener {
    static private int screenX = 1420;
    static private int screenY = 1000;
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
        gameScreen.setSize(screenX,screenY);
        gameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameScreen.addKeyListener(this);
        gameScreen.setFocusable(true); //THIS IS IMPORTANT FOR KEYLISTENER
        gameScreen.setVisible(true);
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
        switch(e.getKeyChar()){
            case 'w':
                if(jacob.getY()>=jacob.getScaledY()){
                    jacob.setLocation(jacob.getX(),jacob.getY()-jacob.getScaledY());
                }
                //System.out.println(e.getKeyChar());
                break;
            case 'a':
                if(jacob.getX()>=jacob.getScaledX()){
                    jacob.setLocation(jacob.getX()-jacob.getScaledX(),jacob.getY());
                }
                //jacob.movePlayer(-1,0);
                break;
            case 's':
                if(jacob.getY()<=screenY-jacob.getScaledY()*2){
                    jacob.setLocation(jacob.getX(),jacob.getY()+jacob.getScaledY());
                }
                //jacob.movePlayer(0,1);
                break;
            case 'd':
                if(jacob.getX()<=screenX-jacob.getScaledX()*2){
                    jacob.setLocation(jacob.getX()+jacob.getScaledX(),jacob.getY());
                }
                //jacob.movePlayer(1,0);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
}
