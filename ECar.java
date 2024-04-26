import javax.imageio.ImageIO;
import java.io.IOException;
public class ECar extends BothC {
  
    public ECar(int x,int speed,int w,int h ){
        this.speed=speed;
        this.x=x;
        y=0;
        this.w=w;
        this.h=h;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("care4.jpeg"));
        } catch (IOException e) {
            System.out.println("Image not found");
            e.printStackTrace();
        }
    }
    public void move(){
       if(y>900){
        y=0;
       }
        y=y+speed;
    }
   
}

