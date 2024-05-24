

import javax.swing.JFrame;

public class MyGame extends JFrame {
    public MyGame(){
        Board board=new Board();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MyGame");
        setSize(1500,920);
        add(board);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
    new MyGame();
    
    }
}
