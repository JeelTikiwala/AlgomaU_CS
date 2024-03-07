/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC1047_lab7*/
package lab7;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BorderLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BorderLayout For Lab7");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        JTextField centerTextField = new JTextField();
        JLabel northLabel = new JLabel("North");
        JButton westButton = new JButton("West");
        JButton eastButton = new JButton("East");
        JButton southButton = new JButton("South");

        // Create panels
        JPanel northPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel westPanel = new JPanel();
        JPanel eastPanel = new JPanel();
        JPanel southPanel = new JPanel();

        // Set layout for panels
        northPanel.setLayout(new BorderLayout());
        centerPanel.setLayout(new BorderLayout());

        // Add components to panels
        northPanel.add(northLabel, BorderLayout.NORTH);
        centerPanel.add(centerTextField, BorderLayout.CENTER);
        westPanel.add(westButton);
        eastPanel.add(eastButton);
        southPanel.add(southButton);

        // Get the content pane and set its layout to BorderLayout
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        // Add panels to the content pane
        contentPane.add(northPanel, BorderLayout.NORTH);
        contentPane.add(centerPanel, BorderLayout.CENTER);
        contentPane.add(westPanel, BorderLayout.WEST);
        contentPane.add(eastPanel, BorderLayout.EAST);
        contentPane.add(southPanel, BorderLayout.SOUTH);

        // Set frame size and visibility
        frame.setSize(400, 200);
        frame.setVisible(true);
    }
}
