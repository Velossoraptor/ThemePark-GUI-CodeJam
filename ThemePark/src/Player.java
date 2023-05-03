import javax.swing.*;
import java.awt.*;

public class Player extends JLabel {
    static private ImageIcon playerIcon = new ImageIcon("C:/Users/talia/OneDrive - Limestone DSB/ICS4U/ThemePark-GUI-CodeJam/ThemePark/src/sprite.png");
    private String name;
    private int coins = 0;
    private int lives = 3;
    private int x, y;

    public Player(String newName){
        playerIcon.setImage(playerIcon.getImage().getScaledInstance(100,150,0));
        this.name=newName;
        this.setIcon(playerIcon);
    }

    public void move(int xChange, int yChange){
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
}
