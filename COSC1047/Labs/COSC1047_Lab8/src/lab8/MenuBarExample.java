/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC1047_lab8*/
package lab8;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu Bar For Lab8");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // create the menu
        JMenu fileMenu = new JMenu("File");

        // create the menu item
        JMenuItem quitMenuItem = new JMenuItem("Quit");

        // add action listener to quit menu item
        quitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // add the menu item to menu
        fileMenu.add(quitMenuItem);

        // add menu to menu bar
        menuBar.add(fileMenu);

        // set menu bar for the frame
        frame.setJMenuBar(menuBar);

        frame.setVisible(true);
    }
}
