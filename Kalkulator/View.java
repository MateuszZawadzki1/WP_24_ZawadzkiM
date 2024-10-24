import javax.swing.*;
import java.awt.*;

public class View extends JFrame{
    private JTextField textScreen = new JTextField("");

    public View(){
        // Tworzenie Okna Aplikacji
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new BorderLayout()); 
        mainPanel.add("North", textScreen); 

        JPanel buttonPanel = new JPanel(new GridLayout(6, 4)); 
        mainPanel.add("Center", buttonPanel); 



        setContentPane(mainPanel); 
        pack();
        setVisible(true); 
    }
}
    

