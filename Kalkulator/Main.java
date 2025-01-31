public class Main {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        new CalculatorController(model, view);

        view.setLocation(100, 100);

        // Dodanie obserwatora
        SecondaryDisplay secondaryDisplay = new SecondaryDisplay();
        view.addDisplayObserver(secondaryDisplay);
    }
}