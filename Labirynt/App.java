import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App extends JFrame{
    private MyJPanel panel;
    private Image image;

    public App (){
        setSize(200, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new MyJPanel();
        JButton button = new JButton("Draw");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buildMaze();
            }
        });
        
        //JPanel panelRooth = new JPanel(new BorderLayout());
        
        
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER); // panel in central position
        add(button, "North");

        //setContentPane(panelRooth); // Ustawiamy jako panel glowny aplikacji
        
        
        

        // buildMaze();

    }   

    public void buildMaze() {
        image = panel.getImage();

        int x = 50;
        int y = 100;
        int nr = 1;

        Room room1 = new Room(x, y, nr++);
        Wall wall1 = new Wall(50, 100, Directions.NORTH);
        room1.setSite(Directions.NORTH, wall1);

        Wall wall2 = new Wall(50, 100, Directions.SOUTH);
        room1.setSite(Directions.SOUTH, wall2);

        Wall wall3 = new Wall(50, 100, Directions.WEST);
        room1.setSite(Directions.WEST, wall3);

        //Wall wall4 = new Wall(50, 100, Directions.EAST);
        //room1.setSite(Directions.EAST, wall4);

        room1.draw(image);

        x = x+MapSite.lenght;
        Room room2 = new Room(x, y, nr++);
        Wall wall21 = new Wall(50, 100, Directions.NORTH);
        room2.setSite(Directions.NORTH, wall1);

        Wall wall22 = new Wall(50, 100, Directions.SOUTH);
        room2.setSite(Directions.SOUTH, wall2);

       // Wall wall23 = new Wall(50, 100, Directions.WEST);
        //room2.setSite(Directions.WEST, wall3);

        Wall wall24 = new Wall(50, 100, Directions.EAST);
        room2.setSite(Directions.EAST, wall24);

        Door door = new Door(room1, room2, true);
        room1.setSite(Directions.EAST, door);  
        room2.setSite(Directions.WEST, door);  

        room2.draw(image);
        
        
        
        
        
        
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
