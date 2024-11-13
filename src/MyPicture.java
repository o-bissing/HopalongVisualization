import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MyPicture extends JPanel {

    // creates variables:
    private static final int h = 600;
    private static final int w = 600;
    private static final double t = 5, b = 1.2, l = -2.0, r = 1.5;

    private double d, e, f;
    private long dots;
    private int scale;

    public MyPicture() { // MyPicture class constructor
        this.setPreferredSize(new Dimension(w, h)); // sets the size of this new panel
        // initializes variables:
        this.d = 1.1;
        this.e = -0.5;
        this.f = 1;
        this.dots = 500000;
        this.scale = 1;
    }

    public MyPicture(double d, double e, double f, long dots, int scale) { // overrides constructor with given parameters
        this.setPreferredSize(new Dimension(w, h));
        this.d = d;
        this.e = e;
        this.f = f;
        this.dots = dots;
        this.scale = scale;
    }

    public void paint(Graphics g) { // overrides paint class

        super.paint(g); // calls the overridden class
        Graphics2D graph = (Graphics2D) g; // casts class Graphics into Graphics2D class

        setBackground(Color.black); // sets background color of the painted picture
        graph.setColor(randomColor()); // sets the painting color

        // initializes variables:
        double x = 0.0, y = 0.0, xnew, ynew;
        int i;

        if (scale == 1) { // if a given "scale" parameter is equal to 1 the program does what is inside the curly brackets
            graph.scale(0.04, 0.04); // scales the painted picture
            graph.rotate(-6, -19000, 28000); // rotates and moves the painted picture on both x and y axes
        } else if (scale == 2) {
            graph.scale(0.06, 0.06);
            graph.rotate(-6, -11500, 18000);
        } else if (scale == 3) {
            graph.scale(0.012, 0.012);
            graph.rotate(-6, -70000, 94000);
        } else if (scale == 4) {
            graph.scale(0.018, 0.018);
            graph.rotate(-6, -45000, 63000);
        }

        for (i = 0; i < dots; i++) {
            xnew = newX(x, y);
            ynew = newY(x);
            x = xnew;
            y = ynew;
            graph.drawLine(transX(x), transY(y), transX(x), transY(y)); // paints a line with given coordinates
            if (i % 100000 == 0) {
                graph.setColor(randomColor()); // changes the painting color
            }
        }
    }

    public Color randomColor() {
        Random rand = new Random(); // creates new instance of the Random class
        int r = rand.nextInt(255); // creates a random integer value between 0 and 255
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);
        return new Color(r, g, b); // returns new color with generated RGB values
    }

    public double newX(double x, double y) {
        int sgn = (x > 0) ? 1 : (x < 0) ? -1 : 0;
        return (y - sgn * Math.sqrt(Math.abs((e * x - f))));
    }

    public double newY(double x) {
        return d - x;
    }

    public int transX(double x)
    {
        return (int)((x - l) / (r - l) * w); // returns a casted into integer value the result of the calculations
    }

    public int transY(double y)
    {
        return (int)((y - t) / (b - t) * h);
    }
}
