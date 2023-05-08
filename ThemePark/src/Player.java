import javax.swing.*;
import java.awt.*;

public class Player extends JLabel {
    //class variables
    static private ImageIcon playerIcon = new ImageIcon("C:/Users/talia/OneDrive - Limestone DSB/ICS4U/ThemePark-GUI-CodeJam/ThemePark/src/fGamechar1.png");
    private String name;
    private int coins = 0;
    private int lives = 3;
    private int x, y;

    //image scaled to these
    private int scaledX=100;
    private int scaledY = 100;

    //constructor
    public Player(String newName){
        playerIcon.setImage(playerIcon.getImage().getScaledInstance(scaledX,scaledY,0));
        this.name=newName;
        this.setIcon(playerIcon);
    }

    //Change methods
    public void movePlayer(int xChange, int yChange){
        this.x+=xChange;
        this.y+=yChange;
    }

    public void loseLife(){
        this.lives--;
    }

    public void gainCoin(){
        this.coins++;
    }

    //Getter Methods
    public String getName(){
        return this.name;
    }

    public int getCoins(){
        return this.coins;
    }

    public int getLives(){
        return this.lives;
    }
    //the size of the sprites image scale
    public int getScaledX(){
        return this.scaledX;
    }

    public int getScaledY(){
        return this.scaledY;
    }
}
