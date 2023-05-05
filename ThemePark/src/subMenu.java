import javax.swing.*;
import java.awt.*;

public class subMenu extends JInternalFrame {
    private JTextField userNameIn = new JTextField("Username");
    private String userName;

    public subMenu(){
        this.setSize(500,500);
        this.add(userNameIn);
        userName=userNameIn.getText();
    }
}
