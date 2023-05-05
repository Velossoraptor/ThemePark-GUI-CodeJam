import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TargetGame extends JFrame implements ActionListener {
    JPanel panel = new JPanel();
    JTextField powerInput = new JTextField(7);
    JTextField angleInput = new JTextField(7);
    JButton fireConfirm = new JButton("Shoot");
    ActionEvent event;
    int power;
    int angle; 
    public static void main (String[] args){
     new TargetGame();
    }

    public TargetGame() {
        setTitle("Target Game");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().add(panel);
        panel.setLayout(null);

        powerInput.setHorizontalAlignment(SwingConstants.RIGHT);
        powerInput.setBounds(20, 20, 80, 25);
        panel.add(powerInput);
        
        angleInput.setHorizontalAlignment(SwingConstants.RIGHT);
        angleInput.setBounds(20, 50, 80, 25);
        panel.add(angleInput);
       
        fireConfirm.setBounds(30, 100, 80, 25);
        fireConfirm.addActionListener(event -> this.handleFire(event));
        panel.add(fireConfirm);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        

    }

    private void handleFire(ActionEvent event){
        String tempP = powerInput.getText();
        power = Integer.parseInt(tempP);

        String tempA = angleInput.getText();
        angle = Integer.parseInt(tempA);

        if(power == 12 && angle == 12){
            panel.remove(powerInput);
            panel.remove(angleInput);
            panel.remove(fireConfirm);

            JLabel text = new JLabel("You hit the target!");
            text.setHorizontalAlignment(SwingConstants.RIGHT);
            text.setBounds(20, 20, 150, 25);
            panel.add(text);
            panel.revalidate();
            panel.repaint();

            JButton confirm = new JButton("Confirm");
            confirm.setBounds(30, 100, 80, 25);
            confirm.addActionListener(a -> this.confirmButton(event));
            panel.add(confirm);
        }
    }

    private void confirmButton(ActionEvent a) {
        this.setVisible(false);
    }
}
