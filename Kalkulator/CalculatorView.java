import javax.swing.*;
import java.awt.*;

public class CalculatorView extends JFrame {
    private JButton button_1 = new JButton("1");
    private JButton button_2 = new JButton("2");
    private JButton button_3 = new JButton("3");
    private JButton button_4 = new JButton("4");
    private JButton button_5 = new JButton("5");
    private JButton button_6 = new JButton("6");
    private JButton button_7 = new JButton("7");
    private JButton button_8 = new JButton("8");
    private JButton button_9 = new JButton("9");
    private JButton button_0 = new JButton("0");
    private JButton button_C = new JButton("C");
    private JButton buttonMinus = new JButton("-");
    private JButton buttonPlus = new JButton("+");
    private JButton buttonDivide = new JButton("/");
    private JButton buttonMultiply = new JButton("*");
    private JButton buttonEquals = new JButton("=");
    private JButton button_BACKSPACE = new JButton("<-");
    
    private JTextField textScreen;

    public CalculatorView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new BorderLayout()); // tworzymy głowny panel
        textScreen = new JTextField(); // okno jako obiekt
        mainPanel.add("North", textScreen); // dodanie komponentu do panela na górze


        JPanel buttonPanel = new JPanel(new GridLayout(6,4));
        buttonPanel.add(new JLabel()); // wstawiamy etykietę czyli puste pole
        buttonPanel.add(new JLabel()); // wstawiamy etykietę czyli puste pole
        buttonPanel.add(new JLabel()); // wstawiamy etykietę czyli puste pole
        buttonPanel.add(new JLabel()); // wstawiamy etykietę czyli puste pole

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
        buttonPanel.add(new JLabel()); // Puste pole
        buttonPanel.add(new JLabel()); // Puste pole
        buttonPanel.add(new JLabel()); // Puste pole
        buttonPanel.add(buttonEquals);
        
        mainPanel.add("Center", buttonPanel); // panel z przyciskami

        setContentPane(mainPanel); // ustawia nam okienko aplikacji
        pack(); // dostosowuje rozmiar okienka aplikacji
        setVisible(true); // wyświetla okienko aplikacji na ekranie

    
    }

    public String getText() {
        return textScreen.getText();
    }

    public void setText(String text) {
        textScreen.setText(text);
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
}
