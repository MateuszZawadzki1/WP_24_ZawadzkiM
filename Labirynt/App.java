import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class App extends JFrame{
    private MyJPanel panel;
    private Image image;

    public App (){
        JPanel panelRooth = new JPanel(new BorderLayout());
        setSize(200, 300);
        
        panel = new MyJPanel();
        
        panelRooth.add("Center", panel);
        setContentPane(panelRooth); // Ustawiamy jako panel glowny aplikacji
        
        
        

        buildMaze();

    }   

    public void buildMaze() {
        image = panel.createImage(panel.getWidth(), panel.getHeight());

        Wall wall = new Wall(50, 100, Directions.NORTH);
        wall.draw(image);
        panel.repaint();    // Odrysowanie panela, nie uzywamy metody paint

        

    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }
}
