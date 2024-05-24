import javax.swing.ImageIcon;


import java.net.URL;
public class Player extends Botheandp {
   
    public Player() {
        w=200;
        h=350;
        x=100;
        y=350;
        try {
            URL imageUrl = Player.class.getResource("walk2.gif");
            if (imageUrl != null) {
                image = new ImageIcon(imageUrl);
            } else {
                System.out.println("Player image not found");
            }
        } catch (Exception e) {
            System.out.println("Error loading player image: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void move(){
        x=x+speed;
        
    }
   public boolean outofScreen(){
    return x>1500;
   }
}
