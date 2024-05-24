import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel {
    private ImageIcon backgroundImage;
    private Timer timer;
    private Timer scoreTimer; 
    private PCar player;
    private ECar[] enemies = new ECar[6];
    private int score = 0; 

    public Board() {
        setSize(1500, 920);
        loadBackgroundImage();
        player = new PCar();
        loadEnemies();
        gameLoop();
        setFocusable(true);
        bindevents();
        startScoreTimer(); 
    }

    private void gameLoop() {
        timer = new Timer(50, (e) -> repaint());
        timer.start();
    }

    private void loadEnemies() {
        int x = 90;
        int gap = 250;
        int speed = 2;
        int w = 200;
        int h = 100;
        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = new ECar(x, speed, w, h);
            x = x + gap;
            speed = speed + 5;
        }
    }

    private void gameOver(Graphics pen) {
        
        for (ECar enemy : enemies) {
            if (isCollide(enemy)) {
                pen.setFont(new Font("times", Font.BOLD, 30));
                pen.setColor(Color.RED);
                pen.drawString("Game Over", 1500 / 2, 900 / 2);
                timer.stop();
                scoreTimer.stop(); 
                score = 0; 
                startScoreTimer(); 
            }
        }
    }

    private boolean isCollide(ECar enemy) {
        int xDistance = Math.abs(player.x - enemy.x);
        int yDistance = Math.abs(player.y - enemy.y);
        int maxH = Math.max(player.h, enemy.h);
        int maxW = Math.max(player.w, enemy.w);
        return xDistance <= maxW - 115 && yDistance <= maxH + 50;
    }

    private void bindevents() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player.speed = 9;
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    player.speed = -9;
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    player.y -= 9;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    player.y -= -9;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
                player.speed = 0;
            }
        });
    }
    private void drawScore(Graphics pen) {
        pen.setColor(Color.WHITE);
        pen.setFont(new Font("Arial", Font.BOLD, 20));
        pen.drawString("Score: " + score, 20, 30);
    }
    private void updateScore() {
        score++; 
    }
    private void startScoreTimer() {
        scoreTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateScore();
            }
        });
        scoreTimer.start();
    }
    @Override
    public void update(Graphics g) {
        paintComponent(g);
    }

    private void loadBackgroundImage() {
        try {
            backgroundImage = new ImageIcon("B:\\Realroad.gif");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error loading background image: " + e.getMessage());
        }
    }

    private void printEnemies(Graphics pen) {
        for (ECar enemy : enemies) {
            enemy.draw(pen);
            enemy.move();
        }
    }

    @Override
    public void paintComponent(Graphics pen) {
        super.paintComponent(pen);
        if (backgroundImage != null) {
            pen.drawImage(backgroundImage.getImage(), 0, 0, 1500, 950, this);
        }
        player.draw(pen);
        player.move();
        printEnemies(pen);
        drawScore(pen); 
        gameOver(pen);
    } 
}
