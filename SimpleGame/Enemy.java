import javax.swing.ImageIcon;
import java.net.URL;

public class Enemy extends Botheandp {
    
    public Enemy(int x,int speed) {
       this.speed=speed;
        w=200;
        h=100;
        this.x=x;
        y=30;
        try {
            URL imageUrl = Enemy.class.getResource("Spider.gif");
            if (imageUrl != null) {
                image = new ImageIcon(imageUrl);
            } else {
                System.out.println("Enemy image not found");
            }
        } catch (Exception e) {
            System.out.println("Error loading Enemy image: " + e.getMessage());
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
