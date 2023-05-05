import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class subMenu extends JInternalFrame implements ActionListener{
    //private JTextField userNameIn = new JTextField("Username",20);
    private String userName;
    private JButton girl = new JButton();
    private JButton boy = new JButton();

    public subMenu(String title, boolean closeable){
        this.setSize(500,500);
        this.setClosable(closeable);
        this.setTitle(title);
        boy.addActionListener(e -> handleBoy());

        this.add(girl);
        this.add(boy);
        //this.add(userNameIn);
        //userName=userNameIn.getText();
        this.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
        this.setVisible(true);

    }

    public void handleBoy(){
        Player.setIcon(playerBoy);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
