import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ClownDunk extends JLabel implements ActionListener {
    JTextField powerInput = new JTextField(7);
    JTextField angleInput = new JTextField(7);
    JButton fireConfirm = new JButton("Shoot");
    JButton confirm = new JButton("Confirm");
    ActionEvent event;
    int power;
    int angle;

    public ClownDunk(){
        this.setLayout(null);


        powerInput.setHorizontalAlignment(SwingConstants.RIGHT);
        powerInput.setBounds(20, 20, 80, 25);
        Screen.targetPanel.add(powerInput);
       
        angleInput.setHorizontalAlignment(SwingConstants.RIGHT);
        angleInput.setBounds(20, 50, 80, 25);
        Screen.targetPanel.add(angleInput);
       
        fireConfirm.setBounds(30, 100, 80, 25);
        fireConfirm.addActionListener(event -> this.handleFire(event));
        Screen.targetPanel.add(fireConfirm);


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
            Screen.targetPanel.remove(powerInput);
            Screen.targetPanel.remove(angleInput);
            Screen.targetPanel.remove(fireConfirm);


            JLabel text = new JLabel("You hit the target!");
            text.setHorizontalAlignment(SwingConstants.RIGHT);
            text.setBounds(20, 20, 150, 25);
            Screen.targetPanel.add(text);
            Screen.targetPanel.setComponentZOrder(text,0);
            Screen.targetPanel.revalidate();
            Screen.targetPanel.repaint();


            
            confirm.setBounds(30, 100, 80, 25);
            confirm.addActionListener(a -> this.confirmButton(event));
            Screen.targetPanel.add(confirm);
            Screen.targetPanel.setComponentZOrder(confirm,0);

            Screen.targetPanel.revalidate();
            Screen.targetPanel.repaint();
        }
    }


    private void confirmButton(ActionEvent a) {
        Screen.targetPanel.setVisible(false);
        Screen.targetPanel.remove(confirm);
        Screen.menu.setSelectedIndex(0);
    }
}
