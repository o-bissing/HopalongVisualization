import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {

    MyPicture picture;
    JPanel buttonsBar;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;

    public MyPanel() { // MyPanel class constructor

        picture = new MyPicture(); // creates an instance of the MyPicture class

        button1 = new JButton("Hopalong 1"); // creates new button with a label "Hopalong 1"
        button1.addActionListener(this); // adds ActionListener to this new button
        button1.setFocusable(false); // deletes a focus from this new button
        button2 = new JButton("Hopalong 2");
        button2.addActionListener(this);
        button2.setFocusable(false);
        button3 = new JButton("Hopalong 3");
        button3.addActionListener(this);
        button3.setFocusable(false);
        button4 = new JButton("Hopalong 4");
        button4.addActionListener(this);
        button4.setFocusable(false);
        button5 = new JButton("Randomize colors");
        button5.addActionListener(this);
        button5.setFocusable(false);

        buttonsBar = new JPanel(); // creates a new panel
        buttonsBar.setBackground(Color.black); // sets the background color of this new panel
        buttonsBar.setPreferredSize(new Dimension(100, 35)); // sets the size of this new panel
        buttonsBar.setLayout(new FlowLayout()); // sets the layout of this new panel
        buttonsBar.add(button1); // adds the button to this new panel
        buttonsBar.add(button2);
        buttonsBar.add(button3);
        buttonsBar.add(button4);
        buttonsBar.add(button5);

        this.setSize(600, 650); // sets the size of the panel
        this.setLayout(new BorderLayout(0, 5)); // sets the layout of the panel
        this.add(picture, BorderLayout.CENTER); // adds picture object to the panel and locates it in the center position
        this.add(buttonsBar, BorderLayout.SOUTH); // adds buttonsBar object to the panel and locates it in the south position
        this.setVisible(true); // makes the panel visible
    }

    @Override
    public void actionPerformed(ActionEvent e) { // overrides the actionPerformed method

        if(e.getSource() == button1) { // if ActionEvent "e" is a pushed button 1 the program does what is inside the curly brackets
            this.remove(picture); // removes the picture object
            picture = new MyPicture(1.1, -0.5, 1, 500000, 1); // creates new picture object
            this.add(picture); // adds this new picture object to the panel
            SwingUtilities.updateComponentTreeUI(this); // updates components to show changes
        }
        if(e.getSource() == button2) {
            this.remove(picture);
            picture = new MyPicture(1.1, 0.5, 1, 2500000, 2);
            this.add(picture);
            SwingUtilities.updateComponentTreeUI(this);
        }
        if(e.getSource() == button3) {
            this.remove(picture);
            picture = new MyPicture(5, 1, 20, 500000, 3);
            this.add(picture);
            SwingUtilities.updateComponentTreeUI(this);
        }
        if(e.getSource() == button4) {
            this.remove(picture);
            picture = new MyPicture(1, 0.1, 20, 1000000, 4);
            this.add(picture);
            SwingUtilities.updateComponentTreeUI(this);
        }
        if(e.getSource() == button5) {
            repaint(); // repaints current picture object
        }
    }
}
