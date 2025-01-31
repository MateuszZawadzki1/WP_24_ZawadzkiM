import java.awt.*;
import javax.swing.*;

public class CalculatorView extends JFrame {
    private final DisplaySubject displaySubject = new DisplaySubject();

    // Przyciski
    final private JButton button_1 = new JButton("1");
    private final JButton button_2 = new JButton("2");
    private final JButton button_3 = new JButton("3");
    private final JButton button_4 = new JButton("4");
    private final JButton button_5 = new JButton("5");
    private final JButton button_6 = new JButton("6");
    private final JButton button_7 = new JButton("7");
    private final JButton button_8 = new JButton("8");
    private final JButton button_9 = new JButton("9");
    private final JButton button_0 = new JButton("0");
    private final JButton button_C = new JButton("C");
    private final JButton buttonMinus = new JButton("-");
    private final JButton buttonPlus = new JButton("+");
    private final JButton buttonDivide = new JButton("/");
    private final JButton buttonMultiply = new JButton("*");
    private final JButton buttonEquals = new JButton("=");
    private final JButton button_BACKSPACE = new JButton("<-");
    
    // Wyswietlacz
    private final JTextField textScreen;

    public CalculatorView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new BorderLayout()); // tworzymy głowny panel
        textScreen = new JTextField(); // okno jako obiekt
        mainPanel.add("North", textScreen); // dodanie komponentu do panela na górze

        // Dodawanie przyciskow, widzialnych i niewidzialnych aby dostosowac rozmieszczenie
        JPanel buttonPanel = new JPanel(new GridLayout(6,4));
        buttonPanel.add(new JLabel()); // Puste pole
        buttonPanel.add(new JLabel()); 
        buttonPanel.add(new JLabel()); 
        buttonPanel.add(new JLabel()); 
        
        buttonPanel.add(button_7);
        buttonPanel.add(button_8);
        buttonPanel.add(button_9);
        buttonPanel.add(buttonMinus);
        buttonPanel.add(button_4);
        buttonPanel.add(button_5);
        buttonPanel.add(button_6);
        buttonPanel.add(buttonPlus);
        buttonPanel.add(button_1);
        buttonPanel.add(button_2);
        buttonPanel.add(button_3);
        buttonPanel.add(buttonMultiply);
        buttonPanel.add(button_C);
        buttonPanel.add(button_0);
        buttonPanel.add(button_BACKSPACE);
        buttonPanel.add(buttonDivide);
        buttonPanel.add(new JLabel()); 
        buttonPanel.add(new JLabel()); 
        buttonPanel.add(new JLabel()); 
        buttonPanel.add(buttonEquals);
        
        mainPanel.add("Center", buttonPanel); // panel na przyciski

        setContentPane(mainPanel); // Okno aplikacji
        pack(); // Formatuje rozmiar okna
        setVisible(true); // Okno aplikacji na ekranie

    
    }

    public String getText() {
        return textScreen.getText();
    }

    public void setText(String text) {
        textScreen.setText(text); // Ustaw tekst na wyświetlaczu
        displaySubject.setDisplayText(text); // Powiadomianie obserwatorow
    }

    public JButton[] getNumberButtons() {
        return new JButton[] {button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9};
    }

    public JButton getButtonPlus() {
        return buttonPlus;
    }

    public JButton getButtonMinus() {
        return buttonMinus;
    }

    public JButton getButtonMultiply() {
        return buttonMultiply;
    }

    public JButton getButtonDivide() {
        return buttonDivide;
    }

    public JButton getButtonEquals() {
        return buttonEquals;
    }

    public JButton getButtonClear() {
        return button_C;
    }

    public JButton getButtonBackspace() {
        return button_BACKSPACE;
    }

    public JButton getButton_5() {
        return button_5;
    }

    // Rejestrowanie obserwatorów
    public void addDisplayObserver(DisplayObserver observer) {
        displaySubject.addObserver(observer);
    }
}
