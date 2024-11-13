import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    MyPanel panel;

    public MyFrame() { // MyFrame class constructor

        panel = new MyPanel(); // creates an instance of the MyPanel class

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // closes program when the window is being closed
        this.setTitle("CG1 - Bissing_Oleg_Matr.-Nr.:47309"); // sets the title of the window
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img.png"))); // sets the icon of the window
        this.add(panel); // adds the created panel to the frame
        this.setSize(600, 650); // sets the size of the frame
        this.setLocationRelativeTo(null); // sets location of the created window to the center of the screen
        this.setVisible(true); // makes created window visible
    }
}
