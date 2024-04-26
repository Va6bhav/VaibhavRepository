import java.awt.Graphics;
import java.awt.image.BufferedImage;
public abstract class BothC {
    public BufferedImage image;
   public int speed;
   public int x;
    public int y;
    public int w;
   public int h;
    public void draw(Graphics pen){
        pen.drawImage(image, x, y,null);
    }
   
}
