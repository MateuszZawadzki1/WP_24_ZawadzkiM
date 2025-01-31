import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;

        for (JButton button : view.getNumberButtons()) {
            button.addActionListener(new NumberButtonListener());
        }

        view.getButtonPlus().addActionListener(new OperatorButtonListener('+'));
        view.getButtonMinus().addActionListener(new OperatorButtonListener('-'));
        view.getButtonMultiply().addActionListener(new OperatorButtonListener('*'));
        view.getButtonDivide().addActionListener(new OperatorButtonListener('/'));
        view.getButtonEquals().addActionListener(new EqualsButtonListener());
        view.getButtonClear().addActionListener(new ClearButtonListener());
        view.getButtonBackspace().addActionListener(new BackspaceButtonListener());
    }

    private class NumberButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            view.setText(view.getText() + source.getText());
        }
    }

    private class OperatorButtonListener implements ActionListener {
        private char operator;

        public OperatorButtonListener(char operator) {
            this.operator = operator;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            model.setNumber1(Integer.parseInt(view.getText()));
            model.setOperator(operator);
            view.setText("");
        }
    }

    private class EqualsButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.setNumber2(Integer.parseInt(view.getText()));
            try {
                int result = model.calculateResult();
                view.setText(Integer.toString(result));
            } catch (Exception ex) {
                view.setText(ex.getMessage());
            }
        }
    }

    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.reset();
            view.setText("");
        }
    }

    private class BackspaceButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String currentText = view.getText();
            if (currentText.length() > 0) {
                view.setText(currentText.substring(0, currentText.length() - 1));
            }
        }
    }
}
