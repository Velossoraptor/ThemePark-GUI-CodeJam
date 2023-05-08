import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Screen implements KeyListener {
    //frame size and frame
    static private int screenX = 1420;
    static private int screenY = 1000;

    //toggle for if tab is already created for game
    static private int targetGame = 0;
    static private int targetGame2 = 0;

    //game frame
    private JFrame gameScreen = new JFrame();

    //game tabbed pane
    public static JTabbedPane menu = new JTabbedPane();
    
    //Main game components
    private ImageIcon mapImage = new ImageIcon("C:/Users/talia/OneDrive - Limestone DSB/ICS4U/ThemePark-GUI-CodeJam/ThemePark/src/game map.png");
    private Player player = new Player("Jamie");
    private JLabel map = new JLabel();
    private JPanel main = new JPanel();

    //target game components
    private ImageIcon targetBG = new ImageIcon("C:/Users/talia/OneDrive - Limestone DSB/ICS4U/ThemePark-GUI-CodeJam/ThemePark/src/dunk tank.png");
    private JLabel targetLabel = new JLabel(targetBG);
    private ClownDunk targetScreen = new ClownDunk();
    public static JPanel targetPanel = new JPanel();

    //coming soon components
    public ImageIcon frogBG = new ImageIcon("C:/Users/talia/OneDrive - Limestone DSB/ICS4U/ThemePark-GUI-CodeJam/ThemePark/src/comingsoon.png");
    public JLabel frogLabel = new JLabel(frogBG);
    public JPanel frogPanel = new JPanel();

    public Screen(){
        targetPanel.add(targetLabel);
        targetPanel.add(targetScreen);
        frogPanel.add(frogLabel);
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

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // if player is within a certain space, allow to move
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
        
        //Check if player is in correct zone, adds correspondent tab
        if(player.getX()<=player.getScaledX() && player.getY()>=screenY-player.getScaledY()*2 && targetGame <=1){
             addTab("Target Game",targetPanel);
             menu.setSelectedIndex(targetGame+1);
             targetGame++;
        }
        else if(player.getX()>=screenX-player.getScaledX()*2 && player.getY()>=screenY-player.getScaledY()*2 && targetGame<=1){
            addTab("FROGGO",frogPanel);
            menu.setSelectedIndex(targetGame+1);
            targetGame++;
        }
        

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Unused
    }
}
