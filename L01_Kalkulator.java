import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class L01_Kalkulator extends JFrame {
    private JButton button1 = new JButton("1");
    private JButton button2 = new JButton("2");
    private JButton button3 = new JButton("3");
    private JButton button4 = new JButton("4");
    private JButton button5 = new JButton("5");
    private JButton button6 = new JButton("6");
    private JButton button7 = new JButton("7");
    private JButton button8 = new JButton("8");
    private JButton button9 = new JButton("9");
    private JButton button0 = new JButton("0");
    private JButton buttonC = new JButton("C");
    private JButton buttonMinus = new JButton("-");
    private JButton buttonPlus = new JButton("+");
    private JButton buttonDivide = new JButton("/");
    private JButton buttonMultiply = new JButton("X");
    private JButton buttonBackspace = new JButton("<-");
    private JButton buttonEqual = new JButton("=");
    private JTextField textScreen;
    private int firstNumber, secondNumber;
    private char operator;


    /*
     * Konstruktor klasy inicjalizujacy GUI
     */
    public L01_Kalkulator() {


        // Tworzenie Okna Aplikacji
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new BorderLayout()); // główny panel aplikacji
        textScreen = new JTextField(""); // obiekt okna
        mainPanel.add("North", textScreen); // dodanie komponentu okna do panelu (na samej gorze)


        // Tworzenie akcji dla przycisków
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textScreen.setText(textScreen.getText() + 0);
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textScreen.setText(textScreen.getText() + 1);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textScreen.setText(textScreen.getText() + 2);
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textScreen.setText(textScreen.getText() + 3);
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textScreen.setText(textScreen.getText() + 4);
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textScreen.setText(textScreen.getText() + 5);
            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textScreen.setText(textScreen.getText() + 6);
            }
        });

        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textScreen.setText(textScreen.getText() + 7);
            }
        });

        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textScreen.setText(textScreen.getText() + 8);
            }
        });

        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textScreen.setText(textScreen.getText() + 9);
            }
        });

        // Operatory
        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNumber = Integer.parseInt(textScreen.getText());
                textScreen.setText(textScreen.getText() + "+");
                operator = '+';
            }
        });

        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNumber = Integer.parseInt(textScreen.getText());
                textScreen.setText(textScreen.getText() + "-");
                operator = '-';
            }
        });

        buttonMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNumber = Integer.parseInt(textScreen.getText());
                textScreen.setText(textScreen.getText() + "*");
                operator = '*';
            }
        });

        buttonDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNumber = Integer.parseInt(textScreen.getText());
                textScreen.setText(textScreen.getText() + "/");
                operator = '/';
            }
        });

        // Przycisk '='
        buttonEqual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String screeen = textScreen.getText(); // Zawartosc ekranu
                int indexOfOperator = screeen.indexOf(operator);
                secondNumber = Integer.parseInt(screeen.substring(indexOfOperator + 1));
                switch (operator) {
                    case '/':
                        if (secondNumber != 0) {
                            textScreen.setText(Integer.toString(firstNumber / secondNumber));
                        } else {
                            textScreen.setText("Error");
                        }
                        break;
                    case '*':
                        textScreen.setText(Integer.toString(firstNumber * secondNumber));
                        break;
                    case '-':
                        textScreen.setText(Integer.toString(firstNumber - secondNumber));
                        break;
                    case '+':
                        textScreen.setText(Integer.toString(firstNumber + secondNumber));
                        break;
                    default:
                        break;
                }

            }
        });

        // Przycisk 'C'
        buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textScreen.setText("");
                firstNumber = 0;
                secondNumber = 0;
                operator = ' ';
            }
        });


        // Tworzenie siatki wraz z przyciskami
        JPanel buttonPanel = new JPanel(new GridLayout(6, 4)); // tworzenie siatki przyciskow 6x4

        buttonPanel.add(new JLabel()); // wstawiamy etykiete (puste pole)
        buttonPanel.add(new JLabel()); 
        buttonPanel.add(new JLabel()); 
        buttonPanel.add(buttonC);
        buttonPanel.add(button7);
        buttonPanel.add(button8);
        buttonPanel.add(button9);
        buttonPanel.add(buttonMinus);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);
        buttonPanel.add(buttonPlus);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(buttonMultiply);
        buttonPanel.add(new JLabel());
        buttonPanel.add(button0);
        buttonPanel.add(new JLabel());
        buttonPanel.add(buttonDivide);
        buttonPanel.add(buttonBackspace);
        buttonPanel.add(new JLabel());
        buttonPanel.add(new JLabel());
        buttonPanel.add(buttonEqual);


        mainPanel.add("Center", buttonPanel); // dodanie panelu z przyciskami do glownego panelu

        setContentPane(mainPanel); // stawia panel okna do aplk
        pack(); // dostosowywuje rozmiar okienka aplikacji
        setVisible(true); // wyswietla okienko aplikacji na ekranie
    }

    public static void main(String[] args) {
        new L01_Kalkulator();

    }
}
