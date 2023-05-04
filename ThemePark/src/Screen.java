import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Screen implements KeyListener {
    //frame size and frame
    static private int screenX = 1420;
    static private int screenY = 1000;
    static private boolean target = false;
    private JFrame gameScreen = new JFrame();
    //various elements
    private JTabbedPane menu = new JTabbedPane();
    //DELETE \/ LATER
    public ImageIcon test = new ImageIcon("C:/Users/talia/OneDrive - Limestone DSB/ICS4U/ThemePark-GUI-CodeJam/ThemePark/src/sprite.png");
    public JLabel testlabel = new JLabel(test);
    public JPanel testPanel = new JPanel();
    private ImageIcon mapImage = new ImageIcon("C:/Users/talia/OneDrive - Limestone DSB/ICS4U/ThemePark-GUI-CodeJam/ThemePark/src/game map.png");
    public Player player = new Player("Jamie");
    private JLabel map = new JLabel();
    private JPanel main = new JPanel();

    public Screen(){
        testPanel.add(testlabel);
        main.setLayout(null);
        map.setIcon(mapImage);
        map.setBounds(0,0,screenX,screenY);
        player.setBounds(screenX/2-player.getScaledX()/2,0,player.getScaledX(),player.getScaledY());
        main.add(map);
        main.add(player);
        //move player in front
        main.setComponentZOrder(player,0);
        menu.addTab("Main Menu", main);
        gameScreen.add(menu);
        gameScreen.setSize(screenX,screenY);
        gameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameScreen.addKeyListener(this);
        gameScreen.setFocusable(true); //THIS IS IMPORTANT FOR KEYLISTENER
        gameScreen.setVisible(true);
        
    }

    public static int getScreenX(){
        return screenX;
    }

    public static int getScreenY(){
        return screenY;
    }
    //adds tab to tabbedpane
    public void addTab(String title, Component JPanel){
        menu.addTab(title, JPanel);
        gameScreen.add(menu);
    }

    //trigger when player moved, incomplete
    public void checkAddTab(Boolean tabOn, String tabTitle, Component tabPanel){
        if(player.getX()<300 && player.getY()>screenY-player.getScaledY()*3){
            if(tabOn=false){
                addTab(tabTitle,tabPanel);
                tabOn=true;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        switch(e.getKeyChar()){
            case 'w':
                if(player.getY()>=player.getScaledY()){
                    player.setLocation(player.getX(),player.getY()-player.getScaledY());
                }
                break;
            case 'a':
                if(player.getX()>=player.getScaledX()){
                    player.setLocation(player.getX()-player.getScaledX(),player.getY());
                }
                break;
            case 's':
                if(player.getY()<=screenY-player.getScaledY()*2.5){
                    player.setLocation(player.getX(),player.getY()+player.getScaledY());
                }
                break;
            case 'd':
                if(player.getX()<=screenX-player.getScaledX()*2){
                    player.setLocation(player.getX()+player.getScaledX(),player.getY());
                }
                break;
        }
        
        if(player.getX()<=player.getScaledX() && player.getY()>=screenY-player.getScaledY()*2){
             addTab("Target Game",testPanel);
        }
        

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
}
