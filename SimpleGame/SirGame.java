import javax.swing.JFrame;

public class SirGame extends JFrame {
    public SirGame(){
        GframeSir board=new GframeSir();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sirgame");
        setSize(1500,950);
        setResizable(false);
        setLocationRelativeTo(null);
        add(board);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SirGame();
    }
    
}
