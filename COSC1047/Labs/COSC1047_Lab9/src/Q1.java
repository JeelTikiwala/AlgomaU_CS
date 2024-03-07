/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC1047_lab9*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Q1 {
    public static void main(String[] args) {
        // Create the GUI components
        JLabel emailLabel = new JLabel("Email Address:");
        JTextField emailField = new JTextField(20);
        
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);
        
        JButton signInButton = new JButton("Sign In");
        JLabel forgotPasswordLabel = new JLabel("Forgot password?");
        JLabel helpLabel = new JLabel("Help");

        // Create a panel and set layout
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(forgotPasswordLabel);
        panel.add(helpLabel);
        panel.add(signInButton);

        // Create the frame for sign in
        JFrame frame = new JFrame("Sign In");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 300);
        frame.add(panel);

        //this part is fot COSC1047_Lab10
        signInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                // Check username and password if it's correct
                if (email.equals("jtikiwala@algomau.ca") && password.equals("~1Qazxsw2")) {
                    // if email and password is correct then Successful login
                    JOptionPane.showMessageDialog(frame, "You are successfully logged in.");
                } else {
                    // if email and password is incorrect then Incorrect login
                    JOptionPane.showMessageDialog(frame, "Username or password is incorrect, login failed.");
                }
            }
        });

        // Add mouse listener for forgot password label
        forgotPasswordLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Open the forgot password page or perform related action
                JOptionPane.showMessageDialog(frame, "Forgot password, redirecting.");
            }
        });

        // Add mouse listener for help label
        helpLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Open the help page or perform related action
                JOptionPane.showMessageDialog(frame, "Help link clicked, redirecting.");
            }
        });

        // Display the frame
        frame.setVisible(true);
    }
}
