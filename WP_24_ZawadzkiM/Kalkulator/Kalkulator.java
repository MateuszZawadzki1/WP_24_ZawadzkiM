import javax.swing.JTextField;

public class Kalkulator {
    private int firstNumber;
    private int secondNumber;
    private char operator;
    private JTextField screen;

    public Kalkulator(JTextField tf)
    {
        screen = tf;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void setOperator(char operator) {
        this.operator = operator;
        String screeen = textScreen.getText(); // Zawartosc ekranu
                int indexOfOperator = screeen.indexOf(operator);
                secondNumber = Integer.parseInt(screeen.substring(indexOfOperator + 1));
    }

    public void calculate() {

        // sprawdzenie, czy mamy obie liczby

        switch (operator) {
            case '+':
                screen.setText("" + (firstNumber + secondNumber));
            case '-':
                return firstNumber - secondNumber;
            case '*':
                return firstNumber * secondNumber;
            case '/':
                if (secondNumber != 0) {
                    return firstNumber / secondNumber;
                } else {
                    screen.setText("Error");
                    throw new ArithmeticException("ERROR");
                }
            default:
                //throw new UnsupportedOperationException();
        }
        operator = ' ';
                   
    }

    public void reset() {
        firstNumber = 0;
        secondNumber = 0;
        operator = ' ';
    }



        
}

