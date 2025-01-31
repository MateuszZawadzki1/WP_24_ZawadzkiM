public class CalculatorModel {
    private int number1;
    private int number2;
    private char operator;

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public int calculateResult() {
        switch (operator) {
            case '+':
                return number1 + number2;
            case '-':
                return number1 - number2;
            case '*':
                return number1 * number2;
            case '/':
                if (number2 != 0) {
                    return number1 / number2;
                } else {
                    throw new ArithmeticException("Nie można dzielić przez zero");
                }
            default:
                throw new IllegalArgumentException("Nieznany operator");
        }
    }

    public void reset() {
        number1 = 0;
        number2 = 0;
        operator = ' ';
    }
}
