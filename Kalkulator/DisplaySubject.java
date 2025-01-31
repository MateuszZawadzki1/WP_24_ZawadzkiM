import java.util.ArrayList;
import java.util.List;

public class DisplaySubject {
    private final List<DisplayObserver> observers = new ArrayList<>();
    private String displayText;

    public void addObserver(DisplayObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(DisplayObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (DisplayObserver observer : observers) {
            observer.update(displayText);
        }
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
        notifyObservers();
    }
}