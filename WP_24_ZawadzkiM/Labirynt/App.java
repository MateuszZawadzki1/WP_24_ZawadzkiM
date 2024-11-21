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
        setSize(300, 300);
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
    
        // Pierwszy pokój
        Room room1 = new Room(x, y, nr++);
        Wall wall1 = new Wall(x, y, Directions.NORTH);
        room1.setSite(Directions.NORTH, wall1);
    
        Wall wall2 = new Wall(x, y, Directions.SOUTH);
        room1.setSite(Directions.SOUTH, wall2);
    
        Wall wall3 = new Wall(x, y, Directions.WEST);
        room1.setSite(Directions.WEST, wall3);

        Wall wall4 = new Wall(x, y, Directions.EAST);
        room1.setSite(Directions.EAST, wall4);
    
    
    
        // Drugi pokój
        x = x + MapSite.lenght; // Przesuwamy w prawo
        Room room2 = new Room(x, y, nr++);
        Wall wall21 = new Wall(x, y, Directions.NORTH);
        room2.setSite(Directions.NORTH, wall21);
    
        Wall wall22 = new Wall(x, y, Directions.SOUTH);
        room2.setSite(Directions.SOUTH, wall22);
    
        Wall wall24 = new Wall(x, y, Directions.EAST);
        room2.setSite(Directions.EAST, wall24);
    
        //Door door = new Door(room1, room2, true);
        //room1.setSite(Directions.EAST, door);
        //room2.setSite(Directions.WEST, door);
    
        
    
        // Trzeci pokój (na prawo od room2)
        x = x + MapSite.lenght; // Przesuwamy dalej w prawo
        Room room3 = new Room(x, y, nr++);
        Wall wall31 = new Wall(x, y, Directions.NORTH);
        room3.setSite(Directions.NORTH, wall31);
    
        Wall wall32 = new Wall(x, y, Directions.SOUTH);
        room3.setSite(Directions.SOUTH, wall32);

        Wall wall33 = new Wall(x, y, Directions.WEST);
        room3.setSite(Directions.WEST, wall33);
    
    
        Wall wall34 = new Wall(x, y, Directions.EAST);
        room3.setSite(Directions.EAST, wall34);
    
        Door door2 = new Door(room2, room3, true);
        room2.setSite(Directions.EAST, door2);
        room3.setSite(Directions.WEST, door2);
    
    
        // Czwarty pokój (poniżej room2)
        x = 50 + MapSite.lenght; // Współrzędna x room2
        y = y + MapSite.lenght;  // Przesuwamy w dół
        Room room4 = new Room(x, y, nr++);
        Wall wall41 = new Wall(x, y, Directions.SOUTH);
        room4.setSite(Directions.SOUTH, wall41);
    
        Wall wall42 = new Wall(x, y, Directions.WEST);
        room4.setSite(Directions.WEST, wall42);
    
        Wall wall44 = new Wall(x, y, Directions.EAST);
        room4.setSite(Directions.EAST, wall44);
    
        Door door3 = new Door(room2, room4, true);
        room2.setSite(Directions.SOUTH, door3);
        room4.setSite(Directions.NORTH, door3);

    
        // Piąty pokój (na lewo od room4)
        x = x - MapSite.lenght; // Przesuwamy w lewo
        Room room5 = new Room(x, y, nr++);
        Wall wall51 = new Wall(x, y, Directions.NORTH);
        room5.setSite(Directions.NORTH, wall51);
    
        Wall wall53 = new Wall(x, y, Directions.WEST);
        room5.setSite(Directions.WEST, wall53);
    
        Wall wall54 = new Wall(x, y, Directions.SOUTH);
        room5.setSite(Directions.SOUTH, wall54);
    
        Door door4 = new Door(room1, room5, true);
        room1.setSite(Directions.SOUTH, door4);
        room5.setSite(Directions.NORTH, door4);
    
        Door door5 = new Door(room5, room4, true);
        room5.setSite(Directions.EAST, door5);
        room4.setSite(Directions.WEST, door5);
        


        room1.draw(image);
        room2.draw(image);
        room3.draw(image);
        room4.draw(image);
        room5.draw(image);
    
        panel.repaint(); // Odrysowanie panela
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }
}
