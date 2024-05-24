import javax.swing.JPanel;

import java.io.IOException;
import javax.swing.Timer;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GframeSir extends JPanel {
    Timer timer;
    BufferedImage loadImage;
    Player player;
    Enemy enemy[]=new Enemy[3];
    public GframeSir(){
        setSize(1500,920);
        loadImage();
        player=new Player();
        loadenemy();
        gameloop();
      
        bindevents();
        setFocusable(true);
    }
    private void gameOver(Graphics pen){
       if(player.outofScreen()){
        pen.setFont(new Font("times",Font.BOLD,30));
        pen.setColor(Color.RED);
        pen.drawString("GAME WIN",1500/2,900/2);
        timer.stop();
       }
        for(Enemy enem : enemy){
            if(isCollide(enem)){
                pen.setFont(new Font("times",Font.BOLD,30));
                pen.setColor(Color.RED);
                pen.drawString("GAME OVER",1500/2,900/2);
                timer.stop();
            }
        }
    }
    private boolean isCollide(Enemy enemy){
        int xDistance=Math.abs(player.x-enemy.x);
        int yDistance=Math.abs(player.y-enemy.y);
        int maxH=Math.max(player.h,enemy.h);
        int maxW=Math.max(player.w,enemy.w);
        return xDistance<=maxW-80 && yDistance<=maxH-310;
    }
    private void bindevents(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Implement keyTyped functionality here
            }
    
            @Override
            public void keyPressed(KeyEvent e) {
                // Implement keyPressed functionality here
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                player.speed = 7; // For example
            }
                else if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    player.speed=-7;
                }
            
            }
    
            @Override
            public void keyReleased(KeyEvent e) {
                // Implement keyReleased functionality here
                player.speed = 0; // For example
            }
        });
    }
    private void loadenemy(){
        int x=400;
        int gap=400;
        int speed =5;
    for(int i=0;i<enemy.length;i++){
        enemy[i]=new Enemy(x,speed);
        x=x+gap;
        speed=speed+5;
    }
    }
    private void gameloop(){
        timer=new Timer(50,(e)->repaint());
        timer.start();
    }
    private void loadImage() {
        try {
            loadImage = ImageIO.read(GframeSir.class.getResource("Forest11.jpg")); // Assuming "Forest11.jpg" is the image file name
        } catch (IOException e) {
            System.out.println("Image not found");
            e.printStackTrace();
            System.exit(1);
        }
    }
    private void printenemy(Graphics pen){
        for(Enemy enemys:enemy){
           enemys.draw(pen);
           enemys.move(); 
        }
    }
    @Override
    public void paintComponent(Graphics pen){
        super.paintComponent(pen);
        pen.drawImage(loadImage,0,0,1500,920,null);
        player.draw(pen);
        player.move();
        printenemy(pen);
        gameOver(pen);
    }
        
        
    

}
