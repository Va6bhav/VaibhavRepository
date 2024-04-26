import javax.imageio.ImageIO;
import java.io.IOException;
public class PCar extends BothC {
    public PCar(){
        x=300;
        y=500;
        h=100;
        w=100;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("care5.jpeg"));
        } catch (IOException e) {
            System.out.println("Image not found");
            e.printStackTrace();
        }
    }
    public void move(){
         x=x+speed;
     }
    
}
