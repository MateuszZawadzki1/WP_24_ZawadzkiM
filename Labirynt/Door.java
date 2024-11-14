import java.awt.Graphics;
import java.awt.Image;

public class Door extends MapSite {
    private Room roomOne;
    private Room roomTwo;
    private boolean isOpen = true;
    

    public Door (Room roomOne, Room roomTwo, boolean isOpen) {
        super(-1, -1); // współrzedne nieokreślone
        this.roomOne = roomOne;
        this.roomTwo = roomTwo;
        this.isOpen = isOpen;
    }

    @Override
    public void draw(Image image) {
        int x1 = roomOne.getX();
        int y1 = roomOne.getY();
        int x2 = roomTwo.getX();
        int y2 = roomTwo.getY();
        Graphics g = image.getGraphics();
        if (x1 == x2) {     // Rooms are vertical
            if (y1 > y2) {
                g.drawLine(x1, y1, x1 + MapSite.lenght, y1);
        } else {g.drawLine(x1, y2, x1 + MapSite.lenght, y2);}
        if (x1 > x2) {
            g.drawLine(x1, y1, x1, y1 + MapSite.lenght);
        } else {
            g.drawLine(x2, y1, x2, y1 + MapSite.lenght);
        }
    }
}
