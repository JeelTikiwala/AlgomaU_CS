/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC1047_lab8*/
package lab8;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonDialogExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Dialog For Lab8");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // button
        JButton button = new JButton("LIFE");

        //action listener to the button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] emotions = {"Happy", "Sad", "Angry", "Guilt"};
                Font font = new Font("Arial", Font.BOLD, 14);
                JOptionPane.showMessageDialog(frame, emotions, "Emotions", JOptionPane.PLAIN_MESSAGE);
            }
        });

        //button font
        button.setFont(new Font("Arial", Font.BOLD, 20));

        //button to the frame
        frame.add(button);

        frame.setVisible(true);
    }
}
