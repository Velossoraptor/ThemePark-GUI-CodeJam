import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ClownDunk extends JLabel implements ActionListener {
    // Adds the powerInput, angleInput textfields
    JTextField powerInput = new JTextField(7);
    JTextField angleInput = new JTextField(7);
    
    // Adds the fireConfirm, confirm buttons
    JButton fireConfirm = new JButton("Shoot");
    JButton confirm = new JButton("Confirm");

    // Creates new ActionEvent for use in fireConfirm and confirm
    ActionEvent event;

    // Creates power and angle integers for storing powerInput and angleInput text
    int power;
    int angle;

    // Constructor
    public ClownDunk() {

        // Sets layout to null
        this.setLayout(null);

        // Sets the horizontal alignment, size, and position of powerInput: adds
        powerInput.setHorizontalAlignment(SwingConstants.RIGHT);
        powerInput.setBounds(20, 20, 80, 25);
        Screen.targetPanel.add(powerInput);

        // Sets the h-alignment, size, and position of angleInput: adds
        angleInput.setHorizontalAlignment(SwingConstants.RIGHT);
        angleInput.setBounds(20, 50, 80, 25);
        Screen.targetPanel.add(angleInput);

        // Sets the size and position of fireConfirm: adds
        fireConfirm.setBounds(30, 100, 80, 25);
        fireConfirm.addActionListener(event -> this.handleFire(event));
        Screen.targetPanel.add(fireConfirm);

        // Sets to visible
        this.setVisible(true);
    }

    // Filler method; Unused
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    // Handles the event when the fireConfirm button is pressed
    private void handleFire(ActionEvent event) {
        // Gets the text from powerInput and angleInput, converts them to integer
        String tempP = powerInput.getText();
        power = Integer.parseInt(tempP);

        String tempA = angleInput.getText();
        angle = Integer.parseInt(tempA);

        // Checks if power and angle are = correct #s
        if (power == 12 && angle == 12) {

            // Removes unnecessary components
            Screen.targetPanel.remove(powerInput);
            Screen.targetPanel.remove(angleInput);
            Screen.targetPanel.remove(fireConfirm);

            // Adds confirmation text, revalidates and repaints panel
            JLabel text = new JLabel("You hit the target!");
            text.setHorizontalAlignment(SwingConstants.RIGHT);
            text.setBounds(20, 20, 150, 25);
            Screen.targetPanel.add(text);
            Screen.targetPanel.setComponentZOrder(text, 0);
            Screen.targetPanel.revalidate();
            Screen.targetPanel.repaint();

            // Adds confirmation button, revalidates and repaints panel
            confirm.setBounds(30, 100, 80, 25);
            confirm.addActionListener(a -> this.confirmButton(event));
            Screen.targetPanel.add(confirm);
            Screen.targetPanel.setComponentZOrder(confirm, 0);
            Screen.targetPanel.revalidate();
            Screen.targetPanel.repaint();
        }
    }

    // Handles when confirm button is pressed
    private void confirmButton(ActionEvent a) {
        // Sets targetPanel to not visible, removes confirm button, changes the tab to the main menu
        Screen.targetPanel.setVisible(false);
        Screen.targetPanel.remove(confirm);
        Screen.menu.setSelectedIndex(0);
    }
}
