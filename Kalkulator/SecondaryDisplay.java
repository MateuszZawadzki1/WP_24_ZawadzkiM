import java.awt.*;
import javax.swing.*;

public class SecondaryDisplay implements DisplayObserver {
    private final JTextField secondaryScreen;

    public SecondaryDisplay() {
        secondaryScreen = new JTextField();
        secondaryScreen.setEditable(false);
        secondaryScreen.setFont(new Font("Arial", Font.BOLD, 24));
        secondaryScreen.setPreferredSize(new Dimension(400, 50));
        secondaryScreen.setBackground(Color.BLACK); // Ciemne tło
        secondaryScreen.setForeground(Color.WHITE); // Jasny tekst

        
        JFrame frame = new JFrame("Secondary Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(secondaryScreen);
        frame.pack();
        frame.setVisible(true);
    }

    

    @Override
    public void update(String displayText) {
        secondaryScreen.setText("Observed: " + displayText);

        // Zmiana koloru w zależności od wyniku
        try {
            int number = Integer.parseInt(displayText);
            if (number >= 0) {
                secondaryScreen.setForeground(Color.GREEN); // Zielony tekst dla wyników dodatnich
            } else {
                secondaryScreen.setForeground(Color.RED); // Czerwony tekst dla wyników ujemnych
            }
        } catch (NumberFormatException e) {
            secondaryScreen.setForeground(Color.WHITE); // Domyślny kolor, jeśli tekst nie jest liczbą
        }
    }
}