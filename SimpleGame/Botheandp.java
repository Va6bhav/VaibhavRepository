import java.awt.Graphics;
import javax.swing.ImageIcon;
public abstract class Botheandp {
    public int speed;
    public int x;
    public int y;
    public int w;
    public int h;
    public ImageIcon image;
    public void draw(Graphics pen){
        if (image != null) { // Check if image is not null before drawing
            pen.drawImage(image.getImage(), x, y,w,h, null); // Draw the image
        }
    }
    
} 

